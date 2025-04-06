package airline.booking;

import airline.Passenger;
import airline.flight.Flight;
import airline.seat.Seat;

public interface IBookingManager {
    Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price);
    void cancelBooking(String bookingNumber);
}
