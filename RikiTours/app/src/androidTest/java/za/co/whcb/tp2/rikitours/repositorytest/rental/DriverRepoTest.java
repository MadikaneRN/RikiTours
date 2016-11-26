package za.co.whcb.tp2.rikitours.repositorytest.rental;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import junit.framework.Assert;

import za.co.whcb.tp2.rikitours.domain.rental.Driver;
import za.co.whcb.tp2.rikitours.factories.rental.DriverFactory;
import za.co.whcb.tp2.rikitours.repository.local.rental.DriverRepo;

/**
 * Created by berka on 10/16/2016.
 */
public class DriverRepoTest extends AndroidTestCase {

    private DriverRepo driverRepo ;



    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        driverRepo = new DriverRepo(context);
    }


    @Override
    public void tearDown() throws Exception {
        driverRepo.close();
        super.tearDown();
    }


    public void addDriverTest() {
        Driver driver = DriverFactory.getDriver((long) 16.0,"madikane","yes","CM33");

        Assert.assertEquals(true,driverRepo.addDriver(driver));
    }


    public void findDriverById() {
        Driver driver = driverRepo.findDriverById((long)16.0);
        Assert.assertEquals("madikane",driver.getFname());

        System.out.println(driver.getFname());
    }



}
