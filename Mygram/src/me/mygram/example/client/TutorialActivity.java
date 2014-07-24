package me.mygram.example.client;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import me.mygram.R;
import me.mygram.controllers.services.MailService;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Credentials;
import me.mygram.models.Mail;
import me.mygram.views.MyActivity;

public class TutorialActivity extends MyActivity {
	private static Credentials credentials = new Credentials();
	final CharSequence[] languages = {"Kannada", "Hindi", "English"};
	int tutorialIndex = 1;
	ImageView tutorialScreenImageView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		
		//Instantiate views
		tutorialScreenImageView = (ImageView)findViewById(R.id.tutorial_activity_screen); 
		
		//Get username and language preference
		showUsernameAndLanguagePreferenceDialog();
	}
	
	@Override
	protected void onResume() {
		super.onResumeParentMethod();
		
	}
	
	public void next(View v) {
		tutorialIndex++;
		switch(tutorialIndex) {
		case 2:
			tutorialScreenImageView.setImageResource(R.drawable.tutorial2);
			break;
		case 3:
			tutorialScreenImageView.setImageResource(R.drawable.tutorial3);
			break;
		case 4:
			tutorialScreenImageView.setImageResource(R.drawable.tutorial4);
			break;
		case 5:
			tutorialScreenImageView.setImageResource(R.drawable.tutorial5);
			break;
		case 6:
			tutorialScreenImageView.setImageResource(R.drawable.tutorial6);
			break;
		case 7:
			tutorialScreenImageView.setImageResource(R.drawable.tutorial7);
			break;
		case 8:
			tutorialScreenImageView.setImageResource(R.drawable.tutorial8);
			break;
		case 9:
			done(v);
		default:
			tutorialScreenImageView.setImageResource(R.drawable.tutorial1);
			tutorialIndex=1;
			break;
		}
		
	}
	
	public void done(View v) {
		//Set the user as registered
		getApp().setRegistered(true);
		
		//Set the user-entered credentials
		setCredentials(credentials);
		
		//Construct conversation
		MailService mailService = getMailService();
		Contact contact = (Contact) new Contact("Mygram", "").setProfilePic(R.drawable.ic_launcher);
		Mail mail = (Mail) new Mail("Welcome to Mygram! Your Email Address is " + credentials.getEmailID() +
									" Your language preference is: " + credentials.getLanguagePreference() +
									"<br><br><a href='http://mygram.me'>Mygram.me</a>").setCorrespondent(contact);
		Conversation conversation = new Conversation();
		conversation.appendMessage(mail);
		conversation.setCorrespondent(contact);
		
		//Add to inbox 
		mailService.addConversation(conversation);
		finish();
	}
	
	private void showUsernameAndLanguagePreferenceDialog() {
		final AlertDialog temporaryEmailAddressAlertDialog;
		AlertDialog.Builder temporaryEmailAddressAlertDialogBuilder = new AlertDialog.Builder(this);
		final AlertDialog emailPasswordAlertDialog;
		AlertDialog.Builder emailPasswordAlertDialogBuilder = new AlertDialog.Builder(this);
		final AlertDialog languagePreferenceAlertDialog;
		AlertDialog.Builder languagePreferenceAlertDialogBuilder = new AlertDialog.Builder(this);
		
		//Password dialog
		final EditText emailPasswordEditText = new EditText(this);
		emailPasswordAlertDialogBuilder
			.setTitle("Enter the password given below:")
			.setView(emailPasswordEditText)
			.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					credentials.setPassword(emailPasswordEditText.getText().toString());
				}
			});
		emailPasswordAlertDialog = emailPasswordAlertDialogBuilder.create();
		
		//Username dialog
		final EditText temporaryEmailAddressEditText = new EditText(this);	
		temporaryEmailAddressAlertDialogBuilder
			.setTitle("Enter the temporary email id displayed on the card:")
			.setView(temporaryEmailAddressEditText)
			.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					credentials.setEmailID(temporaryEmailAddressEditText.getText().toString() + "@mygram.me");
					dialog.dismiss();
					emailPasswordAlertDialog.show();
				}
			});
		temporaryEmailAddressAlertDialog = temporaryEmailAddressAlertDialogBuilder.create();
		
		//Language preference dialog
		languagePreferenceAlertDialogBuilder
			.setTitle("Select your language")
			.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int index) {
					// TODO Auto-generated method stub
					credentials.setLanguagePreference(languages[index].toString());
					dialog.dismiss();
					temporaryEmailAddressAlertDialog.show();
				}
			});
		
		//Create and show
		languagePreferenceAlertDialog = languagePreferenceAlertDialogBuilder.create();
		languagePreferenceAlertDialog.show();
	}
}
