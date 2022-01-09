package Media;

import java.util.ArrayList;
import java.util.Date;

public class ConfirmedMedia {

    private final Date confirmDate;
    private final Media media;
    private final ArrayList<Score> scores = new ArrayList<>();

    public ConfirmedMedia(Media media) {
        this.media = media;
        this.confirmDate = new Date();
    }

    public Media getMedia() {
        return media;
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