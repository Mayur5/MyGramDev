package me.mygram.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import me.mygram.example.client.AppActivity;

public class SampleAppActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent(this, AppActivity.class);
		startActivity(intent);
	}

}
