package repository;

import models.Event;

import java.util.*;

public class EventRepository {
    // eventId -> list of participants
    final Map<String, List<String>> eventParticipants = new HashMap<>();
    final Map<String, Event> events = new HashMap<>();

    // add user to an event
    public void registerUser(final String userId, final String eventId) {
        if (!eventParticipants.containsKey(eventId)) {
            eventParticipants.put(eventId, new ArrayList<>());
        }
        eventParticipants.get(eventId).add(userId);
    }

    public void addEvent(final Event event) {
        events.put(event.getId(), event);
    }

    public boolean isUserRegistered(final String eventId, final String userId) {
        Optional<String> val = eventParticipants.get(eventId)
                .stream()
                .filter(id -> Objects.equals(id, userId))
                .findAny();
        return val.isPresent();
    }

    public List<String> getAllParticipants(final String eventId) {
        return eventParticipants.get(eventId);
    }
}
