package za.co.whcb.tp2.rikitours.services.domain.accommodation;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.repository.local.accommodation.HotelRepo;

/**
 * Created by berka on 11/26/2016.
 */
public class HotelService extends Service {

    private HotelRepo hotelRepo;
    private final IBinder myLocalBinder = new MyLocalBinder();

    public HotelService()
    {
        hotelRepo = new HotelRepo(this);
    }

    public boolean add(Hotel hotel)
    {
        return hotelRepo.addHotel(hotel); // why boolean
    }

    public boolean update(Hotel updateHotel, long id)
    {
        return hotelRepo.updateHotel(updateHotel,id);
    }

    public class MyLocalBinder extends Binder
    {
        public HotelService getService()
        {
            return HotelService.this;
        }
    }

    public boolean deleteById(long id )
    {
        return hotelRepo.deleteById(id);
    }

    public ArrayList<Hotel> findAll()
    {
        return hotelRepo.getAllHotels();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public String test()
    {
        return "works";
    }



}
