package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.rental.Car;

/**
 * Created by berka on 10/10/2016.
 */
public class CarFactory {


<<<<<<< HEAD

=======
>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
    public static Car getCar(long id,String regNumber, String carType)
    {
        return new Car.Builder()
                .id(id)
                .regNumber(regNumber)
                .carType(carType)
                .build();
    }

}
