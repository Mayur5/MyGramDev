package me.mygram.models;

import java.util.Date;

public abstract class NotificationMessage extends Message {

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
	
	
}
