package za.co.whcb.tp2.rikitours.services.domain.rental;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.rental.Driver;
import za.co.whcb.tp2.rikitours.repository.local.rental.DriverRepo;

/**
 * Created by berka on 10/16/2016.
 */
public class DriverService extends Service {

    private DriverRepo driverRepo;
    private final IBinder myLocalBinder = new DriverService.MyLocalBinder();


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }


    public class MyLocalBinder extends Binder
    {
        public DriverService getService()
        {
            return DriverService.this;
        }
    }

    public String test()
    {
        return "works";
    }

    public boolean add(Driver driver) {
        return driverRepo.addDriver(driver);
    }

    public boolean update(Driver updateDriver, long id)
    {
        return driverRepo.updateDriver(updateDriver,id);
    }

    public boolean deleteById(long id )
    {
        return driverRepo.deleteById(id);
    }

    public ArrayList<Driver> findAll()
    {
        return driverRepo.getAllDrivers();
    }


}
