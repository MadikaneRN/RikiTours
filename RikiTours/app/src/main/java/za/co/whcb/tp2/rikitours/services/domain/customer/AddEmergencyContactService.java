//package za.co.whcb.tp2.rikitours.services.domain.customer;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.Binder;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//
//import za.co.whcb.tp2.rikitours.repository.local.customer.EmergencyContactRepo;
//
//*
// * Created by Tamonne on 10/10/2016.
//
//
//public class AddEmergencyContactService extends Service {
//
//    private final IBinder emergencyContactBinder = new LocalBinder();
//
//    public AddEmergencyContactService(){
//
//    }
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return emergencyContactBinder;
//    }
//
//    public class LocalBinder extends Binder {
//        public AddEmergencyContactService getService() {
//            return AddEmergencyContactService.this;
//        }
//    }
//
//    public boolean add(EmergencyContact emergencyContact) {
//        EmergencyContactRepo emergencyContactRepo = new EmergencyContactRepo(this);
//        return emergencyContactRepo.addEmergencyContact(emergencyContact);
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
