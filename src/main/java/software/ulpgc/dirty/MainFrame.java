package software.ulpgc.dirty;

import software.ulpgc.clean.control.Command;
import software.ulpgc.clean.view.BarchartDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commandMap = new HashMap<>();
    private BarchartDisplay barchartDisplay;
    public MainFrame(){
        setTitle("Stats");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createChartDisplay());
        add(createMenu(), BorderLayout.NORTH);
    }

    private JPanel createMenu() {
        JPanel jPanel = new JPanel(new FlowLayout());
        JButton toggle = new JButton("Toggle");

        toggle.addActionListener(e -> {
            if(commandMap.containsKey("Toggle")){
                commandMap.get("Toggle").execute();
            }
        });

        jPanel.add(toggle);
        return jPanel;
    }

    private JPanel createChartDisplay() {
        JFreeBarchartDisplay display = new JFreeBarchartDisplay();
        barchartDisplay = display;
        return display;
    }

    public BarchartDisplay barchartDisplay() {
        return barchartDisplay;
    }

    public void put(String toggle, Command toggleCommand) {
        commandMap.put(toggle, toggleCommand);
    }
}
