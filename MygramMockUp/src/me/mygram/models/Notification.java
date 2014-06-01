package me.mygram.models;

import java.io.Serializable;

public class Notification extends NotificationMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5499079142771347787L;

	public Notification(String body) {
		super();
		this.setBody(body);
	}
}
