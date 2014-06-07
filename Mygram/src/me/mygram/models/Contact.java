package me.mygram.models;

import java.io.Serializable;

import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;

public class Contact implements GenericContact, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1049293541880774741L;
	private Email emailAddress;
	private Phone phoneNUmber;
	private String firstName;
	private String lastName;
	private int profilePic;
	
	public Contact(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public Email getEmailAddress() {
		return emailAddress;
	}

	@Override
	public void setEmailAddress(Email emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public Phone getPhoneNUmber() {
		return phoneNUmber;
	}

	@Override
	public void setPhoneNUmber(Phone phoneNUmber) {
		this.phoneNUmber = phoneNUmber;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	@Override
	public int getProfilePic() {
		return profilePic;
	}

	@Override
	public Contact setProfilePic(int profilePic) {
		this.profilePic = profilePic;
		return this;
	}

	public boolean isSelf() {
		// TODO Auto-generated method stub
		if(this.getFirstName().equals("Harini")) {
			return true;
		}
		return false;
	}
	
	

}
