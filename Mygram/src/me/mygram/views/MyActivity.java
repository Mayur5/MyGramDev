package me.mygram.views;

import me.mygram.controllers.factories.MailServiceFactory;
import me.mygram.controllers.factories.SpringboardServiceFactory;
import me.mygram.controllers.services.MailService;
import me.mygram.controllers.services.SpringboardService;
import me.mygram.models.Mygram;
import android.app.Activity;
import android.os.Bundle;

public abstract class MyActivity extends Activity implements MygramActivity{

	@Override
	protected abstract void onCreate(Bundle savedInstanceState);

	@Override
	protected abstract void onResume();
	
	protected void onCreateParentMethod(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	protected void onResumeParentMethod() {
		super.onResume();
	}

	@Override
	public Mygram getApp() {
		// TODO Auto-generated method stub
		return (Mygram)getApplicationContext();
	}

	@Override
	public Boolean isRegistered() {
		// TODO Auto-generated method stub
		return getApp().isRegistered();
	}
	
	public void setRegistered(Boolean status) {
		getApp().setRegistered(status);
	}

	@Override
	public MailService getMailService() {
		// TODO Auto-generated method stub
		return MailServiceFactory.getMailService(getApp());
	}

	@Override
	public SpringboardService getSpringboardService() {
		// TODO Auto-generated method stub
		return SpringboardServiceFactory.getSpringboardService(getApp());
	}
	
	
	
}
