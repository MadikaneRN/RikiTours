package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Itenary;
import za.co.whcb.tp2.rikitours.repository.local.tour.ItenaryRepo;

/**
 * Created by Encore on 10/24/2016.
 */
public class ItenaryService extends Service {
    private ItenaryRepo itenaryRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public ItenaryService() {
        itenaryRepo = new ItenaryRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public ItenaryService getService()
        {
            return ItenaryService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Itenary itenary) {

        return itenaryRepo.addItenary(itenary);
    }

    public Itenary findById(long id) {
        return itenaryRepo.findItenaryById(id);
    }

    public boolean update(Itenary updateItenary, long id) {
        return itenaryRepo.updateItenary(updateItenary,id);
    }

    public boolean deleteById(long id) {
        return itenaryRepo.deleteById(id);
    }

    public ArrayList<Itenary> findAll() {
        return itenaryRepo.getAllItenaries();
    }
}
