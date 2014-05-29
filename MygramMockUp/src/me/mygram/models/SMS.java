package me.mygram.models;

public class SMS extends SMSMessage {

	public SMS(String body) {
		// TODO Auto-generated constructor stub
		this.setBody(body);
	}

	@Override
	public String typeOfMessage() {
		// TODO Auto-generated method stub
		return "SMS";
	}

}
