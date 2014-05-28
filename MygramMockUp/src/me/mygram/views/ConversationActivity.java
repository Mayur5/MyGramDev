package me.mygram.views;

import me.mygram.models.Conversation;

import com.example.mygrammockup.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ConversationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversation);
		
		//Get the intent
		Intent intent = getIntent();
		
		//Check if intent has extras, if so TODO: inflate listView
		if(intent.hasExtra("selectedConversation")) {
			Conversation conversation = (Conversation) intent.getSerializableExtra("selectedConversation");
			Toast toast = Toast.makeText(this, conversation.getSnippet(), Toast.LENGTH_SHORT);
			toast.show();		
		}
	}

}
