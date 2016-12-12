package za.co.whcb.tp2.rikitours.services.domain.rental;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.rental.Car;
import za.co.whcb.tp2.rikitours.repository.local.rental.CarRepo;

/**
 * Created by berka on 12/12/2016.
 */
public class CarService extends Service {

    private CarRepo carRepo;
    private final IBinder myLocalBinder = new MyLocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }


    public boolean add(Car vehicle)
    {
        return carRepo.addCar(vehicle);
    }
    public class MyLocalBinder extends Binder
    {
        public CarService getService()
        {
            return CarService.this;
        }
    }
    public boolean deleteById(long id )
    {
        return carRepo.deleteById(id);
    }
    public boolean update(Car updateVehicle, long id)
    {
        return carRepo.updateCar(updateVehicle,id);
    }
    public ArrayList<Car> findAll()
    {
        return carRepo.getAllVehicles();
    }
    public Car findById(long id)
    {
        return carRepo.findCarById(id);
    }





}
