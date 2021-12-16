package Accounts;

import java.util.ArrayList;
import Media.Media;

public class Admin extends Account {

    private final int adminId;
    private final ArrayList<Media> confirmedMedia = new ArrayList<>();
    
    public Admin(String email, String password, int adminId) {
        super(email, password);
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public ArrayList<Media> getConfirmedMedia() {
        return confirmedMedia;
    }
}