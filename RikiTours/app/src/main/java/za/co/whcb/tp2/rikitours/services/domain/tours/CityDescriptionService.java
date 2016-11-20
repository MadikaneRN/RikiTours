package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
//import za.co.whcb.tp2.rikitours.repository.local.tour.CityDescriptionRepo;


/**
 * Created by Shaun Mesias on 2016/10/17.
 */
/*
public class CityDescriptionService extends Service {
    private CityDescriptionRepo cityDescriptionRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public CityDescriptionService() {
        cityDescriptionRepo = new CityDescriptionRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public CityDescriptionService getService()
        {
            return CityDescriptionService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(CityDescription description) {

        return cityDescriptionRepo.addCityDescription(description);
    }

    public CityDescription findById(long id) {
        return cityDescriptionRepo.findCityDescriptionById(id);
    }

    public boolean update(CityDescription updateAttractionDescription, long id) {
        return cityDescriptionRepo.updateCityDescription(updateAttractionDescription,id);
    }

    public boolean deleteById(long id) {
        return cityDescriptionRepo.deleteById(id);
    }

    public ArrayList<CityDescription> findAll() {
        return cityDescriptionRepo.getAllCityDescriptions();
    }
}
*/