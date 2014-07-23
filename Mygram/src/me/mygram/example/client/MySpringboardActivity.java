package me.mygram.example.client;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import me.mygram.R;
import me.mygram.views.MyActivity;

public class MySpringboardActivity extends MyActivity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_myspringboard);
		
		//Get URL from intent
		String url = getIntent().getSerializableExtra("url").toString();
		
		//Instantiate webView
		WebView webView = (WebView)findViewById(R.id.springboard_web_view);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(url);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResumeParentMethod();
	}

}
