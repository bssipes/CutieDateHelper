package com.bsipes.cutiedatehelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Settings extends Activity implements OnClickListener {
	public static final String CDHLS = "CDH_Location_Settings";
	CheckBox displayGen3_CB;
	EditText defaultStore_ET;
	EditText searchStore_ET;
	Button saveAndSubmitStore_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		defaultStore_ET = (EditText) findViewById(R.id.DefaultStore_ET);
		searchStore_ET = (EditText) findViewById(R.id.SearchStore_ET);
		
		saveAndSubmitStore_Button = (Button) findViewById(R.id.SaveAndSubmitStore_Button);
		saveAndSubmitStore_Button.setOnClickListener(this);
		loadSavedPreferences();
	}

	private void loadSavedPreferences() {
		SharedPreferences CDHSettings = getSharedPreferences(CDHLS,
				Context.MODE_PRIVATE);

		boolean gen3Mode = CDHSettings.getBoolean("gen3Mode", false);
		if (gen3Mode) {
			displayGen3_CB.setChecked(true);
		} else {
			displayGen3_CB.setChecked(false);
		}

		String searchStore = CDHSettings.getString("lastSearchedStore", "");
		searchStore_ET.setText(searchStore);

		String defaultStore = CDHSettings.getString("defaultStore", "");
		defaultStore_ET.setText(defaultStore);

	}

	private void savePreferences(String key, String value) {
		SharedPreferences CDHSettings = getSharedPreferences(CDHLS,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = CDHSettings.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	private void savePreferences(String key, boolean value) {
		SharedPreferences CDHSettings = getSharedPreferences(CDHLS,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = CDHSettings.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	@Override
	public void onClick(View v) {
		savePreferences("gen3Mode", displayGen3_CB.isChecked());
		savePreferences("defaultStore", defaultStore_ET.getText().toString());
		
		//If no search store was entered, assume the user wants their default store
		if (searchStore_ET.getText().toString() == "")
		{
			searchStore_ET.setText(defaultStore_ET.getText().toString());
		}
		
		Intent intent = new Intent(this, MainActivity.class);
		//pass the user data to the main activity
		intent.putExtra("store", searchStore_ET.getText().toString());
		intent.putExtra("gen3Mode",displayGen3_CB.isChecked());
		startActivity(intent);
		finish();
	}
}