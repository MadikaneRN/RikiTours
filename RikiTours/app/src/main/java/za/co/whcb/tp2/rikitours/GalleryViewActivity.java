package za.co.whcb.tp2.rikitours;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.adapter.gallery.GalleryViewAdapter;

public class GalleryViewActivity extends AppCompatActivity {

    ViewPager viewPager;
    GalleryViewAdapter galleryViewAdapter;
    ArrayList<String> images  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery_view);
        images.add("http://atlastravel.s3.amazonaws.com/sitehomepics/canadianrockies.jpg");
        images.add("https://timestylelife.files.wordpress.com/2012/10/victoriafalls.jpg");
        images.add("http://www.travelnewsdigest.in/wp-content/uploads/2015/04/Zambia-Tourism1.jpg");

        galleryViewAdapter = new GalleryViewAdapter(images,this);
        viewPager = (ViewPager) findViewById(R.id.viewPage);
        viewPager.setAdapter(galleryViewAdapter);
    }
}
