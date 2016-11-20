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


    public void open(View view) {
        Intent myIntent = new Intent(this, ListActivity.class);
        myIntent.putExtra("key", ""); //Optional parameters
        this.startActivity(myIntent);
    }
}
