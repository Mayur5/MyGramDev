package me.mygram.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Conversation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 797774581112946203L;
	private ArrayList<Message> messages = new ArrayList<Message>();
	private Contact correspondent;
	
	public Conversation(){
		super();
	}
	
	public Conversation(ArrayList<Message> messages) {
		super();
		this.messages = messages;
	}
	
	public Message getMessageAt(int index) {
		return messages.get(index);
	}
	
	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> conversations) {
		this.messages = conversations;
	}

	public String getSnippet() {
		String snippet;
		if(messages.get(messages.size() - 1).isEmail()) {
			Mail m = (Mail)messages.get(messages.size() - 1);
			if(m.hasAttachment()) {
				if(m.getAttachmentType().equalsIgnoreCase("image")) {
					snippet = "Has sent you an image";
					return snippet;
				} else if (m.getAttachmentType().equalsIgnoreCase("file")) {
					snippet = "Has sent you a file";
					return snippet;
				} else if (m.getAttachmentType().equalsIgnoreCase("video")) {
					snippet = "Has sent you a video";
					return snippet;
				} else if (m.getAttachmentType().equalsIgnoreCase("audio")) {
					snippet = "Has sent you an audio file";
					return snippet;
				}
			}
		}
		snippet = messages.get(messages.size() - 1).toString();
		if (snippet.length() > 30) { 
			snippet = snippet.substring(0, Math.min(snippet.length(), 15)) + "...";
		}
		return snippet;
	}

	public void appendMessage(Message message) {
		// TODO Auto-generated method stub
		messages.add(message);
	}

	public GenericContact getCorrespondent() {
		// TODO Auto-generated method stub
		return correspondent;
	}
	
	public void setCorrespondent(Contact contact) {
		// TODO Auto-generated method stub
		this.correspondent = contact;
	}

	public Message getLastMessage() {
		// TODO Auto-generated method stub
		return messages.get(messages.size() - 1);
	}
}
