package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.models.Conversation;
import me.mygram.models.MyMessage;

public interface GenericMailService {
	
	public void sendMessage(MyMessage message);

	public ArrayList<Conversation> sync(ArrayList<Conversation> conversations, Context context);
	
	public void addConversation(Conversation conversation);

}
