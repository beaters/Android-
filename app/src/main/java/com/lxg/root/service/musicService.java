package com.lxg.root.service;

import android.content.Context;
import android.media.MediaPlayer;

import com.lxg.root.unti.MusicUtil;

/**
 * Created by root on 15-10-8.
 */
public class musicService {
    private MediaPlayer mp=new MediaPlayer();
    private Context context;
    public musicService(Context context)
    {
        this.context=context;
    }

    public void playByPosition(int position)
    {
        try {
            mp.setDataSource(new MusicUtil(context).getInfo().get(position).data);
            mp.prepare();
        }catch(java.io.IOException EX)
        {
            EX.printStackTrace();
        }

    }

}
