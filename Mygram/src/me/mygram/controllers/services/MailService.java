package me.mygram.controllers.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Mail;
import me.mygram.models.MyMessage;
import me.mygram.views.MyActivity;

public class MailService implements GenericMailService{
	
	Context context;
	ArrayList<Conversation> conversations = new ArrayList<Conversation>();
	ArrayList<Conversation> temporaryConversations = new ArrayList<Conversation>();
	
	public MailService(){
		super();
	}

	public MailService(Context context) {
		super();
		this.context = context;
	}

	@Override
	public ArrayList<Conversation> sync(ArrayList<Conversation> conversations, Context context) {
		// Dummy sync implemented - TODO
		if(conversations.size() == 0) {
			conversations = dummyConversations();
		}
		this.context = context;
		fetchMail();
		return conversations;
	}

	private ArrayList<Conversation> dummyConversations() {
		// Return dummy conversations
		return conversations;
	}

	@Override
	public void sendMessage(MyMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		conversations.add(0, conversation);
	}

	public void sendMail(String email, String subject, String messageBody, Context context) {
		Session session = createSessionObject();

        try {
            Message message = createMessage(email, subject, messageBody, session);
            new SendMailTask(context).execute(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    public void fetchMail() {
    	Session session = createSessionObject();
    	
    	try {
            new FetchMailTask().execute(session);
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
                return new PasswordAuthentication("ram@mygram.me", "ramshreyas123");
            }
        });
    }
    
    private class FetchMailTask extends AsyncTask<Session, Void, Void> {

		@Override
		protected Void doInBackground(Session... session) {
			// Fetch mail in background
			try {
	            Store store = session[0].getStore();
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
	            MyMessage testMessage = new Mail(bp.getContent().toString()).setCorrespondent(new Contact(in[0].toString(), ""));
	    		Conversation conversation = new Conversation();
	    		temporaryConversations = conversations;
	    		conversation.setCorrespondent(new Contact(in[0].toString(), ""));
	    		conversation.appendMessage(testMessage);
	    		temporaryConversations.add(0, conversation);
	        } catch (Exception mex) {
	            mex.printStackTrace();
	        }
			return null;
		}
		
		@Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progressDialog = ProgressDialog.show(context, "Please wait", "Fetching mail", true, false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            conversations = temporaryConversations;
            ((MyActivity)context).getInboxAdapter().notifyDataSetChanged();
        }
    	
    }

    private class SendMailTask extends AsyncTask<Message, Void, Void> {
        private ProgressDialog progressDialog;
        private Context context; 

        public SendMailTask(Context context) {
			this.context = context;
		}

		@Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(context, "Please wait", "Sending mail", true, false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            ((Activity) context).finish();
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
