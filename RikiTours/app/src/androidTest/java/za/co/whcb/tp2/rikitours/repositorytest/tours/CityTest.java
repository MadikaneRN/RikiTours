package za.co.whcb.tp2.rikitours.repositorytest.tours;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.CityRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class CityTest extends AndroidTestCase {
    private CityRepo cityRepo ;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        cityRepo = new CityRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        cityRepo.close();
        super.tearDown();
    }

    public void addAttractionDescriptionTest() {
        CityDescription description = CityDescriptionFactory.getCityDescription(1L, "one", "two");
        City city = CityFactory.getCity(1L, "one", description);
        boolean isAdded = cityRepo.addCity(city);
        assertNull(description);
        assertTrue(isAdded);
    }

    public void findAttractionDescriptionById() {
        City city = cityRepo.findCityById(1L);
        assertNull(city);
    }
}
