package za.co.whcb.tp2.rikitours.controllers.accommodation.callback;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.controllers.AppControllerCallBack;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;

/**
 * Created by gaming on 11/28/2016.
 */
public interface RikiApiAccommodationCallBack extends AppControllerCallBack {
    void onSuccess(ArrayList<Room> roomsFromServer);
}
