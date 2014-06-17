package me.mygram.controllers.factories;

import android.content.Context;
import me.mygram.controllers.services.MailService;
import me.mygram.models.Mygram;

public abstract class MailServiceFactory {

	public static MailService getMailService(Context context) {
		// TODO Auto-generated method stub
		Mygram mygram = (Mygram)context.getApplicationContext();
		return mygram.getMailService();
	}

}
