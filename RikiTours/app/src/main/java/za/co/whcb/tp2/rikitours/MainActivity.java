package za.co.whcb.tp2.rikitours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.repository.local.common.CountryRepo;

public class MainActivity extends AppCompatActivity {
    private CountryRepo countryRepo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* countryRepo = new CountryRepo(this);
        Country country = CountryFactory.getCountry((long) 10.0,"south-africa","South Africa is a country on the southernmost", "sa.jpg");
        if (countryRepo.addCountry(country) == true) {
            Display.toast("country added" , this);
        }
        else {
            Display.toast("failed to  add country" , this);
        }*/


    }
}
