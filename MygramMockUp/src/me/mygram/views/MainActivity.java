package me.mygram.views;

import me.mygram.controllers.adapters.InboxViewAdapter;
import me.mygram.controllers.factories.MailServiceFactory;
import me.mygram.controllers.services.MailService;
import me.mygram.models.Conversation;
import me.mygram.models.Inbox;

import com.example.mygrammockup.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private static Integer selected;
	protected static Inbox inbox = new Inbox();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Set mailService to new mail service
		MailService mailService = MailServiceFactory.getMailService(this);
		inbox.setMailService(mailService);
		
		//Fetch Inbox emails
		inbox.sync();
		
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
	}

	public void goToConversation(View v) {
		//
		Intent intent = new Intent(this, ConversationActivity.class);
		Conversation selectedConversation = inbox.getConversation(MainActivity.selected);
		intent.putExtra("selectedConversation", selectedConversation);
		startActivity(intent);
	}
	
}
