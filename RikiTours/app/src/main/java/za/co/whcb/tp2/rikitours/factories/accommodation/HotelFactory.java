package za.co.whcb.tp2.rikitours.factories.accommodation;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;

/**
 * Created by berka on 11/26/2016.
 */
public class HotelFactory {


    public static Hotel getHotel(long id, String name, String star , String description)
    {
        return new Hotel.Builder()
                .id(id)
                .name(name)
                .star(star)
                .description(description)
                .build();
    }
}
