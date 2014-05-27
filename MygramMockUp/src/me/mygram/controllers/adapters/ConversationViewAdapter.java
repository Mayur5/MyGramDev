package me.mygram.controllers.adapters;

import java.util.List;

import me.mygram.models.Message;
import android.content.Context;
import android.widget.ArrayAdapter;

public class ConversationViewAdapter extends ArrayAdapter<Message> {

	public ConversationViewAdapter(Context context, int resource,
			List<Message> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

}
