package models;

public class Event {
    private String id;
    private String name;
    private String startDate;
    private Item prize;
    private boolean isActive;

    public Event(String id, String name, String startDate, Item prize, boolean isActive) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.prize = prize;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Item getPrize() {
        return prize;
    }

    public void setPrize(Item prize) {
        this.prize = prize;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
