package com.example.acc0752001.seefood;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private Intent intent = new Intent();
    private Button random;

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

        random = (Button)this.findViewById(R.id.random);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = random();
                choose(number);
            }
        });

    }

    protected void onListItemClick(ListView l,View v ,int position , long id){
        super.onListItemClick(l,v,position,id);

        int [] imageIds = null;
        int [] imageIds2 = null;
        int columns = 2;
        switch (position){
            case  0 :
                imageIds = new int[10];
                imageIds[0] = R.drawable.hm001;
                imageIds[1] = R.drawable.hm002;
                imageIds[2] = R.drawable.hm003;
                imageIds[3] = R.drawable.hm004;
                imageIds[4] = R.drawable.hm005;
                imageIds[5] = R.drawable.hm006;
                imageIds[6] = R.drawable.hm007;
                imageIds[7] = R.drawable.hm008;
                imageIds[8] = R.drawable.hm009;
                imageIds[9] = R.drawable.hm010;
                break;

            case  1:
                imageIds = new int[10];
                imageIds[0] = R.drawable.lun001;
                imageIds[1] = R.drawable.lun002;
                imageIds[2] = R.drawable.lun003;
                imageIds[3] = R.drawable.lun004;
                imageIds[4] = R.drawable.lun005;
                imageIds[5] = R.drawable.lun006;
                imageIds[6] = R.drawable.lun007;
                imageIds[7] = R.drawable.lun008;
                imageIds[8] = R.drawable.lun009;
                imageIds[9] = R.drawable.lun010;
                break;

            case 2:
                imageIds = new int[6];
                imageIds[0] = R.drawable.restaurant001;
                imageIds[1] = R.drawable.restaurant002;
                imageIds[2] = R.drawable.restaurant003;
                imageIds[3] = R.drawable.restaurant004;
                imageIds[4] = R.drawable.restaurant005;
                imageIds[5] = R.drawable.restaurant006;
                break;

            default:
                break;

        }
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Grid_Activity.class);
        intent.putExtra("KEY_IDS",imageIds);
        intent.putExtra("KEY_COLUMNS",columns);
        startActivity(intent);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.auther:
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("作者群");
                ad.setMessage("作者:林承毅");
                ad.setMessage("作者:李浩維");
                ad.setMessage("作者:陳陸彥");
                ad.setMessage("作者:陳贊年");


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

    public int random(){
        int num = (int)(Math.random() *5);
        return num;
    }
    public void choose(int num){
        switch (num){
            case 0:
                intent.setClass(MainActivity.this,Restaurant1.class);
                startActivity(intent);
                break;

            case 1:
                intent.setClass(MainActivity.this,Restaurant2.class);
                startActivity(intent);
                break;

            case 2:
                intent.setClass(MainActivity.this,Restaurant3.class);
                startActivity(intent);
                break;

            case 3:
                intent.setClass(MainActivity.this,Restaurant4.class);
                startActivity(intent);
                break;

            case 4:
                intent.setClass(MainActivity.this,Restaurant5.class);
                startActivity(intent);
                break;
        }
    }
}
