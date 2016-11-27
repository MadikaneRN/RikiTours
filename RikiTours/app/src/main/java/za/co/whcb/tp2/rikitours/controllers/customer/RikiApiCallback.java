package za.co.whcb.tp2.rikitours.controllers.customer;

import za.co.whcb.tp2.rikitours.controllers.AppControllerCallBack;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 11/26/2016.
 */
public interface RikiApiCallback extends AppControllerCallBack {
    void onSuccess(Customer user);
}
