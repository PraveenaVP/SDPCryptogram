package edu.gatech.seclass.utilities;

/**
 * Created by praveena on 7/12/17.
 */

public class Ratings {

    private String username;
    private String solved;
    private String incorrect;
    private  String started;


    public Ratings(String username, String solved, String incorrect, String started) {
        this.username = username;
        this.solved = solved;
        this.incorrect = incorrect;
        this.started = started;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSolved() {
        return solved;
    }

    public void setSolved(String solved) {

        this.solved = solved;
    }

    public String getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(String incorrect) {

        this.incorrect = incorrect;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {

        this.started = started;
    }
}
