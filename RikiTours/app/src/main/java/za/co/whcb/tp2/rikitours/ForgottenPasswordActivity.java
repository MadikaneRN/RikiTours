package za.co.whcb.tp2.rikitours;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;

import org.json.JSONException;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.controllers.customer.UserController;
import za.co.whcb.tp2.rikitours.controllers.customer.callback.RikiApiSignUpCallBack;
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;

public class ForgottenPasswordActivity extends AppCompatActivity {

    private TextView txtSuccessfully;
    private ImageView imgSuccessfully;
    private EditText edtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);
        setTitle(" Forgotten Password");

        txtSuccessfully = (TextView) findViewById(R.id.txtPasswordFeedBack);
        imgSuccessfully = (ImageView) findViewById(R.id.imgPassword);
        edtEmail = (EditText) findViewById(R.id.edtForgottenEmail);

        txtSuccessfully.setVisibility(View.GONE);
        imgSuccessfully.setVisibility(View.GONE);
    }

    public void getPassword(View view) {
        if (!edtEmail.getText().toString().trim().equals("")) {
            Display.startLoading("Updating user",this);
            UserController userController = new UserController(edtEmail.getText().toString(),this);
            //calling signup callback coz it watch the same type i am expecting
            userController.forgottenPassword(new RikiApiSignUpCallBack() {
                @Override
                public void onSuccess(String feedback) {
                    Display.endLoading();

                    if(feedback.startsWith("We"))
                    {
                        txtSuccessfully.setVisibility(View.VISIBLE);
                        imgSuccessfully.setVisibility(View.VISIBLE);
                    }

                    Display.toast(feedback,getApplicationContext());
                }

                @Override
                public void onConnectingError(VolleyError error) {
                    Display.endLoading();
                    Display.toast(AppNetworkError.check(error),getApplicationContext());
                }

                @Override
                public void onParsingError(Exception error) {
                    Display.endLoading();
                    Display.toast(error.getMessage(),getApplicationContext());
                }

                @Override
                public void onJSONError(JSONException error) {
                    Display.endLoading();
                    Display.toast(error.getMessage(),getApplicationContext());
                }
            });
        }

        else {
            Display.toast("Enter Your Email to get your password",getApplicationContext());
        }
    }
}
