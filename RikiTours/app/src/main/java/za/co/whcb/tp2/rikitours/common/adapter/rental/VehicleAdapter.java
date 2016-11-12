package za.co.whcb.tp2.rikitours.common.adapter.rental;

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
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

/**
 * Created by berka on 11/12/2016.
 */
public class VehicleAdapter  extends ArrayAdapter<Vehicle> {

    //completed Adapter need to test it will look at lindo how she done it

    private ArrayList<Vehicle> vehicles;
    private final Activity context;
    private GalleryContainer galleryContainer;


    public VehicleAdapter(Activity context, ArrayList<Vehicle> vehicles) {
        super(context, R.layout.activity_layout_listing, vehicles);
        this.context = context;
        this.vehicles = vehicles;
    }

    public VehicleAdapter(Activity context, ArrayList<Vehicle> vehicles, GalleryContainer galleryContainer) {
        super(context, R.layout.activity_layout_listing, vehicles);
        this.context = context;
        this.vehicles = vehicles;
        this.galleryContainer = galleryContainer;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_layout_listing, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView countryImage = (ImageView) rowView.findViewById(R.id.imgBox);

        Button btnReadmore = (Button) rowView.findViewById(R.id.btnReamore);
        Button btnBooknow = (Button) rowView.findViewById(R.id.btnBooknow);
        Button btnGallery = (Button) rowView.findViewById(R.id.btnGallery);


        txtTitle.setText(vehicles.get(position).getVehicleName());

        String description = vehicles.get(position).getDescription();
        String shortDescription = null;

        if (description.length() > 150) {
            shortDescription = description.substring(0, 145);
            shortDescription = shortDescription + " ...";
            txtDescription.setText(shortDescription);
        } else {
            txtDescription.setText(description);
        }

        ImageLoader.loadFromUrl(vehicles.get(position).getRikiImage().getUrl(), countryImage, context);

        final Vehicle currentVehicle = getCurrentVehicle(position);


//        btnReadmore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Display.toast(String.valueOf(currentCountry.getDescription().length()),context);
//                Intent viewDetails = new Intent(context, ViewActivity.class);
//                viewDetails.putExtra("title",currentCountry.getName());
//                viewDetails.putExtra("titleComment","R 500.00 /person");
//                viewDetails.putExtra("firstImage",currentCountry.getImage());
//                viewDetails.putExtra("secondImage",currentCountry.getImage());
//                viewDetails.putExtra("thirdImage",currentCountry.getImage());
//                viewDetails.putExtra("forthImage",currentCountry.getImage());
//                viewDetails.putExtra("description",currentCountry.getDescription());
//                context.startActivity(viewDetails);
//            }
//        });


        btnBooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast("Booking..." + currentVehicle.getVehicleName(), context);
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

    public Vehicle getCurrentVehicle(int position) {
        return vehicles.get(position);
    }

}
