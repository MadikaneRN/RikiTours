package za.co.whcb.tp2.rikitours.controllers.customer.callback;

import za.co.whcb.tp2.rikitours.controllers.AppControllerCallBack;

/**
 * Created by gaming on 11/26/2016.
 */
public interface RikiApiSignUpCallBack extends AppControllerCallBack {
    void onSuccess(String feedback);
}
