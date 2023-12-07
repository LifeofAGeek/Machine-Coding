package Service;

import Models.Booking;
import Models.Room;
import Models.User;
import Repository.BookingRepository;
import Repository.RoomRepository;

import java.time.LocalDateTime;
import java.util.List;

public class BookingService {
    private BookingRepository bookingRepository;
    private RoomRepository roomRepository;

    public Booking bookRoom(final User user, final Room room,
                            final LocalDateTime startTime,
                            final LocalDateTime endTime) {
        Booking booking = bookingRepository.createBooking(
                user.getId(), room.getId(), startTime, endTime);
        roomRepository.setRoomAvailability(room.getId(), true);
        return booking;
    }

    public void cancelBooking(final String bookingId) {
        Booking booking = bookingRepository.getBookingById(bookingId);
        if (booking != null) {
            // Mark the room as available again
            roomRepository.setRoomAvailability(booking.getRoomId(), false);
            // Remove the booking
            bookingRepository.deleteBooking(bookingId);
        }
    }

    public List<Booking> listBookingsByUser(String userId) {
        return bookingRepository.getBookingsByUserId(userId);
    }
}
