package me.mygram.models;

import java.util.Date;

public interface GenericMessage {
	
	public String typeOfMessage();
	
	public String toString();

	public Object getSender();
	
	public void setSender(Object sender);
	
	public Object getReceiver();
	
	public void setReceiver(Object receiver);
	
	public Date sentTimeStamp();
	
	public Date receivedTimeStamp();
	
	public MessageStatus status();

	String getBody();

	void setBody(String body);
	
}
