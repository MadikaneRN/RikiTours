package za.co.whcb.tp2.rikitours.error.setup;

/**
 * Created by kelly on 10/2/2016.
 */
public abstract class AppErrror implements Error{
    private String id;
    private String name;
    private String message;

    public AppErrror() {
    }

    public AppErrror(String id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
