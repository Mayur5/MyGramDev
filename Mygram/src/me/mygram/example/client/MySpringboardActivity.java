package me.mygram.example.client;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import me.mygram.R;
import me.mygram.models.Credentials;
import me.mygram.views.MyActivity;

public class MySpringboardActivity extends MyActivity {
	Credentials credentials;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		credentials = getCredentials();
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_myspringboard);
		
		//Get URL from intent
		String url = getIntent().getSerializableExtra("url").toString();
		
		//Instantiate webView
		WebView webView = (WebView)findViewById(R.id.springboard_web_view);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient() {
		    public void onPageFinished(WebView view, String url) {
		        view.loadUrl("javascript:" + 
		        			"document.getElementById('firstname').value = '" + credentials.getFirstName() + "';" +
		        			"document.getElementById('firstName').value = '" + credentials.getFirstName() + "';" +
		        			"document.getElementById('first_name').value = '" + credentials.getFirstName() + "';" +
		        			"document.getElementById('FirstName').value = '" + credentials.getFirstName() + "';" +
		        			"document.getElementById('first').value = '" + credentials.getFirstName() + "';" +
		        			
							"document.getElementById('username').value = '" + credentials.getUserName() + "';" +
							"document.getElementById('user_name').value = '" + credentials.getUserName() + "';" +			
							"document.getElementById('userName').value = '" + credentials.getUserName() + "';" +
		        			
		        			"document.getElementById('lastname').value='"+credentials.getLastName() + "';" + 
		        			"document.getElementById('lastName').value='"+credentials.getLastName() + "';" + 
		        			"document.getElementById('last_name').value='"+credentials.getLastName() + "';" + 
		        			"document.getElementById('LastName').value='"+credentials.getLastName() + "';" + 
		        			"document.getElementById('last').value='"+credentials.getLastName() + "';" + 
		        			
		        			"document.getElementById('dob').value='"+credentials.getDateOfBith() +"';" + 
		        			"document.getElementById('DOB').value='"+credentials.getDateOfBith() +"';" + 
		        			"document.getElementById('dateOfBirth').value='"+credentials.getDateOfBith() +"';" + 
		        			"document.getElementById('date_of_birth').value='"+credentials.getDateOfBith() +"';" +
		        			"document.getElementById('dateofbirth').value='"+credentials.getDateOfBith() +"';" + 
		        			
							"document.getElementById('email').value='"+credentials.getEmailID() +
							"document.getElementById('emailAddress').value='"+credentials.getEmailID() +
							"document.getElementById('emailID').value='"+credentials.getEmailID() +
							"document.getElementById('email_address').value='"+credentials.getEmailID() +
							"document.getElementById('email_id').value='"+credentials.getEmailID() +
		        			
		        			"document.getElementById('phone').value='"+credentials.getPhoneNumber() +
		        			"document.getElementById('phoneNumber').value='"+credentials.getPhoneNumber() +
		        			"document.getElementById('phonenumber').value='"+credentials.getPhoneNumber() +
		        			"document.getElementById('phone_number').value='"+credentials.getPhoneNumber() + "';");
		    }
		});
		webView.loadUrl(url);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResumeParentMethod();
	}

}
