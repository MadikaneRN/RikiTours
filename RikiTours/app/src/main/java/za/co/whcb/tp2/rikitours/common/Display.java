package za.co.whcb.tp2.rikitours.common;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by kelly on 9/23/2016.
 */
public class Display {
    private static ProgressDialog progress;
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

    public static void startLoading(String message,Context context){
        progress = new ProgressDialog(context);
       // progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //progress.setIndeterminate(true);
        progress.setMessage(message + "...");
        progress.show();
    }

    public static void endLoading() {
        if(progress != null){
            progress.hide();
        }
        else {

        }
    }
}
