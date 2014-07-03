package me.mygram.views;

import me.mygram.controllers.services.MailService;
import me.mygram.controllers.services.SpringboardService;
import me.mygram.models.Mygram;

public interface MygramActivity {
	
	public Boolean isRegistered();
	
	public Mygram getApp();
	
	public MailService getMailService();
	
	public SpringboardService getSpringboardService();

}
