package Models;

import java.util.UUID;

public class Room {
    private final String id;
    private final String floorId;
    private String name;
    private boolean isAvailable;

    public Room(String floorId, String name, boolean isAvailable) {
        this.id = UUID.randomUUID().toString();
        this.floorId = floorId;
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public String getFloorId() {
        return floorId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBooked() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
