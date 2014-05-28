package me.mygram.models;

import java.util.Date;

public interface GenericMessage {

	public Object getSender();
	
	public void setSender(Object sender);
	
	public Object getReceiver();
	
	public void setReceiver(Object receiver);
	
	public String getMessageBody();
	
	public void setMessageBody(String body);
	
	public Date sentTimeStamp();
	
	public Date receivedTimeStamp();
	
	public MessageStatus status();
	
}
