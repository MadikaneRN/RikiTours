package za.co.whcb.tp2.rikitours;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import za.co.whcb.tp2.rikitours.controllers.user.SigninController;

public class MenuActivity extends AppCompatActivity {
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);
        progress = new ProgressDialog(this);
        progress.setMessage("Signing... ");
//        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progress.setIndeterminate(true);
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
        progress.show();

        SigninController userController = new SigninController("ayowaberka1@gmail.com","123456",getApplicationContext());
        boolean re = userController.signin();
        progress.hide();
    }
}
