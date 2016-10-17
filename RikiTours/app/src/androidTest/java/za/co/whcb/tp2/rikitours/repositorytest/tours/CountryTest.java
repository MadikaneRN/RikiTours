package za.co.whcb.tp2.rikitours.repositorytest.tours;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.CountryRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
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
        Country country = CountryFactory.getCountry(1L, "south-africa", "South Africa is a country on the southernmost", "sa.jpg");
        assertEquals(true, countryRepo.addCountry(country));
    }

    public void findCountryById() {
        Country country = countryRepo.findCountryById(12L);
        assertEquals("south-africa", country.getName());
    }
}
