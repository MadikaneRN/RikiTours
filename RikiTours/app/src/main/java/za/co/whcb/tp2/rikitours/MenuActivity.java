package za.co.whcb.tp2.rikitours;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.controllers.user.UserController;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;

public class MenuActivity extends AppCompatActivity {

    Customer user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = (Customer) getIntent().getSerializableExtra("user");
        }
        Display.toast("Welcome " + user.getName().toUpperCase(),this);

    }

    public void listAccommodations(View view) {
        Intent myIntent = new Intent(this, ListActivity.class);
        myIntent.putExtra("open", "Accommodations"); //Optional parameters
        this.startActivity(myIntent);
    }

    public void listAttractions(View view) {
        Intent myIntent = new Intent(this, ListActivity.class);
        myIntent.putExtra("open", "Attractions"); //Optional parameters
        this.startActivity(myIntent);
    }

    public void listVehicles(View view) {
//        Intent myIntent = new Intent(this, ListActivity.class);
//        myIntent.putExtra("open", "Vehicles"); //Optional parameters
        //this.startActivity(myIntent);

    }
}
