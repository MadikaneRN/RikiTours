package za.co.whcb.tp2.rikitours;

import junit.framework.TestCase;

import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.error.ApplicationError;

/**
 * Created by berka on 9/17/2016.
 */
public class AppTest extends TestCase {
   //Factory tests code here


    //Generated object tests code here
    
    //calculation tests code here

    //error tests

    public void testGeneralError() throws Exception {
        //Display.console(ApplicationError.general(0).getMessage());
        assertNotNull(ApplicationError.general(0));
    }

    //end error tests

}
