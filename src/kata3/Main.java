package kata3;

import kata3.files.EmailLoader;
import kata3.files.FileLoader;

import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Iterable<String> entry = new EmailLoader(new FileLoader(new File("emails.txt"))).items();
        entry.forEach(System.out::println);

        Histogram<String> histogram = new Histogram<>();

        for (String email : entry) {
            histogram.increment(email);
        }

        SwingUtilities.invokeLater(() -> {
            HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM", histogram);
            histogramDisplay.execute();
        });
    }
}
