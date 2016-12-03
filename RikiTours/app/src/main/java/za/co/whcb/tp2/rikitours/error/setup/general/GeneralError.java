package za.co.whcb.tp2.rikitours.error.setup.general;

import za.co.whcb.tp2.rikitours.error.setup.AppError;

/**
 * Created by kelly on 10/2/2016.
 */
public class GeneralError extends AppError {
    public GeneralError() {
    }

    public GeneralError(String id, String name, String message) {
        super(id, name, message);
    }
}
