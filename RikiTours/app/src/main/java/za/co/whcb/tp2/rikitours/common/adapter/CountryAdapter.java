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

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.GalleryViewActivity;
import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.ViewActivity;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

/**
 * Created by berka on 10/15/2016.
 */
public class CountryAdapter extends ArrayAdapter<Country> {

    private ArrayList<Country> countries;
    private final Activity context;
    private GalleryContainer galleryContainer;

    public CountryAdapter(Activity context, ArrayList<Country> countries) {
        super(context, R.layout.activity_layout_listing, countries);
        this.context = context;
        this.countries = countries;
    }

    public CountryAdapter(Activity context, ArrayList<Country> countries, GalleryContainer galleryContainer) {
        super(context, R.layout.activity_layout_listing, countries);
        this.context = context;
        this.countries = countries;
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

        txtTitle.setText(countries.get(position).getName());

        String description = countries.get(position).getDescription();
        String shortDescription = null;

        if (description.length() > 150) {
            shortDescription = description.substring(0, 145);
            shortDescription = shortDescription + " ...";
            txtDescription.setText(shortDescription);
        }

        else {
            txtDescription.setText(description);
        }

        ImageLoader.loadFromUrl(countries.get(position).getImage(), countryImage, context);

        final Country currentCountry = getCurrentCountry(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display.toast(String.valueOf(currentCountry.getDescription().length()),context);
                Intent viewDetails = new Intent(context, ViewActivity.class);
                viewDetails.putExtra("title",currentCountry.getName());
                viewDetails.putExtra("titleComment","R 500.00 /person");
                viewDetails.putExtra("firstImage",currentCountry.getImage());
                viewDetails.putExtra("secondImage",currentCountry.getImage());
                viewDetails.putExtra("thirdImage",currentCountry.getImage());
                viewDetails.putExtra("forthImage",currentCountry.getImage());
                viewDetails.putExtra("description",currentCountry.getDescription());
                context.startActivity(viewDetails);
            }
        });

        btnBooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast("Booking..." + currentCountry.getName(),context);
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

    public Country getCurrentCountry(int position) {
        return countries.get(position);
    }
}
