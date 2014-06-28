package me.mygram.views;

import me.mygram.R;
import me.mygram.controllers.factories.MailServiceFactory;
import me.mygram.controllers.services.MailService;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Credentials;
import me.mygram.models.Mail;
import me.mygram.models.Mygram;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistrationActivity extends Activity {
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;	
	static ImageView imageView;
	private static int position = 1;
	private static Credentials credentials = new Credentials();
	private CharSequence[] languages = {"Kannada", "Hindi", "English"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final AlertDialog languagePreferenceAlertDialog;
		final AlertDialog usernameAlertDialog;
		AlertDialog.Builder languagePreferenceAlertDialogBuilder = new AlertDialog.Builder(this);
		AlertDialog.Builder usernameAlertDialogBuilder = new AlertDialog.Builder(this);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
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
		
		
		//Instantiate view objects
		imageView = (ImageView) findViewById(R.id.registration_screen);
		imageView.setImageResource(R.drawable.registration1);
		
		//Set swipeListener
    	gestureDetector = new GestureDetector(this, new SwipeDetector());
    	gestureListener = new View.OnTouchListener() {
    				
    		@Override
    		public boolean onTouch(View v, MotionEvent event) {
    			return gestureDetector.onTouchEvent(event);
    		}
    	};
    	imageView.setOnTouchListener(gestureListener);
		
	}
	

	protected static void setLanguagePreference(CharSequence language, Context context) {
		// Set credential language		
		Toast toast = new Toast(context);
		toast.makeText(context, language, Toast.LENGTH_SHORT).show();
	}


	private static void refreshView(Context context) {
		// TODO Auto-generated method stub
		switch(position) {
		case 1:
			imageView.setImageResource(R.drawable.registration1);
			break;
		case 2:
			imageView.setImageResource(R.drawable.registration2);
			break;
		case 3:
			imageView.setImageResource(R.drawable.registration3);
			break;
		case 4:
			imageView.setImageResource(R.drawable.registration4);
			break;
		case 5:
			imageView.setImageResource(R.drawable.registration5);
			break;
		case 6:
			imageView.setImageResource(R.drawable.registration6);
			break;
		case 7:
			imageView.setImageResource(R.drawable.registration7);
			break;
		case 8:
			imageView.setImageResource(R.drawable.registration8);
			break;
		case 9:
			imageView.setImageResource(R.drawable.registration9);
			break;
		case 10:
			imageView.setImageResource(R.drawable.registration10);
			break;
		case 11:
			imageView.setImageResource(R.drawable.registration11);
			break;
		case 12:
			imageView.setImageResource(R.drawable.registration12);
			break;
		case 13:
			imageView.setImageResource(R.drawable.registration13);
			break;
		case 14:
			sendWelcomeEmail(context);
			break;
		}
	}

	
	private static void sendWelcomeEmail(Context context) {
		//Set registered flag
		Mygram mygram = (((Mygram) context.getApplicationContext()).setRegistered(true));
		mygram.setCredentials(credentials);
		
		//Construct Mail
		Contact contact = (Contact) new Contact("Springboard", "Service").setProfilePic(R.drawable.ic_launcher);
		Mail mail = (Mail) new Mail("Welcome to Mygram! Your username is " + 
									credentials.getUserName() + 
									" Your language preference is: " +
									credentials.getLanguagePreference()).setCorrespondent(contact);
		
		//Construct conversation
		Conversation conversation = new Conversation();
		conversation.appendMessage(mail);
		conversation.setCorrespondent(contact);
		
		//Add to inbox
		MailService mailService = MailServiceFactory.getMailService(context);
		mailService.addConversation(conversation);
		
		//Go to inbox
		Intent intent = new Intent(context, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		context.startActivity(intent);
	}


	private final class SwipeDetector extends SimpleOnGestureListener {
		private static final int SWIPE_MIN_DISTANCE = 120;
	    private static final int SWIPE_MAX_OFF_PATH = 250;
	    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
		
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		    try {
		        if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
		            return false;
		        // right to left swipe
		        if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
		        	RegistrationActivity.swipeLeft(RegistrationActivity.this);
		        }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
		        	RegistrationActivity.swipeRight(RegistrationActivity.this);
		        }
		    } catch (Exception e) {
		        // nothing
		    }
		    return false;
		}

		@Override
	    public boolean onDown(MotionEvent e) {
			  return true;
	    }
	}

	protected static void swipeLeft(Context context) {
		// TODO Auto-generated method stub
		position = position + 1;
		refreshView(context);
	}

	protected static void swipeRight(Context context) {
		// TODO Auto-generated method stub
		position = position - 1;
		refreshView(context);
	}

}
