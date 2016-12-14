package za.co.whcb.tp2.rikitours;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

public class CarRentalActivity extends AppCompatActivity {

    private Vehicle vehicle;
    private TextView vehicleTitle;
    private TextView vehicleDescription;
    private TextView vehiclePrice;
    private EditText pickUpTime;
    private EditText pickUpAddress;
    private EditText comments;

    private Button reservation;
    private ImageView vehicleImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rental);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);

        vehicleTitle = (TextView) findViewById(R.id.txtCarTitleReservation);
        vehicleDescription = (TextView) findViewById(R.id.txtCarDescriptionRese);
        vehiclePrice = (TextView) findViewById(R.id.txtPriceReservation);
        pickUpTime = (EditText) findViewById(R.id.edtPickUpTime);
        pickUpAddress = (EditText) findViewById(R.id.edtPickUpAddress);
        comments = (EditText) findViewById(R.id.edtComments);
        vehicleImg = (ImageView) findViewById(R.id.imgReservation);

        reservation = (Button) findViewById(R.id.btnMakeReservation);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            
            vehicle = (Vehicle) getIntent().getSerializableExtra("vehicle");

            vehicleTitle.setText(
                    vehicle.getVehicleName() + " "
                            + vehicle.getVehicleModel()
                            + " / " + vehicle.getVehicleYear()
            );

            vehicleDescription.setText(vehicle.getDescription());
            vehiclePrice.setText("R " + String.valueOf(vehicle.getPrice()) + " / Day");
            ImageLoader.loadFromUrl(vehicle.getCarImage().getUrl(), vehicleImg, this);

            setTitle(" " + vehicle.getVehicleName().toUpperCase() +" "+ vehicle.getVehicleModel().toUpperCase());

        }
    }
}
