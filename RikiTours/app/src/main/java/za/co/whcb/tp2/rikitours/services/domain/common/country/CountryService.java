package za.co.whcb.tp2.rikitours.services.domain.common.country;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.repository.local.common.CountryRepo;

/**
 * Created by berka on 10/10/2016.
 */
public class CountryService extends Service {

    private final IBinder countryBinder = new LocalBinder();
    private CountryRepo countryRepo;

    public CountryService(){
        countryRepo = new CountryRepo(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return countryBinder;
    }

    public class LocalBinder extends Binder {
        public CountryService getService() {
            return CountryService.this;
        }
    }

    public boolean add(Country country) {
        return countryRepo.addCountry(country);
    }

    public Country findById(long id) {
        return countryRepo.findCountryById(id);
    }
}
