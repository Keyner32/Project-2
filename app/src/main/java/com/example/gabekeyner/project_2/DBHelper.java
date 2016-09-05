package com.example.gabekeyner.project_2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GabeKeyner on 9/5/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    //TODO Set up a universal database for all of your drinks.

    private static final int DB_VERSION = 1;
    public static final String DB_NAME = "WHAT'LL_IT_BE_db";
    public static final String TABLE_NAME = "DRINKS";

    public static final String COL_ID = "_id";
    public static final String COL_ALCOHOL_TYPE = "alcohol_type";
    public static final String COL_NAME = "name";
    public static final String COL_ABV = "alcohol_percent_volume";
    public static final String COL_DESCRIPTION = "drink_description";

    public static final String[] COLUMN_SELECTION = {COL_ALCOHOL_TYPE, COL_NAME, COL_ABV};

    private static final String CREATE_DRINKS = " CREATE TABLE " + TABLE_NAME + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_ALCOHOL_TYPE + " TEXT, " +
            COL_NAME + " TEXT, " +
            COL_ABV + " DECIMAL, " +
            COL_DESCRIPTION + " TEXT ,";

    public static DBHelper mInstance;

    public static DBHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DBHelper(context.getApplicationContext());
        }
        return mInstance;
    }


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DRINKS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);

    }

    /**
     * TODO Get the all the drinks that type of alcohol are beers
     *
     * @return List Beer Names/ABV/Description
     */
    public Cursor getBeers() {
// public List<String> getBeers ()
//        List<String> beers = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        //Build a query
        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                null,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }

    /**
     * TODO Get the all the drinks that type of alcohol are wine
     *
     * @return List Wine Names/ABV/Description
     */
    public Cursor getWines() {
//  public List<String> getWines()
//  List<String> wines = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                null,
                null,
                null,
                null,
                null,
                null);
        return cursor;

    }

    /**
     * TODO Get the all the drinks that type of alcohol are Mixed Drinks
     *
     * @return List Mixed Drink Names/ABV/Description
     */
    public Cursor getMixedDrinks() {
// public List<String> getMixedDrinks()
// List<String> mixedDrinks = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                null,
                null,
                null,
                null,
                null,
                null);
        return cursor;

    }
}
