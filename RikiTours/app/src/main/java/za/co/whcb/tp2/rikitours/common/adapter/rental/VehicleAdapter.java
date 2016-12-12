package za.co.whcb.tp2.rikitours.common.adapter.rental;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.views.CarRentalActivity;
import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.views.MainActivity;

/**
 * Created by Berka on 11/27/2016.
 */
public class VehicleAdapter extends ArrayAdapter<Vehicle> {
    private ArrayList<Vehicle> vehicles;
    private final Activity context;
    private Customer user;

    public VehicleAdapter(Activity context, ArrayList<Vehicle> vehicles) {
        super(context, R.layout.activity_list_car, vehicles);
        this.context = context;
        this.vehicles = vehicles;
    }

    public VehicleAdapter(Activity context, ArrayList<Vehicle> vehicles, Customer user) {
        super(context, R.layout.activity_list_car, vehicles);
        this.context = context;
        this.vehicles = vehicles;
        this.user = user;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_list_car,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtCartTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtCarDiscription);
        TextView  txtPrice = (TextView) rowView.findViewById(R.id.txtPrice);
        ImageView itemImg = (ImageView) rowView.findViewById(R.id.carImg);


        Button btnCartBook = (Button) rowView.findViewById(R.id.btnCartBook);

        txtTitle.setText(
                vehicles.get(position).getVehicleName() + " "
                        + vehicles.get(position).getVehicleModel()
                        + " / " + vehicles.get(position).getVehicleYear()
        );
        txtDescription.setText(
                vehicles.get(position).getDescription()
        );
        txtPrice.setText("R " + String.valueOf(vehicles.get(position).getPrice()) + "/ Day");


        ImageLoader.loadFromUrl(vehicles.get(position).getCarImage().getUrl(), itemImg, context);

        final Vehicle currentVehicle = getCurrentVehicle(position);

        btnCartBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(context, CarRentalActivity.class);
                myIntent.putExtra("vehicle",currentVehicle ); //Optional parameters
                myIntent.putExtra("user",user );
                context.startActivity(myIntent);

            }
        });



        return rowView;
    }

    public Vehicle getCurrentVehicle(int position) {
        return vehicles.get(position);
    }
}
