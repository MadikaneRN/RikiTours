package za.co.whcb.tp2.rikitours.factories.tour;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import za.co.whcb.tp2.rikitours.factories.tour.testcases.AttractionDescriptionTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.AttractionTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.CityDescriptionTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.CityTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.CountryDescriptionTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.CountryTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.EventDescriptionTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.EventsTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.SeasonDescriptionTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.SeasonTest;
import za.co.whcb.tp2.rikitours.factories.tour.testcases.TourTest;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AttractionDescriptionTest.class,
        AttractionTest.class,
        CityDescriptionTest.class,
        CityTest.class,
        CountryDescriptionTest.class,
        CountryTest.class,
        EventDescriptionTest.class,
        EventsTest.class,
        SeasonDescriptionTest.class,
        SeasonTest.class,
        TourTest.class
})

public class TestSuite {
}
