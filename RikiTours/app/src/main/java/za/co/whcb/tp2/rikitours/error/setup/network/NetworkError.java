package za.co.whcb.tp2.rikitours.error.setup.network;

import za.co.whcb.tp2.rikitours.error.setup.AppErrror;

/**
 * Created by kelly on 10/2/2016.
 */
public class NetworkError extends AppErrror {
    public NetworkError() {
    }

    public NetworkError(String id, String name, String message) {
        super(id, name, message);
    }
}
