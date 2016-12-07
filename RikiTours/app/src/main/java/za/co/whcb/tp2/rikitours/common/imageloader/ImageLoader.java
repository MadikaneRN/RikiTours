package za.co.whcb.tp2.rikitours.common.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import za.co.whcb.tp2.rikitours.R;

/**
 * Created by Berka on 10/16/2016.
 */
public class ImageLoader {
    public static void loadFromUrl(String url, ImageView target, Context context) {
        Picasso.with(context).load(url).placeholder(R.drawable.progress_animation)
                .error(R.drawable.not_available)
                .into( target);
    }
}
