package me.mygram.models;

import java.io.File;
import java.util.Date;

import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.Html;

public abstract class EmailMessage extends Message {
	
	private Email sender;
	private Email receiver;
	private String subject;
	protected Html body;
	private Date sentTimeStamp;
	private Date receivedTimeStamp;
	private MessageStatus Status;
	private String attachmentType;
	private File attachment;
	
	public EmailMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Email getSender() {
		return sender;
	}

	public void setSender(Email sender) {
		this.sender = sender;
	}

	public Email getReceiver() {
		return receiver;
	}

	public void setReceiver(Email receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String getBody() {
		return body.toString();
	}
	
	public Html getHtmlBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = (Html) Html.fromHtml(body);
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

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	public Boolean hasAttachment() {
		return null;
	}

}
