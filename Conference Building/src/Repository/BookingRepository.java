package Repository;

import Models.Booking;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BookingRepository {
    private final Map<String, Booking> bookings = new HashMap<>();

    public Booking createBooking(final String userId, final String roomId,
                                 final LocalDateTime startTime, final LocalDateTime endTime) {
        Booking booking = new Booking(userId, roomId, startTime, endTime);
        bookings.put(booking.getId(), booking);
        return booking;
    }

    public void deleteBooking(final String bookingId) {
        bookings.remove(bookingId);
    }

    public List<Booking> getBookingsByUserId(final String userId) {
        return bookings.values().stream()
                .filter(booking -> Objects.equals(booking.getUserId(), userId))
                .collect(Collectors.toList());
    }

    public List<Booking> listBooking() {
        return bookings.values().stream().toList();
    }

    public Booking getBookingById(final String id) {
        return bookings.get(id);
    }
}
