package me.mygram.controllers.factories;

import android.content.Context;
import me.mygram.controllers.services.SpringboardService;

public class SpringboardServiceFactory {

	public static SpringboardService getSpringboardService(Context context) {
		return new SpringboardService(context);
	}
	

}
