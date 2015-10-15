package com.lxg.root.unti;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.lxg.root.model.musicInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 15-10-7.
 */
public class MusicUtil {
    private static final Uri uri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    private Context context;
    private String [] projection=new String []
            {
                MediaStore.Audio.Media._ID,MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.ARTIST,
                    MediaStore.Audio.Media.ALBUM_ID
    };
    public MusicUtil(Context context)
    {
        this.context=context;
    }

    //获取音乐相关信息
    public List<musicInfo> getInfo()
    {
        ContentResolver cr=context.getContentResolver();
        Cursor cursor=cr.query(uri, projection, null, null, null);
        List<musicInfo> list=getInfo(cursor);
        return list;
    }


   //解析获取的cursor
    public List<musicInfo> getInfo(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList<musicInfo> arr = new ArrayList<musicInfo>();
        while (cursor.moveToNext()) {
            musicInfo music = new musicInfo();
            music._id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID)));
            music.data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            music.duration = Integer.parseInt(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)));
            arr.add(music);
        }
        return arr;
    }
}
