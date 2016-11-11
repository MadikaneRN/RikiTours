package za.co.whcb.tp2.rikitours.repositorytest.rental;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import junit.framework.Assert;

import za.co.whcb.tp2.rikitours.domain.rental.Car;
import za.co.whcb.tp2.rikitours.factories.rental.CarFactory;
import za.co.whcb.tp2.rikitours.repository.local.rental.CarRepo;

/**
 * Created by berka on 11/10/2016.
 */
public class CarTest extends AndroidTestCase {

    private CarRepo carRepo;



    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        carRepo = new CarRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        carRepo.close();
        super.tearDown();
    }

    public void addCountryTest()
    {
        Car car = CarFactory.getCar((long) 12.0, "CA22","SUV");
        Assert.assertEquals(true,carRepo.addCar(car));
    }

    
    public void findVehicleById() {
       Car car = carRepo.findCarById((long)16.0);
        assertEquals("SUV", car.getCarType());
    }






}
