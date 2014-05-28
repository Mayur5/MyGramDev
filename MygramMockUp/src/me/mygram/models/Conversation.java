package me.mygram.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Conversation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 797774581112946203L;
	private ArrayList<Message> conversations;
	private String snippet;
	
	public Conversation(){
		super();
	}
	
	public Conversation(ArrayList<Message> conversations) {
		super();
		this.conversations = conversations;
	}
	
	public ArrayList<Message> getConversations() {
		return conversations;
	}

	public void setConversations(ArrayList<Message> conversations) {
		this.conversations = conversations;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

}
