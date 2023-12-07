package models;

import java.util.List;
import java.util.UUID;

public class Bid {
    private String id;
    private String userId;
    private String eventId;
    private List<Integer> bidValues;

    public Bid(String userId, String eventId, List<Integer> bidValues) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.eventId = eventId;
        this.bidValues = bidValues;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public List<Integer> getBidValues() {
        return bidValues;
    }

    public void setBidValues(List<Integer> bidValues) {
        this.bidValues = bidValues;
    }
}
