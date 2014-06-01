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
	
}
