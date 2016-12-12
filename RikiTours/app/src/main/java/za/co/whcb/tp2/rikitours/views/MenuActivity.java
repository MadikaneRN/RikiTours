package za.co.whcb.tp2.rikitours.views;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.NavigatorItem;
import za.co.whcb.tp2.rikitours.common.adapter.MenuAdapter;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;

public class MenuActivity extends AppCompatActivity {

    private  Customer user;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private MenuAdapter mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setIcon(R.mipmap.logo_1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = (Customer) getIntent().getSerializableExtra("user");
        }
        Display.toast("Welcome " + user.getName().toUpperCase(),this);

    }

    public void listAccommodations(View view) {
        Intent myIntent = new Intent(this, ListActivity.class);
        myIntent.putExtra("open", "Accommodations"); //Optional parameters
        this.startActivity(myIntent);
    }

    public void listAttractions(View view) {
        Intent myIntent = new Intent(this, ListActivity.class);
        myIntent.putExtra("open", "Attractions");
        myIntent.putExtra("user", user);

        //Optional parameters
        this.startActivity(myIntent);
    }

    public void listVehicles(View view) {
        Intent myIntent = new Intent(this, ListActivity.class);
        myIntent.putExtra("open", "Vehicles");
        myIntent.putExtra("user", user);//Optional parameters
        this.startActivity(myIntent);

    }

    public void aboutRikiTours(View view) {
        Intent myIntent = new Intent(this, AboutActivity.class);
        myIntent.putExtra("key", ""); //Optional parameters
        this.startActivity(myIntent);
    }

    public void aboutApp(View view) {
        Intent myIntent = new Intent(this, AboutAppActivity.class);
        this.startActivity(myIntent);
    }

    private void addDrawerItems() {
        ArrayList<NavigatorItem> menuItems = new ArrayList<>();
        menuItems.add(new NavigatorItem("My Profile"));
//        menuItems.add(new NavigatorItem("My list"));
//        menuItems.add(new NavigatorItem("My Notifications"));
        menuItems.add(new NavigatorItem("Sign Out"));

        mAdapter = new MenuAdapter(this,menuItems);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Time for an upgrade!", Toast.LENGTH_SHORT).show();

               if(position == 0) {
                   //mDrawerList.
                   Intent myIntent = new Intent(getApplicationContext(), UserProfile.class);
                   myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   myIntent.putExtra("user", user); //Optional parameters
                   getApplicationContext().startActivity(myIntent);
               }

            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
