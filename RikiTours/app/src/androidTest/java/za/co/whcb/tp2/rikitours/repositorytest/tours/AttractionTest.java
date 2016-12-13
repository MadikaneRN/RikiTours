package za.co.whcb.tp2.rikitours.repositorytest.tours;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionsRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class AttractionTest extends AndroidTestCase {

    private AttractionsRepo attractionRepo ;

    @Override
    public void setUp() throws Exception {

        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        attractionRepo = new AttractionsRepo(context);
    }

    @Override
    public void tearDown() throws Exception {

        attractionRepo.close();
        super.tearDown();
    }

    public void addAttractionDescriptionTest() {

        AttractionDescription description = AttractionDescriptionFactory.getAttractionDescription(1L,"one", "two", "three", "four");
        Country country = CountryFactory.getCountry(1L, "south-africa", "South Africa is a country on the southernmost", "sa.jpg");

        Attraction attraction = AttractionFactory.getAttraction(1L, country, description);
        boolean isAdded = attractionRepo.addAttraction(attraction);

        assertNull(description);
        assertTrue(isAdded);
    }

    public void findAttractionDescriptionById() {

        Attraction description = attractionRepo.findAtractionById(1L);
        assertNull(description);
    }
}
