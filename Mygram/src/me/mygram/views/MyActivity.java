package me.mygram.views;

import me.mygram.controllers.factories.MailServiceFactory;
import me.mygram.controllers.factories.SpringboardServiceFactory;
import me.mygram.controllers.services.MailService;
import me.mygram.controllers.services.SpringboardService;
import me.mygram.example.controllers.adapters.InboxViewAdapter;
import me.mygram.models.Credentials;
import me.mygram.models.Mygram;
import android.app.Activity;
import android.os.Bundle;

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
		
	public void sendMail(String email, String subject, String messageBody) {
        getMailService().sendMail(email, subject, messageBody, this);
    }
	
	public void setInboxAdapter(InboxViewAdapter adapter) {
		getApp().setInboxAdapter(adapter);
	}
	
	public InboxViewAdapter getInboxAdapter(){
		return getApp().getInboxAdapter();
	}
    
//    public Inbox fetchMail() {
//    	try {
//            Store store = session.getStore();
//            store.connect("mygram.me", "ram@mygram.me", "ramshreyas123");
//            Folder inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_ONLY);
//            Message msg = inbox.getMessage(inbox.getMessageCount());
//            Address[] in = msg.getFrom();
//            for (Address address : in) {
//                System.out.println("FROM:" + address.toString());
//            }
//            Multipart mp = (Multipart) msg.getContent();
//            BodyPart bp = mp.getBodyPart(0);
//            System.out.println("SENT DATE:" + msg.getSentDate());
//            System.out.println("SUBJECT:" + msg.getSubject());
//            System.out.println("CONTENT:" + bp.getContent());
//        } catch (Exception mex) {
//            mex.printStackTrace();
//        }
//    	return null;
//    }
	
}
