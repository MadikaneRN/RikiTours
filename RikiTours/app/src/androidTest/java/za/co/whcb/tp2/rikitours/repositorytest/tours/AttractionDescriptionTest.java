package za.co.whcb.tp2.rikitours.repositorytest.tours;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionDescriptionRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class AttractionDescriptionTest extends AndroidTestCase {
    
    private AttractionDescriptionRepo attractionDescriptionRepo ;

    @Override
    public void setUp() throws Exception {

        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        attractionDescriptionRepo = new AttractionDescriptionRepo(context);
    }

    @Override
    public void tearDown() throws Exception {

        attractionDescriptionRepo.close();
        super.tearDown();
    }

    public void addAttractionDescriptionTest() {

        AttractionDescription description = AttractionDescriptionFactory.getAttractionDescription(1L, "Table Mountain", "Cape Town","mountain", "sa.jpg");
        assertNull(description);
    }

    public void findAttractionDescriptionById() {

        AttractionDescription description = attractionDescriptionRepo.findAttractionDescriptionById(1L);
        assertNull(description);
        assertEquals("Cape Tow", description.getCity());
    }
}
