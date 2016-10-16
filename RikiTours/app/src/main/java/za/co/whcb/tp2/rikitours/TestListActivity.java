package za.co.whcb.tp2.rikitours;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import za.co.whcb.tp2.rikitours.common.adapter.CountryAdapter;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

public class TestListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);

        Country country1 = CountryFactory.getCountry((long) 26,"canada","South Africa is a country on the southernmost", "http://capetown.hotelguide.co.za/images/1sea-point-beach-summer-cape-town.jpg");
        Country country2 = CountryFactory.getCountry((long) 27,"congo","République démocratique du Congo (French). Repubilika ya Kôngo ya Dimokalasi", "http://capetown.hotelguide.co.za/images/bantry-bay-luxury-suites-ocean-480.jpg");
        Country country3 = CountryFactory.getCountry((long) 28,"zambi"," trading as Zambi Wildlife Retreat, its 's mission is to rescue, rehabilitate", "http://www.zawebsdata.co.za/image/large/villa_sunshine_guest_house_cape_town_accommodation_01.jpg");
        Country country4 = CountryFactory.getCountry((long) 28,"south africa","Responsible for the promotion of tourism to South Africa in the United Kingdom", "https://www.accommodirect.com/media/thumbnails/pictures/places/5326/5326-2.jpg.1366x768_q75.jpg");

        Country countries[] = {country1,country2,country3,country4};

        CountryAdapter adapter = new CountryAdapter(this,countries);
        ListView l = (ListView) findViewById(R.id.listView2);
        l.setAdapter(adapter);

    }
}
