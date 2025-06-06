package airline.booking;

import airline.Passenger;
import airline.flight.Flight;
import airline.seat.Seat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingManager implements IBookingManager {
    private static BookingManager instance;
    private final Map<String,Booking> bookings;
    private final Object lock = new Object();
    private final AtomicInteger bookingCounter = new AtomicInteger(0);

    private BookingManager() {
        bookings = new HashMap<>();
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            synchronized (instance.lock){
                if (instance == null) {
                    instance = new BookingManager();
                }
            }
        }
        return instance;
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price){
        String bookingNumber = generateBookingNumber();
        Booking booking = new Booking(bookingNumber, flight, passenger, seat,price);
        synchronized (lock) {
            bookings.put(bookingNumber, booking);
        }
        return booking;
    }

    public void cancelBooking(String bookingNumber){
        synchronized (lock) {
            Booking booking = bookings.get(bookingNumber);
            if (booking != null) {
                booking.cancel();
            }
        }
    }

    private String generateBookingNumber() {
        int bookingId = bookingCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        return "BKG"+timestamp+"_"+String.format("%10d",bookingId);
    }
}
