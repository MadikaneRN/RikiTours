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
import za.co.whcb.tp2.rikitours.domain.tour.Events;

/**
 * Created by Tamonne on 10/17/2016.
 */
public class EventsAdapter extends ArrayAdapter<Events> {




    private ArrayList<Events> events;
    private final Activity context;

    public EventsAdapter(Activity context, ArrayList<Events> events) {

        super(context, R.layout.activity_layout_listing, events);
        this.context = context;
        this.events = events;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_layout_listing,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView attractionImage = (ImageView) rowView.findViewById(R.id.imgBox);
        Button btnReadmore = (Button) rowView.findViewById(R.id.btnReamore);
        Button btnBooknow = (Button) rowView.findViewById(R.id.btnBooknow);

        txtTitle.setText(events.get(position).getName());
        txtDescription.setText(events.get(position).getDescription().getDescription());
        //Picasso.with(context).load(attractions.get(position).getImage()).into(countryImage);

        final Events currentTour = getCurrentEvent(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast(getCurrentEvent(position).getName().toString(),context);
            }
        });

        return rowView;
    }
    public Events getCurrentEvent(int position) {
        return events.get(position);
    }




}
