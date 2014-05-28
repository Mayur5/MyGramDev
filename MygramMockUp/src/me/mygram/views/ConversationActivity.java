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
		
		Intent intent = getIntent();
		
		Conversation conversation = (Conversation) intent.getSerializableExtra("selectedConversation");

		Toast toast = Toast.makeText(this, conversation.getSnippet(), Toast.LENGTH_SHORT);
		toast.show();		
	}

}
