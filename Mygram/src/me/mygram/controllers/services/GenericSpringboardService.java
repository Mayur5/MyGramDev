package me.mygram.controllers.services;

import java.util.ArrayList;

import me.mygram.models.Vendor;

public interface GenericSpringboardService {
	
	public ArrayList<Vendor> sync();
	
	public Vendor getFeaturedVendor();
	
	public void gotoVendorPage(Vendor vendor);

}
