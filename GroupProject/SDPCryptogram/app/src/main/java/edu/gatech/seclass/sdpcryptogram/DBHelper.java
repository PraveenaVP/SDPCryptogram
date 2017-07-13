package edu.gatech.seclass.sdpcryptogram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import edu.gatech.seclass.utilities.RatingsUtil;
import edu.gatech.seclass.utilities.CryptogramsUtil;

import java.util.List;
import java.util.HashMap;
import java.util.Map;


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
    public static final String DATABASE_NAME = "SDPCryptogram01.db";

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



    //Database Table CryptogramsUtil
    public static final String TABLE_CRYPTOGRAMS  = "Cryptograms";

    //Table CryptogramsUtil Columns
    public static final String CRYPTOGRAM_ID = "cryptogram_id";
    public static final String CRYPTOGRAM = "cryptogram";
    public static final String SOLUTION = "solution";

    //Database Table Player_Games
    public static final String TABLE_PLAYER_GAMES = "Player_Games";

    //Table Player_Games Columns
    public static final String PLAYER_GAMES_PLAYER_USERNAME = "username";
    public static final String PLAYER_GAMES_CRYPTOGRAM_ID = "cryptogram_ID";
    public static final String PLAYER_GAMES_CRYPTOGRAM_TEXT = "cryptogram";
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
                + ADMIN_USERNAME + "TEXT UNIQUE"  + ")" ;

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




        //Creating CryptogramsUtil Table
        String CREATE_CRYPTOGRAMS_TABLE = "CREATE TABLE "+TABLE_CRYPTOGRAMS + " ( "
                + CRYPTOGRAM_ID + " INTEGER PRIMARY KEY, "
                + CRYPTOGRAM + " TEXT UNIQUE, "
                + SOLUTION + " TEXT "
                + " ) " ;

        try {
            db.execSQL(CREATE_CRYPTOGRAMS_TABLE);
        }catch (Exception e)
        {
            System.out.println("Unable to create CryptogramsUtil table");
        }

        //Creating Player_Games Table.
        String CREATE_PLAYER_GAMES_TABLE = "CREATE TABLE "+TABLE_PLAYER_GAMES + "("
                + PLAYER_GAMES_PLAYER_USERNAME + " TEXT, "
                + PLAYER_GAMES_CRYPTOGRAM_ID + " INTEGER, "
                + PLAYER_GAMES_CRYPTOGRAM_TEXT + " TEXT, "
                + PLAYER_GAMES_TEXT + " TEXT, "
                + PLAYER_GAMES_STATUS + " TEXT "
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

        db.close();
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
        db.close();
        return  status;

    }


    // Insert into CryptogramsUtil Tables
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
        db.close();
        return  status;
    }




    // Insert/Update into Player_Games Tables
    public boolean insertupdateDataPlayer_Games(String player_username, int cryptogramID,String cryptogram, String userText, String gamestatus)
    {
        boolean status = false;
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //Adding the values
        contentValues.put(PLAYER_GAMES_PLAYER_USERNAME,player_username);
        contentValues.put(PLAYER_GAMES_CRYPTOGRAM_ID,cryptogramID);
        contentValues.put(PLAYER_GAMES_CRYPTOGRAM_TEXT,cryptogram);
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
        db.close();
        return  status;
    }


    /**Display data of a player based on the player_username
    * @param player_username  = the username used to log into the application
     **/
    public String displayPlayerData(String player_username)
    {

        String selectPlayerQuery = "SELECT first_name,last_name,username FROM "+TABLE_PLAYERS+
                                    " WHERE username IN ('"+player_username +"') ;";

        SQLiteDatabase db  = this.getWritableDatabase();
        StringBuilder sb = new StringBuilder();

        Cursor player_cursor = db.rawQuery(selectPlayerQuery,null);

        if (player_cursor.getCount() == 0)
        {
            sb.append("");
        }
        else
        {
            if(player_cursor.moveToFirst())
            {
                sb.append(player_cursor.getString(0));
                sb.append(" ");
                sb.append(player_cursor.getString(1));

            }
        }
        db.close();
        return sb.toString();

    }


    /**
     * Retrieves the solution from Cryptogram Table using the cryptogram ID
     * to check for the solution
     * @param cryptogram_id: The id of the cryptogram
     */

    public String CryptogramSolution(int cryptogram_id, boolean isSol)
    {
        String solution = "";
        String selectCryptogramQuery = " SELECT "+SOLUTION+ ","+CRYPTOGRAM+" FROM " + TABLE_CRYPTOGRAMS+
                                        " WHERE " + CRYPTOGRAM_ID + " = " +cryptogram_id +" ;";

        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cryptogram_cursor = db.rawQuery(selectCryptogramQuery,null);

        if(cryptogram_cursor.getCount() > 0)
        {
            cryptogram_cursor.moveToFirst();
            if(isSol) {
                solution = cryptogram_cursor.getString(0);
            }
            else
            {
                solution = cryptogram_cursor.getString(1);

            }
        }
        else
        {
            //exception
        }
        db.close();
        return solution;
    }





    /** Retrieve cryptograms lesser than the cryptogramID provided
     * This is done to facilitate batch retrieval.
     * @param cryptogramID = The value of the last cryptogramID in the display list,
     *                      if there is no list(first time load) set it to zero.
     * @param   limit = Sets the retrieval batch size.
     **/

    public String[] displayCryptograms( int cryptogramID, int limit)
    {

        //For loading more cryptograms.
        String displyCryptogramQuery1 = "SELECT * FROM "+TABLE_CRYPTOGRAMS +
                " WHERE " + CRYPTOGRAM_ID + ">" +cryptogramID +
                " ORDER BY  " +CRYPTOGRAM_ID + " ASC " +
                " LIMIT " + limit +";" ;

        String displyCryptogramQuery = "SELECT * FROM "+TABLE_CRYPTOGRAMS + ";" ;


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cryptogram_cursor = db.rawQuery(displyCryptogramQuery,null);

        int count = cryptogram_cursor.getCount();
        if(count == 0)
        {
            db.close();
            return null;
        }
        String cryptogram_list[] = new String[count];
        int i = 0;
        if(cryptogram_cursor.moveToFirst())
        {
            do{
                StringBuffer sb = new StringBuffer();
                sb.append(cryptogram_cursor.getString(0));
                sb.append(':');
                sb.append(cryptogram_cursor.getString(1));
                cryptogram_list[i] = sb.toString();
                i = i+1;
            }while(cryptogram_cursor.moveToNext());
        }
        else
        {
            //Exception
        }
        db.close();
        return cryptogram_list;
    }

    public void DropTemp()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS TEMP1;");
        db.execSQL("DROP TABLE IF EXISTS TEMP2;");
        db.execSQL("DROP TABLE IF EXISTS TEMP3;");
        db.execSQL("DROP TABLE IF EXISTS TEMP4;");
    }

    public String[] displayCryptogramsWithStatus(String username)
    {


        StringBuilder sb1 = new StringBuilder();
        //sb1.append("DROP TABLE IF EXISTS TEMP1; ");
        sb1.append("CREATE TABLE TEMP1 AS ");
        sb1.append("SELECT DISTINCT ");
        sb1.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb1.append(",");
        sb1.append(PLAYER_GAMES_CRYPTOGRAM_TEXT);
        sb1.append(", ");
        sb1.append("CASE ");
        sb1.append(PLAYER_GAMES_STATUS);
        sb1.append(" WHEN 'C' THEN 'SOLVED' ELSE 'INPROCESS' END AS GAME_STATUS ");
        sb1.append("FROM ");
        sb1.append(TABLE_PLAYER_GAMES );
        sb1.append(" WHERE ");
        sb1.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb1.append("='");
        sb1.append(username);
        sb1.append("' GROUP BY ");
        sb1.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb1.append(" ; ");


        StringBuilder sb2 = new StringBuilder();
        //sb1.append("DROP TABLE IF EXISTS TEMP2; ");
        sb2.append("CREATE TABLE TEMP2 AS ");
        sb2.append("SELECT DISTINCT ");
        sb2.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb2.append(",");
        sb2.append(PLAYER_GAMES_CRYPTOGRAM_TEXT);
        sb2.append(",");
        sb2.append("COUNT(");
        sb2.append(PLAYER_GAMES_STATUS);
        sb2.append(")  AS INCORRECT_COUNT ");
        sb2.append("FROM ");
        sb2.append(TABLE_PLAYER_GAMES);
        sb2.append(" WHERE ");
        sb2.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb2.append("='");
        sb2.append(username);
        sb2.append("' AND ");
        sb2.append(PLAYER_GAMES_STATUS);
        sb2.append(" = 'I'  GROUP BY ");
        sb2.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb2.append(" ; ");
        //sb1.append("DROP TABLE IF EXISTS TEMP3; ");

        StringBuilder sb3 = new StringBuilder();
        sb3.append("CREATE TABLE TEMP3 AS ");
        sb3.append("SELECT TEMP1.");
        sb3.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb3.append(" , TEMP1.");
        sb3.append(PLAYER_GAMES_CRYPTOGRAM_TEXT);
        sb3.append(",TEMP1.GAME_STATUS,TEMP2.INCORRECT_COUNT ");
        sb3.append("FROM TEMP1 LEFT JOIN TEMP2 ON ");
        sb3.append("TEMP1.");
        sb3.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb3.append(" = TEMP2.");
        sb3.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb3.append("; ");

        //sb1.append("DROP TABLE IF EXISTS TEMP4; ");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("CREATE TABLE TEMP4 AS ");
        sb4.append(" SELECT ");
        sb4.append(CRYPTOGRAM_ID);
        sb4.append(",");
        sb4.append(CRYPTOGRAM);
        sb4.append(", 'UNATTEMPTED' AS GAMES_STATUS,'' AS INCORRECT_COUNT FROM ");
        sb4.append(TABLE_CRYPTOGRAMS);
        sb4.append(" WHERE ");
        sb4.append(CRYPTOGRAM_ID);
        sb4.append(" NOT IN(SELECT ");
        sb4.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb4.append(" FROM TEMP3 ); ");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TEMP3 UNION SELECT * FROM TEMP4; ");



        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL(sb1.toString());
        }
        catch (Exception e)
        {
            System.out.print("Error creating Temp1");
        }
        try {
            db.execSQL(sb2.toString());
        }
        catch (Exception e)
        {
            System.out.print("Error creating Temp2");
        }
        try {
            db.execSQL(sb3.toString());
        }
        catch (Exception e)
        {
            System.out.print("Error creating Temp3");
        }
        try {
            db.execSQL(sb4.toString());
        }
        catch (Exception e)
        {
            System.out.print("Error creating Temp4");
        }


        Cursor cryptogram_cursor1 = db.rawQuery(sb.toString(),null);

        int count = cryptogram_cursor1.getCount();
        String cryptogram_list[] = new String[count+1];
        StringBuilder sb0 = new StringBuilder();
        sb0.append("ID");
        sb0.append(":");
        sb0.append("   ");
        sb0.append("Game");
        sb0.append(":");
        sb0.append("   ");
        sb0.append("Status");
        sb0.append(":");
        sb0.append("   ");
        sb0.append("Incorrect attempts ");
        sb0.append(":");
        sb0.append("   ");

        cryptogram_list[0] = sb0.toString();
        int i = 1;
        if(cryptogram_cursor1.moveToFirst())
        {
            do{
                StringBuilder sb11 = new StringBuilder();
                sb11.append(cryptogram_cursor1.getString(0));
                sb11.append(":");
                sb11.append("   ");
                sb11.append(cryptogram_cursor1.getString(1));
                sb11.append(":");
                sb11.append("   ");
                sb11.append(cryptogram_cursor1.getString(2));
                sb11.append(":");
                sb11.append("   ");
                String incorrect = cryptogram_cursor1.getString(3);
                if(incorrect == null || incorrect.equals(""))
                    incorrect = "0";
                sb11.append(incorrect);
                sb11.append("");

                cryptogram_list[i] = sb11.toString();
                i = i +1;



            }while(cryptogram_cursor1.moveToNext());
            {

            }
        }
        else
        {
            //Exception
        }
        DropTemp();
        db.close();
        return cryptogram_list;
    }


    public ArrayList<CryptogramsUtil> displayCryptogramsWithStatus1(String username)
    {


        StringBuilder sb1 = new StringBuilder();
        //sb1.append("DROP TABLE IF EXISTS TEMP1; ");
        sb1.append("CREATE TABLE TEMP1 AS ");
        sb1.append("SELECT DISTINCT ");
        sb1.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb1.append(",");
        sb1.append(PLAYER_GAMES_CRYPTOGRAM_TEXT);
        sb1.append(", ");
        sb1.append("CASE ");
        sb1.append(PLAYER_GAMES_STATUS);
        sb1.append(" WHEN 'C' THEN 'SOLVED' ELSE 'INPROCESS' END AS GAME_STATUS ");
        sb1.append("FROM ");
        sb1.append(TABLE_PLAYER_GAMES );
        sb1.append(" WHERE ");
        sb1.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb1.append("='");
        sb1.append(username);
        sb1.append("' GROUP BY ");
        sb1.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb1.append(" ; ");


        StringBuilder sb2 = new StringBuilder();
        //sb1.append("DROP TABLE IF EXISTS TEMP2; ");
        sb2.append("CREATE TABLE TEMP2 AS ");
        sb2.append("SELECT DISTINCT ");
        sb2.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb2.append(",");
        sb2.append(PLAYER_GAMES_CRYPTOGRAM_TEXT);
        sb2.append(",");
        sb2.append("COUNT(");
        sb2.append(PLAYER_GAMES_STATUS);
        sb2.append(")  AS INCORRECT_COUNT ");
        sb2.append("FROM ");
        sb2.append(TABLE_PLAYER_GAMES);
        sb2.append(" WHERE ");
        sb2.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb2.append("='");
        sb2.append(username);
        sb2.append("' AND ");
        sb2.append(PLAYER_GAMES_STATUS);
        sb2.append(" = 'I'  GROUP BY ");
        sb2.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb2.append(" ; ");
        //sb1.append("DROP TABLE IF EXISTS TEMP3; ");

        StringBuilder sb3 = new StringBuilder();
        sb3.append("CREATE TABLE TEMP3 AS ");
        sb3.append("SELECT TEMP1.");
        sb3.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb3.append(" , TEMP1.");
        sb3.append(PLAYER_GAMES_CRYPTOGRAM_TEXT);
        sb3.append(",TEMP1.GAME_STATUS,TEMP2.INCORRECT_COUNT ");
        sb3.append("FROM TEMP1 LEFT JOIN TEMP2 ON ");
        sb3.append("TEMP1.");
        sb3.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb3.append(" = TEMP2.");
        sb3.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb3.append("; ");

        //sb1.append("DROP TABLE IF EXISTS TEMP4; ");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("CREATE TABLE TEMP4 AS ");
        sb4.append(" SELECT ");
        sb4.append(CRYPTOGRAM_ID);
        sb4.append(",");
        sb4.append(CRYPTOGRAM);
        sb4.append(", 'UNATTEMPTED' AS GAMES_STATUS,'' AS INCORRECT_COUNT FROM ");
        sb4.append(TABLE_CRYPTOGRAMS);
        sb4.append(" WHERE ");
        sb4.append(CRYPTOGRAM_ID);
        sb4.append(" NOT IN(SELECT ");
        sb4.append(PLAYER_GAMES_CRYPTOGRAM_ID);
        sb4.append(" FROM TEMP3 ); ");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TEMP3 UNION SELECT * FROM TEMP4; ");



        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL(sb1.toString());
        }
        catch (Exception e)
        {
            System.out.print("Error creating Temp1");
        }
        try {
            db.execSQL(sb2.toString());
        }
        catch (Exception e)
        {
            System.out.print("Error creating Temp2");
        }
        try {
            db.execSQL(sb3.toString());
        }
        catch (Exception e)
        {
            System.out.print("Error creating Temp3");
        }
        try {
            db.execSQL(sb4.toString());
        }
        catch (Exception e)
        {
            System.out.print("Error creating Temp4");
        }


        Cursor cryptogram_cursor = db.rawQuery(sb.toString(),null);
        ArrayList<CryptogramsUtil> cryptogram_list = new ArrayList<>();

        if(cryptogram_cursor.moveToFirst())
        {
            do{
                String id = cryptogram_cursor.getString(0);
                String cryptogram = cryptogram_cursor.getString(1);
                String status = cryptogram_cursor.getString(2);
                String incorrect = cryptogram_cursor.getString(3);
                if(incorrect == null || incorrect.equals(""))
                    incorrect = "0";
                CryptogramsUtil addCryptogram = new CryptogramsUtil(id,cryptogram,status,incorrect);
                cryptogram_list.add(addCryptogram);



            }while(cryptogram_cursor.moveToNext());
            {

            }
        }
        else
        {
            //Exception
        }
        DropTemp();
        db.close();
        return cryptogram_list;
    }

    /**
     * Retreive PriorGames of the user with their status
     * @param username =the username used to log into the application
     *
     *
     */
    public String[] displayPriorGames(String username)
    {

        String displayPriorGamesQuery = " SELECT "+ PLAYER_GAMES_TEXT+","+PLAYER_GAMES_STATUS +","+PLAYER_GAMES_CRYPTOGRAM_TEXT+
                                        ","+PLAYER_GAMES_CRYPTOGRAM_ID+
                                        " FROM "  + TABLE_PLAYER_GAMES + " WHERE " + PLAYER_GAMES_PLAYER_USERNAME
                                        +" IN ('"  + username +"') ;";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor priorgames_cursor = db.rawQuery(displayPriorGamesQuery,null);
        int count = priorgames_cursor.getCount();
        if(count == 0)
        {
            db.close();
            return null;
        }
        String[] priorgames = new String[count+1];
        StringBuffer sb = new StringBuffer();
        sb.append("CryptID");
        sb.append("  ");
        sb.append("Cryptogram");
        sb.append("  ");
        sb.append("User solution");
        sb.append("  ");
        sb.append("Status");
        priorgames[0] = sb.toString();
        int i = 0;
        if(priorgames_cursor.moveToFirst())
        {
            do {

                i = i +1;
                StringBuffer sb1 = new StringBuffer();
                sb1.append(Integer.parseInt(priorgames_cursor.getString(3)));
                sb1.append(":");
                sb1.append("  ");
                sb1.append(priorgames_cursor.getString(2));
                sb1.append(":");
                sb1.append("  ");
                sb1.append(priorgames_cursor.getString(0));
                sb1.append(":");
                sb1.append("  ");
                char status = priorgames_cursor.getString(1).charAt(0);
                String sbstaus = "";
                if(status == 'S')
                {
                    sbstaus = "Started";
                }
                else if(status == 'C')
                {
                    sbstaus = "Solved";
                }
                else
                {
                    sbstaus = "Incorrect";
                }
                sb1.append(sbstaus);
                priorgames[i] = sb1.toString();
            }while(priorgames_cursor.moveToNext());

        }
        else
        {
            //exception
        }
        db.close();
        return priorgames;
    }


    public ArrayList<CryptogramsUtil> displayPriorGames1(String username)
    {

        String displayPriorGamesQuery = " SELECT "+ PLAYER_GAMES_TEXT+","+PLAYER_GAMES_STATUS +","+PLAYER_GAMES_CRYPTOGRAM_TEXT+
                ","+PLAYER_GAMES_CRYPTOGRAM_ID+
                " FROM "  + TABLE_PLAYER_GAMES + " WHERE " + PLAYER_GAMES_PLAYER_USERNAME
                +" IN ('"  + username +"') ;";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor priorgames_cursor = db.rawQuery(displayPriorGamesQuery,null);
        ArrayList<CryptogramsUtil> priorgames_list = new ArrayList<>();

        if(priorgames_cursor.moveToFirst())
        {
            do {

                String id = priorgames_cursor.getString(3);
                String puzzle = priorgames_cursor.getString(2);
                String userText = priorgames_cursor.getString(0);
                char status = priorgames_cursor.getString(1).charAt(0);
                String sbstaus = "";
                if(status == 'S')
                {
                    sbstaus = "Started";
                }
                else if(status == 'C')
                {
                    sbstaus = "Solved";
                }
                else
                {
                    sbstaus = "Incorrect";
                }

                CryptogramsUtil priorcrypt = new CryptogramsUtil(id,puzzle,userText,sbstaus,true);
                priorgames_list.add(priorcrypt);

            }while(priorgames_cursor.moveToNext());

        }
        else
        {
            //exception
        }
        db.close();
        return priorgames_list;
    }

    /**
     * Retrieve single user ratings
     * @param username=the username used to log into the application
     */
    public  String[] displaySingleUserRatings(String username)
    {


        String displayUserRatingsQuery = " SELECT " + PLAYER_GAMES_STATUS +",COUNT("+PLAYER_GAMES_STATUS +") AS RATINGS "+
                " FROM "  + TABLE_PLAYER_GAMES + " WHERE " + PLAYER_GAMES_PLAYER_USERNAME +
                   " IN ('"  + username +"')  GROUP BY " +
                 PLAYER_GAMES_STATUS + " ORDER BY COUNT(" + PLAYER_GAMES_STATUS  + ") DESC ;";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor userratings_cursor = db.rawQuery(displayUserRatingsQuery,null);

        int count  = userratings_cursor.getCount();
        if(count == 0)
        {
            db.close();
            return null;
        }
        String[] ratinglist = new String[count];

                int i =0;

        if(userratings_cursor.moveToFirst())
        {
            do {
            StringBuffer sb = new StringBuffer();
                char status = userratings_cursor.getString(0).charAt(0);
                if(status == 'C')
                {
                    sb.append("Correct: ");
                    sb.append(Integer.parseInt(userratings_cursor.getString(1)));
                }
                else if(status == 'I')
                {
                    sb.append("Incorrect: ");
                    sb.append(Integer.parseInt(userratings_cursor.getString(1)));
                }
                else if(status == 'S')
                {
                    sb.append("Started: ");
                    sb.append(Integer.parseInt(userratings_cursor.getString(1)));
                }
                ratinglist[i] = sb.toString();
                i = i+1;
            }

            while(userratings_cursor.moveToNext());

        }

        else
        {
            //exception
        }
    db.close();
        return ratinglist;
    }

    /**
     * Retrieve  ratings of all users
     * TODO
     */
    public  String[] displayAllUserRatings() {

        DropTemp();
        StringBuilder sb1 = new StringBuilder();
        sb1.append("CREATE TABLE TEMP1 AS ");
        sb1.append(" SELECT ");
        sb1.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb1.append(" ,COUNT(");
        sb1.append(PLAYER_GAMES_STATUS);
        sb1.append(") AS CORRECT  FROM ");
        sb1.append(TABLE_PLAYER_GAMES);
        sb1.append(" WHERE ");
        sb1.append(PLAYER_GAMES_STATUS);
        sb1.append(" = 'C' GROUP BY  ");
        sb1.append(PLAYER_GAMES_PLAYER_USERNAME);

        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE TEMP2 AS ");
        sb2.append(" SELECT ");
        sb2.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb2.append(" ,COUNT(");
        sb2.append(PLAYER_GAMES_STATUS);
        sb2.append(") AS INCORRECT  FROM ");
        sb2.append(TABLE_PLAYER_GAMES);
        sb2.append(" WHERE ");
        sb2.append(PLAYER_GAMES_STATUS);
        sb2.append(" = 'I' GROUP BY  ");
        sb2.append(PLAYER_GAMES_PLAYER_USERNAME);



        StringBuilder sb3 = new StringBuilder();
        sb3.append("CREATE TABLE TEMP3 AS ");
        sb3.append(" SELECT ");
        sb3.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb3.append(" ,COUNT(");
        sb3.append(PLAYER_GAMES_STATUS);
        sb3.append(") AS STARTED  FROM ");
        sb3.append(TABLE_PLAYER_GAMES);
        sb3.append(" WHERE ");
        sb3.append(PLAYER_GAMES_STATUS);
        sb3.append(" = 'S' GROUP BY  ");
        sb3.append(PLAYER_GAMES_PLAYER_USERNAME);

        SQLiteDatabase db = this.getWritableDatabase();


        try
        {
            db.execSQL(sb1.toString());
        }
        catch (Exception e)
        {
            System.out.println("Error creating table temp1 for ratings");
        }
        try
        {
            db.execSQL(sb2.toString());
        }
        catch (Exception e)
        {
            System.out.println("Error creating table temp2 for ratings");
        }
        try
        {
            db.execSQL(sb3.toString());
        }
        catch (Exception e)
        {
            System.out.println("Error creating table temp3 for ratings");
        }


        StringBuilder sb = new StringBuilder();
        sb.append("SELECT TEMP1.");
        sb.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb.append(",TEMP1.CORRECT,TEMP2.INCORRECT, TEMP3.STARTED ");
        sb.append(" FROM TEMP1 LEFT JOIN TEMP2 ON ");
        sb.append("TEMP1.");
        sb.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb.append(" = ");
        sb.append("TEMP2.");
        sb.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb.append("  LEFT JOIN TEMP3 ON ");
        sb.append("TEMP1.");
        sb.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb.append(" = ");
        sb.append("TEMP3.");
        sb.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb.append(";");



        Cursor userratings_cursor = db.rawQuery(sb.toString(),null);
        int count  = userratings_cursor.getCount();
        String[] alluser = new String[count+1];
        StringBuilder sb_header = new StringBuilder();
        sb_header.append("Username");
        sb_header.append(" :        ");
        sb_header.append("Correct");
        sb_header.append(" : ");
        sb_header.append("Incorrect");
        sb_header.append(" : ");
        sb_header.append("Started");
        sb_header.append(" :");
        alluser[0] = sb_header.toString();

        int i = 1;
        if(userratings_cursor.moveToFirst())
        {

            do{
                StringBuilder sb_row = new StringBuilder();
                sb_row.append(userratings_cursor.getString(0));
                sb_row.append(" :        ");

                String correct = userratings_cursor.getString(1);
                if(correct != null && !correct.equals(""))
                    sb_row.append(correct);
                else
                    sb_row.append("0");
                sb_row.append("         ");

                String incorrect = userratings_cursor.getString(2);
                if(incorrect != null && !incorrect.equals(""))
                    sb_row.append(incorrect);
                else
                    sb_row.append("0");
                sb_row.append("         ");

                String started = userratings_cursor.getString(3);
                if(started != null && !started.equals(""))
                    sb_row.append(started);
                else
                    sb_row.append("0");
                sb_row.append("         ");


                alluser[i] = sb_row.toString();
                i = i +1;
           }
            while(userratings_cursor.moveToNext());
        }
        DropTemp();
        db.close();
        return alluser;
    }




    /**
     * Retrieve  ratings of all users
     * TODO
     */
    public  ArrayList<RatingsUtil> displayAllUserRatings1() {

        DropTemp();
        StringBuilder sb1 = new StringBuilder();
        sb1.append("CREATE TABLE TEMP1 AS ");
        sb1.append(" SELECT ");
        sb1.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb1.append(" ,COUNT(");
        sb1.append(PLAYER_GAMES_STATUS);
        sb1.append(") AS CORRECT  FROM ");
        sb1.append(TABLE_PLAYER_GAMES);
        sb1.append(" WHERE ");
        sb1.append(PLAYER_GAMES_STATUS);
        sb1.append(" = 'C' GROUP BY  ");
        sb1.append(PLAYER_GAMES_PLAYER_USERNAME);

        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE TEMP2 AS ");
        sb2.append(" SELECT ");
        sb2.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb2.append(" ,COUNT(");
        sb2.append(PLAYER_GAMES_STATUS);
        sb2.append(") AS INCORRECT  FROM ");
        sb2.append(TABLE_PLAYER_GAMES);
        sb2.append(" WHERE ");
        sb2.append(PLAYER_GAMES_STATUS);
        sb2.append(" = 'I' GROUP BY  ");
        sb2.append(PLAYER_GAMES_PLAYER_USERNAME);



        StringBuilder sb3 = new StringBuilder();
        sb3.append("CREATE TABLE TEMP3 AS ");
        sb3.append(" SELECT ");
        sb3.append(PLAYER_GAMES_PLAYER_USERNAME);
        sb3.append(" ,COUNT(");
        sb3.append(PLAYER_GAMES_STATUS);
        sb3.append(") AS STARTED  FROM ");
        sb3.append(TABLE_PLAYER_GAMES);
        sb3.append(" WHERE ");
        sb3.append(PLAYER_GAMES_STATUS);
        sb3.append(" = 'S' GROUP BY  ");
        sb3.append(PLAYER_GAMES_PLAYER_USERNAME);

        SQLiteDatabase db = this.getWritableDatabase();


        try
        {
            db.execSQL(sb1.toString());
        }
        catch (Exception e)
        {
            System.out.println("Error creating table temp1 for ratings");
        }
        try
        {
            db.execSQL(sb2.toString());
        }
        catch (Exception e)
        {
            System.out.println("Error creating table temp2 for ratings");
        }
        try
        {
            db.execSQL(sb3.toString());
        }
        catch (Exception e)
        {
            System.out.println("Error creating table temp3 for ratings");
        }


        String sb_Temp1 = "SELECT * FROM TEMP1;";
        String sb_Temp2 = "SELECT * FROM TEMP2;";
        String sb_Temp3 = "SELECT * FROM TEMP3;";

        Cursor temp1 = db.rawQuery(sb_Temp1,null);
        Cursor temp2 = db.rawQuery(sb_Temp2,null);
        Cursor temp3 = db.rawQuery(sb_Temp3,null);

        ArrayList<RatingsUtil>alluser = new ArrayList<>();
        List<String> lsusernames = new ArrayList<>();
        Map<String,String> hsTemp1 = new HashMap<String,String>();
        Map<String,String> hsTemp2 = new HashMap<String,String>();
        Map<String,String> hsTemp3 = new HashMap<String,String>();


        if(temp1.moveToFirst())
        {
            do{
                String username = temp1.getString(0);
                if(!lsusernames.contains(username))
                {
                    lsusernames.add(username);
                }
                String correct = temp1.getString(1);
                if(correct == null && correct.equals("")){
                    correct = "0";}
                hsTemp1.put(username,correct);
            }
            while(temp1.moveToNext());
        }
        if(temp2.moveToFirst())
        {
            do{
                String username = temp2.getString(0);
                if(!lsusernames.contains(username))
                {
                    lsusernames.add(username);
                }
                String incorrect = temp2.getString(1);
                if(incorrect == null && incorrect.equals("")){
                    incorrect = "0";}
                hsTemp2.put(username,incorrect);
            }
            while(temp2.moveToNext());
        }
        if(temp3.moveToFirst())
        {
            do{
                String username = temp3.getString(0);
                if(!lsusernames.contains(username))
                {
                    lsusernames.add(username);
                }
                String started = temp3.getString(1);
               if(started == null && started.equals("")){
                    started = "0";}
                hsTemp3.put(username,started);
            }
            while(temp3.moveToNext());
        }

        for(String username: lsusernames)
        {
            String correct = "0";
            String incorrect = "0";
            String started = "0";

            try {
                 correct = hsTemp1.get(username);
              }
            catch (Exception e)
            {

            }
            try {
                incorrect = hsTemp2.get(username);
            }
            catch (Exception e)
            {

            }
            try {
                started = hsTemp3.get(username);
            }
            catch (Exception e)
            {

            }


            RatingsUtil ratings = new RatingsUtil(username,correct,incorrect,started);
            alluser.add(ratings);
        }



        DropTemp();
        db.close();
        return alluser;
    }


}
