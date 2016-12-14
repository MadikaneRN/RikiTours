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

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.controllers.customer.callback.RikiApiCallback;
import za.co.whcb.tp2.rikitours.controllers.customer.callback.RikiApiSignUpCallBack;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;

/**
 * Created by gaming on 11/24/2016.
 */

public class UserController {
    private final String url = "http://tp.sawebdesignhosting.co.za/login/";
    private final String signUpUrl = "http://tp.sawebdesignhosting.co.za/signup/";
    private final String updateUserUrl = "http://tp.sawebdesignhosting.co.za/updateuser/";
    private RequestQueue requestQueue;
    private String email, password, newPassword;
    private Context context;
    private Customer user;
    private String gender;

    public UserController(String email, String password, Context context) {
        this.email = email;
        this.password = password;
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public UserController(Customer user, String password, String newPassword, Context context) {
        this.user = user;
        this.password = password;
        this.newPassword = newPassword;
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public UserController(String email,String password, Context context, Customer user, String gender) {
        this.password = password;
        this.email = email;
        this.context = context;
        this.user = user;
        this.requestQueue = Volley.newRequestQueue(context);
        this.gender = gender;
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
                            long id = Long.parseLong(userInfo[0]);
                            String name = userInfo[1];
                            String surname = userInfo[2];
                            String gender = userInfo[3];
                            String dob = userInfo[4];
                            String email = userInfo[5];

                            Customer userFromServer = CustomerFactory.getCustomer(id,name,surname, String.valueOf(id));
                            userFromServer.setDob(dob);
                            userFromServer.setGender(gender);
                            userFromServer.setEmail(email);

                            Log.e("FROM SERVERR ::::",response);
                            Log.e("FROM SERVERR ::::",email);
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

    public void signUp(final RikiApiSignUpCallBack callback ) {
        StringRequest request = new StringRequest(1,signUpUrl,
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
                     params.put("customer_name", user.getName());
                     params.put("customer_surname", user.getSurname());
                     params.put("customer_gender",gender);
                     params.put("customer_dob"," ");

                     params.put("customer_email", email);
                     params.put("customer_password",password);
                     params.put("city_id","100");
                     params.put("customer_phone","0");

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

    public void updateUser(final RikiApiSignUpCallBack callback ) {
        StringRequest request = new StringRequest(1,updateUserUrl,
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
                params.put("customer_name", user.getName());
                params.put("customer_surname", user.getSurname());
                params.put("customer_gender",gender);
                params.put("customer_dob",user.getDob());

                params.put("customer_email",user.getEmail());
                params.put("customer_password",password);
                params.put("new_customer_password",newPassword);
                params.put("city_id","100");
                params.put("customer_phone","0");

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


