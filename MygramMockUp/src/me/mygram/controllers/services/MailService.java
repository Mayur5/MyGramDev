package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.models.Conversation;
import me.mygram.models.Mail;
import me.mygram.models.Message;
import me.mygram.models.Notification;
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
		conversations = dummyConversations();
		
		return conversations;
	}

	private ArrayList<Conversation> dummyConversations() {
		ArrayList<Conversation> conversations = new ArrayList<Conversation>();
		Conversation a = new Conversation();
		a.appendMessage(new Mail("Oi! Call when you can"));
		a.appendMessage(new SMS("9863647272"));
		a.appendMessage(new SMS("Thanks - that was great fun..."));
		a.appendMessage(new Mail("Call when you're free pls - it's urgent."));		
		a.appendMessage(new SMS("Thank you"));
		a.appendMessage(new Mail("arumugam@seventyfive.com"));		
		a.appendMessage(new Mail("lol"));
		a.appendMessage(new Mail("Bring some salt also."));
		a.appendMessage(new Mail("You have won 10,000 rupees in our..."));
		a.appendMessage(new Mail("=)"));
		a.appendMessage(new Mail("Hey what's srivats's number?"));
		
		Conversation b = new Conversation();
		b.appendMessage(new Mail("Oi! Call when you can"));
		b.appendMessage(new SMS("9863647272"));
		b.appendMessage(new SMS("Thanks - that was great fun..."));
		b.appendMessage(new Mail("Call when you're free pls - it's urgent."));		
		b.appendMessage(new SMS("Thank you"));
		b.appendMessage(new Mail("arumugam@seventyfive.com"));		
		b.appendMessage(new Mail("lol"));
		
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
		
		Conversation d = new Conversation();
		d.appendMessage(new Mail("Oi! Call when you can"));
		d.appendMessage(new SMS("9863647272"));
		d.appendMessage(new SMS("Thanks - that was great fun..."));
		d.appendMessage(new Mail("Call when you're free pls - it's urgent."));		
		d.appendMessage(new SMS("Thank you"));
		
		Conversation e = new Conversation();
		e.appendMessage(new Notification("Subscription Offer"));
		e.appendMessage(new Mail(" "));
		e.appendMessage(new Notification("You are now subscribed to BabaJob.in"));
	
		Conversation f = new Conversation();
		f.appendMessage(new Mail("Oi! Call when you can"));
		f.appendMessage(new SMS("9863647272"));
		f.appendMessage(new SMS("Thanks - that was great fun..."));
		f.appendMessage(new Mail("Call when you're free pls - it's urgent."));		
		f.appendMessage(new SMS("Thank you"));
	
		Conversation g = new Conversation();
		g.appendMessage(new Mail("Oi! Call when you can"));
		
		conversations.add(a);
		conversations.add(b);
		conversations.add(c);
		conversations.add(d);
		conversations.add(e);
		conversations.add(f);
		conversations.add(g);
		
		return conversations;
	}

	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
