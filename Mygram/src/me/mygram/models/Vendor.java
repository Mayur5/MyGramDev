package me.mygram.models;

public class Vendor {
	private String name;
	private int icon;
	private String description;

	public Vendor(String name){
		super();
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIcon() {
		return icon;
	}

	public Vendor setIcon(int icon) {
		this.icon = icon;
		return this;
	}
	
	public String getDescription() {
		return description;
	}

	public Vendor setDescription(String description) {
		this.description = description;
		return this;
	}

}
