package me.mygram.controllers.adapters;

import com.example.mygrammockup.R;
import com.example.mygrammockup.R.drawable;
import com.example.mygrammockup.R.id;
import com.example.mygrammockup.R.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InboxAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;
	
	public InboxAdapter(Context context, String[] values) {
		super(context, R.layout.inbox_item, values);
		this.context = context;
		this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.inbox_item, parent, false);
		TextView textView = (TextView)rowView.findViewById(R.id.conversation_snippet);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.profile_pic);
		textView.setText(values[position]);
		imageView.setImageResource(R.drawable.from);
		
		return rowView;
		
	}
}
