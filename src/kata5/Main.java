package kata5;

import kata5.model.Flight;
import kata5.model.FlightHistogramFactory;
import kata5.model.Histogram;
import kata5.model.persistence.files.SQLiteFlightLoader;
import kata5.view.HistogramDisplay;

import javax.swing.*;
import java.sql.*;


public class Main {
    public static void main(String[] args) {
        new Main().executeAll();
    }

    private static ResultSet flightsResultSetFactory() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:flights.db")
                    .createStatement()
                    .executeQuery("SELECT * FROM flights");
        } catch (SQLException e) {
            throw new RuntimeException("Unable to execute query.", e);
        }
    }

    private Iterable<Flight> flights;
    private Histogram<Integer> histogram;

    public void executeAll(){
        this.getInput();

        this.processInput();

        this.produceOutput();
    }

    public void getInput() {
        flights = new SQLiteFlightLoader(Main::flightsResultSetFactory).items();
    }

    public void processInput() {
        histogram = FlightHistogramFactory.createFromArrivalDelay(flights);
    }

    public void produceOutput() {
        histogram.keySet().forEach(System.out::println);

        SwingUtilities.invokeLater(() -> {
            HistogramDisplay<Integer> histogramDisplay = new HistogramDisplay<>("Retraso de vuelo", histogram);
            histogramDisplay.execute();
        });
    }
}
