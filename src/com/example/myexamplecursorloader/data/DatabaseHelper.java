
package com.example.myexamplecursorloader.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * old version TODO max 100 record process Place table query
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //@formatter:off
    private static final String CREATE_PLACE_TABLE_SQL = "CREATE TABLE "
    + PlaceManager.TABLE_PLACE + "("
    + PlaceManager.Place.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
    + PlaceManager.Place.KEY_PLACE_ID + " TEXT UNIQUE NOT NULL,"
    + PlaceManager.Place.KEY_PLACE + " TEXT,"
    + PlaceManager.Place.KEY_URL + " TEXT"
    + ")";

     static final String[] COL_ARRAY = {
        PlaceManager.Place.KEY_ID,
        PlaceManager.Place.KEY_PLACE_ID,
        PlaceManager.Place.KEY_PLACE,
        PlaceManager.Place.KEY_URL
    };
    //@formatter:on
    private static final String DROP_PLACE_TABLE_SQL = "DROP TABLE IF EXISTS "
            + PlaceManager.TABLE_PLACE;

    public DatabaseHelper(Context context) {
        super(context, PlaceManager.DATABASE_NAME, null, PlaceManager.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PLACE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL(DROP_PLACE_TABLE_SQL);

        // Create tables again
        onCreate(db);
    }
}
