package me.mygram.client;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import me.mygram.client.R;
import me.mygram.controllers.services.MailService;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Credentials;
import me.mygram.models.Mail;
import me.mygram.views.MyActivity;

public class TutorialActivity extends MyActivity {
	private static Credentials credentials = new Credentials();
	final CharSequence[] languages = {"Kannada", "Hindi", "English"};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		
		//Get username and language preference
		showUsernameAndLanguagePreferenceDialog();
	}

	@Override
	protected void onResume() {
		super.onResumeParentMethod();
		
	}
	
	public void done(View v) {
		setCredentials(credentials);
		MailService mailService = getMailService();
		
		//Construct conversation
		Contact contact = (Contact) new Contact("Springboard", "Service").setProfilePic(R.drawable.ic_launcher);
		Mail mail = (Mail) new Mail("Welcome to Mygram! Your username is " + credentials.getUserName() +
									" Your language preference is: " + credentials.getLanguagePreference()).setCorrespondent(contact);
		Conversation conversation = new Conversation();
		conversation.appendMessage(mail);
		conversation.setCorrespondent(contact);
		
		//Add to inbox 
		mailService.addConversation(conversation);
		finish();
	}
	
	private void showUsernameAndLanguagePreferenceDialog() {
		final AlertDialog usernameAlertDialog;
		AlertDialog.Builder usernameAlertDialogBuilder = new AlertDialog.Builder(this);
		final AlertDialog languagePreferenceAlertDialog;
		AlertDialog.Builder languagePreferenceAlertDialogBuilder = new AlertDialog.Builder(this);
		
		//Username dialog
		final EditText usernameEditText = new EditText(this);	
		usernameAlertDialogBuilder
			.setTitle("Enter your username")
			.setView(usernameEditText)
			.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					credentials.setUserName(usernameEditText.getText().toString());
				}
			});
		usernameAlertDialog = usernameAlertDialogBuilder.create();
		
		//Language preference dialog
		languagePreferenceAlertDialogBuilder
			.setTitle("Select your language")
			.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int index) {
					// TODO Auto-generated method stub
					credentials.setLanguagePreference(languages[index].toString());
					dialog.dismiss();
					usernameAlertDialog.show();
				}
			});
		
		//Create and show
		languagePreferenceAlertDialog = languagePreferenceAlertDialogBuilder.create();
		languagePreferenceAlertDialog.show();
	}
}
