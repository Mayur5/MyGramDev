package me.mygram.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Conversation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 797774581112946203L;
	private ArrayList<Message> messages = new ArrayList<Message>();
	
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
		return messages.get(messages.size() - 1).toString();
	}

	public void appendMessage(Message message) {
		// TODO Auto-generated method stub
		messages.add(message);
	}
}
