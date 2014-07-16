package com.bsipes.cutiedatehelper;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	public String store; //set in onCreate
	public boolean gen3Mode; //set in onCreate
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bundle bundle = getIntent().getExtras();
		store = bundle.getString("store");
		gen3Mode = bundle.getBoolean("gen3Mode");
	}//end onCreate
}
