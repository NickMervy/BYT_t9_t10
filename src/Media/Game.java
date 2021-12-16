package Media;

import java.time.LocalDate;

public class Game extends Media {

    private String developer;
    private String publisher;

    public Game(String title, LocalDate releaseDate, String genre, String developer, String publisher) {
        super(title, releaseDate, genre);
        setDeveloper(developer);
        setPublisher(publisher);
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        if(developer == null || developer.isEmpty()) {
            throw new IllegalArgumentException("Developer is empty");
        }

        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if(publisher == null || publisher.isEmpty()) {
            throw new IllegalArgumentException("Publisher is empty");
        }

        this.publisher = publisher;
    }
}