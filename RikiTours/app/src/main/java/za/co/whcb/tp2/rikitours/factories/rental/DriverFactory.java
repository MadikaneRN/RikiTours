package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.rental.Driver;

/**
 * Created by berka on 10/16/2016.
 */
public class DriverFactory {

    public static Driver getDriver(long id, String fname, String driverId, String active)
    {
        return new Driver.Builder()
                .id(id)
                .fname(fname)
                .active(active)
                .driverId(driverId)
                .build();
    }
}
