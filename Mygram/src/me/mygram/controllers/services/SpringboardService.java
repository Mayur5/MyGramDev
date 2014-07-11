package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.R;
import me.mygram.models.Vendor;

public class SpringboardService implements GenericSpringboardService{
	private ArrayList<Vendor> roster = new ArrayList<Vendor>();
	private Context context;
	
	public SpringboardService(Context context) {
		super();
		this.context = context;
	}

	@Override
	public ArrayList<Vendor> sync() {
		final int amazon_icon=R.drawable.amazon_icon;
		final int blur_icon=R.drawable.blur_icon;
		final int dropbox_icon=R.drawable.dropbox_icon;
		final int instagram_icon=R.drawable.instagram_icon;
		final int irctc_icon=R.drawable.irctc;
		final int flipkart_icon=R.drawable.flipkart;
		
		
		roster.add(new Vendor("Flipkart").setIcon(flipkart_icon).setDescription("Everything from Fashion to \nCellphones and electronics!").setUrl("file:///android_asset/flipkart.html"));
		roster.add(new Vendor("IRCTC").setIcon(irctc_icon).setDescription("Book train tickets \non Indian Railways").setUrl("file:///android_asset/krishiSoochana.html"));
		roster.add(new Vendor("Instagram").setIcon(instagram_icon).setDescription("This is a description \nof instagram").setUrl("file:///android_asset/mandi.html"));
		roster.add(new Vendor("Dropbox").setIcon(dropbox_icon).setDescription("This is a description of dropbox").setUrl("file:///android_asset/jobPortal.html"));
		roster.add(new Vendor("Blur").setIcon(blur_icon).setDescription("This is a description \nof blur").setUrl("file:///android_asset/flipkart.html"));
		roster.add(new Vendor("Amazon").setIcon(amazon_icon).setDescription("This is a description \nof amazon").setUrl("file:///android_asset/vendorLogin.html"));
		return roster;
	}

	@Override
	public Vendor getFeaturedVendor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gotoVendorPage(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}
	
	public void gotoVendorPage(int Index) {
		// TODO Auto-generated method stub
		
	}

	

}
