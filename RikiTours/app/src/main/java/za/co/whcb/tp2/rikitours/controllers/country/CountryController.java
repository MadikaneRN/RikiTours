package za.co.whcb.tp2.rikitours.controllers.country;

import android.content.Context;
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

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.adapter.CountryAdapter;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;


/**
 * Created by berka on 10/17/2016.
 */
public class CountryController  {
    private JsonObjectRequest jsonObjectRequest;

    private RequestQueue requestQueue;
    private ArrayList<Country> countriesFromServer;
    private String url;
    private  JsonArrayRequest jsonArrayRequest;

    public CountryController(Context context, String url) {
        requestQueue = Volley.newRequestQueue(context);
        this.url = url;
        countriesFromServer = new ArrayList<>();

    }

    public ArrayList<Country> load (){
        jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);

                                long id = Long.parseLong(jsonObject.getString("id"));
                                String name = jsonObject.getString("name");
                                String description = jsonObject.getString("description");
                                String image = jsonObject.getString("image");

                                Country country = CountryFactory.getCountry(id,name,description,image);
                                countriesFromServer.add(country);
                                //work(countriesFromServer);
                                work(countriesFromServer);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "ERROR");
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
        return countriesFromServer;
    }

    public ArrayList<Country> work(ArrayList<Country> countries) {

        return countries;

    }


}
