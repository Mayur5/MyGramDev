package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
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
		final int amazon_icon=0x7f020000;
		final int blur_icon=0x7f020004;
		final int dropbox_icon=0x7f020006;
		final int instagram_icon=0x7f02000d;
		final int linkedin_icon=0x7f020010;
		final int skype_icon=0x7f020020;
		
		
		roster.add(new Vendor("Featured App").setIcon(skype_icon).setDescription("This is the featured app. It gets to be here right on top"));
		roster.add(new Vendor("B").setIcon(linkedin_icon));
		roster.add(new Vendor("C").setIcon(instagram_icon));
		roster.add(new Vendor("D").setIcon(dropbox_icon));
		roster.add(new Vendor("E").setIcon(blur_icon));
		roster.add(new Vendor("F").setIcon(amazon_icon));
		roster.add(new Vendor("G").setIcon(skype_icon));
		roster.add(new Vendor("H").setIcon(linkedin_icon));
		roster.add(new Vendor("I").setIcon(instagram_icon));
		roster.add(new Vendor("J").setIcon(dropbox_icon));
		roster.add(new Vendor("K").setIcon(amazon_icon));
		roster.add(new Vendor("L").setIcon(skype_icon));
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
