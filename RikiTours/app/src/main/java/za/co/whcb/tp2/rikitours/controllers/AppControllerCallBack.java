package za.co.whcb.tp2.rikitours.controllers;

import com.android.volley.VolleyError;

/**
 * Created by berka on 11/27/2016.
 */
public interface AppControllerCallBack {
    void onConnectingError(VolleyError error);
    void onParsingError(Exception error);
}
