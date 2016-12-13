package za.co.whcb.tp2.rikitours.repositorytest.office;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.office.Office;
import za.co.whcb.tp2.rikitours.factories.office.OfficeFactory;
import za.co.whcb.tp2.rikitours.repository.local.office.OfficeRepo;

/**
 * Created by Lindo on 10/17/2016.
 */
public class OfficeTest extends AndroidTestCase {

    private OfficeRepo officeRepo;

    @Override
    public void setUp() throws Exception {

        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        officeRepo = new OfficeRepo(context);
    }

    @Override
    public void tearDown() throws Exception {

        officeRepo.close();
        super.tearDown();
    }

    public void addOfficeTest() {

        Office office = OfficeFactory.getOffice((long) 16.0,"Cape Town","Gardens");
        assertEquals(true, officeRepo.addOffice(office));
    }

    public void findOfficeById() {

        Office office = officeRepo.findOfficeById((long)16.0);
        assertEquals("Cape Town", office.getCity());
    }

}
