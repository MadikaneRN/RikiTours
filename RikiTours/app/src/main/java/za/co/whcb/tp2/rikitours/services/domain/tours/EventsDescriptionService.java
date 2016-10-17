package za.co.whcb.tp2.rikitours.services.domain.tours;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;
import za.co.whcb.tp2.rikitours.repository.local.tour.EventDescriptionRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class EventsDescriptionService extends Service {
    private EventDescriptionRepo eventDescriptionRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public EventsDescriptionService() {
        eventDescriptionRepo = new EventDescriptionRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public EventsDescriptionService getService()
        {
            return EventsDescriptionService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(EventsDescription description) {

        return eventDescriptionRepo.addEvent(description);
    }

    public EventsDescription findById(long id) {
        return eventDescriptionRepo.findEventsDescriptionById(id);
    }

    public boolean update(EventsDescription updateEventsDescription, long id) {
        return eventDescriptionRepo.updateEventDescription(updateEventsDescription,id);
    }

    public boolean deleteById(long id) {
        return eventDescriptionRepo.deleteById(id);
    }

    public ArrayList<EventsDescription> findAll() {
        return eventDescriptionRepo.getAllEventsDescription();
    }
}
