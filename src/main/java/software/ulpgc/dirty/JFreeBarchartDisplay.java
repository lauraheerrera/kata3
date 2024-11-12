package software.ulpgc.dirty;

import org.jfree.chart.ChartPanel;
import software.ulpgc.clean.model.Barchart;
import software.ulpgc.clean.view.BarchartDisplay;

import javax.swing.*;

public class JFreeBarchartDisplay extends JPanel implements BarchartDisplay {
    @Override
    public void display(Barchart barchart) {
        removeAll();
        add(new ChartPanel(JFreeBarchartAdapter.adapt(barchart)));
        revalidate();
    }
}
