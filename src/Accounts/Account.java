package Accounts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Media.Media;
import Media.Score;
import Media.SuggestedMedia;

public abstract class Account {
    private static int accountIdCounter = 0;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.()])(?=\\S+$).{8,}$"; 
    private static final Pattern PATTERN = Pattern.compile(PASSWORD_PATTERN);

    protected final int accountId;
    protected final LocalDate dateCreated;
    protected final ArrayList<SuggestedMedia> suggestedMedia = new ArrayList<SuggestedMedia>();
    protected final ArrayList<Score> scores = new ArrayList<Score>();
    protected String email;
    protected String password;

    public Account(String email, String password) {
        this.accountId = accountIdCounter++;
        this.dateCreated = LocalDate.now();
        setEmail(email);
        setPassword(password);
    }

    public int getAccountId() {
        return accountId;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is empty");
        }

        this.email = email;
    }
  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is empty");
        }

        if(!isValid(password)) {
            return;
        }

        this.password = password;
    }

    public void score(Media media, byte points) {
    }

    public boolean checkEmailVerification() {
        return true;
    }

    public boolean login(String email, String password) {
        return true;
    }

    private static boolean isValid(final String password) {
        Matcher matcher = PATTERN.matcher(password);
        return matcher.matches();
    }
}