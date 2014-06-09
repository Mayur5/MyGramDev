package me.mygram.models;

import java.util.Date;

public abstract class Message implements GenericMessage{
	
	public String toString(){
		return this.getBody();
	}

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
	public String getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBody(String body) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date sentTimeStamp() {
		// TODO Auto-generated method stub
		return new Date();
	}

	@Override
	public Date receivedTimeStamp() {
		// TODO Auto-generated method stub
		return new Date();
	}

	@Override
	public MessageStatus status() {
		// TODO Auto-generated method stub
		return null;
	}

}
