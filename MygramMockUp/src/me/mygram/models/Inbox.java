package me.mygram.models;

import java.util.ArrayList;

public class Inbox implements GenericInbox{
	

	ArrayList<Conversation> conversations;
	
	public Inbox(ArrayList<Conversation> conversations) {
		super();
		this.conversations = conversations;
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
