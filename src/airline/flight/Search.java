package airline.flight;

import java.time.LocalDate;
import java.util.List;

public interface Search {
    List<Flight> searchFlights(String source, String destination, LocalDate date);
}
