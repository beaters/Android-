package com.lxg.root.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 15-10-7.
 */
public class musicInfo implements Parcelable{
    public final static String KEY_MUSIC= "music";

    public static final String KEY_ID = "_id";
    public static final String KEY_SONG_ID = "songid";
    public static final String KEY_ALBUM_ID = "albumid";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_MUSIC_NAME = "musicname";
    public static final String KEY_ARTIST = "artist";
    public static final String KEY_DATA = "data";
    public static final String KEY_FOLDER = "folder";
    public static final String KEY_MUSIC_NAME_KEY = "musicnamekey";
    public static final String KEY_ARTIST_KEY = "artistkey";
    public static final String KEY_FAVORITE = "favorite";


    public int _id = -1;
    public int songId = -1;
    public int albumId = -1;
    public int duration;
    public String musicName;
    public String artist;
    public String data;
    public String folder;
    public String musicNameKey;
    public String artistKey;

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ID, _id);
        bundle.putInt(KEY_SONG_ID, songId);
        bundle.putInt(KEY_ALBUM_ID, albumId);
        bundle.putInt(KEY_DURATION, duration);
        bundle.putString(KEY_MUSIC_NAME, musicName);
        bundle.putString(KEY_ARTIST, artist);
        bundle.putString(KEY_DATA, data);
        bundle.putString(KEY_FOLDER, folder);
        bundle.putString(KEY_MUSIC_NAME_KEY, musicNameKey);
        dest.writeBundle(bundle);
    }

    public static final Parcelable.Creator<musicInfo> CREATOR = new Parcelable.Creator<musicInfo>() {

        @Override
        public musicInfo createFromParcel(Parcel source) {
            musicInfo music = new musicInfo();
            Bundle bundle = new Bundle();
            bundle = source.readBundle();
            music._id = bundle.getInt(KEY_ID);
            music.songId = bundle.getInt(KEY_SONG_ID);
            music.albumId = bundle.getInt(KEY_ALBUM_ID);
            music.duration = bundle.getInt(KEY_DURATION);
            music.musicName = bundle.getString(KEY_MUSIC_NAME);
            music.artist = bundle.getString(KEY_ARTIST);
            music.data = bundle.getString(KEY_DATA);
            music.folder = bundle.getString(KEY_FOLDER);
            music.musicNameKey = bundle.getString(KEY_MUSIC_NAME_KEY);
            return music;
        }

        @Override
        public musicInfo[] newArray(int size) {
            return new musicInfo[size];
        }
    };


}
