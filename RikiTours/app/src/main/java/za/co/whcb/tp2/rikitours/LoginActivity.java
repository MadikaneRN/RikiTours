package za.co.whcb.tp2.rikitours;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.VolleyError;

import org.json.JSONException;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.controllers.customer.UserController;
import za.co.whcb.tp2.rikitours.controllers.customer.callback.RikiApiCallback;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;

public class LoginActivity extends AppCompatActivity {
    EditText txtEmail;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.hide();

        txtEmail = (EditText) findViewById(R.id.edtEmail);
        txtPassword = (EditText) findViewById(R.id.edtPassword);

    }

    public void register(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("key", ""); //Optional parameters
        this.startActivity(myIntent);
    }

    public void login (View view){

        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        if(!email.equals("") && !password.equals(""))
        {
            Display.startLoading("Signing",this);
            UserController userController = new UserController(email,password,this);
            userController.signIn(new RikiApiCallback() {
                @Override
                public void onSuccess(Customer user) {
                    Intent myIntent = new Intent(getApplicationContext(), MenuActivity.class);
                    myIntent.putExtra("user", user);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Display.endLoading();
                    getApplicationContext().startActivity(myIntent);
                }

                @Override
                public void onConnectingError(VolleyError error) {
                    Display.endLoading();
                    Display.toast("Could not connect to the server",getApplicationContext());
                }

                @Override
                public void onParsingError(Exception error) {
                    Display.endLoading();
                    Display.toast("Invalid Email or Password",getApplicationContext());
                }

                @Override
                public void onJSONError(JSONException error) {
                    Display.endLoading();
                }
            });
        }
        else
        {
            Display.toast("Invalid login details",this);
        }



    }
}
