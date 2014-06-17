package me.mygram.models;

import me.mygram.controllers.services.MailService;
import android.app.Application;

public class Mygram extends Application {
	private MailService mailService;
	
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
}
