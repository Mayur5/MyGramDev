package me.mygram.models;

import java.util.ArrayList;

public interface GenericInbox {
	
	public int size();
	
	public ArrayList<Conversation> getConversations();
	
	public Conversation getConversation(int index);
	
	public void refresh();
	
	public void deleteConversation(Conversation conversation);
	
	public GenericMessage getDraft();
	
	public void setDraft(GenericMessage draftMessage);

}
