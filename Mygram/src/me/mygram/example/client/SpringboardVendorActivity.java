package me.mygram.example.client;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import me.mygram.R;
import me.mygram.models.Credentials;
import me.mygram.models.Vendor;
import me.mygram.views.MyActivity;

public class SpringboardVendorActivity extends MyActivity {

	WebView vendorWebPage;
	Credentials credentials;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		credentials = getCredentials();
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_springboard_vendor);
		
		//Get selected vendor
		Intent intent = getIntent();
		Vendor vendor = (Vendor)intent.getSerializableExtra("selectedVendor");
		
		//Instantiate views
		vendorWebPage = (WebView)findViewById(R.id.activity_springboard_vendor_vendorpage);
		vendorWebPage.loadUrl(vendor.getUrl());
		vendorWebPage.getSettings().setJavaScriptEnabled(true);
		vendorWebPage.addJavascriptInterface(new WebAppInterface(this), "Android");
		vendorWebPage.setWebViewClient(new WebViewClient() {
		    public void onPageFinished(WebView view, String url) {
		        view.loadUrl("javascript:document.getElementById('firstname').value = '" + credentials.getFirstName() + "';" +
		        			"document.getElementById('lastname').value='"+credentials.getLastName()+"';" + 
		        			"document.getElementById('dob').value='"+credentials.getDateOfBith()+"';" + 
		        			"document.getElementById('phone').value='"+credentials.getPhoneNumber()+"';");
		    }
		});
	}

	@Override
	protected void onResume() {
		super.onResumeParentMethod();

	}

	public WebView getVendorWebPage() {
		return vendorWebPage;
	}
	
	public class WebAppInterface {
		Context mContext;

	    /** Instantiate the interface and set the context */
	    public WebAppInterface(Context c) {
	        mContext = c;
	    }
	    
	    public String getUserName() {
	    	return credentials.getFirstName();
	    }

	    /** Show a toast from the web page */
	    @JavascriptInterface
	    public void submit(String toast) {
	        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	        Intent intent = new Intent(Intent.ACTION_VIEW);
	        intent.setData(Uri.parse("market://details?id=com.flipkart.android"));
	        mContext.startActivity(intent);
	    }
	}
}
