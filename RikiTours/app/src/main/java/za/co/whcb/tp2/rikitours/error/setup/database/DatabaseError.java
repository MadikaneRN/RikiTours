package za.co.whcb.tp2.rikitours.error.setup.database;

import za.co.whcb.tp2.rikitours.error.setup.AppError;

/**
 * Created by kelly on 10/2/2016.
 */
public class DatabaseError extends AppError {

    public DatabaseError() {
    }

    public DatabaseError(String id, String name, String message) {
        super(id, name, message);
    }
}
