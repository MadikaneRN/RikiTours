package za.co.whcb.tp2.rikitours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.repository.local.common.CountryRepo;
import za.co.whcb.tp2.rikitours.repository.local.rental.VehicleRepo;

public class MainActivity extends AppCompatActivity {
    private CountryRepo countryRepo ;
    private VehicleRepo vehicleRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryRepo = new CountryRepo(this);
        //Country country = countryRepo.findCountryById(21);
        //Country country = CountryFactory.getCountry((long) 21,"angola","South Africa is a country on the southernmost", "sa.jpg");

        vehicleRepo = new VehicleRepo(this);
        //Vehicle vehicle = VehicleFactory.getVehicle(21,"BMW","M3","2013");

        Vehicle vehicle = vehicleRepo.findVehicleById(21);

        Display.toast(vehicle.getVehicleName(), this);
        /*
        if (vehicleRepo.addVehicle(vehicle)== true) {
            Display.toast("Vehicle added ", this);
        }
        else {
            Display.toast("failed to  add vehicle" , this);
        }

        */
    }
}
