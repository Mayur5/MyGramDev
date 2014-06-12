package me.mygram.views;

import me.mygram.R;
import me.mygram.controllers.adapters.SpringboardRosterViewAdapter;
import me.mygram.controllers.factories.SpringboardServiceFactory;
import me.mygram.controllers.services.SpringboardService;
import me.mygram.models.Roster;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class SpringboardActivity extends Activity {
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;	
	private SpringboardService springboardService;
	private Roster roster = new Roster();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_springboard);
		
		//Instantiate objects
		springboardService = SpringboardServiceFactory.getSpringboardService(this);
		roster.setSpringboardService(springboardService);
		TextView featuredVendorDescriptionView = (TextView)findViewById(R.id.springboard_featured_vendor_description);
		GridView vendorGridView = (GridView)findViewById(R.id.springboard_vendor_grid);
		
		//Dummy Grid inflation
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
				ImageView featuredVendorIcon = (ImageView)findViewById(R.id.springboard_featured_vendor_icon);
				TextView featuredVendorName = (TextView)findViewById(R.id.springboard_featured_vendor_name);
				TextView featuredVendorDescriptionView = (TextView)findViewById(R.id.springboard_featured_vendor_description);
				
				featuredVendorIcon.setImageResource(roster.getVendorAt(position).getIcon());
				featuredVendorName.setText(roster.getVendorAt(position).getName());
				featuredVendorDescriptionView.setText(roster.getVendorAt(position).getDescription());
			}
		});
		
		//Set swipeListener
//		gestureDetector = new GestureDetector(this, new SwipeDetector());
//		gestureListener = new View.OnTouchListener() {	
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				return gestureDetector.onTouchEvent(event);
//			}
//		};		
//		featuredVendorDescriptionView.setOnTouchListener(gestureListener);
//		vendorGridView.setOnTouchListener(gestureListener);
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
	
	private final class SwipeDetector extends SimpleOnGestureListener {
		private static final int SWIPE_MIN_DISTANCE = 120;
	    private static final int SWIPE_MAX_OFF_PATH = 250;
	    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
		
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		    try {
		        if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
		            return false;
		        // right to left swipe
		        if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
		        	SpringboardActivity.swipeLeft(SpringboardActivity.this);
		        }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
		        	SpringboardActivity.swipeRight(SpringboardActivity.this);
		        } 
		    } catch (Exception e) {
		        // nothing
		    }
		    return false;
		}

		@Override
	    public boolean onDown(MotionEvent e) {
			  return true;
	    }
	}
}
