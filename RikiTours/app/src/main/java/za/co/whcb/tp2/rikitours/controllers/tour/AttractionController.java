package za.co.whcb.tp2.rikitours.controllers.tour;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.controllers.tour.callback.RikiAttractionCallBack;
import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

/**
 * Created by gaming on 11/28/2016.
 */
public class AttractionController {
    private final String urlAttractions = "http://tp.sawebdesignhosting.co.za/attractions/";
    private RequestQueue requestQueue;
    private Context context;
    private ArrayList<Attraction> attractionsFromServer;

    public AttractionController(Context context) {
        this.context = context;
        this.attractionsFromServer = new ArrayList<>();
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void getAttractions(final RikiAttractionCallBack rikiAttractionCallBack) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(urlAttractions,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONArray data = response.getJSONArray(0);
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject jsonObject = data.getJSONObject(i);
                                long attractionId = Long.parseLong(jsonObject.getString("attraction_id"));
                                String name = jsonObject.getString("name");
                                String description = jsonObject.getString("attraction_desc");
                                String image = "" ;

                                String imageOne = jsonObject.getString("image_1");
                                String imageTwo = jsonObject.getString("image_2");
                                String imageThree = jsonObject.getString("image_3");

                                String countryName = jsonObject.getString("country_name");
                                String countryFlag = jsonObject.getString("country_image");

                                long cityId = Long.parseLong(jsonObject.getString("city_id"));
                                String cityName = jsonObject.getString("city_name");
                                String cityDescription = jsonObject.getString("city_desc");

                                City city = CityFactory.getCity(cityId, cityName, cityDescription);

                                long countryId = Long.parseLong(jsonObject.getString("country_id"));
                                String countryDescription = jsonObject.getString("country_description");

                                Country country = CountryFactory.getCountry(countryId,countryName,countryDescription,countryFlag);

                                AttractionDescription attractionDescription = AttractionDescriptionFactory
                                        .getAttractionDescription(attractionId,name,city.getName(),description,image);

                                if(!imageOne.equals("null")){
                                    RikiImage firstImage = new RikiImage(name ,imageOne);
                                    attractionDescription.addImage(firstImage);
                                }
                                if (!imageTwo.equals("null")) {
                                    RikiImage secondImage = new RikiImage(name ,imageTwo);
                                    attractionDescription.addImage(secondImage);
                                }
                                if (!imageThree.equals("null")) {
                                    RikiImage thirdImage = new RikiImage(name ,imageThree);
                                    attractionDescription.addImage(thirdImage);
                                }

                                Attraction attraction = AttractionFactory.getAttraction(attractionId,country,attractionDescription);
                                attractionsFromServer.add(attraction);
                            }
                            rikiAttractionCallBack.onSuccess(attractionsFromServer);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            rikiAttractionCallBack.onJSONError(e);
                            //Display.toast("Error "+e.getMessage(), context);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "ERROR");
                        rikiAttractionCallBack.onConnectingError(error);
                        //Display.toast(AppNetworkError.check(error), context);
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }
}
