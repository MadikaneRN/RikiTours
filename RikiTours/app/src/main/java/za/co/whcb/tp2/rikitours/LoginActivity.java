package za.co.whcb.tp2.rikitours;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    private static final String url = "http://tp2.whcb.co.za/customer.php";
    private String request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);

    }

    public void register(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("key", ""); //Optional parameters
        this.startActivity(myIntent);
    }
}
