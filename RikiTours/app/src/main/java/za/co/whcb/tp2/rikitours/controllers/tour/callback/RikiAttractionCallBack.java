package za.co.whcb.tp2.rikitours.controllers.tour.callback;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.controllers.AppControllerCallBack;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;

/**
 * Created by gaming on 11/28/2016.
 */
public interface RikiAttractionCallBack extends AppControllerCallBack {
    void onSuccess(ArrayList<Attraction> attractions);
}
