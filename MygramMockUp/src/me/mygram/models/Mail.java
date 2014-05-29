package me.mygram.models;

public class Mail extends EmailMessage {

	public Mail(String body) {
		// TODO Auto-generated constructor stub
		this.setBody(body);
	}

	@Override
	public String typeOfMessage() {
		// TODO Auto-generated method stub
		return "EMAIL";
	}
}
