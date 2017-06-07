package io.github.gao23.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static double totalEarnings = 0.00;
    private  ListView list;
    private ArrayList<Entry> todayEntry;
    private ArrayAdapter<Entry> entryArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        todayEntry = new ArrayList<Entry>();
        entryArrayAdapter = new entryAdaptor(this, todayEntry);
        list.setAdapter(entryArrayAdapter);
    }

    public void onClick(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, NewTipActivity.class);
        startActivityForResult(intent, intentCode.PASS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == intentCode.CHECK) {
            Entry entry = data.getParcelableExtra(intentCode.parb);
            todayEntry.add(entry);
            entryArrayAdapter.notifyDataSetChanged();
        }
        else{
            return;
        }
        }


}
