package edu.gatech.seclass.sdpcryptogram;

/**
 * Created by WangZiyan on 7/12/17.
 */

class CurrentUserInfo {
    private static final CurrentUserInfo ourInstance = new CurrentUserInfo();

    private String currentUser;

    static CurrentUserInfo getInstance() {
        return ourInstance;
    }

    private CurrentUserInfo() {    }

    public void setCurrentUser(String username) {
        currentUser = username;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
