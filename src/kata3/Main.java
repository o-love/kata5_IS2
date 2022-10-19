package kata3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Histogram<String> histogram = new Histogram<>();

            histogram.increment("ulpgc.es");
            histogram.increment("ulpgc.es");
            histogram.increment("ulpgc.es");
            histogram.increment("dis.ulpgc.es");
            histogram.increment("ulpgc.es");
            histogram.increment("dis.ulpgc.es");
            histogram.increment("gmail.com");
            histogram.increment("hotmail.es");
            histogram.increment("hotmail.es");

            HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM", histogram);
            histogramDisplay.execute();
        });
    }
}
