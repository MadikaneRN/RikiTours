package za.co.whcb.tp2.rikitours.common;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by kelly on 9/23/2016.
 */
public class Display {

    public static void console(String value)
    {
        System.out.println(value);
    }

    public static  void toast(String msg, Context context)
    {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void toastError (String value)
    {

    }
}
