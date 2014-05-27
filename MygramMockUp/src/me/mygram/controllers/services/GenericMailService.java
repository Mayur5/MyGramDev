package me.mygram.controllers.services;

import me.mygram.models.Inbox;
import me.mygram.models.Message;

public interface GenericMailService {
	
	public Inbox sync(Inbox inbox);
	
	public void sendMessage(Message message);

}
