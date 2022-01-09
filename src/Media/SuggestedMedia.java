package Media;

import java.util.Date;
import Accounts.Account;

public class SuggestedMedia {
    
    private final Date dateSuggested;
    private final Media suggestedMedia;
    private final Account suggestingAccount;
    
    public SuggestedMedia(Media media, Account suggestingAccount) {
        this.dateSuggested = new Date();
        this.suggestedMedia = media;
        this.suggestingAccount = suggestingAccount;
    }

    public Media getSuggestedMedia() {
        return suggestedMedia;
    }

    public Date getDateSuggested() {
        return dateSuggested;
    }

    public Account getSuggestingAccount() {
        return suggestingAccount;
    }
}