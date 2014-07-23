package me.mygram.example.controllers.adapters;

import java.text.DateFormat;

import me.mygram.R;
import me.mygram.example.client.CredentialsActivity;
import me.mygram.example.client.MySpringboardActivity;
import me.mygram.models.Contact;
import me.mygram.models.Conversation;
import me.mygram.models.Mail;
import me.mygram.models.MyMessage;
import me.mygram.models.Notification;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ConversationViewAdapter extends ArrayAdapter<MyMessage> {
	
	private Context context;
	private Conversation conversation;

	public ConversationViewAdapter(Context context, int resource, Conversation conversation) {
		super(context, resource, conversation.getMessages());
		this.context = context;
		this.conversation = conversation;
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	public View getView(int position, View convertView, ViewGroup parent) {
		DateFormat df = DateFormat.getDateInstance();
		
		//Initialize view objects
		Contact correspondent = (Contact) conversation.getMessageAt(position).getCorrespondent();
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.conversation_item, parent, false);
		WebView messageBodyWebView = (WebView)rowView.findViewById(R.id.message_text);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.image_attachment);
		TextView timeStampTextView = (TextView)rowView.findViewById(R.id.conversation_message_time_stamp);
		MyMessage m = conversation.getMessageAt(position);
		
		//Set Message text, time stamp
		messageBodyWebView.getSettings().setJavaScriptEnabled(true);
		messageBodyWebView.setWebViewClient(new MyWebViewClient());
		messageBodyWebView.loadDataWithBaseURL("nada", m.toString(), "text/html", "utf-8", "");
		timeStampTextView.setText(df.format(m.receivedTimeStamp()));
		
		//Handle attachments - two different cases for email and notifications, TODO
		if (m.isEmail()) {
			imageView.setImageResource(((Mail) m).getAttachment());
		}
		if (m.isNotification()) {
			imageView.setImageResource(((Notification) m).getAttachment());
		}
		
		//Align right if sender is self
		if (correspondent.isSelf()) {
			RelativeLayout.LayoutParams messageBodyWebViewParams = (RelativeLayout.LayoutParams)messageBodyWebView.getLayoutParams();
			messageBodyWebViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
			messageBodyWebViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			messageBodyWebView.setLayoutParams(messageBodyWebViewParams);
			
			RelativeLayout.LayoutParams timeStampTextViewParams = (RelativeLayout.LayoutParams)timeStampTextView.getLayoutParams();
			timeStampTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
			timeStampTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			timeStampTextView.setLayoutParams(messageBodyWebViewParams);
			
			RelativeLayout.LayoutParams imageViewParams = (RelativeLayout.LayoutParams)imageView.getLayoutParams();
			imageViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
			imageViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			imageView.setLayoutParams(imageViewParams);
		}
		
		return rowView;
	}
	
	@SuppressLint("DefaultLocale")
	private class MyWebViewClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	    	if (url.toLowerCase().contains("http://settings")) {
	    		Intent intent = new Intent(context, CredentialsActivity.class);
		    	intent.putExtra("url", url);
		    	context.startActivity(intent);
		        return false;
	    	}
	    	Intent intent = new Intent(context, MySpringboardActivity.class);
	    	intent.putExtra("url", url);
	    	context.startActivity(intent);
	        return true;
	    }
	}
}
