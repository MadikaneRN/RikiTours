package za.co.whcb.tp2.rikitours;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.repository.local.common.CountryRepo;

/**
 * Created by work on 10/8/2016.
 */

public class CountryTest extends AndroidTestCase {

    private CountryRepo countryRepo ;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        countryRepo = new CountryRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        countryRepo.close();
        super.tearDown();
    }

    public void addCountryTest() {
        Country country = CountryFactory.getCountry((long) 16.0,"south-africa","South Africa is a country on the southernmost", "sa.jpg");
        assertEquals(true, countryRepo.addCountry(country));
    }



}
