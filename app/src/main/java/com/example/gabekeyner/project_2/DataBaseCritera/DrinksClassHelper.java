package com.example.gabekeyner.project_2.DataBaseCritera;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GabeKeyner on 9/5/2016.
 */
public class DrinksClassHelper extends SQLiteOpenHelper {


    //TODO Set up a universal database for all of your drinks.

    private static final int DB_VERSION = 1;
    public static final String DB_NAME = "WHAT'LL_IT_BE3.db";
    public static final String TABLE_NAME = "DRINKS3";

    public static final String COL_ID = "_id";
    public static final String COL_ALCOHOL_TYPE = "alcohol_type";
    public static final String COL_NAME = "name";
    public static final String COL_ABV = "ABV";
    public static final String COL_DESCRIPTION = "drink_description";

    public static final String[] COLUMN_SELECTION = {COL_ID, COL_ALCOHOL_TYPE, COL_NAME, COL_ABV, COL_DESCRIPTION};

    private static final String SQL_CREATE_DRINKS = " CREATE TABLE " + TABLE_NAME + " " + "( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_ALCOHOL_TYPE + " TEXT, " +
            COL_NAME + " TEXT, " +
            COL_ABV + " DOUBLE, " +
            COL_DESCRIPTION + " TEXT)";

    /**
     * SQL command to delete our drinks table
     */
    private static final String SQL_DELETE_DRINKS = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public DrinksClassHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DRINKS);

        insert(db, 1, "beer", "corona", 2.0, "mexican beer");
        insert(db, 2, "beer", "budlight", 1.0, "american beer");
        insert(db, 3, "beer", "coors", 3.0, "american beer");
        insert(db, 4, "beer", "805", 4.0, "imported beer");
        insert(db, 5, "beer", "guinness", 3.0, "british beer");
        insert(db, 6, "beer", "sapporo", 2.0, "chinese beer");

        insert(db, 7, "wine", "Justin", 6.0, "Cab");
        insert(db, 8, "wine", "Clu de Bois", 4.0, "European");
        insert(db, 9, "wine", "Justin", 6.0, "Cab");

        insert(db, 10, "mixed drink", "77", 12.0, "sevens whisky & seven up");
        insert(db, 11, "mixed drink", "Blue Hawaiian", 10.0, "Blue Drink");
        insert(db, 12, "mixed drink", "Long Island", 12.0, "Mixture of vokdas");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_DRINKS);
        this.onCreate(db);

    }

    public static DrinksClassHelper mInstance;

    public static DrinksClassHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DrinksClassHelper(context.getApplicationContext());
        }
        return mInstance;

    }

    public void insert(SQLiteDatabase db, int id, String type, String name, double abv, String desc) {
        ContentValues values = new ContentValues();

        values.put(COL_ID, id);
        values.put(COL_ALCOHOL_TYPE, type);
        values.put(COL_NAME, name);
        values.put(COL_ABV, abv);
        values.put(COL_DESCRIPTION, desc);

        db.insert(TABLE_NAME, null, values);

    }


    public int addItem(String alcoholType, String name, Double ABV, String description) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_ALCOHOL_TYPE, alcoholType);
        values.put(COL_NAME, name);
        values.put(COL_ABV, String.valueOf(ABV));
        values.put(COL_DESCRIPTION, description);

        long id = db.insert(TABLE_NAME, null, values);

        return ((int) id);
    }

    public DrinksClass getDrinksClass(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = new String[]{COL_ID, COL_ALCOHOL_TYPE, COL_NAME, COL_ABV, COL_DESCRIPTION};

        String selection = COL_ID + " = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);
        cursor.moveToFirst();

        String alcoholType = cursor.getString(cursor.getColumnIndex(COL_ALCOHOL_TYPE));
        String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
        Double ABV = cursor.getDouble(cursor.getColumnIndex(COL_ABV));
        String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));

        return new DrinksClass(id, alcoholType, name, ABV, description);
    }

    public int update(String alcoholType, String name, Double ABV, String description) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ALCOHOL_TYPE, alcoholType);
        values.put(COL_NAME, name);
        values.put(COL_ABV, String.valueOf(ABV));
        values.put(COL_DESCRIPTION, description);
        long id = db.insert(TABLE_NAME, null, values);
        return ((int) id);
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();

        String selection = COL_ID + " = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        db.delete(TABLE_NAME, selection, selectionArgs);
    }


//TODO //TODO //TODO //TODO //TODO //TODO




    public Cursor getAllDrinks(String type) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                COL_ALCOHOL_TYPE + " LIKE ?",
                new String[]{type},
                null,
                null,
                null,
                null);

        return cursor;

    }


    /**
     * TODO Get the all the drinks that type of alcohol are beers
     *
     * @return List Beer Names/ABV/Description
     */
    public Cursor getBeers(String query) {

        SQLiteDatabase db = this.getReadableDatabase();

        //Build a query
        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                COL_ALCOHOL_TYPE + " LIKE ?",
                new String[]{query},
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
    public Cursor getWines(String query) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                COL_ALCOHOL_TYPE + " LIKE ?",
                new String[]{query},
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

    public Cursor getMixedDrinks(String query) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                COL_ALCOHOL_TYPE + " LIKE ?",
                new String[]{query},
                null,
                null,
                null,
                null);

        return cursor;

    }



}
