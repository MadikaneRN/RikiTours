package za.co.whcb.tp2.rikitours.controllers;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;


/**
 * Created by berka on 10/17/2016.
 */
public class CountryController  {
    private JsonObjectRequest jsonObjectRequest;

    private RequestQueue requestQueue;
    private ArrayList<Country> countriesFromServer;

    public CountryController(Context context, String url) {
            requestQueue = Volley.newRequestQueue(context);
            load(url);
    }

    public ArrayList<Country> load (String url){
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray countryArray = response.getJSONArray("response_from_server");

                            for(int i = 0; i < countryArray.length();i++) {

                                JSONObject countries = countryArray.getJSONObject(i);
                                countriesFromServer.add(CountryFactory.getCountry(Long.parseLong(countries.getString("id")),
                                        countries.getString("name"),countries.getString("description"),
                                        countries.getString("image")));
                            }



                        }catch (Exception ex) {

                        }
                    }
                },

                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "Error could get data");
                    }
                }

        );

        requestQueue.add(jsonObjectRequest);
        return countriesFromServer;
    }

    public ArrayList<Country> getCountriesFromServer() {
        if (countriesFromServer != null) {
           // if(countriesFromServer.size() != 0) {
                return countriesFromServer;
          //  }
          //  else {
                //return null;
          //  }
        }
        else {
            return null;
        }
    }


}
