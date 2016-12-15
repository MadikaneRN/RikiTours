package za.co.whcb.tp2.rikitours.controllers.tour.callback;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.controllers.AppControllerCallBack;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;

/**
 * Created by owner on 2016/12/15.
 */
public interface RikiAttractionQuoteCallBack extends AppControllerCallBack {
    void onSuccess(String feedback);
}
