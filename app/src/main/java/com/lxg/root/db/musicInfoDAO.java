package com.lxg.root.db;
import com.lxg.root.db.datebaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lxg.root.model.musicInfo;

import java.util.List;

/**
 * Created by root on 15-10-8.
 */
public class musicInfoDAO {
    private Context context;
    private static final String TABLE_MUSIC="music_info";
    public musicInfoDAO(Context context)
    {
        this.context=context;
    }

    public void saveToDB(List<musicInfo> list)
    {
        SQLiteDatabase sql=datebaseHelper.getInstance(context);
        for(musicInfo mi:list)
        {
            ContentValues cv=new ContentValues();
            cv.put("song_id",mi._id);
            cv.put("song_data",mi.data);
            cv.put("song_duration",mi.duration);
            sql.insert(TABLE_MUSIC,null,cv);
        }
    }

    public boolean hasData()
    {
        SQLiteDatabase db=datebaseHelper.getInstance(context);
        String sql="select * from"+TABLE_MUSIC;
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToNext())
        {
            return true;
        }
        else return false;
    }
}
