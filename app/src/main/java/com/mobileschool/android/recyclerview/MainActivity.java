package com.mobileschool.android.recyclerview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

//The main activity of this sample
public class MainActivity extends Activity {
	private RecyclerView recyclerView;
	private MyAdapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

		// use a linear layout manager
		mLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(mLayoutManager);

        // prepare the array of 100 items
        // this is not good practice to do on the mian thread but for our sample we'll keep it simple
		ArrayList<String> values = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			values.add("Test" + i);
		}

		// specify an adapter
		mAdapter = new MyAdapter(values);
		recyclerView.setAdapter(mAdapter);
	}
}