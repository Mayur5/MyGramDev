package me.mygram.models;

import java.util.Date;

import android.provider.ContactsContract.CommonDataKinds.Email;
import android.webkit.MimeTypeMap;

public abstract class EmailMessage extends Message {
	
	public Email getSender() {
		return null;
	}
	
	public void setSender(Email senderEmail) {
	}
	
	public Email getReceiver() {
		return null;
	}
	
	public void setReceiver(Email receiverEmail) {
	}
	
	public String getSubject() {
		return null;
	}
	
	public String setSubject() {
		return null;
	}
	
	public String getMessageBody() {
		return null;
	}
	
	public String setMessageBody() {
		return null;
	}
	
	public String getFooter() {
		return null;
	}
	
	public String setFooter() {
		return null;
	}
	
	public Boolean hasAttachment() {
		return null;
	}
	
	public MimeTypeMap getAttachmentType() {
		return null;
	}
	
	public Attachment getAttachment() {
		return null;
	}
	
	public void setAttachment(Attachment attachment) {
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
