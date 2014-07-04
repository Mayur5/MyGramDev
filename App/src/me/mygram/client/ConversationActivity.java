package me.mygram.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import me.mygram.R;
import me.mygram.models.Conversation;
import me.mygram.sample.controllers.adapters.ConversationViewAdapter;
import me.mygram.views.MyActivity;

public class ConversationActivity extends MyActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_conversation);
		
		//Get the incoming intent
		Intent intent = getIntent();

		//Instantiate view objects
		ListView conversationView = (ListView)findViewById(R.id.conversationView);
		
		//If there is a conversation payload, load conversation, else load compose window
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
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResumeParentMethod();
	}
	
	public void goToSpringboard(View v) {
		Intent intent = new Intent(this, SpringboardActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}
	
	public void goToInbox(View v) {
		Intent intent = new Intent(this, AppActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}

}
