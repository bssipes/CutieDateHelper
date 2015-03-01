package com.bsipes.cutiedatehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class J2G extends Activity {
		TextView cd_tv;
		TextView fd_tv;
		Button j2g_button;
		Button add_button;
		EditText j_et;
		EditText a_et;
		int input = 0;
		GregorianCalendar gc;
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_j2g);
		cd_tv = (TextView)findViewById(R.id.convertedDate);
		fd_tv = (TextView)findViewById(R.id.finalDate);
		j2g_button = (Button)findViewById(R.id.j2g_button);
		add_button = (Button)findViewById(R.id.add_button);
		j_et = (EditText)findViewById(R.id.j2g_et);
		a_et = (EditText)findViewById(R.id.add_et);
		gc = (GregorianCalendar) GregorianCalendar.getInstance();
		super.onCreate(savedInstanceState);
		
		main();
	}// end onCreate

	public void convert(View v) {
		
		String temp = j_et.getText().toString();
		input = Integer.valueOf(j_et.getText().toString());
		if (input > 0 && input <=365 || (gc.isLeapYear(Calendar.YEAR) && input == 365 ))
		{
			gc.set(Calendar.DAY_OF_YEAR, input);
			cd_tv.setText((gc.get(Calendar.MONTH) + 1)+"/"+gc.get(Calendar.DAY_OF_MONTH)+"/"+gc.get(Calendar.YEAR));
		}
		else
		{
			Toast.makeText(this, "Invalid Julian Day entered", Toast.LENGTH_LONG).show();
		}
	}
	
	public void main() {
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
        case R.id.menu_julianConverter:
        	Intent intent4 = new Intent(this, J2G.class);
        	startActivity(intent4);
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
