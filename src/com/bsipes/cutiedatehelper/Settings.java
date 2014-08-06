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
//import android.widget.EditText;
import android.widget.Spinner;

public class Settings extends Activity implements OnClickListener {
	public static final String CDHLS = "CDH_Location_Settings";
	CheckBox displayGen3_CB;
	Spinner defaultDivision_S;
	Spinner searchDivision_S;
	Button saveAndSubmit_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		displayGen3_CB = (CheckBox) findViewById(R.id.displayGen3_CB);
		
		defaultDivision_S = (Spinner) findViewById(R.id.DefaultDivision_S);
		searchDivision_S = (Spinner) findViewById(R.id.SearchDivision_S);
		saveAndSubmit_Button = (Button) findViewById(R.id.SaveAndSubmit_Button);
		saveAndSubmit_Button.setOnClickListener(this);
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
		defaultDivision_S.setSelection(CDHSettings.getInt("defaultDivision", 4)); //4 for KC
	}
	
	private void savePreferences(String key, String value)	{
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
	
	private void savePreferences(String key, int value) {
		SharedPreferences CDHSettings = getSharedPreferences(CDHLS,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = CDHSettings.edit();
		editor.putInt(key, value);
		editor.commit();
	}
	
	@Override
	public void onClick(View v) {
		savePreferences("gen3Mode", displayGen3_CB.isChecked());
		savePreferences("defaultDivision", defaultDivision_S.getSelectedItemPosition());
		
		// pass the user data to the main activity
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		intent.putExtra("gen3Mode", displayGen3_CB.isChecked());
		
		//if search is at position 0, no search was entered, assume user wants default
		if (searchDivision_S.getSelectedItemPosition() == 0)
			{searchDivision_S.setSelection(defaultDivision_S.getSelectedItemPosition());}
		
		//translate from the item position to readable text to display to user in MainActivity
		switch (searchDivision_S.getSelectedItemPosition())
		{
		case 1:
			intent.putExtra("divisionName", "ATL");
		case 2:
			intent.putExtra("divisionName", "CAR");
		case 3:
			intent.putExtra("divisionName", "IA (not Omaha)");
		case 4:
			intent.putExtra("divisionName", "KC");
		case 5:
			intent.putExtra("divisionName", "PHO");
		case 6:
			intent.putExtra("divisionName", "STL");
		case 7:
			intent.putExtra("divisionName", "WIC");
		case 8:
			intent.putExtra("divisionName", "OTHER");
		default: //shouldn't ever hit the default. if it does, the if statement above isn't logically correct
			intent.putExtra("divisionName", "ERROR");
		}
		startActivity(intent);
		return;
	}
}
