package za.co.whcb.tp2.rikitours.factories.accommodation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;

/**
 * Created by bishop v on 2016-12-03.
 */
public class RoomTest {
    private Room room;
    private Hotel hotel;

    @Before
    public void setUp() throws Exception {
        room = RoomFactory.getRoom(1L,"800*200","double","ein suite", hotel);
    }

    @Test
    public void testRoom() throws Exception {
        Assert.assertNotNull(room);
        Assert.assertEquals("double", room.getType());
    }

    @Test
    public void testRoomUpdate() throws Exception {
        Room newRoom  = new Room.Builder().copy(room).type("single") .build();
        Assert.assertEquals("single", newRoom.getType());
    }
}
