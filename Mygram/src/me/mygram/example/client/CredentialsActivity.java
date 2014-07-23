package me.mygram.example.client;

import java.util.ArrayList;

import android.os.Bundle;
import me.mygram.R;
import me.mygram.views.MyActivity;

public class CredentialsActivity extends MyActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_credentials);
		
		//Get url from intent
		String url = getIntent().getSerializableExtra("url").toString();
		
		//Parse url for settings
		ArrayList<String> settings = parse(url);
		
		System.out.println(settings);
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResumeParentMethod();
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
