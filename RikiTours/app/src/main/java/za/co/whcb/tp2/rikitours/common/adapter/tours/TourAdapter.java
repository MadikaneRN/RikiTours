package za.co.whcb.tp2.rikitours.common.adapter.tours;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.Tour;

/**
 * Created by Tamonne on 10/17/2016.
 */
public class TourAdapter extends ArrayAdapter<Tour> {



    private ArrayList<Tour> tours;
    private final Activity context;

    public TourAdapter(Activity context, ArrayList<Tour> tours) {

        super(context, R.layout.activity_layout_listing, tours);
        this.context = context;
        this.tours = tours;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_layout_listing,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView attractionImage = (ImageView) rowView.findViewById(R.id.imgBox);
        Button btnReadmore = (Button) rowView.findViewById(R.id.btnReamore);
        Button btnBooknow = (Button) rowView.findViewById(R.id.btnBooknow);

        txtTitle.setText(tours.get(position).getId().toString());
        txtDescription.setText(tours.get(position).getId().toString());
        //Picasso.with(context).load(attractions.get(position).getImage()).into(countryImage);

        final Tour currentTour = getCurrentTour(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast(currentTour.getId().toString(),context);
            }
        });

        return rowView;
    }
    public Tour getCurrentTour(int position) {
        return tours.get(position);
    }


}
