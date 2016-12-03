package za.co.whcb.tp2.rikitours.services.domain.accommodation;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.repository.local.accommodation.RoomRepo;

/**
 * Created by lindo on 2016-12-03.
 */
public class RoomService extends Service {

    private RoomRepo roomRepo;

    private final IBinder myLocalBinder = new MyLocalBinder();
    public RoomService() {
        roomRepo = new RoomRepo(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myLocalBinder;
    }

    public  class MyLocalBinder extends Binder
    {
        public RoomService getService()
        {
            return RoomService.this;
        }
    }

    public String test() {
        return "works";
    }

    public boolean add(Room room) {

        return roomRepo.addRoom(room);
    }

    public Room findById(long id) {
        return roomRepo.findRoomById(id);
    }

    public boolean update(Room updateRoom, long id) {
        return roomRepo.updateRoom(updateRoom, id);
    }

    public boolean deleteById(long id) {
        return roomRepo.deleteById(id);
    }

    public ArrayList<Room> findAll() {
        return roomRepo.getAllRooms();
    }
}
