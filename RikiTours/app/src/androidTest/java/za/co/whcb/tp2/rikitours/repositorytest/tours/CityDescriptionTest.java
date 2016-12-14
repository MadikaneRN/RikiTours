package za.co.whcb.tp2.rikitours.repositorytest.tours;

import android.database.sqlite.SQLiteOpenHelper;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.CityDescriptionRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class CityDescriptionTest extends AndroidTestCase {

    private CityDescriptionRepo descriptionRepo ;
    private static Country country;
    private long id;

    @Override
    public void setUp() throws Exception {

        super.setUp();

        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        descriptionRepo = new CityDescriptionRepo(context);
        country = CountryFactory.getCountry(100,"South Africa","dangerous","sa.jpg");
    }

    @Override
    public void tearDown() throws Exception {

        descriptionRepo.close();
        super.tearDown();
    }

    public void testAddAttractionDescriptionTest() {

        CityDescription description = CityDescriptionFactory.getCityDescription(100,"Cape Town is great",country);
        boolean isAdded = descriptionRepo.addCityDescription(description);

        assertTrue(isAdded);


    }

}
