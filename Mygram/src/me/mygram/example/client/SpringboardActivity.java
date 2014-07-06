package me.mygram.example.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import me.mygram.R;
import me.mygram.controllers.services.SpringboardService;
import me.mygram.example.controllers.adapters.SpringboardRosterViewAdapter;
import me.mygram.models.Roster;
import me.mygram.models.Vendor;
import me.mygram.views.MyActivity;

public class SpringboardActivity extends MyActivity {
	private SpringboardService springboardService;
	private static Roster roster = new Roster();
	private static int selected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreateParentMethod(savedInstanceState);
		setContentView(R.layout.activity_springboard);
		
		//Instantiate view objects
		springboardService = getSpringboardService();
		roster.setSpringboardService(springboardService);
		TextView featuredVendorDescriptionView = (TextView)findViewById(R.id.springboard_featured_vendor_description);
		GridView vendorGridView = (GridView)findViewById(R.id.springboard_vendor_grid);
		
		//Grid inflation
		roster.sync();
		SpringboardRosterViewAdapter adapter = new SpringboardRosterViewAdapter(this, roster);
		vendorGridView.setAdapter(adapter);
		
		//Featured Vendor inflation
		ImageView featuredVendorIcon = (ImageView)findViewById(R.id.springboard_featured_vendor_icon);
		TextView featuredVendorName = (TextView)findViewById(R.id.springboard_featured_vendor_name);
		featuredVendorIcon.setImageResource(roster.getFirstVendor().getIcon());
		featuredVendorName.setText(roster.getFirstVendor().getName());
		featuredVendorDescriptionView.setText(roster.getFirstVendor().getDescription());
		
		//Set onClickListener
		vendorGridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				//Instantiate views
				ImageView featuredVendorIcon = (ImageView)findViewById(R.id.springboard_featured_vendor_icon);
				TextView featuredVendorName = (TextView)findViewById(R.id.springboard_featured_vendor_name);
				TextView featuredVendorDescriptionView = (TextView)findViewById(R.id.springboard_featured_vendor_description);
				
				//Set selected values
				selected = position;
				featuredVendorIcon.setImageResource(roster.getVendorAt(position).getIcon());
				featuredVendorName.setText(roster.getVendorAt(position).getName());
				featuredVendorDescriptionView.setText(roster.getVendorAt(position).getDescription());
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResumeParentMethod();

	}
	
	public void launchVendor(View v) {
		Intent intent = new Intent(this, SpringboardVendorActivity.class);
		intent.putExtra("selectedVendor", (Vendor)roster.getVendorAt(SpringboardActivity.selected));
		startActivity(intent);
	}
	
	public void goToNewConversation(View v) {
		Intent intent = new Intent(this, ConversationActivity.class);
		startActivity(intent);
	}
	
	public void goToInbox(View v) {
		Intent intent = new Intent(this, AppActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}

}
