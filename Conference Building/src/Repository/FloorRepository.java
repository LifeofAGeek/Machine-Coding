package Repository;

import Models.Floor;

import java.util.HashMap;
import java.util.Map;

public class FloorRepository {
    private final Map<String, Floor> floors = new HashMap<>();
    private int floorCounter = 1;

    public Floor addFloor(final String buildingId) {
        Floor floor = new Floor(buildingId, floorCounter++);
        floors.put(floor.getId(), floor);
        return floor;
    }
}
