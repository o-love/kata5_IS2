package kata3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM");
            histogramDisplay.execute();
        });
    }
}
