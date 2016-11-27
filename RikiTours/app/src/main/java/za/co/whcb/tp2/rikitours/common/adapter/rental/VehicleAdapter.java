package za.co.whcb.tp2.rikitours.common.adapter.rental;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

/**
 * Created by gaming on 11/27/2016.
 */
public class VehicleAdapter extends ArrayAdapter<Vehicle> {
    private ArrayList<Vehicle> vehicles;
    private final Activity context;

    public VehicleAdapter(Activity context, ArrayList<Vehicle> vehicles) {
        super(context, R.layout.activity_list_car, vehicles);
        this.context = context;
        this.vehicles = vehicles;
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

        final Vehicle item = getCurrentVehicle(position);

        btnCartBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                OrderDetailsDB orderDetailsDB = new OrderDetailsDB(context);
//                Display.toast("Adding...",context);
//
//                if(orderDetailsDB.insertData(item)) {
//                    Display.toast(item.getName() +" Added To Your List",context);
//                }
//                else {
//                    Display.toast("Error Failed to Add",context);
//                }


            }
        });



        return rowView;
    }

    public Vehicle getCurrentVehicle(int position) {
        return vehicles.get(position);
    }
}
