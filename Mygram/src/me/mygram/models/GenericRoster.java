package me.mygram.models;

import java.util.ArrayList;

public interface GenericRoster {

	public abstract Vendor getVendorAt(int index);

	public abstract ArrayList<Vendor> getVendors();

	public abstract void setVendors(ArrayList<Vendor> vendors);

	public abstract void addVendor(Vendor vendor);
	
	public abstract Vendor getFirstVendor();
	
	public abstract Vendor getFeaturedVendor();

}