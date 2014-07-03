package me.mygram.client;

import android.os.Bundle;
import me.mygram.client.R;
import me.mygram.controllers.services.MailService;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Credentials;
import me.mygram.models.Mail;
import me.mygram.views.MyActivity;

public class TutorialActivity extends MyActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
	}

	@Override
	protected void onResume() {
		super.onResumeParentMethod();
		MailService mailService = getMailService();
		Credentials credentials = new Credentials("Big Sooth", "Vishwanathan").setLanguagePreference("kannada");
		
		Contact contact = (Contact) new Contact("Springboard", "Service").setProfilePic(R.drawable.ic_launcher);
		Mail mail = (Mail) new Mail("Welcome to Mygram! Your username is <TODO>" + credentials.getFirstName() +
									" Your language preference is: <TODO>" + credentials.getLanguagePreference()).setCorrespondent(contact);
		
		//Construct conversation
		Conversation conversation = new Conversation();
		conversation.appendMessage(mail);
		conversation.setCorrespondent(contact);
		
		//Add to inbox
		mailService.addConversation(conversation);
	}
}
