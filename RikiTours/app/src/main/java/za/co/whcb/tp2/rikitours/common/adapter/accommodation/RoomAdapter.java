package za.co.whcb.tp2.rikitours.common.adapter.accommodation;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.GalleryViewActivity;
import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.ViewActivity;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.common.imageloader.ImageLoader;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.gallery.GalleryContainer;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

/**
 * Created by gaming on 11/12/2016.
 */
public class RoomAdapter extends ArrayAdapter<Room> {
    private ArrayList<Room> rooms;
    private final Activity context;
    private GalleryContainer galleryContainer;

    public RoomAdapter(Activity context, ArrayList<Room> rooms) {
        super(context, R.layout.activity_layout_listing, rooms);
        this.context = context;
        this.rooms = rooms;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_layout_listing,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.txtDescription);
        ImageView image = (ImageView) rowView.findViewById(R.id.imgBox);
        ImageView viewImageFlag = (ImageView) rowView.findViewById(R.id.imgFlag);
        ImageView viewImageRant = (ImageView) rowView.findViewById(R.id.imageStar);
        Button btnReadmore = (Button) rowView.findViewById(R.id.btnReamore);
        Button btnBooknow = (Button) rowView.findViewById(R.id.btnBooknow);
        Button btnGallery = (Button) rowView.findViewById(R.id.btnGallery);

        txtTitle.setText(rooms.get(position).getHotel().getName() +" / "+ rooms.get(position).getType());
        int rant = rooms.get(position).getHotel().getStar();

        switch (rant){
            case 1:
                viewImageRant.setBackgroundResource(R.drawable.stars_1);
                break;
            case 2:
                viewImageRant.setBackgroundResource(R.drawable.stars_2);
                break;
            case 3:
                viewImageRant.setBackgroundResource(R.drawable.stars_3);
                break;
            case 4:
                viewImageRant.setBackgroundResource(R.drawable.stars_4);
                break;
            case 5:
                viewImageRant.setBackgroundResource(R.drawable.stars_5);
                break;
            default:
                viewImageRant.setVisibility(View.GONE);
                break;
        }
//        if(rant == 1) {
//            viewImageRant.setBackgroundResource(R.drawable.stars_1);
//        }
//
//        else if (rant == 2){
//            viewImageRant.setBackgroundResource(R.drawable.stars_1);
//        }

        String description = rooms.get(position).getDescription();
        String shortDescription ;

        if (description.length() > 150) {
            shortDescription = description.substring(0, 145);
            shortDescription = shortDescription + " ...";
            txtDescription.setText(shortDescription);
        }

        else {
            txtDescription.setText(description);
        }

        ImageLoader.loadFromUrl(rooms.get(position).getImage(2).getUrl(),image, context);
        ImageLoader.loadFromUrl(rooms.get(position).getImage(0).getUrl(), viewImageFlag, context);

        final Room currentRoom = getCurrentRoom(position);

        btnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display.toast(String.valueOf(currentCountry.getDescription().length()),context);
                 Intent viewDetails = new Intent(context, ViewActivity.class);
                 viewDetails.putExtra("objectType","room");
                 viewDetails.putExtra("room",currentRoom);

                 context.startActivity(viewDetails);
            }
        });

        btnBooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display.toast("Booking..." + currentCountry.getName(),context);
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryViewer = new Intent(context, GalleryViewActivity.class);
                GalleryContainer galleryContainer = new GalleryContainer(currentRoom.getImages(),
                        currentRoom.getHotel().getName());;
                if(galleryContainer.getImages().size() > 0) {
                    galleryViewer.putExtra("gallery", galleryContainer);
                    galleryViewer.putExtra("objectType","gallery");
                    context.startActivity(galleryViewer);
                }
            }
        });

        return rowView;
    }

    public Room getCurrentRoom(int position) {
        return rooms.get(position);
    }
}