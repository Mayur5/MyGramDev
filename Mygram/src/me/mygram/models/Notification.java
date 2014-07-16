package me.mygram.models;

import java.io.Serializable;

public class Notification extends NotificationMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5499079142771347787L;
	private int attachment = 0;

	public Notification(String body) {
		super();
		this.setBody(body);
	}

	public int getAttachment() {
		return attachment;
	}

	public MyMessage setAttachment(int attachment) {
		this.attachment = attachment;
		return this;
	}
	
	public boolean hasAttachment() {
		if(attachment == 0) {
			return false;
		}
		return true;
	}
	
	
}
