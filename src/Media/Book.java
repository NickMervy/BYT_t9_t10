package Media;

import java.time.LocalDate;

public class Book extends Media {

    private String Author;
    private String publisher;

    public Book(String title, LocalDate releaseDate, String genre, String author, String publisher) {
        super(title, releaseDate, genre);
        setAuthor(author);
        setPublisher(publisher);
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author is empty");
        }

        this.Author = author;
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