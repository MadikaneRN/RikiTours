package za.co.whcb.tp2.rikitours.services.domain.rental;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.rental.Reservation;
import za.co.whcb.tp2.rikitours.repository.local.rental.ReservationRepo;

/**
 * Created by Lindo on 2016-10-22.
 */
public class ReservationService extends Service{

    private ReservationRepo reservationRepo;

    private final  IBinder myLocalBinder = new MyLocalBinder();
    public ReservationService() {
        reservationRepo = new ReservationRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public ReservationService getService()
        {
            return ReservationService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Reservation reservation) {

        return reservationRepo.addReservation(reservation);
    }

    public Reservation findById(long id) {
        return reservationRepo.findReservationById(id);
    }

    public boolean update(Reservation updateReservation, long id) {
        return reservationRepo.updateReservation(updateReservation,id);
    }

    public boolean deleteById(long id) {
        return reservationRepo.deleteById(id);
    }

    public ArrayList<Reservation> findAll() {
        return reservationRepo.getAllReservations();
    }
}
