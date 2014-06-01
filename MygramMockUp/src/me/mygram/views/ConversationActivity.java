package me.mygram.views;

import me.mygram.controllers.adapters.ConversationViewAdapter;
import me.mygram.models.Conversation;

import com.example.mygrammockup.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class ConversationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversation);
		
		//Get the intent
		Intent intent = getIntent();
		
		//Check if intent is carrying a conversation, if so inflate listView with conversation
		if(intent.hasExtra("selectedConversation")) {
			//Populate conversations
			Conversation conversation = (Conversation) intent.getSerializableExtra("selectedConversation");			
			final ListView conversationView = (ListView)findViewById(R.id.conversationView);			
			final ConversationViewAdapter adapter = new ConversationViewAdapter(this, R.layout.conversation_item, conversation);
			conversationView.setAdapter(adapter);
			
			//Conversation item Clicklistener
			
			Toast toast = Toast.makeText(this, conversation.getSnippet(), Toast.LENGTH_SHORT);
			toast.show();	
		}
	}
}
