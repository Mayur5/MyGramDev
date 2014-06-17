package me.mygram.views;

import me.mygram.controllers.adapters.InboxViewAdapter;
import me.mygram.controllers.factories.MailServiceFactory;
import me.mygram.controllers.services.MailService;
import me.mygram.models.Conversation;
import me.mygram.models.Inbox;
import me.mygram.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private static Integer selected;
	protected static Inbox inbox = new Inbox();
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;	
	
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);  			
    	
    	//Set mailService to new mail service
    	MailService mailService = MailServiceFactory.getMailService(this);
    	inbox.setMailService(mailService);
		
    	//Fetch Inbox emails
    	inbox.sync();
	}
    
    public void onResume() {
    	super.onResume();
    	
    			
    	///Populate Inbox ListView
    	final ListView inboxView = (ListView)findViewById(R.id.inboxView);
    	final InboxViewAdapter adapter = new InboxViewAdapter(this, R.layout.inbox_item, inbox);
    	inboxView.setAdapter(adapter);
    			
    	//Set clickListener
    	inboxView.setOnItemClickListener(new OnItemClickListener() {
    				
    		@Override
    		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    			// Set selected on view
    			view.setSelected(true);
    					
    			//Set global selected to position
    			MainActivity.selected = position;
    		}
    	});
    			
    	//Set swipeListener
    	gestureDetector = new GestureDetector(this, new SwipeDetector());
    	gestureListener = new View.OnTouchListener() {
    				
    		@Override
    		public boolean onTouch(View v, MotionEvent event) {
    			return gestureDetector.onTouchEvent(event);
    		}
    	};
    	inboxView.setOnTouchListener(gestureListener);
    }

	protected static void swipeRight(Context context) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, SpringboardActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		context.startActivity(intent);
	}

	protected static void swipeLeft(Context context) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, ConversationActivity.class);
		if(MainActivity.selected != null) {
			//Pass selected conversation
			Conversation selectedConversation = inbox.getConversation(MainActivity.selected);
			intent.putExtra("selectedConversation", selectedConversation);
		}
		context.startActivity(intent);
	}

	public void goToConversationView(View v) {
		//
		Intent intent = new Intent(this, ConversationActivity.class);
		if(MainActivity.selected != null) {
			//Pass selected conversation
			Conversation selectedConversation = inbox.getConversation(MainActivity.selected);
			intent.putExtra("selectedConversation", selectedConversation);
		}
		startActivity(intent);
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
		        	MainActivity.swipeLeft(MainActivity.this);
		        }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
		        	MainActivity.swipeRight(MainActivity.this);
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
}
