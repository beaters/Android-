package com.lxg.root.musicplayer;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
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

import org.w3c.dom.Text;

import java.util.zip.Inflater;

import javax.xml.datatype.Duration;

public class MainActivity extends Activity {
    private ListView listview;
    private RelativeLayout ll;
    ImageView iv;
    Animation du;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Drawable drawable=getBaseContext().getDrawable(R.drawable.test);

        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listview);
        ll=(RelativeLayout)findViewById(R.id.linearLayout);
        iv=(ImageView)findViewById(R.id.imageview);
        TextView tv=(TextView)findViewById(R.id.exit);
        final View view=getLayoutInflater().inflate(R.layout.listview_layout,null);
        BaseAdapter ba=new BaseAdapter() {
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
        };
        listview.setAdapter(ba);
        du= AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation);
        iv.setAnimation(du);
    }

    public void test(TextView tv,Drawable dr)
    {
        dr.setBounds(0,0,dr.getMinimumWidth(),dr.getMinimumHeight());
        tv.setCompoundDrawables(dr,null,null,null);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
