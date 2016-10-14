package za.co.whcb.tp2.rikitours;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.repository.local.common.CountryRepo;
import za.co.whcb.tp2.rikitours.repository.local.rental.VehicleRepo;
import za.co.whcb.tp2.rikitours.services.domain.common.country.CountryService;

public class MainActivity extends AppCompatActivity {
    private CountryRepo countryRepo ;
    private VehicleRepo vehicleRepo;

     private CountryService countryService;
     boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, CountryService.class);
        bindService(i,serviceConnection, Context.BIND_AUTO_CREATE);

    }

    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CountryService.LocalBinder binder = (CountryService.LocalBinder) service;
            countryService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };
}
