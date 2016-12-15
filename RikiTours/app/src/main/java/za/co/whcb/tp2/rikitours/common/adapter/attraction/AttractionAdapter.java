package za.co.whcb.tp2.rikitours.common.adapter.attraction;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;

import org.json.JSONException;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.controllers.tour.AttractionController;
import za.co.whcb.tp2.rikitours.controllers.tour.callback.RikiAttractionQuoteCallBack;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.error.setup.network.AppNetworkError;
import za.co.whcb.tp2.rikitours.views.GalleryViewActivity;
import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.views.ViewActivity;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.repository.local.tour.AttractionsRepo;
import za.co.whcb.tp2.rikitours.services.domain.tours.CountryService;

/**
 * Created by work on 10/27/2016.
 */
public class AttractionAdapter extends ArrayAdapter<Attraction> {


    private ArrayList<Attraction> attractions;
    private final Activity context;
    //private GalleryContainer galleryContainer;
    private CountryService attractionService;
    private boolean isBound;
    private Customer user;
    private AttractionsRepo attractionsRepo;

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions, Customer user) {
        super(context, R.layout.activity_layout_listing, attractions);
        this.context = context;
        this.attractions = attractions;
        this.user = user;
        this.attractionsRepo = new AttractionsRepo(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_layout_listing,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        TextView txtSubTitle = (TextView) rowView.findViewById(R.id.txtSubTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView viewImage = (ImageView) rowView.findViewById(R.id.imgBox);
        ImageView viewImageFlag = (ImageView) rowView.findViewById(R.id.imgFlag);
        Button btnReadmore = (Button) rowView.findViewById(R.id.btnReamore);
        Button btnBooknow = (Button) rowView.findViewById(R.id.btnBooknow);
        Button btnGallery = (Button) rowView.findViewById(R.id.btnGallery);

        btnBooknow.setText("Get a Quote");
        txtTitle.setText(attractions.get(position).getAttractionDescription().getName().toUpperCase());
        txtSubTitle.setText(attractions.get(position).getAttractionDescription().getCity()+" / " +attractions.get(position).getCountry().getName());

        String description = attractions.get(position).getAttractionDescription().getDescription();
        String shortDescription = null;

        if (description.length() > 150) {
            shortDescription = description.substring(0, 145);
            shortDescription = shortDescription + " ...";
            txtDescription.setText(shortDescription);
        }

        else {
            txtDescription.setText(description);
        }

        ImageLoader.loadFromUrl(attractions.get(position).getAttractionDescription().getImage(0).getUrl(), viewImage, context);
        ImageLoader.loadFromUrl(attractions.get(position).getCountry().getImage(), viewImageFlag, context);

        final Attraction currentAttraction = getCurrentAttraction(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewDetails = new Intent(context, ViewActivity.class);
                viewDetails.putExtra("objectType","attraction");
                viewDetails.putExtra("attraction",currentAttraction);
                context.startActivity(viewDetails);
            }
        });

        btnBooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.startLoading("Requesting a quote",context);
                AttractionController attractionController = new AttractionController(currentAttraction,user,context);
                attractionController.requestQuote(new RikiAttractionQuoteCallBack() {
                    @Override
                    public void onSuccess(String feedback) {
                        Display.endLoading();
                        Display.toast(feedback,context);
                    }

                    @Override
                    public void onConnectingError(VolleyError error) {
                        Display.endLoading();
                        Display.toast(AppNetworkError.check(error),context);
                    }

                    @Override
                    public void onParsingError(Exception error) {
                        Display.endLoading();
                        Display.toast(error.getMessage(),context);
                    }

                    @Override
                    public void onJSONError(JSONException error) {

                    }
                });


            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryViewer = new Intent(context, GalleryViewActivity.class);
                GalleryContainer galleryContainer = new GalleryContainer(currentAttraction.getAttractionDescription().getImages(),
                        currentAttraction.getAttractionDescription().getName());;
                if(galleryContainer.getImages().size() > 0) {
                    galleryViewer.putExtra("gallery", galleryContainer);
                    galleryViewer.putExtra("objectType","gallery");
                    context.startActivity(galleryViewer);
                }
            }
        });

        return rowView;
    }

    public Attraction getCurrentAttraction(int position) {
        return attractions.get(position);
    }

}
