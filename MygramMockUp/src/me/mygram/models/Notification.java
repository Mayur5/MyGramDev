package me.mygram.models;

public class Notification extends NotificationMessage {
	
	public Notification(String body) {
		this.setBody(body);
	}

	@Override
	public String typeOfMessage() {
		// TODO Auto-generated method stub
		return "NOTIFICATION";
	}

}
