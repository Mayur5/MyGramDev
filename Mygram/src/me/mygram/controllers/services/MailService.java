package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.R;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.EmailMessage;
import me.mygram.models.Mail;
import me.mygram.models.Message;
import me.mygram.models.Notification;
import me.mygram.models.SMS;

public class MailService implements GenericMailService{
	
	Context context;
	ArrayList<Conversation> conversations = new ArrayList<Conversation>();
	
	public MailService(){
		super();
	}

	public MailService(Context context) {
		super();
		this.context = context;
	}

	@Override
	public ArrayList<Conversation> sync(ArrayList<Conversation> conversations) {
		// Dummy sync implemented - TODO
		if(conversations.size() == 0) {
			conversations = dummyConversations();
		}
		
		return conversations;
	}

	private ArrayList<Conversation> dummyConversations() {
		final int from=R.drawable.from;
        final int jamesh_bond=R.drawable.jamesh_bond;
        final int love_smiley=R.drawable.love_smiley;
        final int notification1=R.drawable.notification1;
        final int notification2=R.drawable.notification2;
        final int notification3=R.drawable.notification3;
        final int pic1=R.drawable.pic1;
        final int pic4=R.drawable.pic4;
        final int pic5=R.drawable.ic_launcher;
        final int pic6=R.drawable.pic6;
        final int thumbs_up=R.drawable.thumbs_up;
		
		
		
		return conversations;
	}

	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		conversations.add(0, conversation);
	}

}
