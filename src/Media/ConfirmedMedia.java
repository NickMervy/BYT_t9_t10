package Media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ConfirmedMedia extends Media {

    private final Date confirmDate;
    private final ArrayList<Score> scores = new ArrayList<>();

    public ConfirmedMedia(String title, LocalDate releaseDate, String genre) {
        super(title, releaseDate, genre);
        this.confirmDate = new Date();
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public long aggregateScores() {
        return scores.stream()
                    .mapToLong(s -> s.getPoints())
                    .sum();
    }

    public void scoreMedia(Score score) {
        if(score == null) {
            throw new IllegalArgumentException();
        }
        
        scores.add(score);
    }
}