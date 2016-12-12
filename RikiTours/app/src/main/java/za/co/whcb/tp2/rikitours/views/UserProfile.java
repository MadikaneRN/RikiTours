package za.co.whcb.tp2.rikitours.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.VolleyError;

import org.json.JSONException;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.controllers.customer.UserController;
import za.co.whcb.tp2.rikitours.controllers.customer.callback.RikiApiSignUpCallBack;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;


public class UserProfile extends AppCompatActivity {

    private Customer user;
    //private Customer tempUser
    private EditText userName;
    private EditText userSurname;
    private EditText userEmail;
    private EditText userCurrentPassword;
    private EditText userNewPassword;
    private EditText userDob;
    private Spinner userGender;
    private Spinner countries;
    private Spinner cities;

    private Button update;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userName = (EditText) findViewById(R.id.edtUserName);
        userSurname = (EditText) findViewById(R.id.edtUserSurnam);
        userEmail = (EditText) findViewById(R.id.edtUserEmail);
        userCurrentPassword = (EditText) findViewById(R.id.edtCurrentPassword);
        userNewPassword = (EditText) findViewById(R.id.edtNewPassword);
        userDob = (EditText) findViewById(R.id.edtDob);
        userGender = (Spinner) findViewById(R.id.spnUserGender);
        countries = (Spinner) findViewById(R.id.spnCountries);
        cities = (Spinner) findViewById(R.id.spnCity);

        update = (Button) findViewById(R.id.btnUpdate);
        save = (Button) findViewById(R.id.btnSave);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = (Customer) getIntent().getSerializableExtra("user");
            userName.setText(user.getName());
            userSurname.setText(user.getSurname());
            userEmail.setText(user.getEmail());
            userDob.setText(user.getDob());

            if(user.getGender().equalsIgnoreCase("female")) {
                userGender.setSelection(2);
            } else if (user.getGender().equalsIgnoreCase("male")) {
                userGender.setSelection(1);
            }
            else {
                userGender.setSelection(0);
            }

            setTitle(user.getName() +" " +user.getSurname());
        }

        countries.setEnabled(false);
        cities.setEnabled(false);
        save.setEnabled(false);
        userGender.setEnabled(false);

    }

    public void updateEnable(View view) {
        enableUserFields();
    }

    public void saveUser(View view) {

        if(!userName.getText().toString().trim().equals("") && !userSurname.getText().toString().trim().equals("")
                && !userEmail.getText().toString().trim().equals("") && !userGender.getSelectedItem().toString().trim().equals("")
                && !userGender.getSelectedItem().toString().trim().equalsIgnoreCase("gender"))
        {

            Display.startLoading("Updating User Details..",this);
            disableUserFields();
            user.setName(userName.getText().toString());
            user.setSurname(userSurname.getText().toString());
            user.setDob(userDob.getText().toString());
            user.setEmail(userEmail.getText().toString());
            user.setGender(userGender.getSelectedItem().toString());
            
            UserController userController = new UserController(user,userCurrentPassword.getText().toString(),
                    userNewPassword.getText().toString(),this);

            userController.updateUser(new RikiApiSignUpCallBack() {
                @Override
                public void onSuccess(String feedback) {
                    Display.endLoading();
                    Display.toast(feedback,getApplicationContext());
                }

                @Override
                public void onConnectingError(VolleyError error) {
                    Display.endLoading();
                    Display.toast(AppNetworkError.check(error),getApplicationContext());
                    enableUserFields();
                }

                @Override
                public void onParsingError(Exception error) {
                    Display.endLoading();
                    Display.toast("Parsing Error ! " + error.getMessage() ,getApplicationContext());
                    enableUserFields();
                }

                @Override
                public void onJSONError(JSONException error) {
                    Display.endLoading();
                    Display.toast("Json Error ! " + error.getMessage() ,getApplicationContext());
                    enableUserFields();
                }
            });

        }

        else
        {
            Display.toast("Plz fill all required fields", this);

        }

    }

    public void enableUserFields() {
        userName.setEnabled(true);
        userSurname.setEnabled(true);
        userEmail.setEnabled(true);
        userDob.setEnabled(true);
        userGender.setEnabled(true);
        userCurrentPassword.setEnabled(true);
        userNewPassword.setEnabled(true);

        update.setEnabled(false);
        save.setEnabled(true);
    }

    public void disableUserFields() {
        update.setEnabled(true);
        save.setEnabled(false);
        userName.setEnabled(false);
        userSurname.setEnabled(false);
        userEmail.setEnabled(false);
        userDob.setEnabled(false);
        userGender.setEnabled(false);
        userCurrentPassword.setEnabled(false);
        userNewPassword.setEnabled(false);
    }


}
