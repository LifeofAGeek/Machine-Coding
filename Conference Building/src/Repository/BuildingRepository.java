package Repository;

import Models.Building;

import java.util.HashMap;
import java.util.Map;

public class BuildingRepository {
    private final Map<String, Building> buildings = new HashMap<>();

    public Building addBuilding(final String buildingName) {
        Building building = new Building(buildingName);
        buildings.put(building.getId(), building);
        return building;
    }

    public Building getBuildingById(final String id) {
        return buildings.get(id);
    }
}
