package me.mygram.models;

import java.util.ArrayList;

import me.mygram.controllers.services.MailService;

public interface GenericInbox {
	
	public int size();
	
	public void setMailService(MailService mailService);
	
	public void sync();
	
	public ArrayList<Conversation> getConversations();
	
	public Conversation getConversation(int index);
	
	public void refresh();
	
	public void deleteConversation(Conversation conversation);
	
	public GenericMessage getDraft();
	
	public void setDraft(GenericMessage draftMessage);

}
