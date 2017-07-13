package edu.gatech.seclass.utilities;

/**
 * Created by praveena on 7/12/17.
 */

public class CryptogramsUtil {
    private String id;
    private String cryptogram;
    private String solution;
    private String status;
    private String incorrectcount;
    private String userText;

    //used for display the list of cryptograms
    public CryptogramsUtil(String id, String cryptogram, String status, String incorrectcount) {
        this.id = id;
        this.cryptogram = cryptogram;
        this.status = status;
        this.incorrectcount = incorrectcount;
    }

    public CryptogramsUtil(String id, String cryptogram, String solution, String status, String userText) {
        this.id = id;
        this.cryptogram = cryptogram;
        this.solution = solution;
        this.status = status;
        this.userText = userText;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCryptogram() {
        return cryptogram;
    }

    public void setCryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIncorrectcount() {
        return incorrectcount;
    }

    public void setIncorrectcount(String incorrectcount) {
        this.incorrectcount = incorrectcount;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }
}
