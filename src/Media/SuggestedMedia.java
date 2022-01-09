package Media;

import java.time.LocalDate;
import java.util.Date;
import Accounts.Account;

public class SuggestedMedia extends Media {
    
    private final Date dateSuggested;
    private final Account suggestingAccount;
    
    public SuggestedMedia(String title, LocalDate releaseDate, String genre, Account suggestingAccount) {
        super(title, releaseDate, genre);

        this.dateSuggested = new Date();
        this.suggestingAccount = suggestingAccount;
    }

    public Date getDateSuggested() {
        return dateSuggested;
    }

    public Account getSuggestingAccount() {
        return suggestingAccount;
    }
}