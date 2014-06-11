package me.mygram.views;

import me.mygram.controllers.adapters.ConversationViewAdapter;
import me.mygram.models.Conversation;
import me.mygram.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ConversationActivity extends Activity {
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversation);
		
		//Get the intent
		Intent intent = getIntent();
		
		//Instantiate objects
		final ListView conversationView = (ListView)findViewById(R.id.conversationView);	
		
		//Check if intent is carrying a conversation, if so inflate listView with conversation
		if(intent.hasExtra("selectedConversation")) {
			Conversation conversation = (Conversation) intent.getSerializableExtra("selectedConversation");	
			
			//Set correspondent Pic and Name
			ImageView profilePic = (ImageView)findViewById(R.id.conversation_correspondent_profile_pic);
			profilePic.setImageResource(conversation.getCorrespondent().getProfilePic());
			TextView correspondentNameTextView = (TextView)findViewById(R.id.conversation_correspondent_name);
			correspondentNameTextView.setText(conversation.getCorrespondent().getFullName());
			
			//Populate conversations	
			final ConversationViewAdapter adapter = new ConversationViewAdapter(this, R.layout.conversation_item, conversation);
			conversationView.setAdapter(adapter);
		}
		
		//Conversation item Clicklistener
		
		//Set swipeListener
		gestureDetector = new GestureDetector(this, new SwipeDetector());
		gestureListener = new View.OnTouchListener() {	
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};
		conversationView.setOnTouchListener(gestureListener);
	}
	
	protected static void swipeRight(Context context) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		context.startActivity(intent);
	}

	protected static void swipeLeft(Context context) {
		// TODO Auto-generated method stub
		
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
		        	ConversationActivity.swipeLeft(ConversationActivity.this);
		        }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
		        	ConversationActivity.swipeRight(ConversationActivity.this);
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
