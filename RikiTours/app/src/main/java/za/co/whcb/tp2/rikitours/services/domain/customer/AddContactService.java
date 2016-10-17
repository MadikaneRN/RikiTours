package za.co.whcb.tp2.rikitours.services.domain.customer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import za.co.whcb.tp2.rikitours.domain.customer.Contact;
import za.co.whcb.tp2.rikitours.repository.local.customer.ContactRepo;

/**
 * Created by Tamonne on 10/10/2016.
 */
public class AddContactService extends Service {

    private final IBinder contactBinder = new LocalBinder();

    public AddContactService(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return contactBinder;
    }

    public class LocalBinder extends Binder {
        public AddContactService getService() {
            return AddContactService.this;
        }
    }

    public boolean add(Contact contact) {
        ContactRepo contactRepo = new ContactRepo(this);
        return contactRepo.addContact(contact);
    }
}













