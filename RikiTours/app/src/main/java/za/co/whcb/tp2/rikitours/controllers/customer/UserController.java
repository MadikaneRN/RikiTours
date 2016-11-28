package za.co.whcb.tp2.rikitours.controllers.customer;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import za.co.whcb.tp2.rikitours.controllers.customer.callback.RikiApiCallback;
import za.co.whcb.tp2.rikitours.controllers.customer.callback.RikiApiSignUpCallBack;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;

/**
 * Created by gaming on 11/24/2016.
 */

public class UserController {
    private final String url = "http://tp.sawebdesignhosting.co.za/login/";
    private RequestQueue requestQueue;
    private String email,password;
    private Context context;

    public UserController(String email, String password, Context context) {
        this.email = email;
        this.password = password;
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void signIn(final RikiApiCallback callback ) {
        StringRequest request = new StringRequest(1,url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String[] userInfo = response.split("#");
                            Log.d("Response --> : ", response);
                            long id = Long.parseLong("1");
                            String name = userInfo[1];
                            String surname = userInfo[2];
                            String gender = userInfo[3];
                            String dob = userInfo[4];
                            String email = userInfo[5];

                            Customer userFromServer = CustomerFactory.getCustomer(id,name,surname, String.valueOf(id));
                            callback.onSuccess(userFromServer);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Log.d("Error--> : ", e.getMessage());
                            callback.onParsingError(e);
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onConnectingError(error);
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }
        };

        requestQueue.add(request);
    }

    public void signUp(final Customer user, String UserPassword, final RikiApiSignUpCallBack callback ) {
        StringRequest request = new StringRequest(1,url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            callback.onSuccess(response);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Log.d("Error--> : ", e.getMessage());
                            callback.onParsingError(e);
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onConnectingError(error);
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("id", String.valueOf(user.getId()));
                params.put("name", user.getName());
                params.put("surname", user.getSurname());
                params.put("email", user.getEmail());
                params.put("password", password);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }
        };

        requestQueue.add(request);
    }

}


