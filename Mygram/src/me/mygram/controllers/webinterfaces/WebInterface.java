package me.mygram.controllers.webinterfaces;

import android.content.Context;
import android.widget.Toast;

public class WebInterface {
	
	private Context mContext;
	
	public WebInterface(Context mContext) {
		super();
		this.mContext = mContext;
	}
	
	public void submit(String data) {
		Toast.makeText(mContext, data, Toast.LENGTH_SHORT);
	}

}
