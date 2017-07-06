package edu.gatech.seclass.sdpcryptogram;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


/**
 * Created by praveena on 7/3/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */


    //Creating Database variables

    //Database Version Number
    public static final int DATABASE_VERSION = 1;

    //Database Name
    public static final String DATABASE_NAME = "SDPCryptogram.db";

    //Database Table Adminstrator
    public static final String TABLE_ADMINISTRATORS =  "Admin";

    //Table Adminstrator Columns
    //public static final String ADMIN_ID = "id";
    public static final String ADMIN_USERNAME = "username";


    //Database Table Players
    public static final String TABLE_PLAYERS = "Player";

    //Table Players Columns
    //public static final String PLAYER_ID = "id";
    public static final String PLAYER_FIRSTNAME = "first_name";
    public static final String PLAYER_LASTNAME = "last_name";
    public static final String PLAYER_USERNAME = "username";



    //Database Table Cryptograms
    public static final String TABLE_CRYPTOGRAMS  = "Cryptograms";

    //Table Cryptograms Columns
    public static final String CRYPTOGRAM_ID = "cryptogram_id";
    public static final String CRYPTOGRAM = "cryptogram";
    public static final String SOLUTION = "solution";

    //Database Table Player_Games
    public static final String TABLE_PLAYER_GAMES = "Player_Games";

    //Table Player_Games Columns
    public static final String PLAYER_GAMES_PLAYER_USERNAME = "username";
    public static final String PLAYER_GAMES_CRYPTOGRAM_ID = "cryptogram_id";
    public static final String PLAYER_GAMES_TEXT = "userText";
    public static final String PLAYER_GAMES_STATUS = "status";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
           }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {


//        //Creating Adminstrators Table
        String CREATE_ADMINSTRATORS_TABLE = "CREATE TABLE "+TABLE_ADMINISTRATORS + " ( "
               // + ADMIN_ID + "INTEGER PRIMARY KEY,"
                + ADMIN_USERNAME + " TEXT UNIQUE "  + ")" ;

        try {
            db.execSQL(CREATE_ADMINSTRATORS_TABLE);
        }catch (Exception e)
        {
            System.out.println("Unable to create Adminstrator table");
        }

        //Creating Players Table
        String CREATE_PLAYERS_TABLE = "CREATE TABLE "+TABLE_PLAYERS + " ( "
               // + PLAYER_ID + "INTEGER PRIMARY KEY,"
                + PLAYER_FIRSTNAME + " TEXT, "
                + PLAYER_LASTNAME + " TEXT, "
                + PLAYER_USERNAME + " TEXT UNIQUE "
                + " ) " ;

        try {
            db.execSQL(CREATE_PLAYERS_TABLE);
        }catch (Exception e)
        {
            System.out.println("Unable to create Players table");
        }




        //Creating Cryptograms Table
        String CREATE_CRYPTOGRAMS_TABLE = "CREATE TABLE "+TABLE_CRYPTOGRAMS + " ( "
                + CRYPTOGRAM_ID + " INTEGER PRIMARY KEY, "
                + CRYPTOGRAM + " TEXT, "
                + SOLUTION + " TEXT "
                + " ) " ;

        try {
            db.execSQL(CREATE_CRYPTOGRAMS_TABLE);
        }catch (Exception e)
        {
            System.out.println("Unable to create Cryptograms table");
        }

        //Creating Player_Games Table.
        String CREATE_PLAYER_GAMES_TABLE = "CREATE TABLE "+TABLE_PLAYER_GAMES + "("
                + PLAYER_GAMES_PLAYER_USERNAME + " TEXT, "
                + PLAYER_GAMES_CRYPTOGRAM_ID + " INTEGER, "
                + PLAYER_GAMES_TEXT + " TEXT, "
                + PLAYER_GAMES_STATUS + " TEXT, "
               // + "PRIMARY KEY ("+PLAYER_GAMES_PLAYER_USERNAME + "," +PLAYER_GAMES_CRYPTOGRAM_ID+")"
                + ")" ;


        try {
            db.execSQL(CREATE_PLAYER_GAMES_TABLE);
        }catch (Exception e)
        {
            System.out.println("Unable to create Player_Games table");
        }

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop all older version tables

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_ADMINISTRATORS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PLAYERS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PLAYERS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CRYPTOGRAMS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PLAYER_GAMES);

        //Create once again
        onCreate(db);
    }

    //CRUD Operations on the Tables

    //Insert Data
    //Insert Admin
    public void insertAdmin(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //Adding Admin defaultvalue
        contentValues.put(ADMIN_USERNAME,username);

        long result = db.insert(TABLE_ADMINISTRATORS,null,contentValues);

        if(result == -1){
                //Exception
            }


    }

    //Insert into Players Table

    public boolean insertDataPlayer(String firstname, String lastname, String username)
    {
        boolean status = false;
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //Adding the values
        contentValues.put(PLAYER_FIRSTNAME,firstname);
        contentValues.put(PLAYER_LASTNAME,lastname);
        contentValues.put(PLAYER_USERNAME,username);

        long result = db.insert(TABLE_PLAYERS,null,contentValues);

        //if insert is successful it returns rowid else -1
        if(result != -1)
        {
            status = true;
        }

        return  status;
    }


    // Insert into Cryptograms Tables
    public boolean insertDataCryptograms(String cryptogram, String solution)
    {
        boolean status = false;
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //Adding the values
        contentValues.put(CRYPTOGRAM,cryptogram);
        contentValues.put(SOLUTION,solution);

        long result = db.insert(TABLE_CRYPTOGRAMS,null,contentValues);

        //if insert is successful it returns rowid else -1
        if(result != -1)
        {
            status = true;
        }

        return  status;
    }




    // Insert/Update into Player_Games Tables
    public boolean insertupdateDataPlayer_Games(String player_username, int cryptogramID, String userText, String gamestatus)
    {
        boolean status = false;
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //Adding the values
        contentValues.put(PLAYER_GAMES_PLAYER_USERNAME,player_username);
        contentValues.put(PLAYER_GAMES_CRYPTOGRAM_ID,cryptogramID);
        contentValues.put(PLAYER_GAMES_TEXT,userText);
        contentValues.put(PLAYER_GAMES_STATUS,gamestatus);

        long result = db.insert(TABLE_PLAYER_GAMES,null,contentValues);

        //if insert is successful it returns rowid else -1
        if(result != -1)
        {
            status = true;
        }
        else
        {
//            ContentValues updatecontentValues = new ContentValues();
//
//            //Adding the values
//
//            updatecontentValues.put(PLAYER_GAMES_TEXT,userText);
//            updatecontentValues.put(PLAYER_GAMES_STATUS,gamestatus);
//            String where = PLAYER_GAMES_PLAYER_USERNAME+" = "+player_username + " AND " + PLAYER_GAMES_CRYPTOGRAM_ID + " = " +PLAYER_GAMES_CRYPTOGRAM_ID;
//            result = db.update(TABLE_PLAYER_GAMES,updatecontentValues,where,null);
//
//            if(result != -1){
//                status = true;
//            }
        }

        return  status;
    }


    /**Display data of a player based on the player_username
    * @param player_username  = the username used to log into the application
     **/
    public Player_DB displayPlayerData(String player_username)
    {

        Player_DB current_player = new Player_DB();;
        String selectPlayerQuery = "SELECT firstname,lastname,username FROM "+TABLE_PLAYERS+
                                    "WHERE username = '"+player_username +"' ;";

        SQLiteDatabase db  = this.getWritableDatabase();

        Cursor player_cursor = db.rawQuery(selectPlayerQuery,null);

        if (player_cursor.getCount() == 0)
        {
            throw new NullPointerException("Player records are missing");

        }
        else
        {
            if(player_cursor.moveToFirst())
            {
             current_player.set_firstname(player_cursor.getString(0));
             current_player.set_lastname(player_cursor.getString(1));
             current_player.set_username(player_cursor.getString(2));

            }
        }

        return current_player;

    }


    /**
     * Retrieves the solution from Cryptogram Table using the cryptogram ID
     * to check for the solution
     * @param cryptogram_id: The id of the cryptogram
     */

    public String CryptogramSolution(int cryptogram_id)
    {
        String solution = "";
        String selectCryptogramQuery = " SELECT SOULTION FROM " + TABLE_CRYPTOGRAMS+
                                        "WHERE " + CRYPTOGRAM_ID + " = " +cryptogram_id;

        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cryptogram_cursor = db.rawQuery(selectCryptogramQuery,null);

        if(cryptogram_cursor.getCount() > 0)
        {
            solution  = cryptogram_cursor.getString(0);
        }
        else
        {
            //exception
        }
        return solution;
    }





    /** Retrieve cryptograms lesser than the cryptogramID provided
     * This is done to facilitate batch retrieval.
     * @param cryptogramID = The value of the last cryptogramID in the display list,
     *                      if there is no list(first time load) set it to zero.
     * @param   limit = Sets the retrieval batch size.
     **/
    public List<Cryptogram_DB> displayCryptograms( int cryptogramID, int limit)
    {
        List<Cryptogram_DB> cryptogram_list = new ArrayList<Cryptogram_DB>();

        String displyCryptogramQuery = "SELECT * FROM "+TABLE_CRYPTOGRAMS +
                                        " WHERE " + CRYPTOGRAM_ID + ">" +cryptogramID +
                                        " ORDER BY  " +CRYPTOGRAM_ID + "ASC " +
                                        " LIMIT " + limit +";" ;


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cryptogram_cursor = db.rawQuery(displyCryptogramQuery,null);

        if(cryptogram_cursor.moveToFirst())
        {
            do{
                Cryptogram_DB crypt = new Cryptogram_DB();
                crypt.set_cryptogramID(Integer.parseInt(cryptogram_cursor.getString(0)));
                crypt.set_cryptogram(cryptogram_cursor.getString(1));

                cryptogram_list.add(crypt);
            }while(cryptogram_cursor.moveToNext());
        }
        else
        {
            //Exception
        }

        return cryptogram_list;
    }


    /**
     * Retreive PriorGames of the user with their status
     * @param username =the username used to log into the application
     *
     *
     */
    public List<Player_Games_DB> displayPriorGames(String username)
    {
        List<Player_Games_DB> priorgames_list = new ArrayList<Player_Games_DB>();

        String displayPriorGamesQuery = " SELECT "+ PLAYER_GAMES_TEXT+","+PLAYER_GAMES_STATUS +","+PLAYER_GAMES_CRYPTOGRAM_ID+
                                        " FROM "  + TABLE_PLAYER_GAMES + " WHERE " + PLAYER_GAMES_PLAYER_USERNAME
                                        +" = '"  + username +",) ;";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor priorgames_cursor = db.rawQuery(displayPriorGamesQuery,null);

        if(priorgames_cursor.moveToFirst())
        {
            do {
                Player_Games_DB priorgames = new Player_Games_DB();
                priorgames.set_userText(priorgames_cursor.getString(0));
                priorgames.set_status(priorgames_cursor.getString(1).charAt(0));
                priorgames.set_cryptogramID(Integer.parseInt(priorgames_cursor.getString(0)));
                priorgames.set_username(username);


                priorgames_list.add(priorgames);

            }while(priorgames_cursor.moveToNext());

        }
        else
        {
            //exception
        }

        return priorgames_list;
    }


    /**
     * Retrieve single user ratings
     * @param username=the username used to log into the application
     */
    public  List<Player_Games_DB> displaySingleUserRatings(String username)
    {
        List<Player_Games_DB> userratings_list = new ArrayList<Player_Games_DB>();

        String displayUserRatingsQuery = " SELECT" + PLAYER_GAMES_STATUS +",COUNT("+PLAYER_GAMES_STATUS +"), AS RATINGS "+
                " FROM "  + TABLE_PLAYER_GAMES + " WHERE " + PLAYER_GAMES_PLAYER_USERNAME +
                   " = '"  + username +",  GROUP BY " +
                 PLAYER_GAMES_STATUS + " ORDER BY COUNT(" + PLAYER_GAMES_STATUS  + ") DESC ;";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor userratings_cursor = db.rawQuery(displayUserRatingsQuery,null);

        int count  = userratings_cursor.getCount();
        if(count > 0)
        {

            Player_Games_DB userratings = new Player_Games_DB();
            userratings.set_username(username);
            while(userratings_cursor.moveToNext())
            {
                char retrieve_status =userratings_cursor.getString(0).charAt(0);
                if(retrieve_status == 'C')
                {
                    userratings.set_correct(Integer.parseInt(userratings_cursor.getString(1)));
                }
                else if(retrieve_status == 'I')
                {
                    userratings.set_incorrect(Integer.parseInt(userratings_cursor.getString(1)));
                }
                else if(retrieve_status == 'S')
                {
                    userratings.set_started(Integer.parseInt(userratings_cursor.getString(1)));
                }

            }

            userratings_list.add(userratings);
        }

        else
        {
            //exception
        }

        return userratings_list;
    }

    /**
     * Retrieve  ratings of all users
     * TODO
     */
    public  List<Player_Games_DB> displayAllUserRatings() {
        List<Player_Games_DB> userratings_list = new ArrayList<Player_Games_DB>();

        String displayUserRatingsQuery = "SELECT " + PLAYER_GAMES_PLAYER_USERNAME + ","+ PLAYER_GAMES_STATUS+ ", COUNT(" + PLAYER_GAMES_STATUS + ") AS RATINGS" +
                                         "FROM "+ TABLE_PLAYER_GAMES +
                                         "GROUP BY "+PLAYER_GAMES_PLAYER_USERNAME+","+PLAYER_GAMES_STATUS+" ORDER BY "+PLAYER_GAMES_STATUS +", COUNT ("+PLAYER_GAMES_STATUS+") DESC";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor userratings_cursor = db.rawQuery(displayUserRatingsQuery,null);


        if(userratings_cursor.getCount() > 0)
        {

            do{

                    Player_Games_DB alluser = new Player_Games_DB();
                    alluser.set_username(userratings_cursor.getColumnName(0));
                    userratings_cursor.moveToNext();
                    char retrieve_status1 =userratings_cursor.getString(0).charAt(0);
                    if(retrieve_status1 == 'C')
                    {
                        alluser.set_correct(Integer.parseInt(userratings_cursor.getString(1)));
                    }
                    else if(retrieve_status1 == 'I')
                    {
                        alluser.set_incorrect(Integer.parseInt(userratings_cursor.getString(1)));
                    }
                    else if(retrieve_status1 == 'S')
                    {
                        alluser.set_started(Integer.parseInt(userratings_cursor.getString(1)));
                    }

                    userratings_cursor.moveToNext();
                    char retrieve_status2 =userratings_cursor.getString(0).charAt(0);
                    if(retrieve_status2 == 'C')
                    {
                        alluser.set_correct(Integer.parseInt(userratings_cursor.getString(1)));
                    }
                    else if(retrieve_status2 == 'I')
                    {
                        alluser.set_incorrect(Integer.parseInt(userratings_cursor.getString(1)));
                    }
                    else if(retrieve_status2 == 'S')
                    {
                        alluser.set_started(Integer.parseInt(userratings_cursor.getString(1)));
                    }

                    userratings_cursor.moveToNext();
                    char retrieve_status3 =userratings_cursor.getString(0).charAt(0);
                    if(retrieve_status3 == 'C')
                    {
                        alluser.set_correct(Integer.parseInt(userratings_cursor.getString(1)));
                    }
                    else if(retrieve_status3 == 'I')
                    {
                        alluser.set_incorrect(Integer.parseInt(userratings_cursor.getString(1)));
                    }
                    else if(retrieve_status3 == 'S')
                    {
                        alluser.set_started(Integer.parseInt(userratings_cursor.getString(1)));
                    }



                userratings_list.add(alluser);



            }
            while(userratings_cursor.moveToNext());
        }

        return userratings_list;
    }


}
