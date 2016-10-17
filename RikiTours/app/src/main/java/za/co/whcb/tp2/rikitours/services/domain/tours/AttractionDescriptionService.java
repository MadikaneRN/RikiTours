package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.test.RenamingDelegatingContext;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionDescriptionRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class AttractionDescriptionService extends Service{
    private AttractionDescriptionRepo attractionDescriptionRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public AttractionDescriptionService() {
        attractionDescriptionRepo = new AttractionDescriptionRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public AttractionDescriptionService getService()
        {
            return AttractionDescriptionService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(AttractionDescription description) {

        return attractionDescriptionRepo.addAttractionDescription(description);
    }

    public AttractionDescription findById(long id) {
        return attractionDescriptionRepo.findAttractionDescriptionById(id);
    }

    public boolean update(AttractionDescription updateAttractionDescription, long id) {
        return attractionDescriptionRepo.updateAttractionDescription(updateAttractionDescription,id);
    }

    public boolean deleteById(long id) {
        return attractionDescriptionRepo.deleteById(id);
    }

    public ArrayList<AttractionDescription> findAll() {
        return attractionDescriptionRepo.getAllAttractionDescriptions();
    }
}
