package za.co.whcb.tp2.rikitours;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.adapter.CountryAdapter;
import za.co.whcb.tp2.rikitours.controllers.CountryController;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;
import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

public class ListActivity extends AppCompatActivity {

    //JsonObjectRequest jsonObjectRequest;

    private RequestQueue requestQueue;
    private  ArrayList<Country> countriesFromServer;
    private final String url = "http://tp2.whcb.co.za/countries";
    private GalleryContainer galleryContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        countriesFromServer = new ArrayList<>();
        galleryContainer = new GalleryContainer();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                long id = Long.parseLong(jsonObject.getString("country_id"));
                                String name = jsonObject.getString("name");
                                String description = jsonObject.getString("description");
                                String image = jsonObject.getString("image");

                                Country country = CountryFactory.getCountry(id,name,description,image);
                                countriesFromServer.add(country);

                                galleryContainer.addImage( new RikiImage("",jsonObject.getString("image1")));
                                galleryContainer.addImage( new RikiImage("",jsonObject.getString("image2")));
                                galleryContainer.addImage( new RikiImage("",jsonObject.getString("image3")));
                                galleryContainer.addImage( new RikiImage("",jsonObject.getString("image4")));
                                galleryContainer.addImage( new RikiImage("",jsonObject.getString("image5")));



                                for(int y = 0; y < galleryContainer.getSize(); y++){
                                    if( galleryContainer.getImage(y) == null || galleryContainer.getImage(y).getUrl().equals(""))
                                    {
                                        galleryContainer.removeImagee(y);
                                    }
                                }

                                if (galleryContainer.getSize() > 0){
                                    loadList(countriesFromServer, galleryContainer);
                                }
                                else {
                                    loadList(countriesFromServer);
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Display.toast("Error "+e.getMessage(), getApplicationContext());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "ERROR");
                        AppNetworkError.check(error);
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }

    public void loadList(ArrayList<Country> countries , GalleryContainer galleryContainer) {

        CountryAdapter adapter = new CountryAdapter(this,countries,galleryContainer);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);

    }

    public void loadList(ArrayList<Country> countries) {

        CountryAdapter adapter = new CountryAdapter(this,countries);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);

    }
}
