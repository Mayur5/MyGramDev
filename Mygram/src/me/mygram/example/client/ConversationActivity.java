package me.mygram.example.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import me.mygram.R;
import me.mygram.example.controllers.adapters.ConversationViewAdapter;
import me.mygram.models.Conversation;
import me.mygram.views.MyActivity;

public class ConversationActivity extends MyActivity {
    private EditText emailEdit;
    private EditText subjectEdit;
    private EditText messageEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		
		//Get the incoming intent
		Intent intent = getIntent();
		
		//If there is a conversation payload, load conversation, else load compose window
		if(intent.hasExtra("selectedConversation")) {
			setContentView(R.layout.activity_conversation);
			ListView conversationView = (ListView)findViewById(R.id.conversationView);
			Conversation conversation = (Conversation) intent.getSerializableExtra("selectedConversation");	
			
			//Set correspondent Pic and Name
			ImageView profilePic = (ImageView)findViewById(R.id.conversation_correspondent_profile_pic);
			profilePic.setImageResource(conversation.getCorrespondent().getProfilePic());
			TextView correspondentNameTextView = (TextView)findViewById(R.id.conversation_correspondent_name);
			correspondentNameTextView.setText(conversation.getCorrespondent().getFullName());
			
			//Populate conversations	
			final ConversationViewAdapter adapter = new ConversationViewAdapter(this, R.layout.conversation_item, conversation);
			conversationView.setAdapter(adapter);
		} else {
			setContentView(R.layout.new_conversation);
			emailEdit = (EditText) findViewById(R.id.email);
	        subjectEdit = (EditText) findViewById(R.id.subject);
	        messageEdit = (EditText) findViewById(R.id.message);
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResumeParentMethod();
	}
	
	public void sendMail(View v) {
		String email = emailEdit.getText().toString();
        String subject = subjectEdit.getText().toString();
        String message = messageEdit.getText().toString();
        sendMail(email, subject, message);
	}
	
	public void goToInbox(View v) {
		Intent intent = new Intent(this, AppActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}
	
	

}
