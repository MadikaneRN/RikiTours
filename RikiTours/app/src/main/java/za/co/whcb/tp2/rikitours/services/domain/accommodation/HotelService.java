package za.co.whcb.tp2.rikitours.services.domain.accommodation;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.repository.local.accommodation.HotelRepo;

/**
 * Created by lindo on 2016-12-03.
 */
public class HotelService extends Service {

    private HotelRepo hotelRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public HotelService() {
        hotelRepo = new HotelRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public HotelService getService()
        {
            return HotelService.this;
        }
    }


    public String test() {
        return "works";
    }

    public boolean add(Hotel hotel) {

        return hotelRepo.addHotel(hotel);
    }

    public Hotel findById(long id) {
        return hotelRepo.findHotelById(id);
    }

    public boolean update(Hotel updateHotel, long id) {
        return hotelRepo.updateHotel(updateHotel, id);
    }

    public boolean deleteById(long id) {
        return hotelRepo.deleteById(id);
    }

    public ArrayList<Hotel> findAll() {
        return hotelRepo.getAllHotels();
    }
}
