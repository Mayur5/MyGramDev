package com.example.mygrammockup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static Integer selected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Fetch Inbox emails
		final String[] inboxArray = fetchMail();
		
		///Populate Inbox ListView
		final ListView inboxView = (ListView)findViewById(R.id.inboxView);
		final InboxAdapter adapter = new InboxAdapter(this, inboxArray);
		inboxView.setAdapter(adapter);
		
		//Set clickListener
		inboxView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// Get the text
				MainActivity.highlight(view, position);
				String snippet = (String)inboxView.getAdapter().getItem(position);		
				Toast.makeText(getApplicationContext(), snippet, Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void goToConversation(View v) {
		//Go to selected conversation
		Toast.makeText(getApplicationContext(), fetchMail()[selected], Toast.LENGTH_SHORT).show();
	}
	
	protected static void highlight(View view, int position) {
		// If an item was previously selected
		if(selected != null) {
			//Toggle previous selection highlight
			ListView parent = (ListView)view.getParent();
			View previous = (View) parent.getChildAt(selected);
			previous.setBackgroundColor(-1);	
		}
		
		//Set selected to current position, Highlight selected
		view.setBackgroundColor(-3355444);
		MainActivity.selected = position;
	}

	private String[] fetchMail() {
		String[] threads = new String[] {
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
		
		return threads;
	}
	
	
}
