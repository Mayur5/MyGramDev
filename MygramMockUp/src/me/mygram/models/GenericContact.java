package me.mygram.models;

import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;

public interface GenericContact {

	public abstract Contact setProfilePic(int profilePic);

	public abstract int getProfilePic();

	public abstract void setLastName(String lastName);

	public abstract String getLastName();

	public abstract void setFirstName(String firstName);

	public abstract String getFirstName();

	public abstract void setPhoneNUmber(Phone phoneNUmber);

	public abstract Phone getPhoneNUmber();

	public abstract void setEmailAddress(Email emailAddress);

	public abstract Email getEmailAddress();

}
