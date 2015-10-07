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
    private static final Uri uri= Uri.parse("MediaStore.Audio.Media.EXTERNAL_CONTENT_URI");
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
    public List<musicInfo> getInfo()
    {
        ContentResolver cr=context.getContentResolver();
        Cursor cursor=cr.query(uri, projection, null, null, null);
        List<musicInfo> list=
    }
    public List<musicInfo> getInfo(Cursor cursor)
    {
        if(cursor==null)
        {
            return null;
        }
        ArrayList<musicInfo> arr=new ArrayList<musicInfo>();
        while (cursor.moveToNext())
        {
            musicInfo music=new musicInfo();
            music.
        }
    }
}
