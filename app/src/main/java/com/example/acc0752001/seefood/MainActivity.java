package com.example.acc0752001.seefood;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DialogTitle;
import android.support.v7.widget.Toolbar;
import android.text.AlteredCharSequence;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        ArrayList<String> albumlist = new ArrayList<String>();

        albumlist.add("早餐");
        albumlist.add("午餐");
        albumlist.add("晚餐");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listitem, R.id.tv_listitem,albumlist);
        setListAdapter(adapter);


    }

    protected void onListItemClick(ListView l,View v ,int position , long id){
        super.onListItemClick(l,v,position,id);

        int [] imageIds = null;
        int columns = 3;
        switch (position){
            case  0 :
                imageIds = new int[5];
                imageIds[0] = R.drawable.hm001;
                imageIds[0] = R.drawable.hm002;
                imageIds[0] = R.drawable.hm003;
                imageIds[0] = R.drawable.hm004;
                imageIds[0] = R.drawable.hm005;
                columns = 2;
                break;

            case  1:
                imageIds = new int[5];
                imageIds[0] = R.drawable.lun001;
                imageIds[0] = R.drawable.lun002;
                imageIds[0] = R.drawable.lun003;
                imageIds[0] = R.drawable.lun004;
                imageIds[0] = R.drawable.lun005;
                break;

        }
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,GridActivity.class);
        intent.putExtra("KEY_IDS",imageIds);
        intent.putExtra("KEY_COLUMNS",columns);
        startActity(intent);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.auther:
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("作者群");
                ad.setMessage("作者:林承毅");

                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                };

                ad.setPositiveButton("確定", listener);
                ad.show();
                break;

            case R.id.action_quit:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
