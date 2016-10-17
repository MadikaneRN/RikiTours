package za.co.whcb.tp2.rikitours;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.rental.Driver;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

import za.co.whcb.tp2.rikitours.factories.rental.DriverFactory;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;

import za.co.whcb.tp2.rikitours.repository.local.rental.DriverRepo;
import za.co.whcb.tp2.rikitours.repository.local.rental.VehicleRepo;

public class MainActivity extends AppCompatActivity {
    private VehicleRepo vehicleRepo;

    private DriverRepo driverRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //vehicleRepo = new VehicleRepo(this);
        //UpdateRepo
        //Vehicle vehicle = VehicleFactory.getVehicle(12l,"AUDI","M3","2014");

        driverRepo = new DriverRepo(this);

        //Driver driver = DriverFactory.getDriver(10,"Madikane","CA33","yes");

        Driver driver = driverRepo.findDriverById(10);
        Display.toast(driver.getFname(),this);

        /*if(driverRepo.addDriver(driver) == true)
        {
            Display.toast(driver.getFname(),this);
        }
        else
        {
            Display.toast("failed to add Driver",this);
        }
*/

        //vehicleRepo = new VehicleRepo(this);
        //Vehicle vehicle = VehicleFactory.getVehicle(21,"BMW","M3","2013");

      //Vehicle vehicle = vehicleRepo.findVehicleById(12l);

       // Display.toast(vehicle.getVehicleName(), this);



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
