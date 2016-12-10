package za.co.whcb.tp2.rikitours.common.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.R;
import za.co.whcb.tp2.rikitours.common.NavigatorItem;

/**
 * Created by gaming on 12/7/2016.
 */
public class MenuAdapter extends ArrayAdapter<NavigatorItem> {
    private Activity context;
    private  ArrayList<NavigatorItem> items;
    public MenuAdapter(Activity context, ArrayList<NavigatorItem> items) {
        super(context, R.layout.left_menu_layout, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.left_menu_layout,null,true);

        TextView txtIconName = (TextView) rowView.findViewById(R.id.txtIconeName);
        ImageView iconImage = (ImageView) rowView.findViewById(R.id.imgIcon);

        LinearLayout layout = (LinearLayout) rowView.findViewById(R.id.menuLayout);

        txtIconName.setVisibility(View.GONE);
        iconImage.setVisibility(View.GONE);

        final NavigatorItem currentItem = getCurrentItem(position);

        if(currentItem.getName().equalsIgnoreCase("my profile")) {
            txtIconName.setText(currentItem.getName());
            iconImage.setImageResource(R.drawable.user);
            txtIconName.setVisibility(View.VISIBLE);
            iconImage.setVisibility(View.VISIBLE);
        }
        else if(currentItem.getName().equalsIgnoreCase("my list")){
            txtIconName.setText(currentItem.getName());
            iconImage.setImageResource(R.drawable.cart_1);
            //txtIconName.setVisibility(View.VISIBLE);
            txtIconName.setVisibility(View.VISIBLE);
            iconImage.setVisibility(View.VISIBLE);
        }
        else if(currentItem.getName().equalsIgnoreCase("my notifications")){
            txtIconName.setText(currentItem.getName());
            iconImage.setImageResource(R.drawable.chat_icon);
            iconImage.setVisibility(View.VISIBLE);
            txtIconName.setVisibility(View.VISIBLE);
           // txtNew.setText("2* new");
           //txtNew.setVisibility(View.VISIBLE);
        }

        else if(currentItem.getName().equalsIgnoreCase("Sign Out")){
            txtIconName.setText(currentItem.getName());
            layout.setPadding(10,60,0,0);
            //iconImage.setPadding(0,50,0,0);
            iconImage.setImageResource(R.drawable.logout_1);
            iconImage.setVisibility(View.VISIBLE);
            txtIconName.setVisibility(View.VISIBLE);
        }
        else if(currentItem.getName().equalsIgnoreCase("Options") || currentItem.getName().equalsIgnoreCase("Options")){
            //txtHeading.setText(currentItem.getName());
           // txtHeading.setVisibility(View.VISIBLE);
        }


        return rowView;
    }



    public NavigatorItem getCurrentItem(int position) {
        return items.get(position);
    }
}
