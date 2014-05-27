package me.mygram.views;

import java.util.ArrayList;

import me.mygram.controllers.adapters.InboxViewAdapter;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Fetch Inbox emails
		final Inbox inbox = fetchMail();
		
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
		startActivity(intent);
	}
	
	private Inbox fetchMail() {
		ArrayList<Conversation> conversations = new ArrayList<Conversation>();
		String[] snippets = new String[] {
				"Oi! Call when you can",
				"9863647272",
				"Thanks - that was great fun...",
				"Call when you're free pls - it's urgent.",
				"Thank you",
				"arumugam@seventyfive.com",
				"lol",
				"Bring some salt also.",
				"You have won 10,000 rupees in our...",
				"Hey what's srivats's number?",
				"=)"
		};
		
		for(int i=0; i<10; i++) {
			Conversation c = new Conversation();
			c.setSnippet(snippets[i]);
			conversations.add(c);
		}
		
		Inbox inbox = new Inbox(conversations);
		
		return inbox;
	}
	
	
}
