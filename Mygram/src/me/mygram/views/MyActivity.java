package me.mygram.views;

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

import me.mygram.controllers.factories.MailServiceFactory;
import me.mygram.controllers.factories.SpringboardServiceFactory;
import me.mygram.controllers.services.MailService;
import me.mygram.controllers.services.SpringboardService;
import me.mygram.models.Credentials;
import me.mygram.models.Mygram;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

public abstract class MyActivity extends Activity implements MygramActivity{

	@Override
	protected abstract void onCreate(Bundle savedInstanceState);

	@Override
	protected abstract void onResume();
	
	protected void onCreateParentMethod(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	protected void onResumeParentMethod() {
		super.onResume();
	}

	@Override
	public Mygram getApp() {
		// TODO Auto-generated method stub
		return (Mygram)getApplicationContext();
	}

	@Override
	public Boolean isRegistered() {
		// TODO Auto-generated method stub
		return getApp().isRegistered();
	}
	
	public void setRegistered(Boolean status) {
		getApp().setRegistered(status);
	}

	@Override
	public MailService getMailService() {
		// TODO Auto-generated method stub
		return MailServiceFactory.getMailService(getApp());
	}

	@Override
	public SpringboardService getSpringboardService() {
		// TODO Auto-generated method stub
		return SpringboardServiceFactory.getSpringboardService(getApp());
	}

	@Override
	public Credentials getCredentials() {
		// TODO Auto-generated method stub
		return getApp().getCredentials();
	}

	@Override
	public void setCredentials(Credentials credentials) {
		getApp().setCredentials(credentials);
	}	
	
	protected void sendMail(String email, String subject, String messageBody, Context context) {
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
                return new PasswordAuthentication("ram@mygram.me", "ramshreyas123");
            }
        });
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
