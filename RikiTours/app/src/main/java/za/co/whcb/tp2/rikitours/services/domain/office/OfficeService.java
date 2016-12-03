package za.co.whcb.tp2.rikitours.services.domain.office;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.office.Office;
import za.co.whcb.tp2.rikitours.repository.local.office.OfficeRepo;

/**
 * Created by Lindo on 10/17/2016.
 */
public class OfficeService extends Service{

    private OfficeRepo officeRepo;

    private final  IBinder myLocalBinder = new MyLocalBinder();
    public OfficeService() {
        officeRepo = new OfficeRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public OfficeService getService()
        {
            return OfficeService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Office office) {

        return officeRepo.addOffice(office);
    }

    public Office findById(long id) {
        return officeRepo.findOfficeById(id);
    }

    public boolean update(Office updateOffice, long id) {
        return officeRepo.updateOffice(updateOffice,id);
    }

    public boolean deleteById(long id) {
        return officeRepo.deleteById(id);
    }

    public ArrayList<Office> findAll() {
        return officeRepo.getAllOffice();
    }

}
