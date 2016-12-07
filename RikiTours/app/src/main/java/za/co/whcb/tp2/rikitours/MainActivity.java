package za.co.whcb.tp2.rikitours;

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
import android.widget.TextView;

import com.android.volley.VolleyError;

import org.json.JSONException;

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
    EditText edtCustomerName;
    EditText edtCustomerEmail;
    EditText edtCustomerSurname;
    EditText edtCustomerPassword;
    EditText edtCustomerPasswordConfimed;
    boolean termsClick = false;
    boolean accepted = false;

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

        edtCustomerName = (EditText) findViewById(R.id.edtCustomerName);
        edtCustomerSurname = (EditText) findViewById(R.id.edtCustomerSurname);
        edtCustomerEmail = (EditText) findViewById(R.id.edtCustomerEmail);
        edtCustomerPassword = (EditText) findViewById(R.id.edtCustomerPassword);
        edtCustomerPasswordConfimed = (EditText) findViewById(R.id.edtCustomerPasswordConfimed);

        btnTerms = (Button) findViewById(R.id.btnTerms);
        txtViewTerms = (TextView) findViewById(R.id.txtViewTerms);

    }

    public void signup(View view) {



        City city = new City(Long.parseLong("1"), "Cape Town", "Cape Town is the second largest city in South Africa blah blah");
        Address address = new Address(Long.parseLong("20"), "287", "Watergang", "7600",city);



        Contacts contacts = new Contacts(Long.parseLong("10"),"0833445567","0215689985",address);


        contacts.setAddress(address);

        Customer customer = CustomerFactory.getCustomer(0,edtCustomerName.getText().toString(),
                edtCustomerSurname.getText().toString(),edtCustomerEmail.getText().toString(),contacts);

        UserController userController = new UserController(getApplicationContext(),edtCustomerPassword.getText().toString());

        userController.signUp(customer, new RikiApiSignUpCallBack() {
            @Override
            public void onSuccess(String feedback) {
                Display.toast(feedback, getApplicationContext());
            }

            @Override
            public void onConnectingError(VolleyError error) {
                Display.toast(error.getMessage(), getApplicationContext());
                Log.e("ERROR ON connecting -> ",error.getMessage());
            }

            @Override
            public void onParsingError(Exception error) {
                Display.toast(error.getMessage(), getApplicationContext());
                Log.e("ERROR ON parsing -> ",error.getMessage());
            }

            @Override
            public void onJSONError(JSONException error) {
                Display.toast(error.getMessage(), getApplicationContext());
                Log.e("ERROR ON json -> ",error.getMessage());
            }
        });

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
