package me.mygram.models;

import java.util.Date;

public abstract class GenericNotification implements GenericMessage {

	@Override
	public Object getSender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSender(Object sender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getReceiver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReceiver(Object receiver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMessageBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessageBody(String body) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date sentTimeStamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date receivedTimeStamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageStatus status() {
		// TODO Auto-generated method stub
		return null;
	}	

}
