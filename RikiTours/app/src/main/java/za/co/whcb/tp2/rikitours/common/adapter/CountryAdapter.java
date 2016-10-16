package za.co.whcb.tp2.rikitours.common.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

/**
 * Created by work on 10/15/2016.
 */
public class CountryAdapter extends ArrayAdapter<Country> {

    private Country[] country;
    private final Activity context;

    public CountryAdapter(Activity context, Country[] country) {

        super(context, R.layout.activity_listing, country);
        this.context = context;
        this.country = country;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_listing,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView countryImage = (ImageView) rowView.findViewById(R.id.imgBox);

        txtTitle.setText(country[position].getName());
        txtDescription.setText(country[position].getDescription());

        Picasso.with(context).load(country[position].getImage()).into(countryImage);

        return rowView;
    }

}
