package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;
import za.co.whcb.tp2.rikitours.repository.local.tour.SeasonDescriptionRepo;

/**
 * Created by Encore on 10/24/2016.
 */
public class SeasonDescriptionService extends Service{
    private SeasonDescriptionRepo seasonDescriptionRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public SeasonDescriptionService() {
        seasonDescriptionRepo = new SeasonDescriptionRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public SeasonDescriptionService getService()
        {
            return SeasonDescriptionService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(SeasonDescription seasonDescription) {

        return seasonDescriptionRepo.addSeasonDescription(seasonDescription);
    }

    public SeasonDescription findById(long id) {
        return seasonDescriptionRepo.findSeaseonDescriptionById(id);
    }

    public boolean update(SeasonDescription updateSeasonDescription, long id) {
        return seasonDescriptionRepo.updateSeasonDescription(updateSeasonDescription,id);
    }

    public boolean deleteById(long id) {
        return seasonDescriptionRepo.deleteById(id);
    }

    public ArrayList<SeasonDescription> findAll() {
        return seasonDescriptionRepo.getAllSeasonDescriptions();
    }
}
