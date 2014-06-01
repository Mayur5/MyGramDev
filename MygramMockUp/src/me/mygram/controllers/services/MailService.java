package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.models.Contact;
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
		final int pic1=0x7f020003;
        final int pic2=0x7f020004;
        final int pic3=0x7f020005;
        final int pic4=0x7f020006;
        final int pic5=0x7f020007;
        final int pic6=0x7f020008;
        final int pic7=0x7f020009;
		
		Contact self = new Contact("Harini", "Appaiah").setProfilePic(pic7);;
		ArrayList<Conversation> conversations = new ArrayList<Conversation>();
		
		Conversation a = new Conversation();
		Contact contactA = new Contact("Lokesh", "Jagannathan").setProfilePic(pic1);
		a.setCorrespondent(contactA);
		a.appendMessage(new Mail("Oi! Call when you can").setCorrespondent(contactA));
		a.appendMessage(new SMS("9863647272").setCorrespondent(contactA));
		a.appendMessage(new SMS("Thanks - that was great fun...").setCorrespondent(self));
		a.appendMessage(new Mail("Call when you're free pls - it's urgent.").setCorrespondent(contactA));		
		a.appendMessage(new SMS("Thank you").setCorrespondent(self));
		a.appendMessage(new Mail("arumugam@seventyfive.com").setCorrespondent(self));		
		a.appendMessage(new Mail("lol").setCorrespondent(contactA));
		a.appendMessage(new Mail("Bring some salt also.").setCorrespondent(contactA));
		a.appendMessage(new Mail("=)").setCorrespondent(self));
		a.appendMessage(new Mail("Hey what's srivats's number?").setCorrespondent(contactA));
		
		Conversation b = new Conversation();
		Contact contactB = new Contact("Kumari", "Bomman").setProfilePic(pic4);
		b.setCorrespondent(contactB);
		
		b.appendMessage(new Mail("Oi! Call when you can").setCorrespondent(contactB));
		
		Conversation c = new Conversation();
		Contact contactC = new Contact("Muthu", "B").setProfilePic(pic2);
		c.setCorrespondent(contactC);
		c.appendMessage(new Mail("Bring some salt also.").setCorrespondent(contactC));
		c.appendMessage(new Mail("You have won 10,000 rupees in our...").setCorrespondent(self));
		c.appendMessage(new Mail("=)").setCorrespondent(contactC));
		
		Conversation d = new Conversation();
		Contact contactD = new Contact("Jaggu", "Abraham").setProfilePic(pic3);
		d.setCorrespondent(contactD);
		d.appendMessage(new Mail("Oi! Call when you can").setCorrespondent(contactD));
		
		Conversation e = new Conversation();
		Contact contactE = new Contact("SPRINGBOARD", "SERVICE").setProfilePic(pic5);
		e.setCorrespondent(contactE);
		e.appendMessage(new Notification("Subscription Offer: Click here to subscribe to BabaJob.in").setCorrespondent(contactE));
		e.appendMessage(new Mail("Congratulations! You are now subscribed to Babajobs.in.").setCorrespondent(contactE));
		e.appendMessage(new Notification("Job Offer: Driver wanted in Sirsi for retired Army Major - click here to apply").setCorrespondent(contactE));
	
		Conversation f = new Conversation();
		Contact contactF = new Contact("Priya", "Sarin").setProfilePic(pic6);
		f.setCorrespondent(contactF);
		f.appendMessage(new Mail("Where should I come in Indiranagar?").setCorrespondent(contactF));
		
		conversations.add(a);
		conversations.add(b);
		conversations.add(c);
		conversations.add(d);
		conversations.add(e);
		conversations.add(f);
		
		return conversations;
	}

	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
