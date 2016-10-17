package za.co.whcb.tp2.rikitours;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.services.domain.common.country.CountryService;


public class MainActivity extends AppCompatActivity {


     CountryService countryService;
     boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this.getApplicationContext(), CountryService.class);
        bindService(i,serviceConnection, Context.BIND_AUTO_CREATE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);


    }

    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CountryService.MyLocalBinder binder = (CountryService.MyLocalBinder) service;
            countryService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

    @Override
    protected  void onStop()
    {
        super.onStop();

        if(isBound)
        {
            unbindService(serviceConnection);
            isBound = false;
        }

    }


    //manual testing
    public void addCountry(View view) {

        Country country = CountryFactory.getCountry((long) 29,"South Africa","South Africa is a country on the southernmost", "sa.jpg");

        if(isBound) {
            if(countryService.add(country) == true) {
                Display.toast("Country added" , this);
            }
            else {
                 Display.toast("failed to add country" , this);
            }

        }

        else {
            Display.toast("could not bound ", this);
        }

    }
}
