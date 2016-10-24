package za.co.whcb.tp2.rikitours.common.adapter;

import android.app.Activity;
import android.content.Intent;
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
import za.co.whcb.tp2.rikitours.domain.tour.Events;

/**
 * Created by Shaun Mesias on 2016/10/24.
 */
public class EventAdapter extends ArrayAdapter<Events> {
    private ArrayList<Events> events;
    private final Activity context;
    private GalleryContainer galleryContainer;

    public EventAdapter(Activity context, ArrayList<Events> events) {
        super(context, R.layout.activity_layout_listing, events);
        this.context = context;
        this.events = events;
    }

    public EventAdapter(Activity context, ArrayList<Events> events, GalleryContainer galleryContainer) {
        super(context, R.layout.activity_layout_listing, events);
        this.context = context;
        this.events = events;
        this.galleryContainer = galleryContainer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_layout_listing,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView countryImage = (ImageView) rowView.findViewById(R.id.imgBox);
        Button btnReadmore = (Button) rowView.findViewById(R.id.btnReamore);
        Button btnBooknow = (Button) rowView.findViewById(R.id.btnBooknow);
        Button btnGallery = (Button) rowView.findViewById(R.id.btnGallery);

        txtTitle.setText(events.get(position).getName());

        String description = events.get(position).getDescription().getDescription();
        String shortDescription = null;

        if (description.length() > 150) {
            shortDescription = description.substring(0, 145);
            shortDescription = shortDescription + " ...";
            txtDescription.setText(shortDescription);
        }

        else {
            txtDescription.setText(description);
        }

       // ImageLoader.loadFromUrl(events.get(position).getAttractionDescriptionId().getImage(), countryImage, context);

        final Events currentEvent = getCurrentEvent(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display.toast(String.valueOf(currentCountry.getDescription().length()),context);
                Intent viewDetails = new Intent(context, ViewActivity.class);
                viewDetails.putExtra("title",currentEvent.getName());
                viewDetails.putExtra("titleComment","R 500.00 /person");
                viewDetails.putExtra("firstImage",currentEvent.getImage().getName());
                viewDetails.putExtra("secondImage",currentEvent.getImage().getName());
                viewDetails.putExtra("thirdImage", currentEvent.getImage().getName());
                viewDetails.putExtra("forthImage",currentEvent.getImage().getName());
                viewDetails.putExtra("description",currentEvent.getImage().getName());
                context.startActivity(viewDetails);
            }
        });

        btnBooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast("Booking..." + currentEvent.getName(), context);
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryViewer = new Intent(context, GalleryViewActivity.class);
                if(galleryContainer.getSize() > 0) {
                    galleryViewer.putExtra("title", galleryContainer.getTitle());
                    galleryViewer.putExtra("image1", galleryContainer.getImage(0).getUrl());
                    galleryViewer.putExtra("image2", galleryContainer.getImage(1).getUrl());
                    galleryViewer.putExtra("image3", galleryContainer.getImage(2).getUrl());
                    galleryViewer.putExtra("image4", galleryContainer.getImage(3).getUrl());
                    galleryViewer.putExtra("image5", galleryContainer.getImage(4).getUrl());
                    context.startActivity(galleryViewer);
                }
            }
        });

        return rowView;
    }

    public Events getCurrentEvent(int position) {
        return events.get(position);
    }
}
