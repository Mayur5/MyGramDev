package me.mygram.models;

import me.mygram.controllers.services.MailService;
import me.mygram.example.controllers.adapters.InboxViewAdapter;
import android.app.Application;

public class Mygram extends Application {
	private MailService mailService;
	private boolean registered = false;
	private Credentials credentials;
	private InboxViewAdapter adapter;
	
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

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public InboxViewAdapter getInboxAdapter() {
		return adapter;
	}

	public void setInboxAdapter(InboxViewAdapter adapter) {
		this.adapter = adapter;
	}
	
	
}
