package Repository;

import Models.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RoomRepository {
    private final Map<String, Room> rooms = new HashMap<>();

    public Room addRoom(final String floorId) {
        Room room = new Room(floorId, UUID.randomUUID().toString(), false);
        rooms.put(room.getId(), room);
        return room;
    }

    public Room getRoomById(final String roomId) {
        return rooms.get(roomId);
    }

    public void setRoomAvailability(final String roomId, final boolean isBooked) {
        rooms.get(roomId).setAvailability(isBooked);
    }
}
