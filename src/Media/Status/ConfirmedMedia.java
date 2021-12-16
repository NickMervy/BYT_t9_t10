package Media.Status;

import java.util.ArrayList;
import java.util.Date;

import Media.Media;
import Media.Score;

public class ConfirmedMedia extends MediaStatus {

    private final Date confirmDate;
    private final ArrayList<Score> scores = new ArrayList<>();

    public ConfirmedMedia(Media media) {
        super(media);
        this.confirmDate = new Date();
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    @Override
    public long AggregateScores() {
        return scores.stream()
                    .mapToLong(s -> s.getPoints())
                    .sum();
    }

    @Override
    public void ScoreMedia(Score score) {
        if(score == null) {
            throw new IllegalArgumentException();
        }
        
        scores.add(score);
    }
}