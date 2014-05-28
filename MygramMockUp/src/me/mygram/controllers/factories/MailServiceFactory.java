package me.mygram.controllers.factories;

import android.content.Context;
import me.mygram.controllers.services.MailService;

public abstract class MailServiceFactory {

	public static MailService getMailService(Context context) {
		// TODO Auto-generated method stub
		return new MailService(context);
	}

}
