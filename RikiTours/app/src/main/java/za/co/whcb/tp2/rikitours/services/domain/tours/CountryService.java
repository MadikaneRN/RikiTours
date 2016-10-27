package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.repository.local.tour.CountryRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class CountryService extends Service {
    private CountryRepo countryRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public CountryService() {
        countryRepo = new CountryRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public CountryService getService()
        {
            return CountryService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Country description) {

        return countryRepo.addCountry(description);
    }

    public Country findById(long id) {
        return countryRepo.findCountryById(id);
    }

    public boolean update(Country updateAttractionDescription, long id) {
        return countryRepo.updateAttractionDescription(updateAttractionDescription,id);
    }

    public boolean deleteById(long id) {
        return countryRepo.deleteById(id);
    }

    public ArrayList<Country> findAll() {
        return countryRepo.getAllCountries();
    }
}
