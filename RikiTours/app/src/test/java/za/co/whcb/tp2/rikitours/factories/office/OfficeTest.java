package za.co.whcb.tp2.rikitours.factories.office;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.office.Office;


/**
 * Created by LILO on 2016/10/10.
 */
public class OfficeTest {

    private Office office;

    @Before
    public void setUp() throws Exception {

        office = OfficeFactory.getOffice(12345L,"Cape Town","Gardens");
    }

    @Test
    public void testOffice() throws Exception {
        Assert.assertNotNull(office);
        Assert.assertEquals("Cape Town", office.getCity());
    }

    @Test
    public void testOfficeUpdate() throws Exception {
        
        Office newOffice  = new Office.Builder().copy(office).city("Durban") .build();
        Assert.assertEquals("Durban", newOffice.getCity());
    }
}
