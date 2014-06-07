package me.mygram.models;

import java.io.Serializable;
import java.util.Date;

public abstract class NotificationMessage extends Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2673475498537373357L;
	private String body;
	private Date sentTimeStamp;
	private Date receivedTimeStamp;
	private MessageStatus Status;
		
	public NotificationMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getSentTimeStamp() {
		return sentTimeStamp;
	}
	public void setSentTimeStamp(Date sentTimeStamp) {
		this.sentTimeStamp = sentTimeStamp;
	}
	public Date getReceivedTimeStamp() {
		return receivedTimeStamp;
	}
	public void setReceivedTimeStamp(Date receivedTimeStamp) {
		this.receivedTimeStamp = receivedTimeStamp;
	}
	public MessageStatus getStatus() {
		return Status;
	}
	public void setStatus(MessageStatus status) {
		Status = status;
	}
	@Override
	public boolean isEmail() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isSMS() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isNotification() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public GenericContact getCorrespondent() {
		// TODO Auto-generated method stub
		GenericContact mygram = new Contact("Mygram.me", "").setProfilePic(0x7f020001);
		
		return mygram;
	}
	@Override
	public Message setCorrespondent(Contact contact) {
		// TODO Auto-generated method stub
		return this;
	}
	
	
}
