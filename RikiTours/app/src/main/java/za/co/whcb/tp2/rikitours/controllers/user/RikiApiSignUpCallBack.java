package za.co.whcb.tp2.rikitours.controllers.user;

import com.android.volley.VolleyError;

/**
 * Created by gaming on 11/26/2016.
 */
public interface RikiApiSignUpCallBack {
    void onSuccess(String feedback);
    void onConnectingError(VolleyError error);
    void onParsingError(Exception error);
}
