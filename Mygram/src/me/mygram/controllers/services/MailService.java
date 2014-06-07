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
		final int from=0x7f02005a;
        final int jamesh_bond=0x7f02005c;
        final int love_smiley=0x7f02005d;
        final int notification1=0x7f02005e;
        final int notification2=0x7f02005f;
        final int notification3=0x7f020060;
        final int pic1=0x7f020062;
        final int pic4=0x7f020065;
        final int pic5=0x7f020066;
        final int pic6=0x7f020067;
        final int thumbs_up=0x7f02006a;
		
		Contact self = new Contact("Harini", "Appaiah").setProfilePic(from);;
		ArrayList<Conversation> conversations = new ArrayList<Conversation>();
		
		Conversation a = new Conversation();
		Contact contactA = new Contact("Lokesh", "Jagannathan").setProfilePic(pic1);
		a.setCorrespondent(contactA);
		a.appendMessage(new SMS("I got wipro job!!").setCorrespondent(contactA));
		a.appendMessage(new Mail("Bombat!").setAttachment(thumbs_up).setCorrespondent(self));
		a.appendMessage(new Mail("").setAttachment(jamesh_bond).setCorrespondent(contactA));
		
		Conversation b = new Conversation();
		Contact contactB = new Contact("Kumari", "Bomman").setProfilePic(pic4);
		b.setCorrespondent(contactB);
		b.appendMessage(new Mail("9827345362").setCorrespondent(contactB));
		b.appendMessage(new Mail("").setAttachment(love_smiley).setCorrespondent(self));
		
		Conversation e = new Conversation();
		Contact contactE = new Contact("SPRINGBOARD", "SERVICE").setProfilePic(pic5);
		e.setCorrespondent(contactE);
		e.appendMessage(new Notification("").setAttachment(notification1).setCorrespondent(contactE));
		e.appendMessage(new Notification("").setAttachment(notification2).setCorrespondent(contactE));
		e.appendMessage(new Notification("").setAttachment(notification3).setCorrespondent(contactE));
	
		Conversation f = new Conversation();
		Contact contactF = new Contact("Priya", "Sarin").setProfilePic(pic6);
		f.setCorrespondent(contactF);
		f.appendMessage(new SMS("Why late?").setCorrespondent(contactF));
		
		conversations.add(a);
		conversations.add(b);
		conversations.add(e);
		conversations.add(f);
		
		return conversations;
	}

	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
