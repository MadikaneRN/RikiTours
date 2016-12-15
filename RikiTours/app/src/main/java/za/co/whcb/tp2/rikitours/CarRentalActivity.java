package za.co.whcb.tp2.rikitours;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;

import org.json.JSONException;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.controllers.rental.callback.RikiApiReservationCallBack;
import za.co.whcb.tp2.rikitours.controllers.rental.reservation.ReservationController;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Reservation;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;
import za.co.whcb.tp2.rikitours.factories.rental.ReservationsFactory;

public class CarRentalActivity extends AppCompatActivity {

    private Vehicle vehicle;
    private Customer user;
    private TextView vehicleTitle;
    private TextView vehicleDescription;
    private TextView vehiclePrice;
    private EditText pickUpTime;
    private EditText pickUpDate;
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
        pickUpDate = (EditText) findViewById(R.id.edtPickupDate);
        pickUpAddress = (EditText) findViewById(R.id.edtPickUpAddress);
        comments = (EditText) findViewById(R.id.edtComments);
        vehicleImg = (ImageView) findViewById(R.id.imgReservation);

        reservation = (Button) findViewById(R.id.btnMakeReservation);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            
            vehicle = (Vehicle) getIntent().getSerializableExtra("vehicle");
            user = (Customer) getIntent().getSerializableExtra("user");

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

    public void makeReservaton(View view) {

        String pickupTime = pickUpTime.getText().toString().trim();
        String pickupDate = pickUpDate.getText().toString().trim();
        String comment = comments.getText().toString().trim();
        String pickupAddress = pickUpAddress.getText().toString().trim();


        if(!pickupTime.equals("") && !pickupDate.equals("") && !pickupAddress.equals("")) {

            Reservation reservation = ReservationsFactory.getReservations(Long.parseLong("2"), user, vehicle, pickupDate, "", vehicle.getPrice());
            reservation.setPickupTime(pickupTime);
            reservation.setPickUpDate(pickupAddress);
            reservation.setComment(comment);

            Display.startLoading("Making Reservation",this);
            ReservationController reservationController = new ReservationController(reservation, this);
            reservationController.makeReservation(new RikiApiReservationCallBack() {
                @Override
                public void onSuccess(String feedback) {
                    Display.endLoading();
                    Display.toast(feedback,getApplicationContext());
                }

                @Override
                public void onConnectingError(VolleyError error) {
                    Display.endLoading();
                    Display.toast(AppNetworkError.check(error),getApplicationContext());
                }

                @Override
                public void onParsingError(Exception error) {
                    Display.endLoading();
                    Display.toast(error.getMessage(),getApplicationContext());

                }

                @Override
                public void onJSONError(JSONException error) {
                    Display.endLoading();
                    Display.toast(error.getMessage(),getApplicationContext());

                }
            });

        }
        else {
            Display.toast("Plz fill all required field", this);
        }



    }
}
