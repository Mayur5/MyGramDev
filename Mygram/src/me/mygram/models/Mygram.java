package me.mygram.models;

import me.mygram.controllers.services.MailService;
import android.app.Application;

public class Mygram extends Application {
	private MailService mailService;
	private boolean registered = false;
	private Credentials credentials;
	
	public Mygram(){
		super();
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mailService = new MailService();
	}
	
	public MailService getMailService() {
		return mailService;
	}

	public boolean isRegistered() {
		return registered;
	}

	public Mygram setRegistered(boolean registered) {
		this.registered = registered;
		return this;
	}
}
