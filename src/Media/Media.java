package Media;

import java.time.LocalDate;
import java.util.ArrayList;

import Accounts.Account;
import Media.Status.ConfirmedMedia;
import Media.Status.MediaStatus;
import Media.Status.SuggestedMedia;

public abstract class Media {
    private static final ArrayList<Media> allMedia = new ArrayList<>();

    protected String title;
    protected LocalDate releaseDate;
    protected String genre;
    protected MediaStatus status;
    
    public Media(String title, LocalDate releaseDate, String genre) {
        setTitle(title);
        setReleaseDate(releaseDate);
        setGenre(genre);
        allMedia.add(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title is empty");
        }

        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        if(releaseDate == null) {
            throw new IllegalArgumentException("ReleaseDate is null");
        }

        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre is empty");
        }

        this.genre = genre;
    }

    public MediaStatus getStatus() {
        return status;
    }

    public void suggestMedia(Account suggester) {
        if(suggester == null) {
            throw new IllegalArgumentException("Suggester is null");
        }

        this.status = new SuggestedMedia(this, suggester);
    }

    public void confirmMedia() {
        this.status = new ConfirmedMedia(this);
    }

    public void delete() {
        allMedia.remove(this);
    }

    public static ArrayList<Media> getAllMedia() {
        return allMedia;
    }
}