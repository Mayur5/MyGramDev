package me.mygram.models;

import java.io.Serializable;

public class SMS extends SMSMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1487310406135836813L;

	public SMS(String body) {
		// TODO Auto-generated constructor stub
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
		return true;
	}

	@Override
	public boolean isNotification() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
