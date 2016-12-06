package za.co.whcb.tp2.rikitours.controllers.accommodation;

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

import za.co.whcb.tp2.rikitours.controllers.accommodation.callback.RikiApiAccommodationCallBack;
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;
/**
 * Created by Berka on 11/28/2016.
 */
public class AccommodationController {
    private final String urlRooms = "http://tp.sawebdesignhosting.co.za/rooms/";
    private RequestQueue requestQueue;
    private Context context;
    private  ArrayList<Room> roomsFromServer;

    public AccommodationController(Context context) {
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
        this.roomsFromServer = new ArrayList<>();
    }

    public void getAccommodations(final RikiApiAccommodationCallBack rikiApiAccommodationCallBack) {
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

                            rikiApiAccommodationCallBack.onSuccess(roomsFromServer);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            rikiApiAccommodationCallBack.onJSONError(e);
                            //Display.toast("Error "+e.getMessage(), context);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "ERROR");
                        rikiApiAccommodationCallBack.onConnectingError(error);
                        //Display.toast(AppNetworkError.check(error), context);
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }
}
