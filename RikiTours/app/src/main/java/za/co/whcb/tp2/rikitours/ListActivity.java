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
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

public class ListActivity extends AppCompatActivity {

    //JsonObjectRequest jsonObjectRequest;

    RequestQueue requestQueue;
   private  ArrayList<Country> countriesFromServer;
   private ArrayList<Country> t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

         t = new ArrayList<>(); ;

        countriesFromServer = new ArrayList<>();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);


       // CountryController countryController = new CountryController(this,"http://tp2.whcb.co.za/customer.php");




        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                "http://tp2.whcb.co.za/countries",
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

                                work(countriesFromServer);

                            }

                            t = countriesFromServer;
                            //Display.toast(String.valueOf(countriesFromServer.size()),getApplicationContext());

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "ERROR");
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);




        //CountryAdapter adapter = new CountryAdapter(this,countriesFromServer);
        //ListView l = (ListView) findViewById(R.id.listView2);
       // l.setAdapter(adapter);

       // Display.toast(String.valueOf(t.size()),this);

    }

    public void work(ArrayList<Country> countries) {

        CountryAdapter adapter = new CountryAdapter(this,countries);
        ListView l = (ListView) findViewById(R.id.listView2);
        l.setAdapter(adapter);

    }
}
