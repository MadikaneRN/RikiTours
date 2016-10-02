package za.co.whcb.tp2.rikitours.error;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.error.setup.Error;
import za.co.whcb.tp2.rikitours.error.setup.general.GeneralError;

/**
 * Created by kelly on 10/2/2016.
 */
public class ApplicationError {
    //GENERAL ERRORS
    private static final ArrayList<GeneralError> genErrors = new ArrayList<>();

    public static GeneralError general(int index){
        load("general");
        return genErrors.get(index);
    }

    private static void load(String error) {
        if( error.equals("general")) {
            genErrors.add(new GeneralError("1", "savinggerror", "error , the app could not save " ));
            genErrors.add(new GeneralError("2", "unknown", "error " ));
        }

        else if( error.equals("network")) {
            genErrors.add(new GeneralError("1", "connecting", "error , could not connect to the server" ));
            genErrors.add(new GeneralError("2", "unknown", "connection failed " ));
        }
    }
}
