package za.co.whcb.tp2.rikitours.common.adapter.gallery;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;

/**
 * Created by berka on 10/22/2016.
 */
public class GalleryViewAdapter extends PagerAdapter {
    private GalleryContainer galleryContainer;
    private Context context;
    private LayoutInflater layoutInflater;

    public GalleryViewAdapter(GalleryContainer galleryContainer, Context context) {
        this.galleryContainer = galleryContainer;
        this.context = context;
    }

    @Override
    public int getCount() {
        return galleryContainer.getSize();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewItems = layoutInflater.inflate(R.layout.activity_gallery_swip, container, false);

        ImageView imageView = (ImageView) viewItems.findViewById(R.id.imageViewGallery);
        TextView textView = (TextView) viewItems.findViewById(R.id.galleryTitle);
        textView.setText("image : "+ position);

        ImageLoader.loadFromUrl(galleryContainer.getImage(position).getUrl(),imageView,context);

        container.addView(viewItems);

        return viewItems;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
