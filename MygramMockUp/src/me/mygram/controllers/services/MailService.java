package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.models.Conversation;
import me.mygram.models.Message;

public class MailService implements GenericMailService{
	
	Context context;

	public MailService(Context context) {
		super();
		this.context = context;
	}

	@Override
	public ArrayList<Conversation> sync(ArrayList<Conversation> conversations) {
		// Dummy sync implemented - TODO
		String[] snippets = new String[] {
				"Oi! Call when you can",
				"9863647272",
				"Thanks - that was great fun...",
				"Call when you're free pls - it's urgent.",
				"Thank you",
				"arumugam@seventyfive.com",
				"lol",
				"Bring some salt also.",
				"You have won 10,000 rupees in our...",
				"Hey what's srivats's number?",
				"=)"
		};
		
		for(int i=0; i<10; i++) {
			Conversation c = new Conversation();
			c.setSnippet(snippets[i]);
			conversations.add(c);
		}
		return conversations;
	}

	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
