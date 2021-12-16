package Media.Status;

import java.util.Date;
import Accounts.Account;
import Media.Media;
import Media.Score;

public class SuggestedMedia extends MediaStatus {

    private final Date dateSuggested;
    private final Account suggestingAccount;
    
    public SuggestedMedia(Media media, Account suggestingAccount) {
        super(media);
        this.dateSuggested = new Date();
        this.suggestingAccount = suggestingAccount;
    }

    public Date getDateSuggested() {
        return dateSuggested;
    }

    public Account getSuggestingAccount() {
        return suggestingAccount;
    }

    public void AcceptMedia() {
        media.confirmMedia();
    }

    @Override
    public long AggregateScores() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void ScoreMedia(Score score) {
        throw new UnsupportedOperationException();
    }
}