package za.co.whcb.tp2.rikitours.common.adapter.attraction;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.GalleryViewActivity;
import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.ViewActivity;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionDescriptionRepo;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionsRepo;
import za.co.whcb.tp2.rikitours.services.domain.tours.AttractionService;
import za.co.whcb.tp2.rikitours.services.domain.tours.CountryService;

/**
 * Created by work on 10/27/2016.
 */
public class AttractionAdapter extends ArrayAdapter<Attraction> {


    private ArrayList<Attraction> attractions;
    private final Activity context;
    //private GalleryContainer galleryContainer;
    private CountryService attractionService;
    private boolean isBound;
    private Context app;
    private AttractionsRepo attractionsRepo;

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions, Context app) {
        super(context, R.layout.activity_layout_listing, attractions);
        this.context = context;
        this.attractions = attractions;
        this.isBound = false;
        this.app = app;
        this.attractionsRepo = new AttractionsRepo(context);

//        Intent i = new Intent(app, CountryService.class);
//        app.bindService(i,serviceConnection, app.BIND_AUTO_CREATE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_layout_listing,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        TextView txtSubTitle = (TextView) rowView.findViewById(R.id.txtSubTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView viewImage = (ImageView) rowView.findViewById(R.id.imgBox);
        ImageView viewImageFlag = (ImageView) rowView.findViewById(R.id.imgFlag);
        Button btnReadmore = (Button) rowView.findViewById(R.id.btnReamore);
        Button btnBooknow = (Button) rowView.findViewById(R.id.btnBooknow);
        Button btnGallery = (Button) rowView.findViewById(R.id.btnGallery);

        btnBooknow.setText("Add To List");
        txtTitle.setText(attractions.get(position).getAttractionDescription().getName().toUpperCase());
        txtSubTitle.setText(attractions.get(position).getAttractionDescription().getCity()+" / " +attractions.get(position).getCountry().getName());

        String description = attractions.get(position).getAttractionDescription().getDescription();
        String shortDescription = null;

        if (description.length() > 150) {
            shortDescription = description.substring(0, 145);
            shortDescription = shortDescription + " ...";
            txtDescription.setText(shortDescription);
        }

        else {
            txtDescription.setText(description);
        }

        ImageLoader.loadFromUrl(attractions.get(position).getAttractionDescription().getImage(0).getUrl(), viewImage, context);
        ImageLoader.loadFromUrl(attractions.get(position).getCountry().getImage(), viewImageFlag, context);

        final Attraction currentAttraction = getCurrentAttraction(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewDetails = new Intent(context, ViewActivity.class);
                viewDetails.putExtra("objectType","attraction");
                viewDetails.putExtra("attraction",currentAttraction);
                context.startActivity(viewDetails);
            }
        });

        btnBooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast("Adding...",context);
               if(attractionsRepo.addAttraction(currentAttraction) == true) {
                   Display.toastLong("Successfully added "+currentAttraction.getAttractionDescription().getName()+" to your list ",context);
               }
                else {
                   Display.toast("Failed to add in your list",context);
               }


            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryViewer = new Intent(context, GalleryViewActivity.class);
                GalleryContainer galleryContainer = new GalleryContainer(currentAttraction.getAttractionDescription().getImages(),
                        currentAttraction.getAttractionDescription().getName());;
                if(galleryContainer.getImages().size() > 0) {
                    galleryViewer.putExtra("gallery", galleryContainer);
                    galleryViewer.putExtra("objectType","gallery");
                    context.startActivity(galleryViewer);
                }
            }
        });

        return rowView;
    }

    public Attraction getCurrentAttraction(int position) {
        return attractions.get(position);
    }

//    public  ServiceConnection serviceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            CountryService.MyLocalBinder binder = (CountryService.MyLocalBinder) service;
//            attractionService = binder.getService();
//            isBound = true;
//            // Display.toast(attractionService.test(),context);
//
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            isBound = false;
//
//        }
//    };



}
