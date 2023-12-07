package repository;

import models.Bid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BidRepository {
    // eventID -> list of bids
    final Map<String, List<Bid>> eventBids = new HashMap<>();

    public void addBid(final String eventId, final Bid bid) {
        if (!eventBids.containsKey(eventId)) {
            eventBids.put(eventId, new ArrayList<>());
        }
        eventBids.get(eventId).add(bid);
    }

    public List<Bid> getBidsOfEvent(final String eventId) {
        return eventBids.get(eventId);
    }
}
