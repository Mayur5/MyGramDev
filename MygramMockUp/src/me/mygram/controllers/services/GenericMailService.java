package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.models.Conversation;
import me.mygram.models.Inbox;
import me.mygram.models.Message;

public interface GenericMailService {
	
	public void sendMessage(Message message);

	public ArrayList<Conversation> sync(ArrayList<Conversation> conversations);

}
