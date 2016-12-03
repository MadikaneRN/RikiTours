package za.co.whcb.tp2.rikitours.domain.gallery;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by work on 10/22/2016.
 */
public class GalleryContainer implements Serializable{

    private ArrayList<RikiImage> images;
    private String title;

    public GalleryContainer(ArrayList<RikiImage> images,String title) {
        this.images = images;
        this.title = title;
    }

    public GalleryContainer() {
        this.images = new ArrayList<>();
        this.title = "testing";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<RikiImage> getImages() {
        return images;
    }

    public void addImage(RikiImage images) {
        this.images.add(images);
    }

    public RikiImage getImage(int index) {
        return images.get(index);
    }

    public void removeImagee(int index) {
        images.remove(index);
    }
    public int getSize() {
       return images.size();
    }


}
