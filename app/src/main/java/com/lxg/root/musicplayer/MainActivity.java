package com.lxg.root.musicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxg.root.model.musicInfo;
import com.lxg.root.service.musicService;
import com.lxg.root.unti.MusicUtil;


import java.util.List;

/*
* @author lxg
* */
public class MainActivity extends Activity {
    public static int music_state=0; //0表示不在播放,1表示正在播放
    private ListView listview,musicListView;
    private RelativeLayout ll;
    ImageView iv;
    private View view;
    private ImageButton last,next,start;
    private List<musicInfo> music;
    private TextView musicName,musician;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listview);
        musicListView=(ListView)findViewById(R.id.musicList);
        ll=(RelativeLayout)findViewById(R.id.linearLayout);
        iv=(ImageView)findViewById(R.id.imageview);
        TextView tv=(TextView)findViewById(R.id.exit);
        view=getLayoutInflater().inflate(R.layout.listview_layout,null);
        musicName=(TextView)findViewById(R.id.MusicName);
        musician=(TextView)findViewById(R.id.Musician);

        last=(ImageButton)findViewById(R.id.last);
        next=(ImageButton)findViewById(R.id.next);
        start=(ImageButton)findViewById(R.id.start_stop);

        music=new MusicUtil(getApplicationContext()).getInfo();  //获取music列表

        /*
        * set the Adapter to the lists
        * */

        listview.setAdapter(new leftAddapter());
        musicListView.setAdapter(new MyAdapter());
        start.setOnClickListener(new StartListener());
    }


    public class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return music.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.music_list,parent);
            musicName.setText(music.get(position).musicName);
            musician.setText(music.get(position).artist+"-"+music.get(position).album);
            view.setOnClickListener(new Play());
            return view;
        }
    }

    public class leftAddapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return view;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main,menu);
        menu.add(0,0,1,"exit");
        menu.getItem(0).setIcon(R.drawable.exit);
        return true;
    }


    public class Play implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            new musicService(getApplicationContext()).playByPosition(v.getId());
            changeState();
        }
    }
    public void change_BG()
    {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       switch(id)
       {
           case R.id.exit:
               System.exit(0);
               break;
       }

        return super.onOptionsItemSelected(item);
    }


    public class StartListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            if(music_state==0)
            {
                start.setImageResource(R.drawable.music_play_button);
                new musicService(getApplicationContext()).playByPosition();
            }
        }
    }
    public void changeState()
    {
        if(music_state==0)
        {
            start.setImageResource(R.drawable.music_play_button);
        }else {
            start.setImageResource(R.drawable.music_pause_button);
        }
    }

}
