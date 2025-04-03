package airline;
import airline.booking.Booking;
import airline.flight.Flight;
import airline.payment.Payment;
import airline.seat.Seat;
import airline.seat.SeatType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
public class AirlineManagementSystemDemo {
    public static void run() {
        AirlineManagementSystem airlineManagementSystem = new AirlineManagementSystem();
        Passenger passenger1 = new Passenger("ABC","John Doe","john@email.com","1231231234");

        LocalDateTime departureTime1 = LocalDateTime.now().plusDays(1);
        LocalDateTime arrivalTime1 = departureTime1.plusHours(2);

        Flight flight1 = new Flight("F001", "New York", "London", departureTime1, arrivalTime1);

        LocalDateTime departureTime2 = LocalDateTime.now().plusDays(3);
        LocalDateTime arrivalTime2 = departureTime2.plusHours(5);

        Flight flight2 = new Flight("F002", "Paris", "Tokyo", departureTime2, arrivalTime2);

        airlineManagementSystem.addFlight(flight1);
        airlineManagementSystem.addFlight(flight2);

        Aircraft aircraft1 = new Aircraft("t001","Boeing 747",300);
        Aircraft aircraft2 = new Aircraft("t002","AirBus A380",500);

        airlineManagementSystem.addAircraft(aircraft1);
        airlineManagementSystem.addAircraft(aircraft2);

        Seat seat = new Seat("23B", SeatType.BUSINESS);
        Booking booking = airlineManagementSystem.bookFlight(flight1,passenger1,seat,1000);
        if(booking != null) {
            System.out.println("Booking Successful: "+ booking.getBookingNumber());
        }
        else{
            System.out.println("Booking Failed");
        }
        Booking booking2 = airlineManagementSystem.bookFlight(flight2,passenger1,seat,1000);
        if(booking2 != null) {
            System.out.println("Booking Successful: "+ booking2.getBookingNumber());
        }
        else{
            System.out.println("Booking Failed");
        }



        airlineManagementSystem.cancelBooing(booking2.getBookingNumber());
        System.out.println("Booking Canceled.");

    }

}
