package com.mobileschool.android.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//The secondary activity in this sample
public class ItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", -1);
        // make sure you received data from the main activity
        if (pos > -1) {
            TextView firstLine = (TextView) findViewById(R.id.itemFirstLine);
            firstLine.setText(String.valueOf(pos));
        }
    }
}
