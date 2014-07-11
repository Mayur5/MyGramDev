package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.models.Conversation;
import me.mygram.models.Message;

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
