package za.co.whcb.tp2.rikitours;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;

import za.co.whcb.tp2.rikitours.repository.local.rental.VehicleRepo;

public class MainActivity extends AppCompatActivity {
    private VehicleRepo vehicleRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vehicleRepo = new VehicleRepo(this);
        //UpdateRepo
        //Vehicle vehicle = VehicleFactory.getVehicle(12l,"AUDI","M3","2014");


        //vehicleRepo = new VehicleRepo(this);
        //Vehicle vehicle = VehicleFactory.getVehicle(21,"BMW","M3","2013");

      Vehicle vehicle = vehicleRepo.findVehicleById(12l);

        Display.toast(vehicle.getVehicleName(), this);

       /* if (vehicleRepo.addVehicle(vehicle)== true) {
            Display.toast("Vehicle added ", this);
        }
        else {
            Display.toast("failed to  add vehicle" , this);
        }

        //vehicleRepo.addVehicle(vehicle);

    */

    //Comlete service methods.....



        /* if (vehicleRepo.addVehicle(vehicle)== true) {
            Display.toast("Vehicle added ", this);
        }
        else {
            Display.toast("failed to  add vehicle" , this);
        }

        //vehicleRepo.addVehicle(vehicle);

    */

        //Comlete service methods.....


    }







}
