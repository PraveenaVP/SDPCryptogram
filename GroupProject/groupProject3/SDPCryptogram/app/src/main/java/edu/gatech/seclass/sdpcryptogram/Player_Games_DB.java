package edu.gatech.seclass.sdpcryptogram;

import android.os.Build;

/**
 * Created by praveena on 7/4/17.
 */

public class Player_Games_DB {

    //private variables
    String _username;
    String _userText;
    int _cryptogramID;
    int _correct;
    int _started;
    int _incorrect;
    char _status;

    //Empty constructor
    public Player_Games_DB(){};

    //Three parameter constructor for display of view prior games
    public Player_Games_DB(String username,String userText,int cryptogramID, char status)
    {
        this._username = username;
        this._userText = userText;
        this._cryptogramID = cryptogramID;
        this._status = status;
    }

    // Four paramter constructor for display of ratings
    public Player_Games_DB(String username, int correct, int started, int incorrect)
    {
        this._username = username;
        this._correct = correct;
        this._started = started;
        this._incorrect = incorrect;
    }

    public String get_username()
    {
        return this._username;
    }
    public  String get_userText()
    {
        return this._userText;
    }
    public  int get_cryptogramID()
    {
        return this._cryptogramID;
    }
    public int get_correct()
    {
        return this._correct;
    }
    public int get_started()
    {
        return this._started;
    }
    public int get_incorrect()
    {
        return this._incorrect;
    }
    public char get_status()
    {
        return this._status;
    }


    public void set_username(String username)
    {
        this._username = username;
    }
    public void set_userText(String userText)
    {
        this._userText = userText;
    }
    public void set_cryptogramID(int cryptogramID)
    {
        this._cryptogramID = cryptogramID;
    }
    public void set_correct(int correct)
    {
        this._correct = correct;
    }
    public void set_started(int started)
    {
        this._started = started;
    }
    public void set_incorrect(int incorrect)
    {
        this._incorrect = incorrect;
    }
    public void set_status(char status)
    {
        this._status = status;
    }





}
