package Service;

import models.Bid;
import models.Event;
import models.Item;
import models.User;
import repository.BidRepository;
import repository.EventRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EventService {
    private final EventRepository eventRepository;
    private final BidRepository bidRepository;

    public EventService(EventRepository eventRepository, BidRepository bidRepository) {
        this.eventRepository = eventRepository;
        this.bidRepository = bidRepository;
    }

    public Event createEvent(final String eventId, final String eventName,
                             final Item item, String startDate) {
        Event event = new Event(eventId, eventName, startDate, item, true);
        eventRepository.addEvent(event);
        System.out.printf("%s with prize %s added successfully%n", eventName, item.getName());
        return event;
    }

    public void registerUser(final User user, final Event event) {
        eventRepository.registerUser(user.getId(), event.getId());
        System.out.println(user.getName() + " registered to the " + event.getName() + " event successfully");
    }

    public String declareWinner(final String eventId) {
        List<Bid> bids = bidRepository.getBidsOfEvent(eventId);
        Optional<Bid> winningBid = bids.stream()
                .min(Comparator.comparingInt(bid -> bid.getBidValues().stream()
                        .mapToInt(Integer::intValue)
                        .min()
                        .orElse(Integer.MAX_VALUE)));

        return winningBid.map(Bid::getUserId).orElse(null);
    }
}
