package me.mygram.controllers.adapters;

import com.example.mygrammockup.R;

import me.mygram.models.Conversation;
import me.mygram.models.Inbox;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InboxViewAdapter extends ArrayAdapter<Conversation> {
	
	private final Context context;
	private final Inbox inbox;

	public InboxViewAdapter(Context context, int resource, Inbox inbox) {
		super(context, resource, inbox.asConversationArray());
		this.context = context;
		this.inbox = inbox;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.inbox_item, parent, false);
		TextView textView = (TextView)rowView.findViewById(R.id.conversation_snippet);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.profile_pic);
		textView.setText(inbox.getConversation(position).getSnippet());
		imageView.setImageResource(R.drawable.from);
		
		return rowView;
		
	}

}
