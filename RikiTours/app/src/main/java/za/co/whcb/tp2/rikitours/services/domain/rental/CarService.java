package za.co.whcb.tp2.rikitours.services.domain.rental;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.rental.Car;
import za.co.whcb.tp2.rikitours.repository.local.rental.CarRepo;

/**
<<<<<<< HEAD
 * Created by bishop v on 2016-11-11.
=======
 * Created by berka on 12/12/2016.
>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
 */
public class CarService extends Service {

    private CarRepo carRepo;
    private final IBinder myLocalBinder = new MyLocalBinder();

<<<<<<< HEAD

=======
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }


    public boolean add(Car vehicle)
    {
        return carRepo.addCar(vehicle);
    }
>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
    public class MyLocalBinder extends Binder
    {
        public CarService getService()
        {
            return CarService.this;
        }
    }
<<<<<<< HEAD


    public boolean add(Car car)
    {
        return carRepo.addCar(car);
    }


    public String test()
    {
        return "works";
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public boolean update(Car updateCar, long id)
    {
        return carRepo.updateCar(updateCar,id);
    }

    public boolean deleteById(long id )
    {
        return carRepo.deleteById(id);
    }

    public ArrayList<Car> findAll()
    {
        return carRepo.getAllCar();
    }
=======
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



>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266


}
