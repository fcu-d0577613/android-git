package com.example.acc0752001.seefood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Grid_Activity  extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_);

        Intent intent = getIntent();
        int [] ids = intent.getIntArrayExtra("KEY_IDS");
        int cols = intent.getIntExtra("KEY_COLUMNS", 3);

        Integer [] imglist = new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            imglist[i] = Integer.valueOf(ids[i]);
        }

        GridView gv = (GridView)findViewById(R.id.gv);
        gv.setNumColumns(cols);
        gv.setAdapter(new ImageAdapter(this, imglist));
    }

    public class ImageAdapter extends ArrayAdapter<Integer> {
        private Context mCtx;

        public ImageAdapter(Context c, Integer [] imglist) {
            super(c, 0, imglist);
            mCtx = c;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(mCtx);
            int resid = getItem(position);
            iv.setImageResource(resid);
            iv.setAdjustViewBounds(true);
            return iv;
        }
    }


}
