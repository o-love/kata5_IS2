package kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class HistogramDisplay extends ApplicationFrame {

    public HistogramDisplay(String title) {
        super(title);


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
                "Histograma JFreeChart",
                "Dominios email",
                "Nº de emails",
                defaultCategoryDataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(4, "", "ulpgc.es");
        dataset.addValue(2, "", "dis.ulpgc.es");
        dataset.addValue(4, "", "eii.ulpgc.es");
        dataset.addValue(9, "", "gmail.com");
        dataset.addValue(6, "", "yahoo.es");
        dataset.addValue(5, "", "hotmail.es");


        return dataset;
    }
}
