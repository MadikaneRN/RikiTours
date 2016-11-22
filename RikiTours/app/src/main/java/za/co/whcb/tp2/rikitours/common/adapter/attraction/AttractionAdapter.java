package za.co.whcb.tp2.rikitours.common.adapter.attraction;

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
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

/**
 * Created by work on 10/27/2016.
 */
public class AttractionAdapter extends ArrayAdapter<Attraction> {


    private ArrayList<Attraction> attractions;
    private final Activity context;
    //private GalleryContainer galleryContainer;

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {
        super(context, R.layout.activity_layout_listing, attractions);
        this.context = context;
        this.attractions = attractions;
    }

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions, GalleryContainer galleryContainer) {
        super(context, R.layout.activity_layout_listing, attractions);
        this.context = context;
        this.attractions = attractions;
        //this.galleryContainer = galleryContainer;
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

//        galleryContainer = new GalleryContainer(attractions.get(position).getAttractionDescription().getImages(),
//                attractions.get(position).getAttractionDescription().getName());

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
                Display.toast("Booking...",context);
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
}
