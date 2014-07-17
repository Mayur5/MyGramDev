package me.mygram.models;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.controllers.services.MailService;

public class Inbox implements GenericInbox{
	

	ArrayList<Conversation> conversations = new ArrayList<Conversation>();
	MailService mailService;
	
	public Inbox() {
		super();
	}
	
	public Inbox(ArrayList<Conversation> conversations) {
		super();
		this.conversations = conversations;
	}

	@Override
	public void setMailService(MailService mailService) {
		// TODO Auto-generated method stub
		this.mailService = mailService;
	}

	@Override
	public void sync(Context context) {
		// TODO Auto-generated method stub
		this.conversations = mailService.sync(conversations, context);
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Conversation> getConversations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conversation getConversation(int index) {
		// TODO Auto-generated method stub
		return conversations.get(index);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenericMessage getDraft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDraft(GenericMessage draftMessage) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Conversation> asConversationArray() {
		// TODO Auto-generated method stub
		return conversations;
	}

}
