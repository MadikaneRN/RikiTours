package za.co.whcb.tp2.rikitours.domain;

import java.io.Serializable;

/**
 * Created by berka on 9/17/2016.
 */
public interface Person extends Serializable {
    long getId();
    String getName();
    String getSurname();
    String getEmail();

}
