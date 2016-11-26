package za.co.whcb.tp2.rikitours.controllers.user;

import com.android.volley.VolleyError;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 11/26/2016.
 */
public interface RikiApiCallback {
    void onSuccess(Customer user);
    void onConnectingError(VolleyError error);
    void onParsingError(Exception error);

}
