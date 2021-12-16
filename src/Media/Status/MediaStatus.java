package Media.Status;

import Media.Media;
import Media.Score;

public abstract class MediaStatus {
    
    protected final Media media;
    
    public MediaStatus(Media media) {
        this.media = media;
    }

    public abstract long AggregateScores();
    public abstract void ScoreMedia(Score score);
}