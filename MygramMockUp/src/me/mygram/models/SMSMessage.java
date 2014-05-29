package me.mygram.models;

import java.util.Date;

import android.provider.ContactsContract.CommonDataKinds.Phone;

public abstract class SMSMessage extends Message{
	
	private Phone sender;
	private Phone receiver;
	private String body;
	private Date sentTimeStamp;
	private Date receivedTimeStamp;
	private MessageStatus Status;
	
	public SMSMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phone getSender() {
		return sender;
	}
	public void setSender(Phone sender) {
		this.sender = sender;
	}
	public Phone getReceiver() {
		return receiver;
	}
	public void setReceiver(Phone receiver) {
		this.receiver = receiver;
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
