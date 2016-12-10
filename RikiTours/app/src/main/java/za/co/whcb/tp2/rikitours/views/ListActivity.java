package za.co.whcb.tp2.rikitours.views;

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

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.adapter.CountryAdapter;
import za.co.whcb.tp2.rikitours.common.adapter.accommodation.RoomAdapter;
import za.co.whcb.tp2.rikitours.common.adapter.attraction.AttractionAdapter;
import za.co.whcb.tp2.rikitours.common.adapter.rental.VehicleAdapter;
import za.co.whcb.tp2.rikitours.controllers.accommodation.AccommodationController;
import za.co.whcb.tp2.rikitours.controllers.accommodation.callback.RikiApiAccommodationCallBack;
import za.co.whcb.tp2.rikitours.controllers.rental.VehicleController;
import za.co.whcb.tp2.rikitours.controllers.rental.callback.RikiApiVehicleCallback;
import za.co.whcb.tp2.rikitours.controllers.tour.AttractionController;
import za.co.whcb.tp2.rikitours.controllers.tour.callback.RikiAttractionCallBack;
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;
import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);

        Bundle extras = getIntent().getExtras();
        if (extras.get("open").equals("Accommodations")) {
            loadRoomsServerData();
        }
        else if (extras.get("open").equals("Attractions")) {
            loadAttractionData();
        }
        else if (extras.get("open").equals("Vehicles")) {
            loadVehicleData();
        }
        else {

        }
        setTitle(extras.getString("open"));

    }

    public void loadAttractionsList(ArrayList<Attraction> attractions) {
        AttractionAdapter adapter = new AttractionAdapter(this,attractions,getApplicationContext());
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        Display.endLoading();

    }

    public void loadRoomsToList(ArrayList<Room> rooms) {

        RoomAdapter adapter = new RoomAdapter(this,rooms);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        Display.endLoading();
    }

    public void loadVehiclesToList(ArrayList<Vehicle> vehicles) {

        VehicleAdapter adapter = new VehicleAdapter(this,vehicles);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        Display.endLoading();

    }

    public void loadRoomsServerData() {
        Display.startLoading("Loading Accommodation",this);
        AccommodationController accommodationController = new AccommodationController(this);
        accommodationController.getAccommodations(new RikiApiAccommodationCallBack() {
            @Override
            public void onSuccess(ArrayList<Room> roomsFromServer) {
                loadRoomsToList(roomsFromServer);
            }

            @Override
            public void onConnectingError(VolleyError error) {
                Display.endLoading();
                Display.toast(AppNetworkError.check(error),getApplicationContext());
            }

            @Override
            public void onParsingError(Exception error) {
                Display.endLoading();
                Display.toast("Error on parsing "+ error.getMessage(), getApplicationContext());
            }

            @Override
            public void onJSONError(JSONException error) {
                Display.endLoading();
                Display.toast("Error "+ error.getMessage(), getApplicationContext());
            }
        });

    }

    public void loadAttractionData() {
        Display.startLoading("Loading attractions",this);
        AttractionController attractionController = new AttractionController(this);
        attractionController.getAttractions(new RikiAttractionCallBack() {
            @Override
            public void onSuccess(ArrayList<Attraction> attractions) {
                loadAttractionsList(attractions);
            }

            @Override
            public void onConnectingError(VolleyError error) {
                Display.endLoading();
                Display.toast(AppNetworkError.check(error),getApplicationContext());
            }

            @Override
            public void onParsingError(Exception error) {
                Display.endLoading();
                Display.toast("Error on parsing "+ error.getMessage(), getApplicationContext());
            }

            @Override
            public void onJSONError(JSONException error) {
                Display.endLoading();
                Display.toast("Error "+ error.getMessage(), getApplicationContext());
            }
        });

    }

    public void loadVehicleData(){
        Display.startLoading("Loading Vehicles",this);
        VehicleController vehicleController = new VehicleController(this);
        vehicleController.getVehicles(new RikiApiVehicleCallback() {
            @Override
            public void onSuccess(ArrayList<Vehicle> vehicles) {
                loadVehiclesToList(vehicles);
            }

            @Override
            public void onConnectingError(VolleyError error) {
                Display.endLoading();
                Display.toast(AppNetworkError.check(error),getApplicationContext());
            }

            @Override
            public void onParsingError(Exception error) {
                Display.endLoading();
                Display.toast("Error on parsing "+ error.getMessage(), getApplicationContext());
            }

            @Override
            public void onJSONError(JSONException error) {
                Display.endLoading();
                Display.toast("Error "+ error.getMessage(), getApplicationContext());
            }
        });
    }

}
