package za.co.whcb.tp2.rikitours.views;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.VolleyError;

import org.json.JSONException;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.controllers.customer.UserController;
import za.co.whcb.tp2.rikitours.controllers.customer.callback.RikiApiSignUpCallBack;
import za.co.whcb.tp2.rikitours.domain.Address;
import za.co.whcb.tp2.rikitours.domain.Contacts;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.services.domain.common.country.CountryService;

public class MainActivity extends AppCompatActivity {


    CountryService countryService;
    boolean isBound = false;
    Button btnTerms;
    TextView txtViewTerms;
    boolean termsClick = false;
    boolean accepted = false;

    EditText edtCustomerName;
    EditText edtCustomerEmail;
    EditText edtCustomerSurname;
    EditText edtCustomerPassword;
    EditText edtCustomerPasswordConfimed;
    Spinner gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this.getApplicationContext(), CountryService.class);
        bindService(i,serviceConnection, Context.BIND_AUTO_CREATE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);
        setTitle(R.string.registration);

        btnTerms = (Button) findViewById(R.id.btnTerms);
        txtViewTerms = (TextView) findViewById(R.id.txtViewTerms);

        edtCustomerName = (EditText) findViewById(R.id.edtCustomerName);
        edtCustomerSurname = (EditText) findViewById(R.id.edtCustomerSurname);
        edtCustomerEmail = (EditText) findViewById(R.id.edtCustomerEmail);
        edtCustomerPassword = (EditText) findViewById(R.id.edtCustomerPassword);
        edtCustomerPasswordConfimed = (EditText) findViewById(R.id.edtCustomerPasswordConfimed);

        gender = (Spinner) findViewById(R.id.spinner1);

    }

    public void signup(View view) {

        String customerName =   edtCustomerName.getText().toString();
        String customerSurname = edtCustomerSurname.getText().toString();
        String customerEmail = edtCustomerEmail.getText().toString();
        String customerPassword = edtCustomerPassword.getText().toString();
        String confirmedPassword =  edtCustomerPasswordConfimed.getText().toString();
        String customerGender = gender.getSelectedItem().toString();

        if(!customerName.isEmpty() && !customerSurname.isEmpty() && !customerEmail.isEmpty() && !customerPassword.equals(""))
        {
            if(!customerGender.equals("Gender"))
            {
                if(customerPassword.equals(confirmedPassword)){
                    Customer newCustomer = CustomerFactory.getCustomer(Long.parseLong("0"),customerName,customerSurname,"");
                    UserController userController = new UserController(customerEmail,customerPassword,getApplicationContext(),newCustomer,customerGender);
                    Display.startLoading("Registering",this);
                    userController.signUp(new RikiApiSignUpCallBack() {
                                              @Override
                                              public void onSuccess(String feedback) {
                                                  Display.endLoading();
                                                  Display.toast(feedback, getApplicationContext());
                                                  onBackPressed();
                                              }

                                              @Override
                                              public void onConnectingError(VolleyError error) {
                                                  Display.endLoading();
                                                  Display.toast(error.getMessage(), getApplicationContext());
                                                  Log.e("ERROR ON connecting -> ",error.getMessage());
                                              }

                                              @Override
                                              public void onParsingError(Exception error) {
                                                  Display.endLoading();
                                                  Display.toast(error.getMessage(), getApplicationContext());
                                                  Log.e("ERROR ON parsing -> ",error.getMessage());
                                              }

                                              @Override
                                              public void onJSONError(JSONException error) {
                                                  Display.endLoading();
                                                  Display.toast(error.getMessage(), getApplicationContext());
                                                  //Log.e("ERROR ON json -> ",error.getMessage());
                                              }
                                          }
                    );
                }
                else {
                    Display.errorToast("! Passwords Don't match",this);
                }
            }
            else {
                Display.errorToast("Select Your Gender!",this);
            }

        }

        else {
            Display.errorToast("Fill all fields",this);
        }



    }

    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CountryService.MyLocalBinder binder = (CountryService.MyLocalBinder) service;
            countryService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

    @Override
    protected  void onStop()
    {
        super.onStop();

        if(isBound)
        {
            unbindService(serviceConnection);
            isBound = false;
        }

    }


    //manual testing
    public void addCountry(View view) {

        Country country = CountryFactory.getCountry((long) 29,"South Africa","South Africa is a country on the southernmost", "sa.jpg");

        if(isBound) {
            if(countryService.add(country) == true) {
                Display.toast("Country added" , this);
            }
            else {
                 Display.toast("failed to add country" , this);
            }

        }

        else {
            Display.toast("could not bound ", this);
        }

    }

    public void terms(View view) {
        if(termsClick != true) {
            txtViewTerms.setVisibility(View.VISIBLE);
            termsClick = true;
        }
        else {
            txtViewTerms.setVisibility(View.GONE);
            termsClick = false;
        }
    }


}
