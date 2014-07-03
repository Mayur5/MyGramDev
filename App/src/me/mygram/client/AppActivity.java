package me.mygram.client;

import me.mygram.client.views.TutorialActivity;
import me.mygram.models.Inbox;
import me.mygram.sample.controllers.adapters.InboxViewAdapter;
import me.mygram.views.MyActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

/**
 * 
 */
public class AppActivity extends MyActivity {
	private static Integer selected;
	protected static Inbox inbox = new Inbox();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_app);
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
		
		final ListView inboxView = (ListView)findViewById(R.id.inboxView);
		final InboxViewAdapter adapter = new InboxViewAdapter(this, R.layout.inbox_item, inbox);
		inboxView.setAdapter(adapter);
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
