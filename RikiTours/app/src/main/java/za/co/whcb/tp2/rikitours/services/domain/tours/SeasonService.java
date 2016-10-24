package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Seasons;
import za.co.whcb.tp2.rikitours.repository.local.tour.SeasonsRepo;

/**
 * Created by Encore on 10/24/2016.
 */
public class SeasonService extends Service {
    private SeasonsRepo seasonsRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public SeasonService() {
        seasonsRepo = new SeasonsRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public SeasonService getService()
        {
            return SeasonService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Seasons seasons) {

        return seasonsRepo.addSeason(seasons);
    }

    public Seasons findById(long id) {
        return seasonsRepo.findSeasonById(id);
    }

    public boolean update(Seasons updateSeasons, long id) {
        return seasonsRepo.updateSeason(updateSeasons,id);
    }

    public boolean deleteById(long id) {
        return seasonsRepo.deleteById(id);
    }

    public ArrayList<Seasons> findAll() {
        return seasonsRepo.getAllSeasons();
    }
}
