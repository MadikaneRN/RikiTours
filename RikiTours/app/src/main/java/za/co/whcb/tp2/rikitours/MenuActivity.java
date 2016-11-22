package za.co.whcb.tp2.rikitours;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);
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
        Intent myIntent = new Intent(this, ListActivity.class);
        myIntent.putExtra("open", "Vehicles"); //Optional parameters
        //this.startActivity(myIntent);
    }
}
