package com.lxg.root.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 15-10-7.
 */
public class datebaseHelper extends SQLiteOpenHelper {
    private static SQLiteDatabase mDb;
    private static datebaseHelper mHelper;
    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "musicstore_new";
    private static final String TABLE_ALBUM = "album_info";
    private static final String TABLE_ARTIST = "artist_info";
    private static final String TABLE_MUSIC = "music_info";
    private static final String TABLE_FOLDER = "folder_info";
    private static final String TABLE_FAVORITE = "favorite_info";

    public static  SQLiteDatabase getInstance(Context context)
    {
        if(mDb==null)
        {
            getHelper(context).getWritableDatabase();
        }
        return mDb;
    }
    public static datebaseHelper getHelper(Context context)
    {
        if(mHelper==null)
        {
            mHelper=new datebaseHelper(context);
        }
        return mHelper;
    }
    public datebaseHelper(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                + TABLE_MUSIC
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " songid integer, albumid integer, duration integer, musicname varchar(10), "
                + "artist char, data char, folder char, musicnamekey char, artistkey char, favorite integer)");
        db.execSQL("create table "
                + TABLE_ALBUM
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "album_name char, album_id integer, number_of_songs integer, album_art char)");
        db.execSQL("create table "
                + TABLE_ARTIST
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, artist_name char, number_of_tracks integer)");
        db.execSQL("create table "
                + TABLE_FOLDER
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, folder_name char, folder_path char)");
        db.execSQL("create table "
                + TABLE_FAVORITE
                + " (_id integer,"
                + " songid integer, albumid integer, duration integer, musicname varchar(10), "
                + "artist char, data char, folder char, musicnamekey char, artistkey char, favorite integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTIST);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALBUM);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSIC);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOLDER);
            onCreate(db);
        }
    }
}
