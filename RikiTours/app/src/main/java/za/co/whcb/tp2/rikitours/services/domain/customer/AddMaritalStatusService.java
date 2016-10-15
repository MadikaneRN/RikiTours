package za.co.whcb.tp2.rikitours.services.domain.customer.MaritalStatus;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import za.co.whcb.tp2.rikitours.domain.customer.MaritalStatus;
import za.co.whcb.tp2.rikitours.repository.local.customer.MaritalStatusRepo;

/**
 * Created by Tamonne on 10/10/2016.
 */
public class AddMaritalStatusService extends Service {
 
    private final IBinder maritalStatusBinder = new LocalBinder();

    public AddMaritalStatusService(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return maritalStatusBinder;
    }

    public class LocalBinder extends Binder {
        public AddMaritalStatusService getService() {
            return AddMaritalStatusService.this;
        }
    }

    public boolean add(MaritalStatus maritalStatus) {
        MaritalStatusRepo maritalStatusRepo = new MaritalStatusRepo(this);
        return MaritalStatusRepo.addMaritalStatus(maritalStatus);
    }
}











