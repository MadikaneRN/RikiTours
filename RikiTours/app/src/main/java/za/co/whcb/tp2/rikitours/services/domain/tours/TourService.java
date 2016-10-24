package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Tour;
import za.co.whcb.tp2.rikitours.repository.local.tour.TourRepo;

/**
 * Created by Encore on 10/24/2016.
 */
public class TourService extends Service {
    private TourRepo tourRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public TourService() {
        tourRepo = new TourRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public TourService getService()
        {
            return TourService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Tour tour) {

        return tourRepo.addTour(tour);
    }

    public Tour findById(long id) {
        return tourRepo.findTourById(id);
    }

    public boolean update(Tour updateTour, long id) {
        return tourRepo.updateTour(updateTour,id);
    }

    public boolean deleteById(long id) {
        return tourRepo.deleteById(id);
    }

    public ArrayList<Tour> findAll() {
        return tourRepo.getAllTours();
    }
}
