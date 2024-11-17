package software.ulpgc.clean.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Barchart {
    private final String title;
    private final Map<String, Integer> count;

    public Barchart(String title) {
        this.title = title;
        this.count = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Integer> getCount() {
        return count;
    }

    public Set<String> categories() {
        return count.keySet();
    }

    public int get(String category) {
        return count.getOrDefault(category, 0);
    }

    public void add(String key, Integer integer) {
        count.put(key, integer);
    }
}
