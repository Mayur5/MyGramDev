package me.mygram.example.client;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
		        view.loadUrl("javascript:document.getElementById('username').value = '" +
		        credentials.getUserName() +
		        "';document.getElementById('langPref').value='"+credentials.getLanguagePreference()+"';");
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

	    /** Show a toast from the web page */
	    @JavascriptInterface
	    public void submit(String toast) {
	        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	        SpringboardVendorActivity.this.vendorWebPage.loadUrl("https://play.google.com/store/apps/details?id=com.flipkart.android");
	    }
	}
}
