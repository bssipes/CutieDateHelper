package com.bsipes.cutiedatehelper;

import android.app.Activity;
import android.content.Context;
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
	Button saveDefaultStore_Button;
	Button submitSearchStore_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		defaultStore_ET = (EditText) findViewById(R.id.DefaultStore_ET);
		searchStore_ET = (EditText) findViewById(R.id.SearchStore_ET);
		
		saveDefaultStore_Button = (Button) findViewById(R.id.SaveDefaultStore_Button);
		saveDefaultStore_Button.setOnClickListener(this);
		
		submitSearchStore_Button = (Button) findViewById(R.id.SubmitSearchStore_Button);
		submitSearchStore_Button.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {

	}
}