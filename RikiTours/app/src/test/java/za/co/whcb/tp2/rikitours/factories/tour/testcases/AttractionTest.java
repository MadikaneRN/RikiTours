package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;

import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionTest {
    @Test
    public void testCreate() throws Exception {
        Country country= CountryFactory.getCountry(1L,"South Africa","Africa","SA.png");

        AttractionDescription attractionDescription = AttractionDescriptionFactory.getAttracionDescription(1L,"Water Front","Cape Town","Sea","waterfront.png");
        Attraction attraction = AttractionFactory.getAttracion(2L,country, attractionDescription);

        Assert.assertNotNull(attraction.getId());
        Assert.assertEquals("SA.png", attraction.getCountryId().getImage());

    }
}
