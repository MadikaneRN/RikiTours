package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Events;
import za.co.whcb.tp2.rikitours.repository.local.tour.EventsRepo;

/**
 * Created by Encore on 10/24/2016.
 */
public class EventsService extends Service {

    private EventsRepo eventsRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public EventsService() {
        eventsRepo = new EventsRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public EventsService getService()
        {
            return EventsService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Events events) {

        return eventsRepo.addEvent(events);
    }

    public Events findById(long id) {
        return eventsRepo.findEventById(id);
    }

    public boolean update(Events updateEvents, long id) {
        return eventsRepo.updateEvents(updateEvents,id);
    }

    public boolean deleteById(long id) {
        return eventsRepo.deleteById(id);
    }

    public ArrayList<Events> findAll() {
        return eventsRepo.getAllEvents();
    }
}
