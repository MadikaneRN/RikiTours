package za.co.whcb.tp2.rikitours.views;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;

public class ViewActivity extends AppCompatActivity {

    private String[] dataFromBundle = new String[4];
    private String[] imagesFromBundle = new String[5];;
    private TextView[] avalaibleTextViews = new TextView[4];;
    private ImageView imageViews ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_1);

        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        TextView txtTitleComment = (TextView) findViewById(R.id.txtTtileComment);
        TextView txtDescription1  = (TextView) findViewById(R.id.txtDescription1);
        TextView txtDescription2  = (TextView) findViewById(R.id.txtDescription);

        imageViews = (ImageView) findViewById(R.id.imgMain);

        avalaibleTextViews[0] =  txtTitle;
        avalaibleTextViews[1] = txtTitleComment;
        avalaibleTextViews[2] = txtDescription1;
        avalaibleTextViews[3] = txtDescription2;

        Bundle extras = getIntent().getExtras();
        getDataFromBundle(extras);

    }

    public void getDataFromBundle(Bundle extras){
        if (extras != null) {

            if (extras.get("objectType").equals("room")) {
                Room room = (Room) getIntent().getSerializableExtra("room");
                //Log.e("VOLLEY", room.getSize());

                dataFromBundle[0] = room.getHotel().getName();
                dataFromBundle[1] = " R " + String.valueOf(room.getPrice()) + "/pn";
                dataFromBundle[2] = room.getDescription();
                dataFromBundle[3] = room.getHotel().getDescription();

                setTitle(room.getType());
                loadDataToViews(dataFromBundle, avalaibleTextViews, room.getImage(2).getUrl(), imageViews);
            }

            if (extras.get("objectType").equals("attraction")) {
                Attraction attraction = (Attraction) getIntent().getSerializableExtra("attraction");
                Log.e("VOLLEY", String.valueOf(attraction.getId()));

                dataFromBundle[0] = attraction.getAttractionDescription().getName();
                dataFromBundle[1] = " / "+attraction.getAttractionDescription().getCity();
                dataFromBundle[2] = attraction.getAttractionDescription().getDescription();
                dataFromBundle[3] = attraction.getCountry().getDescription();

                setTitle(attraction.getAttractionDescription().getName());
                loadDataToViews(dataFromBundle, avalaibleTextViews, attraction.getAttractionDescription().getImage(1).getUrl(), imageViews);
            }

        }
    }
    private void loadDataToViews(String[] data, TextView[] textViews, String imageUrl, ImageView imageViews) {

        for(int i = 0; i< data.length;i++) {
            textViews[i].setText(data[i]);
        }
        ImageLoader.loadFromUrl(imageUrl, imageViews, this);


    }
}

