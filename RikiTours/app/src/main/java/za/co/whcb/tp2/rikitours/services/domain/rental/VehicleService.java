package za.co.whcb.tp2.rikitours.services.domain.rental;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.repository.local.rental.VehicleRepo;

/**
 * Created by berka on 10/15/2016.
 */
public class VehicleService extends Service {

    private VehicleRepo vehicleRepo;
    private final  IBinder myLocalBinder = new MyLocalBinder();


    public VehicleService ()
    {
        vehicleRepo = new VehicleRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }


    public class MyLocalBinder extends Binder
    {
        public VehicleService getService()
        {
            return VehicleService.this;
        }
    }


    public String test()
    {
        return "works";
    }

    public boolean add(Vehicle vehicle)
    {
        return vehicleRepo.addVehicle(vehicle); // why boolean
    }

    public Vehicle findById(long id)
    {
        return vehicleRepo.findVehicleById(id);
    }

    public boolean update(Vehicle updateVehicle, long id)
    {
        return vehicleRepo.updateVehicle(updateVehicle,id);
    }

    public boolean deleteById(long id )
    {
        return vehicleRepo.deleteById(id);
    }

    public ArrayList<Vehicle> findAll()
    {
        return vehicleRepo.getAllVehicles();
    }

}
