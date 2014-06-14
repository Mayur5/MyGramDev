package me.mygram.views;

import me.mygram.R;
import me.mygram.models.Vendor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SpringboardVendorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_springboard_vendor);
		
		//Get selected Vendor
		Intent intent = getIntent();
		Vendor vendor = (Vendor)intent.getSerializableExtra("selectedVendor");
		
		//Instantiate views
		TextView vendorName = (TextView)findViewById(R.id.activity_springboard_vendor_name);
		vendorName.setText("Selected Vendor is = " + vendor.getName());
		
		
		
	}
	

}
