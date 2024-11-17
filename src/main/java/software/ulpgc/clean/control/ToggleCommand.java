package software.ulpgc.clean.control;

import software.ulpgc.clean.model.Barchart;
import software.ulpgc.clean.model.Title;
import software.ulpgc.clean.model.TitleLoader;
import software.ulpgc.clean.view.BarchartDisplay;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ToggleCommand implements Command{
    private final BarchartDisplay barchartDisplay;
    private final TitleLoader titleLoader;

    public ToggleCommand(BarchartDisplay barchartDisplay, TitleLoader titleLoader) {
        this.barchartDisplay = barchartDisplay;
        this.titleLoader = titleLoader;
    }

    private int i = 0;

    @Override
    public void execute() {
        Barchart nextBarchart;
        try {
            nextBarchart = getBarchart(i++);
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
        barchartDisplay.display(nextBarchart);
    }

    private Barchart getBarchart(int i) throws IOException {
        List<Title> titles = titleLoader.load();
        return i % 2 == 0 ?
                genreBarchart(titles) :
                adultContentBarchart(titles);
    }

    private Barchart adultContentBarchart(List<Title> titles) {
        Barchart barchart = new Barchart("Adults content");
        HashMap<String, Integer> contentCount = new HashMap<>();

        for (Title title : titles) {
            String key = title.isAdult() ? "Adult" : "Non adult";
            contentCount.put(key, contentCount.getOrDefault(key, 0) + 1);
        }

        for (String s : contentCount.keySet()) {
            barchart.add(s, contentCount.get(s));
        }
        return barchart;
    }

    private Barchart genreBarchart(List<Title> titles) {
        Barchart barchart = new Barchart("Genre");
        HashMap<String, Integer> genreCount = new HashMap<>();
        for (Title title : titles) {
            for (String genre : title.getGenre()) {
                genreCount.put(genre, genreCount.getOrDefault(genre, 0)+1);
            }
        }
        for (String key : genreCount.keySet()) {
            barchart.add(key, genreCount.get(key));
        }
        return barchart;
    }
}
