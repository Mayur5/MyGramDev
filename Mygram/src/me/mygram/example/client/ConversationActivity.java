package me.mygram.example.client;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import me.mygram.R;
import me.mygram.example.controllers.adapters.ConversationViewAdapter;
import me.mygram.models.Conversation;
import me.mygram.views.MyActivity;

public class ConversationActivity extends MyActivity {
	private static final String username = "ram@mygram.me";
    private static final String password = "ramshreyas123";
    private EditText emailEdit;
    private EditText subjectEdit;
    private EditText messageEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		
		//Get the incoming intent
		Intent intent = getIntent();
		
		//If there is a conversation payload, load conversation, else load compose window
		if(intent.hasExtra("selectedConversation")) {
			setContentView(R.layout.activity_conversation);
			ListView conversationView = (ListView)findViewById(R.id.conversationView);
			Conversation conversation = (Conversation) intent.getSerializableExtra("selectedConversation");	
			
			//Set correspondent Pic and Name
			ImageView profilePic = (ImageView)findViewById(R.id.conversation_correspondent_profile_pic);
			profilePic.setImageResource(conversation.getCorrespondent().getProfilePic());
			TextView correspondentNameTextView = (TextView)findViewById(R.id.conversation_correspondent_name);
			correspondentNameTextView.setText(conversation.getCorrespondent().getFullName());
			
			//Populate conversations	
			final ConversationViewAdapter adapter = new ConversationViewAdapter(this, R.layout.conversation_item, conversation);
			conversationView.setAdapter(adapter);
		} else {
			setContentView(R.layout.new_conversation);
			emailEdit = (EditText) findViewById(R.id.email);
	        subjectEdit = (EditText) findViewById(R.id.subject);
	        messageEdit = (EditText) findViewById(R.id.message);
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResumeParentMethod();
	}
	
	public void sendMail(View v) {
		String email = emailEdit.getText().toString();
        String subject = subjectEdit.getText().toString();
        String message = messageEdit.getText().toString();
        sendMail(email, subject, message);
	}
	
	public void goToInbox(View v) {
		Intent intent = new Intent(this, AppActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}
	
	private void sendMail(String email, String subject, String messageBody) {
        Session session = createSessionObject();

        try {
            Message message = createMessage(email, subject, messageBody, session);
            new SendMailTask().execute(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    public void fetchMail(View v) {
    	Session session = createSessionObject();
    	try {
            Store store = session.getStore();
            store.connect("mygram.me", "ram@mygram.me", "ramshreyas123");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" + bp.getContent());
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

    private Message createMessage(String email, String subject, String messageBody, Session session) throws MessagingException, UnsupportedEncodingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("ram@mygram.me", "Ram"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email, email));
        message.setSubject(subject);
        message.setText(messageBody);
        return message;
    }

    private Session createSessionObject() {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "mygram.me");
        properties.put("mail.smtp.port", "587");

        return Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private class SendMailTask extends AsyncTask<Message, Void, Void> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(ConversationActivity.this, "Please wait", "Sending mail", true, false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }

        @Override
        protected Void doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
