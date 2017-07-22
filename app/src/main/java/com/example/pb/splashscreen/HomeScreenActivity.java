package com.example.pb.splashscreen;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class HomeScreenActivity extends FragmentActivity {

    private final int listSize = 20;
    private TextView footer;
    private TextView header;
    private ColorFilter defaultBackgroundColor;
    private int defaultTextColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] listValues = new String[listSize];

        for(int i = 0; i < listSize; i++) {
            listValues[i] = new String("Item " + (i + 1));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listValues);

        setListAdapter(adapter);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomeScreenActivity.this, "Long click on " + (position + 1), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        getListView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // touch
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(HomeScreenActivity.this, "Touched", Toast.LENGTH_SHORT);

                }
                // untouch
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Toast.makeText(HomeScreenActivity.this, "Untouched", Toast.LENGTH_SHORT);
                }
                return false;
            }
        });


        if (savedInstanceState == null) {
            Intent intent = new Intent(HomeScreenActivity.this, SplashScreenActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
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
