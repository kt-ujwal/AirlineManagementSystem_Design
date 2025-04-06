package airline;

import airline.booking.Booking;
import airline.booking.BookingManager;
import airline.booking.IBookingManager;
import airline.flight.Flight;
import airline.flight.FlightSearch;
import airline.flight.Search;
import airline.payment.CreditCardPayment;
import airline.payment.Payment;
import airline.payment.PaymentProcessor;
import airline.payment.PaymentStrategy;
import airline.seat.Seat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AirlineManagementSystem {
    private final List<Flight> flights;
    private final List<Aircraft> aircrafts;
    private final Search search;
    private final IBookingManager bookingManager;
    private final PaymentProcessor paymentProcessor;
    private final PaymentStrategy paymentStrategy;

    public AirlineManagementSystem(Search search) {
        flights = new ArrayList<>();
        aircrafts = new ArrayList<>();
        this.search = search;
        this.paymentStrategy = new CreditCardPayment();
        this.bookingManager = BookingManager.getInstance();
        this.paymentProcessor = PaymentProcessor.getInstance(paymentStrategy);
    }

    public AirlineManagementSystem() {
        flights = new ArrayList<>();
        aircrafts = new ArrayList<>();
        this.search = new FlightSearch(flights);
        this.bookingManager = BookingManager.getInstance();
        this.paymentStrategy = new CreditCardPayment();
        this.paymentProcessor = PaymentProcessor.getInstance(paymentStrategy);
    }

    public AirlineManagementSystem(Search search, PaymentStrategy paymentStrategy) {
        flights = new ArrayList<>();
        aircrafts = new ArrayList<>();
        this.search = search;
        this.paymentStrategy = paymentStrategy;
        this.bookingManager = BookingManager.getInstance();
        this.paymentProcessor = PaymentProcessor.getInstance(paymentStrategy);
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }
    public List<Flight> searchFlights(String source,String destination,LocalDate date) {
        return search.searchFlights(source,destination,date);
    }

    public Booking bookFlight(Flight flight, Passenger passenger,Seat seat,double price) {
        return bookingManager.createBooking(flight,passenger,seat,price);
    }

    public void cancelBooing(String bookingNumber){
        bookingManager.cancelBooking(bookingNumber);
    }

    public void processPayment(Payment payment) {
        paymentProcessor.processPayment(payment);
    }

}
