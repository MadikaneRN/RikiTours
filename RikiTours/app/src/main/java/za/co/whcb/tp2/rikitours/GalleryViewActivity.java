package za.co.whcb.tp2.rikitours;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.adapter.gallery.GalleryViewAdapter;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
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

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            if (extras.get("objectType").equals("gallery")) {
                galleryContainer = (GalleryContainer) getIntent().getSerializableExtra("gallery");
            }
        }
        Display.toast(galleryContainer.getImage(1).getName(),this);
        if (galleryContainer  != null) {
            setTitle(galleryContainer.getTitle());

            galleryViewAdapter = new GalleryViewAdapter(galleryContainer,this);
            viewPager = (ViewPager) findViewById(R.id.viewPage);
            viewPager.setAdapter(galleryViewAdapter);
        }



    }
}
