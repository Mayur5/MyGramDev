package me.mygram.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import me.mygram.R;
import me.mygram.controllers.factories.MailServiceFactory;
import me.mygram.controllers.services.MailService;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Mail;
import me.mygram.models.Message;
import me.mygram.models.Vendor;
import me.mygram.views.MyActivity;

public class SpringboardVendorActivity extends MyActivity {

	private EditText vendorInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_springboard_vendor);
		
		//Get selected vendor
		Intent intent = getIntent();
		Vendor vendor = (Vendor)intent.getSerializableExtra("selectedVendor");
		
		//Instantiate views
		TextView vendorName = (TextView)findViewById(R.id.activity_springboard_vendor_name);
		vendorInput = (EditText)findViewById(R.id.activity_springboard_vendor_input);
		
		//Set values
		vendorName.setText("Selected Vendor is = " + vendor.getName() + ", " + getCredentials().getUserName());	

	}

	@Override
	protected void onResume() {
		super.onResumeParentMethod();

	}

	public void submitInput(View v) {
		//Get submission
		String submission = vendorInput.getText().toString();
		Contact contact = new Contact("Springboard", "Service").setProfilePic(R.drawable.ic_launcher);
		
		//Create mail
		Message vendorEmail = (Message) new Mail(submission)
			.setAttachment(R.drawable.notification3)
			.setAttachmentType("image")
			.setCorrespondent(contact);
		
		//Create Conversation
		Conversation c = new Conversation();
		c.setCorrespondent(contact);
		c.appendMessage(vendorEmail);
				
		//Send to MailService
		MailService mailService = getMailService();
		mailService.addConversation(c);
		finish();
	}
}
