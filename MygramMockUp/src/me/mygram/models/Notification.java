package me.mygram.models;

import java.io.Serializable;

public class Notification extends NotificationMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5499079142771347787L;

	public Notification(String body) {
		this.setBody(body);
	}

	@Override
	public boolean isEmail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSMS() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNotification() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
