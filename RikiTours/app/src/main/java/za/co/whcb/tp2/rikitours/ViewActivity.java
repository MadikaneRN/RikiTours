package za.co.whcb.tp2.rikitours;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;

public class ViewActivity extends AppCompatActivity {

    private String[] dataFromBundle = new String[4];
    private String[] imagesFromBundle = new String[5];;
    private TextView[] avalaibleTextViews = new TextView[4];;
    private ImageView[] avalaibleImageViews = new ImageView[5];


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

        ImageView imgMain = (ImageView) findViewById(R.id.imgMain);
        ImageView imgSub1 = (ImageView) findViewById(R.id.imgSub1);
        ImageView imgSub2 = (ImageView) findViewById(R.id.imgSub2);
        ImageView imgSub3 = (ImageView) findViewById(R.id.imgSub3);

        avalaibleTextViews[0] =  txtTitle;

        avalaibleTextViews[1] = txtTitleComment;
        avalaibleTextViews[2] = txtDescription1;
        avalaibleTextViews[3] = txtDescription2;


        avalaibleImageViews[0] =  imgMain;
        avalaibleImageViews[1] = imgSub1;
        avalaibleImageViews[2] = imgSub2;
        avalaibleImageViews[3] = imgSub3 ;



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            dataFromBundle[0] = extras.getString("title");
            dataFromBundle[1] = extras.getString("titleComment");
            dataFromBundle[2] = extras.getString("description");

            imagesFromBundle[0] = extras.getString("firstImage");
            imagesFromBundle[1] = extras.getString("secondImage");
            imagesFromBundle[2] = extras.getString("thirdImage");
            imagesFromBundle[3] = extras.getString("forthImage");

            //this.getActionBar().setTitle(dataFromBundle[0]);
            setTitle(dataFromBundle[0]);
        }

        loadDataToViews(dataFromBundle, avalaibleTextViews, imagesFromBundle, avalaibleImageViews);


    }

    private void loadDataToViews(String[] data, TextView[] textViews, String[] imageUrl, ImageView[] imageViews) {


        for(int i = 0; i< data.length;i++) {
            textViews[i].setText(data[i]);

            if(i == 2 && data[i].length() > 250 && data[i].length() < 350){
                textViews[i].setText(data[i].substring(0, 250));
                textViews[i+1].setText(data[i+1].substring(250));
            }

            else if (i == 2 && data[i].length() < 250){
                textViews[i].setText(data[i]);
            }

            else if (i == 2 && data[i].length() >  350 ){

                int length = data[i].length();
                int half = length/2;
                textViews[i].setText(data[i].substring(0, half));
                textViews[i+1].setText(data[i+1].substring(half));

            }

            ImageLoader.loadFromUrl(imageUrl[i], imageViews[i], this);
        }

        ImageLoader.loadFromUrl(imageUrl[3], imageViews[3], this);


    }
}

