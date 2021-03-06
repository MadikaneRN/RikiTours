package za.co.whcb.tp2.rikitours;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;
import za.co.whcb.tp2.rikitours.views.ForgottenPasswordActivity;
import za.co.whcb.tp2.rikitours.views.MainActivity;
import za.co.whcb.tp2.rikitours.views.MenuActivity;

public class LoginActivity extends AppCompatActivity {
    EditText txtEmail;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle(" ");

        txtEmail = (EditText) findViewById(R.id.edtLoginEmail);
        txtPassword = (EditText) findViewById(R.id.edtLoginPassword);

    }

    public void register(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("key", ""); //Optional parameters
        this.startActivity(myIntent);
    }

    public void login (View view){

        String email = txtEmail.getText().toString();//"altia@gmail.com";//
        String password = txtPassword.getText().toString();//"1234";//
        if(!email.trim().equals("") && !password.trim().equals(""))
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
                    Display.toast(AppNetworkError.check(error),getApplicationContext());
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
            Display.toast("Plz Fill all your login details",this);
        }



    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                //.setIcon(R.drawable.logout_1)
                .setTitle("Exiting Riki Tours App")
                .setMessage("Do you really want to close this application ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    public void forgottenPassword(View view) {
        Intent myIntent = new Intent(this, ForgottenPasswordActivity.class);
        myIntent.putExtra("key", ""); //Optional parameters
        this.startActivity(myIntent);
    }
}
