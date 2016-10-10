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
public class AddCountryService extends Service {

    private final IBinder countryBinder = new LocalBinder();

    public AddCountryService(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return countryBinder;
    }

    public class LocalBinder extends Binder {
        public AddCountryService getService() {
            return AddCountryService.this;
        }
    }

    public boolean add(Country country) {
        CountryRepo countryRepo = new CountryRepo(this);
        return countryRepo.addCountry(country);
    }
}
