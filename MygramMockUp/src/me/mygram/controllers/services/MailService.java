package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.models.Conversation;
import me.mygram.models.Mail;
import me.mygram.models.Message;
import me.mygram.models.SMS;

public class MailService implements GenericMailService{
	
	Context context;

	public MailService(Context context) {
		super();
		this.context = context;
	}

	@Override
	public ArrayList<Conversation> sync(ArrayList<Conversation> conversations) {
		// Dummy sync implemented - TODO
		Conversation c = new Conversation();
		c.appendMessage(new Mail("Oi! Call when you can"));
		c.appendMessage(new SMS("9863647272"));
		c.appendMessage(new SMS("Thanks - that was great fun..."));
		c.appendMessage(new Mail("Call when you're free pls - it's urgent."));		
		c.appendMessage(new SMS("Thank you"));
		c.appendMessage(new Mail("arumugam@seventyfive.com"));		
		c.appendMessage(new Mail("lol"));
		c.appendMessage(new Mail("Bring some salt also."));
		c.appendMessage(new Mail("You have won 10,000 rupees in our..."));
		c.appendMessage(new Mail("=)"));
		c.appendMessage(new Mail("Hey what's srivats's number?"));
		
		conversations.add(c);
		return conversations;
	}

	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
