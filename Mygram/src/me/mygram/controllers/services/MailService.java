package me.mygram.controllers.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.FetchProfile;
import javax.mail.Flags;
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
import javax.mail.search.FlagTerm;

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
	Conversation tempConversation = new Conversation();
	Message[] unseenMessages;
	ArrayList<MyMessage> myUnseenMessages = new ArrayList<MyMessage>();
	
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
				//Connect to Mygram
	            Store store = session[0].getStore();
	            store.connect("mygram.me", "ram@mygram.me", "ramshreyas123");
	            
	            //Open the Inbox folder in Read & Write mode
	            Folder inbox = store.getFolder("INBOX");
	            inbox.open(Folder.READ_WRITE);
	            
	            //Get references to latest unseen messages
	            Flags seenFlag = new Flags(Flags.Flag.SEEN);
	            FlagTerm unseenMessagesFlagTarm = new FlagTerm(seenFlag, false);
	            unseenMessages = inbox.search(unseenMessagesFlagTarm);
	            
	            /* Use a suitable FetchProfile to fetch those messages */
//	            FetchProfile fp = new FetchProfile();
//	            fp.add(FetchProfile.Item.ENVELOPE);
//	            fp.add(FetchProfile.Item.CONTENT_INFO);
//	            inbox.fetch(unseenMessages, fp);
	            
	            //Get array of fetched messages from inbox - reusing unseenMessages - put it in myUnseenMessages
	            //unseenMessages = inbox.getMessages();
	            for (Message m : unseenMessages) {
	            	Multipart mp = (Multipart) m.getContent();
		            BodyPart bp = mp.getBodyPart(0);
		            MyMessage testMessage = new Mail(bp.getContent().toString()).setCorrespondent(new Contact(m.getFrom().toString() + "", "T"));
		            myUnseenMessages.add(testMessage);
		            System.out.println("From" + m.getFrom().toString());
		            System.out.println("Content" + bp.getContent().toString());
	            }
	            	            
	            //Message msg = inbox.getMessage(inbox.getMessageCount());
//	            Message msg = unseenMessages[0];
//	            Address[] in = msg.getFrom();
//	            for (Address address : in) {
//	                System.out.println("FROM:" + address.toString());
//	            }
//	            Multipart mp = (Multipart) msg.getContent();
//	            BodyPart bp = mp.getBodyPart(0);
//	            System.out.println("SENT DATE:" + msg.getSentDate());
//	            System.out.println("SUBJECT:" + msg.getSubject());
//	            System.out.println("CONTENT:" + bp.getContent());
//	            
//	            //Create new MyMessage
//	            MyMessage testMessage = new Mail(bp.getContent().toString()).setCorrespondent(new Contact(in[0].toString(), ""));
//	    		tempConversation.setCorrespondent(new Contact(in[0].toString(), ""));
//	    		tempConversation.appendMessage(testMessage);
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
            
            //Add unseen messages
            try {
				addMessages(myUnseenMessages);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
            ((MyActivity)context).getInboxAdapter().notifyDataSetChanged();
            
            //Add message to Inbox
//            addConversation(tempConversation);
//            tempConversation = new Conversation();
//            ((MyActivity)context).getInboxAdapter().notifyDataSetChanged();
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

	public void addMessages(ArrayList<MyMessage> unseenMessages) throws IOException, MessagingException {
		String fromAddress = "";
		// Attach messages to relevant conversations
		for (Conversation c : conversations) {
			for (MyMessage m : unseenMessages) {
				//Check if correspondent of m is correspondent of m
				fromAddress = m.getCorrespondent().getFirstName();
				if (fromAddress.equalsIgnoreCase(c.getCorrespondent().getFirstName())) {
					//If so, add to conversation, remove from unseenMessages
					c.appendMessage(m);
					unseenMessages.remove(m);
				}
			}
		}
		
		//For all remaining messages, check if they belong in conversations together, create new conversations and add them
		if(unseenMessages == null) {
			//Do nothing
		} else {
			for (MyMessage m : unseenMessages) {
				//Create list for comparison, remove message to compare against, create new Conversation
				ArrayList<MyMessage> comparisonList = unseenMessages;
				comparisonList.remove(m);
				Conversation newConversation = new Conversation();
				newConversation.setCorrespondent((Contact)m.getCorrespondent());
				
				//Add message to this conversation
				newConversation.appendMessage(m);
				
				for(MyMessage c : comparisonList) {
					fromAddress = c.getCorrespondent().getFirstName();
					if(m.getCorrespondent().getFirstName().equalsIgnoreCase(fromAddress)) {
						//Add message to neConversation - reusing variables 
			            newConversation.appendMessage(c);
			            unseenMessages.remove(c);
					}
				}
				//Add newConversation to conversations
				addConversation(newConversation);
			}
		}
	}

}
