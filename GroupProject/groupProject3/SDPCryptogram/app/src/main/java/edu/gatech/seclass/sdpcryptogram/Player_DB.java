package edu.gatech.seclass.sdpcryptogram;

/**
 * Created by praveena on 7/4/17.
 */

public class Player_DB {

    //Private
    String _firstname ;
    String _lastname;
    String _username;


    //public empty constructor
    public Player_DB(){}

    //all parameter constructr
    public Player_DB(String firstname,String lastname, String username)
    {
        this._firstname = firstname;
        this._lastname = lastname;
        this._username = username;
    }

    public String get_firstname()
    {
        return _firstname;
    }
    public String get_lastname()
    {
        return _lastname;
    }
    public String get_username()
    {
        return _username;
    }


    public void set_firstname(String firstname)
    {
        this._firstname = firstname;

    }

    public void set_lastname(String lastname)
    {
        this._lastname = lastname;
    }

    public void set_username(String username)
    {
        this._username = username;
    }
}
