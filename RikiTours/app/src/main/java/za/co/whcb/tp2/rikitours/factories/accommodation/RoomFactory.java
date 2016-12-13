package za.co.whcb.tp2.rikitours.factories.accommodation;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;

/**
 * Created by berka on 11/26/2016.
 */
public class RoomFactory {

    public static Room getRoom(long id, String size, String type, Hotel hotel, String description)
    {
        return new Room.Builder()
                .id(id)
                .size(size)
                .type(type)
                .hotel(hotel)
                .description(description)
                .build();
    }
}
