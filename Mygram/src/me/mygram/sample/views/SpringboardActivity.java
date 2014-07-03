package me.mygram.sample.views;

import me.mygram.R;
import me.mygram.controllers.factories.SpringboardServiceFactory;
import me.mygram.controllers.services.SpringboardService;
import me.mygram.models.Roster;
import me.mygram.models.Vendor;
import me.mygram.sample.controllers.adapters.SpringboardRosterViewAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class SpringboardActivity extends Activity {
	private SpringboardService springboardService;
	private static Roster roster = new Roster();
	private static int selected;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_springboard);
		
		//Instantiate objects
		springboardService = SpringboardServiceFactory.getSpringboardService(this);
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
	
	public void launchVendor(View v) {
		Intent intent = new Intent(this, SpringboardVendorActivity.class);
		intent.putExtra("selectedVendor", (Vendor)roster.getVendorAt(SpringboardActivity.selected));
		startActivity(intent);
	}
	
	protected static void swipeRight(Context context) {
		// TODO Auto-generated method stub
		
	}

	protected static void swipeLeft(Context context) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		context.startActivity(intent);
	}

}
