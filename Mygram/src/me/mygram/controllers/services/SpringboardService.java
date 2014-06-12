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
		final int linkedin_icon=R.drawable.linkedin_icon;
		final int skype_icon=R.drawable.skype_icon;
		
		
		roster.add(new Vendor("Featured App").setIcon(skype_icon).setDescription("This is the featured app. It gets to be here right on top"));
		roster.add(new Vendor("B").setIcon(linkedin_icon).setDescription("This is a description of linked in"));
		roster.add(new Vendor("C").setIcon(instagram_icon).setDescription("This is a description of instagram"));
		roster.add(new Vendor("D").setIcon(dropbox_icon).setDescription("This is a description of dropbox"));
		roster.add(new Vendor("E").setIcon(blur_icon).setDescription("This is a description of blur"));
		roster.add(new Vendor("F").setIcon(amazon_icon).setDescription("This is a description of amazon"));
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
