package com.example.pb.splashscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HomeScreenActivity extends AppCompatActivity {
    private static final int LIST_ITEM_COUNT = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ListView listView = (ListView) findViewById(R.id.item_list);

        String[] listValues = new String[LIST_ITEM_COUNT];
        for(int i = 0; i < LIST_ITEM_COUNT; i++) {
            listValues[i] = "Item " + (i + 1);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listValues);
        listView.setAdapter(adapter);
    }
}
