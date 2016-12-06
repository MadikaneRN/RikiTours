package za.co.whcb.tp2.rikitours.controllers.rental;

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
import za.co.whcb.tp2.rikitours.controllers.rental.callback.RikiApiVehicleCallback;
import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;

/**
 * Created by berka on 11/27/2016.
 */
public class VehicleController {
    private final String urlVehicle = "http://tp.sawebdesignhosting.co.za/vehicles/";
    private RequestQueue requestQueue;
    private Context context;
    private ArrayList<Vehicle> vehicleFromServer;

    public VehicleController(Context context) {
        this.context = context;
        this.vehicleFromServer = new ArrayList<>();
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void getVehicles(final RikiApiVehicleCallback rikiApiVehicleCallback) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(urlVehicle,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONArray data = response.getJSONArray(0);
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject jsonObject = data.getJSONObject(i);
                                long id = Long.parseLong(jsonObject.getString("vehicle_id"));
                                String year = jsonObject.getString("vehicle_year");
                                String name = jsonObject.getString("vehicle_name");
                                String model = jsonObject.getString("vehicle_model");
                                String description = jsonObject.getString("vehicle_desc");
                                double price = Double.parseDouble(jsonObject.getString("vehicle_price"));
                                String image = jsonObject.getString("image_1");

                                Vehicle vehicle = VehicleFactory.getVehicle(id,name,model,year);
                                vehicle.setDescription(description);
                                vehicle.setPrice(price);

                                if(!image.equals("null")){
                                    RikiImage firstImage = new RikiImage(name ,image);
                                    vehicle.setCarImage(firstImage);
                                }

                                vehicleFromServer.add(vehicle);
                            }

                            rikiApiVehicleCallback.onSuccess(vehicleFromServer);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            rikiApiVehicleCallback.onJSONError(e);
                            //Display.toast("Error "+e.getMessage(), context);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "ERROR");
                        rikiApiVehicleCallback.onConnectingError(error);
                        //Display.toast(AppNetworkError.check(error), context);
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }
}

