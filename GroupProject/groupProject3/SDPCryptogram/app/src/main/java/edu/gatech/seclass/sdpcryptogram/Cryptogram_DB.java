package edu.gatech.seclass.sdpcryptogram;

/**
 * Created by praveena on 7/4/17.
 */

public class Cryptogram_DB {

    //Private variables
    String _cryptogram;
    int _cryptogramID;

    //Empty Contructor
    public Cryptogram_DB(){};

    //Parameter Constructor
    public Cryptogram_DB(String cryptogram, int cryptogramID)
    {
        this._cryptogram = cryptogram;
        this._cryptogramID = cryptogramID;
    }

    public String get_cryptogram()
    {
        return _cryptogram;
    }

    public int get_cryptogramID()
    {
        return _cryptogramID;
    }

    public void set_cryptogram(String cryptogram)
    {
        this._cryptogram = cryptogram;
    }
    public  void set_cryptogramID(int cryptogramID)
    {
        this._cryptogramID = cryptogramID;
    }

}
