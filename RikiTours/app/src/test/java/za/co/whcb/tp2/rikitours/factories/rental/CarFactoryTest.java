package za.co.whcb.tp2.rikitours.factories.rental;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.rental.Car;

/**
 * Created by berka on 10/10/2016.
 */
public class CarFactoryTest {

    @Test
    public void testGetCar() throws Exception
    {

<<<<<<< HEAD
        Car car = CarFactory.getCar(12,"CA-7889","SUV");
=======
        Car car = CarFactory.getCar(10,"CA-7889","SUV");
>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
        Assert.assertNotNull(car);
        Assert.assertEquals(car.getCarType(),"SUV");
    }
}
