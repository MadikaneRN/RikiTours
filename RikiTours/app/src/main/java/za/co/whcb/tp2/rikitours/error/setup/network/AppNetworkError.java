package za.co.whcb.tp2.rikitours.error.setup.network;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import za.co.whcb.tp2.rikitours.error.setup.AppErrror;

/**
 * Created by kelly on 10/2/2016.
 */
public class AppNetworkError {
  public static String check(VolleyError error){
      String message = null;
      if (error instanceof com.android.volley.NetworkError) {
          message = "Cannot connect to Internet...Please check your connection!";
      } else if (error instanceof ServerError) {
          message = "The server could not be found. Please try again after some time!!";
      } else if (error instanceof AuthFailureError) {
          message = "Cannot connect to Internet...Please check your connection!";
      } else if (error instanceof ParseError) {
          message = "Parsing error! Please try again after some time!!";
      } else if (error instanceof NoConnectionError) {
          message = "Cannot connect to Internet...Please check your connection!";
      } else if (error instanceof TimeoutError) {
          message = "Connection TimeOut! Please check your internet connection.";
      }
      return message;
  }
}
