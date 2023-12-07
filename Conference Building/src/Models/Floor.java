package Models;

import java.util.UUID;

public class Floor {
    private final String id;
    private final String buildingId;
    private int floorNumber;

    public Floor(String buildingId, int floorNumber) {
        this.id = UUID.randomUUID().toString();
        this.buildingId = buildingId;
        this.floorNumber = floorNumber;
    }

    public String getId() {
        return id;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
