package com.bsipes.cutiedatehelper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	public String store; //set in onCreate
	public boolean gen3Mode; //set in onCreate
	TextView displayStoreNumber_TV;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bundle bundle = getIntent().getExtras();
		store = bundle.getString("store");
		displayStoreNumber_TV = (TextView) findViewById(R.id.DisplayStoreNumber_TV);
		displayStoreNumber_TV.setText(store);
		gen3Mode = bundle.getBoolean("gen3Mode");
	}//end onCreate
}
