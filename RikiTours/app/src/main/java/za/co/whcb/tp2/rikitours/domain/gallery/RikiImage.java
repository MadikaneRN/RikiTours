package za.co.whcb.tp2.rikitours.domain.gallery;

/**
 * Created by work on 10/22/2016.
 */
public class RikiImage {
    private String name;
    private String url;

    public RikiImage(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
