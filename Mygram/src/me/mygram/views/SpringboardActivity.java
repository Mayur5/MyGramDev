package me.mygram.views;

import me.mygram.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class SpringboardActivity extends Activity {
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;	
	
	static final String[] numbers = new String[] { 
		"A", "B", "C", "D", "E",
		"F", "G", "H", "I", "J",
		"K", "L", "M", "N", "O",
		"P", "Q", "R", "S", "T",
		"U", "V", "W", "X", "Y", "Z"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_springboard);
		
		//Instantiate objects
		TextView featuredVendorDescriptionView = (TextView)findViewById(R.id.springboard_featured_vendor_description);
		GridView vendorGridView = (GridView)findViewById(R.id.springboard_vendor_grid);
		
		//Dummy Grid inflation
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);
		vendorGridView.setAdapter(adapter);
		
		//Set swipeListener
		gestureDetector = new GestureDetector(this, new SwipeDetector());
		gestureListener = new View.OnTouchListener() {	
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};		
		featuredVendorDescriptionView.setOnTouchListener(gestureListener);
		vendorGridView.setOnTouchListener(gestureListener);
	}
	
	protected static void swipeRight(Context context) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, ConversationActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		context.startActivity(intent);
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
