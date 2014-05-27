package me.mygram.controllers.adapters;

import java.util.List;

import me.mygram.models.Message;
import android.content.Context;
import android.widget.ArrayAdapter;

public class ConversationAdapter extends ArrayAdapter<Message> {

	public ConversationAdapter(Context context, int resource,
			List<Message> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

}
