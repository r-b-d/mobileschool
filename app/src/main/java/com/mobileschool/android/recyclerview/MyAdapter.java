package com.mobileschool.android.recyclerview;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

//Custom adapter for the RecyclerView
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private ArrayList<String> values;
    public Context context;

	// Provide a reference to the views for each data item
	public class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		public TextView txtHeader;
		public TextView txtFooter;
		public View layout;


		public ViewHolder(View v) {
			super(v);
			layout = v;
			txtHeader = (TextView) v.findViewById(R.id.firstLine);
			txtFooter = (TextView) v.findViewById(R.id.secondLine);
            context = v.getContext();
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(ArrayList<String> myDataset) {
		values = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {
		// create a new view
		LayoutInflater inflater = LayoutInflater.from(
				parent.getContext());
		View v = 
				inflater.inflate(R.layout.rowlayout, parent, false);
		// set the view's size, margins, paddings and layout parameters
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		final String name = values.get(position);
		holder.txtHeader.setText(name);
		holder.txtHeader.setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View v) {
                    Intent intent = new Intent(context, ItemActivity.class);

                    // another way to get the start the intent (the holder need to be final
                    //Intent intent = new Intent(holder.txtHeader.getContext(), ItemActivity.class);

                    intent.putExtra("position", position);
                    context.startActivity(intent);
		        }
		    });
		
		holder.txtFooter.setText("Footer: " + name);
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return values.size();
	}

}