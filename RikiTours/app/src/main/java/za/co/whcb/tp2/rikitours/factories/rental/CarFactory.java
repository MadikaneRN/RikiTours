package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.rental.Car;

/**
 * Created by berka on 10/10/2016.
 */
public class CarFactory {



    public static Car getCar(long id,String regNumber, String carType)
    {
        return new Car.Builder()
                .id(id)
                .regNumber(regNumber)
                .carType(carType)
                .build();
    }

}
