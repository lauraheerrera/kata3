package software.ulpgc.dirty;

import software.ulpgc.clean.control.Command;
import software.ulpgc.clean.control.ToggleCommand;
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

        add(createBarcharDisplay());
        add(createMenu(), BorderLayout.NORTH);
    }

    private JPanel createMenu() {
        JPanel panel = new JPanel(new FlowLayout());
        Button toggle = new Button("Toggle");

        toggle.addActionListener(e -> {
            if (commandMap.containsKey("Toggle")){
                commandMap.get("Toggle").execute();
            }
        });

        panel.add(toggle);
        return panel;
    }

    private JPanel createBarcharDisplay() {
        JFreeBarchartDisplay display = new JFreeBarchartDisplay();
        barchartDisplay = display;
        return display;
    }

    public void put(String toggle, ToggleCommand toggleCommand) {
        commandMap.put(toggle, toggleCommand);
    }

    public BarchartDisplay barchartDisplay() {
        return barchartDisplay;
    }
}
