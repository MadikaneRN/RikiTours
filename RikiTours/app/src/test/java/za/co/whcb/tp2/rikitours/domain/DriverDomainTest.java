package za.co.whcb.tp2.rikitours.domain;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.rental.Driver;

/**
 * Created by berka on 10/16/2016.
 */
public class DriverDomainTest {

    @Test
    public void testDriverCreation()
    {
        Driver driver = new Driver.Builder()
                .id(2l)
                .fname("Michael")
                .driverId("CA22")
                .active("yes")
                .build();



        Assert.assertNotNull(driver);
        Assert.assertEquals(driver.getId(),2l);
        Assert.assertEquals(driver.getDriverId(),"CA22");
        Assert.assertEquals("yes",driver.getActive());
        Assert.assertEquals("Michael",driver.getFname());



    }


}
