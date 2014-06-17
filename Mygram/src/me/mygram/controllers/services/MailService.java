package me.mygram.controllers.services;

import java.util.ArrayList;

import android.content.Context;
import me.mygram.R;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.EmailMessage;
import me.mygram.models.Mail;
import me.mygram.models.Message;
import me.mygram.models.Notification;
import me.mygram.models.SMS;

public class MailService implements GenericMailService{
	
	Context context;
	ArrayList<Conversation> conversations = new ArrayList<Conversation>();
	
	public MailService(){
		super();
	}

	public MailService(Context context) {
		super();
		this.context = context;
	}

	@Override
	public ArrayList<Conversation> sync(ArrayList<Conversation> conversations) {
		// Dummy sync implemented - TODO
		if(conversations.size() == 0) {
			conversations = dummyConversations();
		}
		
		return conversations;
	}

	private ArrayList<Conversation> dummyConversations() {
		final int from=R.drawable.from;
        final int jamesh_bond=R.drawable.jamesh_bond;
        final int love_smiley=R.drawable.love_smiley;
        final int notification1=R.drawable.notification1;
        final int notification2=R.drawable.notification2;
        final int notification3=R.drawable.notification3;
        final int pic1=R.drawable.pic1;
        final int pic4=R.drawable.pic4;
        final int pic5=R.drawable.ic_launcher;
        final int pic6=R.drawable.pic6;
        final int thumbs_up=R.drawable.thumbs_up;
		
		Contact self = new Contact("Harini", "Appaiah").setProfilePic(from);
		
		Conversation a = new Conversation();
		Contact contactA = new Contact("Lokesh", "Jagannathan").setProfilePic(pic1);
		a.setCorrespondent(contactA);
		a.appendMessage(new SMS("I got wipro job!!").setCorrespondent(contactA));
		a.appendMessage(new Mail("Bombat!").setAttachment(thumbs_up).setAttachmentType("image").setCorrespondent(self));
		a.appendMessage(new Mail("").setAttachment(jamesh_bond).setAttachmentType("image").setCorrespondent(contactA));
		
		Conversation b = new Conversation();
		Contact contactB = new Contact("Kumari", "Bomman").setProfilePic(pic4);
		b.setCorrespondent(contactB);
		b.appendMessage(new Mail("9827345362").setCorrespondent(contactB));
		b.appendMessage(new Mail("").setAttachment(love_smiley).setAttachmentType("file").setCorrespondent(self));
		
		Conversation e = new Conversation();
		Contact contactE = new Contact("SPRINGBOARD", "SERVICE").setProfilePic(pic5);
		e.setCorrespondent(contactE);
		e.appendMessage((new Notification("").setAttachment(notification1)).setCorrespondent(contactE));
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

	@Override
	public void addConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		conversations.add(0, conversation);
	}

}
