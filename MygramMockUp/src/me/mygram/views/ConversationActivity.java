package me.mygram.views;

import me.mygram.models.Conversation;

import com.example.mygrammockup.R;

import android.app.Activity;
import android.content.Context;
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
		
		//Check if intent is carrying a conversation, if so TODO: inflate listView with conversation
		if(intent.hasExtra("selectedConversation")) {
			Conversation conversation = (Conversation) intent.getSerializableExtra("selectedConversation");
			Toast toast = Toast.makeText(this, conversation.getSnippet(), Toast.LENGTH_SHORT);
			toast.show();	
			
			ListView listView = (ListView)findViewById(R.id.conversationView);			
			inflate(this, listView, conversation);
		}
	}

	private void inflate(Context context, ListView listView, Conversation conversation) {
		// TODO Auto-generated method stub
		
	}

}
