package za.co.whcb.tp2.rikitours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.repository.local.common.CountryRepo;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionsRepo;

public class MainActivity extends AppCompatActivity {
    private CountryRepo countryRepo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AttractionsRepo attractionsRepo = new AttractionsRepo(this);
        //Attraction attraction= attractionsRepo.findCountryById(21);
        Attraction country = AttractionFactory.getAttracion(1L, 1L, 1L);

        //Display.toast(attraction.getCountryId().toString(), this);
         if (attractionsRepo.addCountry(country)== true) {
            Display.toast("Country added ", this);
        }
        else {
            Display.toast("failed to  add country" , this);
        }


    }
}
