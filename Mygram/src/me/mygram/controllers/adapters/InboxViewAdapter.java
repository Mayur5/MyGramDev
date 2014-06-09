package me.mygram.controllers.adapters;

import java.text.DateFormat;

import me.mygram.R;
import me.mygram.models.Conversation;
import me.mygram.models.Inbox;
import me.mygram.models.Mail;
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
		Conversation c = inbox.getConversation(position);
		DateFormat df = DateFormat.getDateInstance();
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.inbox_item, parent, false);
		TextView snippetTextView = (TextView)rowView.findViewById(R.id.conversation_snippet);
		TextView correspondentNameTextView = (TextView)rowView.findViewById(R.id.correspondent_name_inbox);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.profile_pic);
		ImageView messageTypeImageView = (ImageView)rowView.findViewById(R.id.message_type);
		TextView timeStampTextView = (TextView)rowView.findViewById(R.id.inbox_message_time_stamp);
		
		snippetTextView.setText(c.getSnippet());
		correspondentNameTextView.setText(c.getCorrespondent().getFullName());
		imageView.setImageResource(c.getCorrespondent().getProfilePic());
		timeStampTextView.setText(df.format(c.getLastMessage().receivedTimeStamp()));
		
		if(c.getLastMessage().isEmail()) {
			Mail e = (Mail)c.getLastMessage();
			messageTypeImageView.setImageResource(R.drawable.email_temp);
			if(e.hasAttachment()) {
				String attachmentType = e.getAttachmentType();
				ImageView attachmentTypeView = (ImageView)rowView.findViewById(R.id.attachment_type);
				if(attachmentType.equalsIgnoreCase("image")) {
					attachmentTypeView.setImageResource(R.drawable.photo);
				} else if (attachmentType.equalsIgnoreCase("audio")) {
					attachmentTypeView.setImageResource(R.drawable.audio);
				} else if (attachmentType.equalsIgnoreCase("video")) {
					attachmentTypeView.setImageResource(R.drawable.video);
				} else if (attachmentType.equalsIgnoreCase("file")) {
					attachmentTypeView.setImageResource(R.drawable.file);
				}
			}
		} else if (c.getLastMessage().isNotification()) {
			messageTypeImageView.setImageResource(R.drawable.ic_launcher);
		} else if (c.getLastMessage().isSMS()) {
			messageTypeImageView.setImageResource(R.drawable.sms_reverse);
		}
		
		return rowView;
		
	}

}
