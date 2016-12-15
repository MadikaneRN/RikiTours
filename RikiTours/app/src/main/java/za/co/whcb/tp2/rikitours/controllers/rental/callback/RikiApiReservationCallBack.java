package za.co.whcb.tp2.rikitours.controllers.rental.callback;

import za.co.whcb.tp2.rikitours.controllers.AppControllerCallBack;

/**
 * Created by owner on 2016/12/14.
 */
public interface RikiApiReservationCallBack extends AppControllerCallBack {
    void onSuccess(String feedback);
}
