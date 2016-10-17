package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionDescriptionRepo;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionsRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class AttractionService extends Service {
    private AttractionsRepo attractionRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public AttractionService() {
        attractionRepo = new AttractionsRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public AttractionService getService()
        {
            return AttractionService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Attraction description) {

        return attractionRepo.addAttraction(description);
    }

    public Attraction findById(long id) {
        return attractionRepo.findAtractionById(id);
    }

    public boolean update(Attraction updateAttraction, long id) {
        return attractionRepo.updateAttraction(updateAttraction,id);
    }

    public boolean deleteById(long id) {
        return attractionRepo.deleteById(id);
    }

    public ArrayList<Attraction> findAll() {
        return attractionRepo.getAllAttractions();
    }
}
