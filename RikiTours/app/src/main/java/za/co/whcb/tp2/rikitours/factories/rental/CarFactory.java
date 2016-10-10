package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.rental.Car;

/**
 * Created by berka on 10/10/2016.
 */
public class CarFactory {



    public static Car getCar(String regNumber, String carType)
    {
        return new Car.Builder()
                .regNumber(regNumber)
                .carType(carType)
                .build();
    }

}
