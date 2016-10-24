package za.co.whcb.tp2.rikitours;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.adapter.gallery.GalleryViewAdapter;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;
import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;

public class GalleryViewActivity extends AppCompatActivity {

    ViewPager viewPager;
    GalleryViewAdapter galleryViewAdapter;
    GalleryContainer galleryContainer ;
    ArrayList<RikiImage> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);

        ArrayList<RikiImage> images = new ArrayList<>();

//        images.add("http://atlastravel.s3.amazonaws.com/sitehomepics/canadianrockies.jpg");
//        images.add("https://timestylelife.files.wordpress.com/2012/10/victoriafalls.jpg");
//        images.add("http://www.travelnewsdigest.in/wp-content/uploads/2015/04/Zambia-Tourism1.jpg");
//        images.add("http://favim.com/orig/201106/30/beatiful-beautiful-eclipse-field-green-lavendar-Favim.com-88836.jpg");
//        images.add("http://s6.favim.com/610/65/Favim.com-amazing-beach-beatiful-cool-590410.jpg");

        Bundle bundle = getIntent().getExtras();
        images.add(new RikiImage("name", bundle.getString("image1")));
        images.add(new RikiImage("name", bundle.getString("image2")));
        images.add(new RikiImage("name", bundle.getString("image3")));
        images.add(new RikiImage("name", bundle.getString("image4")));
        images.add(new RikiImage("name", bundle.getString("image5")));

        galleryContainer = new GalleryContainer(images,bundle.getString("title"));

        if (galleryContainer  != null) {
            setTitle(galleryContainer.getTitle());

            galleryViewAdapter = new GalleryViewAdapter(galleryContainer,this);
            viewPager = (ViewPager) findViewById(R.id.viewPage);
            viewPager.setAdapter(galleryViewAdapter);
        }



    }
}
