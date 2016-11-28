package za.co.whcb.tp2.rikitours.controllers.rental.callback;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.controllers.AppControllerCallBack;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;

/**
 * Created by berka on 11/28/2016.
 */
public interface RikiApiVehicleCallback extends AppControllerCallBack{
    void onSuccess(ArrayList<Vehicle> vehicles);
}
