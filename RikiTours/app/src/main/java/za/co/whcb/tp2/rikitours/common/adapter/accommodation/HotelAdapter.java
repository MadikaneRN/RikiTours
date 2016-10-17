package za.co.whcb.tp2.rikitours.common.adapter.accommodation;

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
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;

/**
 * Created by Tamonne on 10/17/2016.
 */
public class HotelAdapter extends ArrayAdapter<Hotel> {


    private ArrayList<Hotel> hotels;
    private final Activity context;

    public HotelAdapter(Activity context, ArrayList<Hotel> hotels) {

        super(context, R.layout.activity_layout_listing, hotels);
        this.context = context;
        this.hotels = hotels;
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

        txtTitle.setText(hotels.get(position).getName());
        txtDescription.setText(hotels.get(position).getDescription());
        //Picasso.with(context).load(attractions.get(position).getImage()).into(countryImage);

        final  Hotel currentHotel = getCurrentHotel(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast(currentHotel.getName(),context);
            }
        });

        return rowView;
    }
    public Hotel getCurrentHotel(int position) {
        return hotels.get(position);
    }

















}
