package me.mygram.models;

import java.io.Serializable;

public class Mail extends EmailMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2345844610198017768L;

	public Mail(String body) {
		// TODO Auto-generated constructor stub
		this.setBody(body);
	}

	@Override
	public boolean isEmail() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSMS() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNotification() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
