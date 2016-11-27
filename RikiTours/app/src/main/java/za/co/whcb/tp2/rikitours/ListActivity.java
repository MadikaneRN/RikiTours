package za.co.whcb.tp2.rikitours;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

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
import za.co.whcb.tp2.rikitours.common.adapter.CountryAdapter;
import za.co.whcb.tp2.rikitours.common.adapter.accommodation.RoomAdapter;
import za.co.whcb.tp2.rikitours.common.adapter.attraction.AttractionAdapter;
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;
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

public class ListActivity extends AppCompatActivity {

    //JsonObjectRequest jsonObjectRequest;
    private RequestQueue requestQueue;
    private  ArrayList<Country> countriesFromServer;
    private  ArrayList<Room> roomsFromServer;
    private  ArrayList<Attraction> attractionsFromServer;
    private final String url = "http://10.0.0.5:8005/countries/";
    private final String urlAttractions = "http://tp.sawebdesignhosting.co.za/attractions/";
    private final String urlRooms = "http://tp.sawebdesignhosting.co.za/rooms/";

    private GalleryContainer galleryContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        countriesFromServer = new ArrayList<>();
        attractionsFromServer =  new ArrayList<>();
        roomsFromServer =  new ArrayList<>();
        galleryContainer = new GalleryContainer();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);

        requestQueue = Volley.newRequestQueue(this);
        Bundle extras = getIntent().getExtras();
        if (extras.get("open").equals("Accommodations")) {
            loadRoomsServerData();
        }
        else if (extras.get("open").equals("Attractions")) {
            loadAttractionData();
        }
        else if (extras.get("open").equals("Vehicles")) {
            //loadAttractionData();
        }
        else {

        }
        setTitle(extras.getString("open"));

    }


    public void loadAttractionsList(ArrayList<Attraction> attractions) {
        AttractionAdapter adapter = new AttractionAdapter(this,attractions);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        Display.endLoading();

    }

    public void loadList(ArrayList<Country> countries) {

        CountryAdapter adapter = new CountryAdapter(this,countries);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);

    }

    public void loadRoomsToList(ArrayList<Room> rooms) {

        RoomAdapter adapter = new RoomAdapter(this,rooms);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        Display.endLoading();

    }

    public void loadRoomsServerData() {
        Display.startLoading("Loading Accommodation",this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(urlRooms,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONArray data = response.getJSONArray(0);
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject jsonObject = data.getJSONObject(i);
                                long id = Long.parseLong(jsonObject.getString("room_id"));
                                String room_size = jsonObject.getString("room_size");
                                String room_type = jsonObject.getString("room_type");
                                String room_city = jsonObject.getString("city_name");
                                String room_description = jsonObject.getString("room_desc");
                                String imageOne = jsonObject.getString("image_1");
                                String imageTwo = jsonObject.getString("image_2");
                                String imageThree = jsonObject.getString("image_3");
                                String countryName = jsonObject.getString("country_name");
                                String countryFlag = jsonObject.getString("country_image");
                                double room_price = Double.parseDouble(jsonObject.getString("room_price"));


                                long hotel_id = Long.parseLong(jsonObject.getString("hotel_id"));
                                String name = jsonObject.getString("hotel_name");
                                int star = Integer.parseInt(jsonObject.getString("hotel_star"));
                                String hotel_description = jsonObject.getString("hotel_desc");

                                Hotel hotel = new Hotel(hotel_id,name,room_city,star,hotel_description);
//                                //to add builder class and factories [Room class]
                                Room newRoom = new Room(id,room_size,room_type,room_description, hotel);
                                newRoom.setPrice(room_price);

                                if (!countryFlag.equals("null")) {
                                    RikiImage countryImage = new RikiImage(countryName ,countryFlag);
                                    newRoom.addImage(countryImage);
                                }
                                if(!imageOne.equals("null")){
                                    RikiImage firstImage = new RikiImage(room_type ,imageOne);
                                    newRoom.addImage(firstImage);
                                }
                                if (!imageTwo.equals("null")) {
                                    RikiImage secondImage = new RikiImage(room_type ,imageTwo);
                                    newRoom.addImage(secondImage);
                                }
                                if (!imageThree.equals("null")) {
                                    RikiImage thirdImage = new RikiImage(room_type ,imageThree);
                                    newRoom.addImage(thirdImage);
                                }

                                roomsFromServer.add(newRoom);

                            }

                            loadRoomsToList(roomsFromServer);
                            //Display.toast("send to adapter", getApplicationContext());
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
                        Display.toast(AppNetworkError.check(error), getApplicationContext());
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }

    public void loadCountryServerData() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONArray data = response.getJSONArray(0);
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject jsonObject = data.getJSONObject(i);
                                long id = Long.parseLong(jsonObject.getString("country_id"));
                                String name = jsonObject.getString("country_name");
                                String description = jsonObject.getString("country_description");
                                String image = jsonObject.getString("country_image");

                                Country country = CountryFactory.getCountry(id,name,description,image);
                                countriesFromServer.add(country);
                                //loadList(countriesFromServer);
                            }
                            loadList(countriesFromServer);

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
                        Display.toast(AppNetworkError.check(error), getApplicationContext());
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }



    public void loadAttractionData() {
        Display.startLoading("Loading attractions",this);
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

                               // Display.toast(countryFlag, getApplicationContext());

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
                            loadAttractionsList(attractionsFromServer);

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
                        Display.toast(AppNetworkError.check(error), getApplicationContext());
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
        //progress.hide();
    }

}
