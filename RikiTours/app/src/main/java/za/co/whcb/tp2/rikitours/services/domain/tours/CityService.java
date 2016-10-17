package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.repository.local.tour.CityRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class CityService extends Service {
    private CityRepo cityRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public CityService() {
        cityRepo = new CityRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public CityService getService()
        {
            return CityService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(City description) {

        return cityRepo.addCity(description);
    }

    public City findById(long id) {
        return cityRepo.findCityById(id);
    }

    public boolean update(City city, long id) {
        return cityRepo.updateCity(city,id);
    }

    public boolean deleteById(long id) {
        return cityRepo.deleteById(id);
    }

    public ArrayList<City> findAll() {
        return cityRepo.getAllCities();
    }
}
