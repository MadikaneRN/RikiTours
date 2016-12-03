package za.co.whcb.tp2.rikitours.factories.accommodation;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;

/**
 * Created by lindo on 2016-12-03.
 */
public class RoomFactory {
    public static Room getRoom(long id, String size, String type, String description, Hotel hotel)
    {
        return new Room.Builder()
                .id(id)
                .size(size)
                .type(type)
                .description(description)
                .hotel(hotel)
                .build();
    }
}
