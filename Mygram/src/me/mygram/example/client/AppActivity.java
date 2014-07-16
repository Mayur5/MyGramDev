package me.mygram.example.client;

import me.mygram.R;
import me.mygram.models.Conversation;
import me.mygram.models.Inbox;
import me.mygram.example.client.ConversationActivity;
import me.mygram.example.controllers.adapters.InboxViewAdapter;
import me.mygram.views.MyActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 
 */
public class AppActivity extends MyActivity {
	protected static Inbox inbox = new Inbox();
	protected Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_app);
		context = (Context)getApp();
		inbox.setMailService(getMailService());
		
		if(isRegistered()) {
			inbox.sync();
		} else {
			launchTutorial();
		}
	}

	@Override
	protected void onResume() {
		super.onResumeParentMethod();
		
		inbox.sync();
		
		//Populate inbox listView
		final ListView inboxView = (ListView)findViewById(R.id.inboxView);
		final InboxViewAdapter adapter = new InboxViewAdapter(this, R.layout.inbox_item, inbox);
		inboxView.setAdapter(adapter);
		
		
		
		//Set clickListener
		inboxView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
				// TODO Auto-generated method stub
				AppActivity.gotoSelectedConversation(index, AppActivity.this);
			}
			
		});
	}
	
	public void goToSpringboard(View v) {
		Intent intent = new Intent(this, SpringboardActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}
	
	public void goToNewConversation(View v) {
		Intent intent = new Intent(this, ConversationActivity.class);
		startActivity(intent);
	}

	protected static void gotoSelectedConversation(int index, Context context) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, ConversationActivity.class);
		Conversation selectedConversation = inbox.getConversation(index);
		intent.putExtra("selectedConversation", selectedConversation);
		context.startActivity(intent);
	}

	private void launchTutorial() {
		// Launch registration activity
		setRegistered(true);
		Intent intent = new Intent(this, TutorialActivity.class);
		startActivity(intent);
	}
	
	/*
	 * Delete all other code and uncomment the following block to launch the sample app 
	 */
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//
//		//setContentView(R.layout.activity_app);
//	}

	
}
