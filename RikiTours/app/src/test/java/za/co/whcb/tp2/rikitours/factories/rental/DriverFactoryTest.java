package za.co.whcb.tp2.rikitours.factories.rental;

import junit.framework.Assert;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.rental.Driver;

import static org.junit.Assert.*;

/**
 * Created by berka on 10/16/2016.
 */
public class DriverFactoryTest {

    @Test
    public void testGetDriver() throws Exception {

        Driver driver = DriverFactory.getDriver(22,"Michael","CM33","yes");

        Assert.assertEquals("Michael",driver.getFname());
        Assert.assertEquals(22,driver.getId());


    }
}