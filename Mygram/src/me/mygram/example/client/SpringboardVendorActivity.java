package me.mygram.example.client;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import me.mygram.R;
import me.mygram.controllers.services.MailService;
import me.mygram.controllers.webinterfaces.WebAppInterface;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Mail;
import me.mygram.models.Message;
import me.mygram.models.Vendor;
import me.mygram.views.MyActivity;

public class SpringboardVendorActivity extends MyActivity {

	private EditText vendorInput;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_springboard_vendor);
		
		//Get selected vendor
		Intent intent = getIntent();
		Vendor vendor = (Vendor)intent.getSerializableExtra("selectedVendor");
		
		//Instantiate views
		WebView vendorWebPage = (WebView)findViewById(R.id.activity_springboard_vendor_vendorpage);
		vendorWebPage.getSettings().setJavaScriptEnabled(true);
		vendorWebPage.loadUrl(vendor.getUrl());
		vendorWebPage.addJavascriptInterface(new WebAppInterface(this), "Android");

	}

	@Override
	protected void onResume() {
		super.onResumeParentMethod();

	}

	public void submitInput(View v) {
		//Get submission
		String submission = vendorInput.getText().toString();
		Contact contact = new Contact("Springboard", "Service").setProfilePic(R.drawable.grid);
		
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
