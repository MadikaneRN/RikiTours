package za.co.whcb.tp2.rikitours.services.domain.rental;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.repository.local.rental.RentalRepo;

/**
 * Created by Lindo on 2016-10-22.
 */
public class RentalService extends Service {

    private RentalRepo rentalRepo;

    private final  IBinder myLocalBinder = new MyLocalBinder();
    public RentalService() {
        rentalRepo = new RentalRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public RentalService getService()
        {
            return RentalService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Rental rental) {

        return rentalRepo.addRenatl(rental);
    }

    public Rental findById(long id) {
        return rentalRepo.findRentalById(id);
    }

    public boolean update(Rental updateRental, long id) {
        return rentalRepo.updateRental(updateRental,id);
    }

    public boolean deleteById(long id) {
        return rentalRepo.deleteById(id);
    }

    public ArrayList<Rental> findAll() {
        return rentalRepo.getAllRentals();
    }
}
