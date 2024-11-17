package software.ulpgc.clean.model;

import java.util.List;

public class Title {
    private final String title;
    private final List<String> genre;
    private final boolean isAdult;
    public Title(String title, List<String> genre, boolean isAdult) {
        this.title = title;
        this.genre = genre;
        this.isAdult = isAdult;
    }

    public boolean isAdult() {
        return isAdult;
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", isAdult=" + isAdult +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenre() {
        return genre;
    }

}
