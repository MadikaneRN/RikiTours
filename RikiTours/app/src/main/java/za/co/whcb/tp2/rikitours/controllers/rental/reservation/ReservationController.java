package za.co.whcb.tp2.rikitours.controllers.rental.reservation;

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
import za.co.whcb.tp2.rikitours.controllers.rental.callback.RikiApiReservationCallBack;
import za.co.whcb.tp2.rikitours.domain.rental.Reservation;

/**
 * Created by owner on 2016/12/14.
 */
public class ReservationController {
    private Reservation reservation;
    private final String reservationUrl = "http://tp.sawebdesignhosting.co.za/makereservation/";
    private RequestQueue requestQueue;

    public ReservationController(Reservation reservation, Context context) {
        this.reservation = reservation;
        this.requestQueue = Volley.newRequestQueue(context);


    }

    public ReservationController( Context context) {
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void makeReservation(final RikiApiReservationCallBack callBack) {
        StringRequest request = new StringRequest(1,reservationUrl,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            callBack.onSuccess(response);

                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Log.d("Error--> : ", e.getMessage());
                            callBack.onParsingError(e);
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callBack.onConnectingError(error);
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("customer_id", String.valueOf(reservation.getCustomer().getId()));
                params.put("vehecle_id", String.valueOf(reservation.getVehicle().getId()));
                params.put("reservation_pickupdate", reservation.getPickUpDate());
                params.put("reservation_pickuptime", reservation.getPickupTime());
                params.put("reservation_amount_to_pay", String.valueOf(reservation.getAmountToPay()));
                params.put("reservation_comments", reservation.getComment());

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
