package me.mygram.controllers.adapters;

import java.util.ArrayList;

import me.mygram.R;
import me.mygram.models.Roster;
import me.mygram.models.Vendor;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SpringboardRosterViewAdapter extends BaseAdapter {
	private Context context;
	private Roster roster;
	
	public SpringboardRosterViewAdapter(Context context, Roster roster) {
		this.context = context;
		this.roster = roster;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return roster.getVendors().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ArrayList<Vendor> vendors = roster.getVendors();
				
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View springboardVendorGridView;
		
		if(convertView == null) {
			//inflate item view
			springboardVendorGridView = new View(context);
			springboardVendorGridView = inflater.inflate(R.layout.springboard_vendor_grid_item, null);
			
			//Get layout from springboard_vendor_grid_item
			TextView vendorName = (TextView)springboardVendorGridView.findViewById(R.id.springboard_vendor_grid_vendor_name);
			ImageView vendorIcon = (ImageView)springboardVendorGridView.findViewById(R.id.springboard_vendor_grid_vendor_icon);
			
			//Set values
			vendorName.setText(vendors.get(position).getName());
			vendorIcon.setImageResource(vendors.get(position).getIcon());
			
		} else {
			springboardVendorGridView = (View) convertView;
		}
		
		return springboardVendorGridView;
	}

}
