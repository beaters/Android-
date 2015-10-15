package com.lxg.root.musicplayer;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxg.root.model.musicInfo;
import com.lxg.root.unti.MusicUtil;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

import javax.xml.datatype.Duration;

public class MainActivity extends Activity {
    private ListView listview,musicListView;
    private RelativeLayout ll;
    ImageView iv;
    private View view;

    private List<musicInfo> music;
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

        music=new MusicUtil(getApplicationContext()).getInfo();  //获取music列表

        /*
        * set the Adapter to the lists
        * */

        listview.setAdapter(new leftAddapter());
        musicListView.setAdapter(new MyAdapter());
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
            LinearLayout linearLayout=new LinearLayout(getApplicationContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

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

        return true;
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
           case R.id.action_settings:



               break;
           case R.id.exit:
               System.exit(0);
               break;
       }

        return super.onOptionsItemSelected(item);
    }


}
