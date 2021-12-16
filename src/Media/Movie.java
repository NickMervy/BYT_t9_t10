package Media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Movie extends Media {
    
    private final ArrayList<String> directors = new ArrayList<>();
    private final ArrayList<String> actors = new ArrayList<>();
    
    public Movie(String title, LocalDate releaseDate, String genre, ArrayList<String> directors, String... actors) {
        super(title, releaseDate, genre);
        this.directors.addAll(directors);
        this.actors.addAll(Arrays.asList(actors));
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getDirectors() {
        return directors;
    }
}