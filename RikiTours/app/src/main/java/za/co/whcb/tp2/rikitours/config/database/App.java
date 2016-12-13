package za.co.whcb.tp2.rikitours.config.database;

import android.app.Application;
import android.content.Context;

/**
 * Created by berka on 12/12/2016.
 */
public class App extends Application {

    private static Context context;
    private static App singleton;

    public void onCreate()
    {
        super.onCreate();
        App.context =getApplicationContext();
        singleton = this;
    }


    public static Context getAppContext()
    {
        return App.context;
    }



}
