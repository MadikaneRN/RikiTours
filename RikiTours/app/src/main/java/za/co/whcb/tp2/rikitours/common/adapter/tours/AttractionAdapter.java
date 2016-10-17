package za.co.whcb.tp2.rikitours.common.adapter.tours;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;

/**
 * Created by Tamonne on 10/17/2016.
 */
public class AttractionAdapter extends ArrayAdapter <Attraction>{

    private ArrayList<Attraction> attractions;
    private final Activity context;



    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {

        super(context, R.layout.activity_layout_listing, attractions);
        this.context = context;
        this.attractions = attractions;
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

        txtTitle.setText(attractions.get(position).getCountryId().getName());
        txtDescription.setText(attractions.get(position).getAttractionDescriptionId().getDescription());
       //Picasso.with(context).load(attractions.get(position).getImage()).into(countryImage);

        final Attraction currentAttraction = getCurrentAttraction(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast(currentAttraction.getCountryId().getName(),context);
            }
        });

        return rowView;
    }
    public Attraction getCurrentAttraction(int position) {
        return attractions.get(position);
    }


}
