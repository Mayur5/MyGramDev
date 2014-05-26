package me.mygram.models;

import java.util.Date;

import android.provider.ContactsContract.CommonDataKinds.Phone;

public abstract class SMSMessage extends Message{
	
	public Phone fromPhoneNumber() {
		return null;
	}
	
	public Phone toPhoneNumber() {
		return null;
	}
	
	public String messageBody() {
		return null;
	}
	
	public Date sentTimeStamp() {
		return null;
	}
	
	public Date receivedTimeStamp() {
		return null;
	}
	
	public MessageStatus status() {
		return null;
	}

}
