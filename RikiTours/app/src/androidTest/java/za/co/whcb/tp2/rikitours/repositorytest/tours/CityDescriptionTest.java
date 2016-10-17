package za.co.whcb.tp2.rikitours.repositorytest.tours;

import android.database.sqlite.SQLiteOpenHelper;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.CityDescriptionRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class CityDescriptionTest extends AndroidTestCase {
    private CityDescriptionRepo descriptionRepo ;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        descriptionRepo = new CityDescriptionRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        descriptionRepo.close();
        super.tearDown();
    }

    public void addAttractionDescriptionTest() {
        CityDescription description = CityDescriptionFactory.getCityDescription(1L, "one", "two");
        boolean isAdded = descriptionRepo.addCityDescription(description);
        assertNull(description);
        assertTrue(isAdded);
    }

    public void findAttractionDescriptionById() {
        CityDescription description = descriptionRepo.findCityDescriptionById(1L);
        assertNull(description);
    }
}
