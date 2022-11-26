package kata5.model;

import java.util.Objects;
import java.util.function.ToIntFunction;
import java.util.stream.StreamSupport;

public class FlightHistogramFactory {

    public static Histogram<Integer> createFromArrivalDelay(Iterable<Flight> flights) {
        return create(flights, flight -> {
            if (flight.arrivalDelay() < 0) {
                return 0;
            }
            if (flight.arrivalDelay() > 100) {
                return 100;
            }

            return flight.arrivalDelay() / 10 * 10;
        });
    }

    private static Histogram<Integer> create(Iterable<Flight> flights, ToIntFunction<Flight> intMapper) {
        Objects.requireNonNull(flights);
        Objects.requireNonNull(intMapper);

        Histogram<Integer> histogram = new Histogram<>();
        StreamSupport.stream(flights.spliterator(), false)
                .mapToInt(intMapper)
                .forEach(histogram::increment);
        return histogram;
    }
}
