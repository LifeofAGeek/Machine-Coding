package Service;

import models.Bid;
import repository.BidRepository;
import repository.EventRepository;

import java.util.List;


// A -> B, C

public class BiddingService {
    private final BidRepository bidRepository;
    private final EventRepository eventRepository;

    public BiddingService(BidRepository bidRepository, EventRepository eventRepository) {
        this.bidRepository = bidRepository;
        this.eventRepository = eventRepository;
    }

    public void submitBid(final String userId, final String eventId, final List<Integer> bids) {
        if (!eventRepository.isUserRegistered(eventId, userId)) {
            System.out.println("[UserID: " + userId + "] did not registered for this event");
            return;
        }
        Bid bid = new Bid(userId, eventId, bids);
        bidRepository.addBid(eventId, bid);
        System.out.println("[UserID: " + userId + "] BIDS submitted successfully");
    }
}
