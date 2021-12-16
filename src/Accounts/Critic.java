package Accounts;

public class Critic extends Account {

    private String credentials;

    public Critic(String email, String password, String credentials) {
        super(email, password);
        setCredentials(credentials);
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        if(credentials == null || credentials.trim().isEmpty()) {
            throw new IllegalArgumentException("Credentials are empty");
        }

        this.credentials = credentials;
    }

    public void confirmCritic() {       
    }
}