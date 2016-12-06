package za.co.whcb.tp2.rikitours.repositorytest.accommodation;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.repository.local.accommodation.RoomRepo;

/**
 * Created by bishop v on 2016-12-06.
 */
public class RoomTest extends AndroidTestCase {
    private RoomRepo roomRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        roomRepo = new RoomRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        roomRepo.close();
        super.tearDown();
    }


}
