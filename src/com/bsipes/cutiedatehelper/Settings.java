package com.bsipes.cutiedatehelper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
		defaultDivision_S.setSelection(CDHSettings.getInt("defaultDivision", 3)); //3 for KC
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
			{searchDivision_S.setSelection(defaultDivision_S.getSelectedItemPosition()+1);}
		
		//translate from the item position to readable text to display to user in MainActivity
		switch (searchDivision_S.getSelectedItemPosition())
		{
		case 1:
			intent.putExtra("divisionName", "ATL"); break;
		case 2:
			intent.putExtra("divisionName", "CAR"); break;
		case 3:
			intent.putExtra("divisionName", "IA (not Omaha)"); break;
		case 4:
			intent.putExtra("divisionName", "KC"); break;
		case 5:
			intent.putExtra("divisionName", "PHO"); break;
		case 6:
			intent.putExtra("divisionName", "STL"); break;
		case 7:
			intent.putExtra("divisionName", "WIC"); break;
		case 8:
			intent.putExtra("divisionName", "OTHER"); break;
		default: //shouldn't ever hit the default. if it does, the IF statement above isn't logically correct, or the switch isn't correct
			intent.putExtra("divisionName", "ERROR"); 
		}
		startActivity(intent);
		return;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        switch (item.getItemId()) 
        {
        case R.id.menu_settings:
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
            break;
        case R.id.menu_about:
        	Intent intent2 = new Intent(this, About.class);
        	startActivity(intent2);
        	break;
        case R.id.menu_storeList:
        	Intent intent3 = new Intent(this, StoreList.class);
        	startActivity(intent3);
        	break;
        }
        return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
