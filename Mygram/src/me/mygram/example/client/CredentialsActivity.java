package me.mygram.example.client;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import me.mygram.R;
import me.mygram.models.Credentials;
import me.mygram.views.MyActivity;

public class CredentialsActivity extends MyActivity {
	EditText firstNameEditText;
	EditText lastNameEditText;
	EditText phoneEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_credentials);
		
		//Get url from intent
		String url = getIntent().getSerializableExtra("url").toString();
		
		//Parse url for settings
		ArrayList<String> settings = parse(url);
		
		//Display for confirmation
		firstNameEditText = (EditText)findViewById(R.id.credentials_activity_first_name_edit_text);
		lastNameEditText = (EditText)findViewById(R.id.credentials_activity_last_name_edit_text);
		phoneEditText = (EditText)findViewById(R.id.credentials_activity_phone_edit_text);
		firstNameEditText.setText(settings.get(0).toString());
		lastNameEditText.setText(settings.get(1).toString());
		phoneEditText.setText(settings.get(2).toString());
		
		System.out.println(settings);
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResumeParentMethod();
	}
	
	public void saveCredentials(View v) {
		Credentials cred = getCredentials();
		cred.setFirstName(firstNameEditText.getText().toString());
		cred.setLastName(lastNameEditText.getText().toString());
		cred.setPhoneNumber(phoneEditText.getText().toString());
		setCredentials(cred);
		finish();
	}

	private ArrayList<String> parse(String url) {
		String setting = "";
		Boolean record = false;
		ArrayList<String> settings = new ArrayList<String>();
		// Parse settings in string
		for(char c : url.toCharArray()) {
			//Start recording
			if (c == "#".toCharArray()[0] && record == false) {
				record = true;
			} else if (c == "#".toCharArray()[0] && record == true) {
				record = false;
				settings.add(setting);
				setting="";
			}
			//Record only the non # characters
			if(record == true && c != "#".toCharArray()[0]) {
				setting = setting + c;
			}
		}
		System.out.println(url);
		return settings;
	}

}
