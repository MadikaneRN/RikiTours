package za.co.whcb.tp2.rikitours.controllers.user;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;

/**
 * Created by gaming on 11/24/2016.
 */
public class SigninController {
    private final String url = "http://tp.sawebdesignhosting.co.za/login/";
    private Customer user;
    private RequestQueue requestQueue;
    private String email,password;
    private Context context;
    private boolean feedback;

    public SigninController(String email, String password, Context context) {
        this.email = email;
        this.password = password;
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public boolean signin() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONArray data = response.getJSONArray(0);
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject jsonObject = data.getJSONObject(i);
                                long id = Long.parseLong(jsonObject.getString("customer_id"));
                                Display.toast(String.valueOf(id), context);
//                                String namme = jsonObject.getString("customer_name");
//                                String surnamme = jsonObject.getString("customer_surname");
//                                String gender = jsonObject.getString("customer_gender");
//                                String dob = jsonObject.getString("customer_dob");
//                                String email = jsonObject.getString("customer_email");
//                                String phone = jsonObject.getString("customer_phone");
//
//                                user = CustomerFactory.getCustomer(id,namme,surnamme, String.valueOf(id));
                                feedback = true;
                                //Log.d("Response", response);
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                            Display.toast("Error " + e.getMessage(), context);
                            feedback = false;

                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                HashMap<String, String>  params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);

//                HashMap<String, String> params = new HashMap<String, String>();
//                params.put("token", "AbCdEfGh123456");

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        requestQueue.add(jsonArrayRequest);
        return feedback;
    }

}


