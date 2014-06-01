package me.mygram.controllers.adapters;

import com.example.mygrammockup.R;

import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Message;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ConversationViewAdapter extends ArrayAdapter<Message> {
	
	private Context context;
	private Conversation conversation;

	public ConversationViewAdapter(Context context, int resource, Conversation conversation) {
		super(context, resource, conversation.getMessages());
		this.context = context;
		this.conversation = conversation;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		Contact correspondent = (Contact) conversation.getMessageAt(position).getCorrespondent();
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.conversation_item, parent, false);
		TextView textView = (TextView)rowView.findViewById(R.id.message_text);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.conversation_profile_pic);
		textView.setText(conversation.getMessageAt(position).toString());
		imageView.setImageResource(correspondent.getProfilePic());
		
		if (correspondent.getFirstName().equals("Harini")) {
			RelativeLayout.LayoutParams textViewParams = (RelativeLayout.LayoutParams)textView.getLayoutParams();
			textViewParams.addRule(RelativeLayout.LEFT_OF, 0);
			textViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);;
			textView.setLayoutParams(textViewParams);
			
			RelativeLayout.LayoutParams imageViewParams = (RelativeLayout.LayoutParams)imageView.getLayoutParams();
			//imageViewParams.addRule(RelativeLayout.RIGHT_OF, R.id.message_text);
			imageViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			imageView.setLayoutParams(imageViewParams);
		}
		
		return rowView;
	}
}
