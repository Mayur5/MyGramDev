package me.mygram.models;

import java.util.ArrayList;

import me.mygram.controllers.services.SpringboardService;

public class Roster implements GenericRoster{
	private ArrayList<Vendor> vendors;
	private SpringboardService springboardService;
	
	public Roster(ArrayList<Vendor> vendors) {
		super();
		this.vendors = vendors;
	}
	
	public Roster() {
		super();
	}

	public void sync() {
		vendors = springboardService.sync();
	}

	public void setSpringboardService(SpringboardService springboardService) {
		this.springboardService = springboardService;
	}

	
	@Override
	public Vendor getVendorAt(int index) {
		return vendors.get(index);
	}

	@Override
	public ArrayList<Vendor> getVendors() {
		return vendors;
	}

	@Override
	public void setVendors(ArrayList<Vendor> vendors) {
		this.vendors = vendors;
	}

	@Override
	public void addVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		this.vendors.add(vendor);
	}

	@Override
	public Vendor getFirstVendor() {
		// TODO Auto-generated method stub
		return vendors.get(0);
	}

	@Override
	public Vendor getFeaturedVendor() {
		// TODO Auto-generated method stub
		return getFirstVendor();
	}
	
}
