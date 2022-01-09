package Media;
import java.time.LocalDate;
import Accounts.Account;

public class Score {

    private int points;
    private final LocalDate date;
    private String review;
    private final Account account;
    private final ConfirmedMedia media;

    public Score(int points, Account account, ConfirmedMedia media) {
        if(account == null || media == null) {
            throw new IllegalArgumentException();
        }
        
        this.points = points;
        this.date = LocalDate.now();
        this.account = account;
        this.media = media;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getReview() {
        return review;
    }

    public void postReview(String review) {
        if(review == null || review.trim().isEmpty()) {
            throw new IllegalArgumentException("Review is empty");
        }

        this.review = review;
    }

    public Account getAccount() {
        return account;
    }

    public Media getMedia() {
        return media;
    }  

    public void LinkExternalReview(String link) {
    }
}