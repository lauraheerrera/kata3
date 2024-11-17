package software.ulpgc.dirty;

import software.ulpgc.clean.control.ToggleCommand;
import software.ulpgc.clean.model.FileTitleLoader;
import software.ulpgc.clean.model.TsvTitleDeserializer;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        File file = new File("C:\\Users\\Usuario\\Downloads\\title.basics.tsv");
        FileTitleLoader loader = new FileTitleLoader(file, new TsvTitleDeserializer());
        mainFrame.put("Toggle", new ToggleCommand(mainFrame.barchartDisplay(), loader));
        mainFrame.setVisible(true);
    }
}
