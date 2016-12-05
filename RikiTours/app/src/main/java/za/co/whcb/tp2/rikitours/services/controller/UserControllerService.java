package za.co.whcb.tp2.rikitours.services.controller;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.repository.local.common.CountryRepo;

/**
 * Created by gaming on 12/5/2016.
 */
public class UserControllerService extends Service {
    private final IBinder myLocalBinder = new MyLocalBinder();
    public UserControllerService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public UserControllerService getService()
        {
            return UserControllerService.this;
        }
    }

    public String test() {
        return "works";
    }

    public void signup() {


    }

}
