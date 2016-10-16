package za.co.whcb.tp2.rikitours.common.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

/**
 * Created by work on 10/15/2016.
 */
public class CountryAdapter extends ArrayAdapter<Country> {

    private Country[] countries;
    private final Activity context;

    public CountryAdapter(Activity context, Country[] countries) {

        super(context, R.layout.activity_layout_listing, countries);
        this.context = context;
        this.countries = countries;
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

        txtTitle.setText(countries[position].getName());
        txtDescription.setText(countries[position].getDescription());
        Picasso.with(context).load(countries[position].getImage()).into(countryImage);

        final Country currentCountry = getCurrentCountry(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.toast(currentCountry.getName(),context);
            }
        });

        return rowView;
    }

    public Country getCurrentCountry(int position) {
        return countries[position];
    }
}
