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

    private static final int DB_VERSION = 5;
    public static final String DB_NAME = "WHAT'LL_IT_BE3.db";
    public static final String TABLE_NAME = "DRINKS3";

    public static final String COL_ID = "_id";
    public static final String COL_ALCOHOL_TYPE = "alcohol_type";
    public static final String COL_NAME = "name";
    public static final String COL_ABV = "ABV";
    public static final String COL_DESCRIPTION = "drink_description";
    public static final String COL_USER = "user_drink";


    public static final String[] COLUMN_SELECTION = {COL_ID, COL_ALCOHOL_TYPE, COL_NAME, COL_ABV, COL_DESCRIPTION, COL_USER};

    private static final String SQL_CREATE_DRINKS = " CREATE TABLE " + TABLE_NAME + " " + "( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_ALCOHOL_TYPE + " TEXT, " +
            COL_NAME + " TEXT, " +
            COL_ABV + " DOUBLE, " +
            COL_DESCRIPTION + " TEXT, " +
            COL_USER + " TEXT)";

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

        insert(db, "beer", "Corona", 2.0, "Mexican beer", "no");
        insert(db, "beer", "Budlight", 1.0, "American beer", "no");
        insert(db, "beer", "Coors", 3.0, "American beer", "no");
        insert(db, "beer", "805", 4.0, "imported beer", "no");
        insert(db, "beer", "Guinness", 3.0, "british beer", "no");
        insert(db, "beer", "Sapporo", 2.0, "chinese beer", "no");

        insert(db, "wine", "Beringer", 6.0, "Red wine with a strong ripe flavor", "no");
        insert(db, "wine", "Clu de Bois", 4.0, "European wine that is seen in more of restaurants", "no");
        insert(db, "wine", "Brunello", 6.0, "This strain of Sangiovese is the only grape permitted for Brunello", "no");

        insert(db, "mixed drink", "7 & 7", 12.0, "a mixed alcoholic drink containing Seagrams Seven Crown and 7 Up.", "no");
        insert(db, "mixed drink", "Blue Hawaiian", 10.0, "tropical cocktail made of rum, pineapple juice, Curaçao, sweet and sour mix, and sometimes vodka as well.", "no");
        insert(db, "mixed drink", "Long Island", 12.0, "typically made with tequila, vodka, light rum, triple sec, gin, and a splash of cola", "no");

        insert(db, "wine", "Bardolino ", 8.0, "A light red wine from the Veneto Region of Italy.", "no");
        insert(db, "wine", "Barolo", 11.0, "Highly regarded Italian red, made from Nebbiolo grapes.", "no");
        insert(db, "wine", "Blush", 9.0, "American term for rosé. Any wine that is pink in color.", "no");
        insert(db, "wine", "Cabernet Sauvignon", 8.0, "Currant, Plum, Black Cherry & Spice, with notes of Olive, Vanilla Mint..", "no");
        insert(db, "wine", "Carmenere", 11.0, "Imported to Chile in the 1850s.", "no");
        insert(db, "wine", "Charbono'", 9.0, "This grape has dwindled in acreage, often lean and tannic.", "no");
        insert(db, "mixed drink", "Piña Colada ", 8.0, "Is a sweet cocktail made with rum, coconut cream or coconut milk, and pineapple juice", "no");
        insert(db, "mixed drink", "Mojito", 11.0, "White rum, sugar, lime juice, soda water, and mint.", "no");
        insert(db, "mixed drink", "White Russian", 9.0, "made with vodka, coffee liqueur, and cream served with ice in an Old Fashioned glass,", "no");
        insert(db, "beer", "Budweiser", 3.0, " American-style pale lager", "no");
        insert(db, "beer", "Modelo", 4.0, "Pilsner-Style beer", "no");
        insert(db, "beer", "Pacifico ", 3.0, "Mexican pilsner-style beer", "no");
        insert(db, "beer", "Stella Artois", 2.0, "Its slightly bitter, very refreshing similiar to the average beer but slightly stronger", "no");


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

    public void insert(SQLiteDatabase db, String type, String name, double abv, String desc, String added) {
        ContentValues values = new ContentValues();


        values.put(COL_ALCOHOL_TYPE, type);
        values.put(COL_NAME, name);
        values.put(COL_ABV, abv);
        values.put(COL_DESCRIPTION, desc);
        values.put(COL_USER, added);

        db.insert(TABLE_NAME, null, values);

    }


    public int addItem(DrinksClass addedDrink) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COL_ALCOHOL_TYPE, addedDrink.getAlcoholType());
        values.put(COL_NAME, addedDrink.getName());
        values.put(COL_ABV, addedDrink.getABV());
        values.put(COL_DESCRIPTION, addedDrink.getDescription());
        values.put(COL_USER, addedDrink.getUser_drink());


        long id = db.insert(TABLE_NAME, null, values);

        return ((int) id);
    }

    public DrinksClass getDrinksClass(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = new String[]{COL_ID, COL_ALCOHOL_TYPE, COL_NAME, COL_ABV, COL_DESCRIPTION, COL_USER};

        String selection = COL_ID + " = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);
        cursor.moveToFirst();

        String alcoholType = cursor.getString(cursor.getColumnIndex(COL_ALCOHOL_TYPE));
        String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
        Double ABV = cursor.getDouble(cursor.getColumnIndex(COL_ABV));
        String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
        String user_drink = cursor.getString(cursor.getColumnIndex(COL_USER));

        return new DrinksClass(alcoholType, name, ABV, description, user_drink);
    }

    public int update(String alcoholType, String name, Double ABV, String description, String user_drink) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ALCOHOL_TYPE, alcoholType);
        values.put(COL_NAME, name);
        values.put(COL_ABV, String.valueOf(ABV));
        values.put(COL_DESCRIPTION, description);
        values.put(COL_USER, user_drink);
        long id = db.insert(TABLE_NAME, null, values);
        return ((int) id);
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();

        String selection = COL_ID + " = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        db.delete(TABLE_NAME, selection, selectionArgs);
    }

    //This is the query that gets All Drinks
    public Cursor getAllDrinks(String type) {

        SQLiteDatabase db = getReadableDatabase();

        //When ever a drink was entered into the database with the maker it will return the user_drink column as "no"
        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                COL_ALCOHOL_TYPE + " = ?" + " AND " + COL_USER + " = ?",
                new String[]{type, "no"},
                null,
                null,
                null,
                null);

        return cursor;

    }

    //This is the query that gets the User Added Drink
    public Cursor getUserDrinks() {

        SQLiteDatabase db = getReadableDatabase();

        //When ever a drink was entered into the database with the maker it will return the user_drink column as "yes"
        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                COL_USER + " = ?",
                new String[]{"yes"},
                null,
                null,
                null,
                null);

        return cursor;

    }

    //Use this method to search all by name or type or abv or description

    public Cursor searchAll(String query) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                COLUMN_SELECTION,
                COL_NAME + " LIKE ? OR " + COL_ALCOHOL_TYPE + " LIKE ? OR " + COL_ABV + " LIKE ? OR " + COL_DESCRIPTION + " LIKE ? ",
                new String[]{"%" + query + "%", "%" + query + "%", "%" + query + "%", "%" + query + "%"},
                null,
                null,
                null,
                null);


        return cursor;
    }

    //Use this method to get the name of the list item to display in ClickedDrinkItem
    public String getTitleByID(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COL_NAME},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_NAME));
        } else {
            return "No Description Found";
        }
    }

    //Use this method to get the name of the list item to display in ClickedDrinkItem
    public String getAbvByID(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COL_ABV},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_ABV));
        } else {
            return "No Description Found";
        }
    }

    //Use this method to get the name of the list item to display in ClickedDrinkItem
    public String getDescByID(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COL_DESCRIPTION},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
        } else {
            return "No Description Found";
        }
    }

}
