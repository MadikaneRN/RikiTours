package za.co.whcb.tp2.rikitours.repositorytest.accommodation;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.accommodation.RoomFactory;
import za.co.whcb.tp2.rikitours.repository.local.accommodation.RoomRepo;

/**
 * Created by bishop v on 2016-12-06.
 */
public class RoomTest extends AndroidTestCase {
    private RoomRepo roomRepo;
    private static Hotel hotel;

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

    public void addRoomTest() {
        Room room = RoomFactory.getRoom(1L,"8000*2000","double","cabin",hotel);
        assertEquals(true, roomRepo.addRoom(room));
    }

    public void findRoomById() {
        Room room = roomRepo.findRoomById(1);
        assertEquals("double", room.getType());
    }
}
