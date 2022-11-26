package kata5.view;

import kata5.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class HistogramDisplay<T extends Comparable<T>> extends ApplicationFrame {

    private final Histogram<T> histogram;

    public HistogramDisplay(String title, Histogram<T> histogram) {
        super(title);

        this.histogram = histogram;

        this.setContentPane(createJPanel());

        this.pack();
    }

    public void execute() {
        setVisible(true);
    }

    public JPanel createJPanel() {
        JPanel jPanel = new ChartPanel(createChart(createDataSet()));

        jPanel.setPreferredSize(new Dimension(500, 400));

        return jPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset defaultCategoryDataset) {
        return ChartFactory.createBarChart(
                getTitle(),
                "Eje " + getTitle(),
                "Nº de Vuelos",
                defaultCategoryDataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (T key: histogram.keySet()) {
            dataset.addValue(
                    histogram.get(key),
                    "",
                    key
            );
        }

        return dataset;
    }
}
