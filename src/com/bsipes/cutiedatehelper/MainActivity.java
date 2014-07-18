package com.bsipes.cutiedatehelper;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity 
{

	public String store; // set in onCreate
	public boolean gen3Mode; // set in onCreate
	TextView displayStoreNumber_TV;

	public void main() 
	{
		GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();

		TextView gregorian_TV = (TextView) findViewById(R.id.gregorian_TV);
		gregorian_TV.setText((gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));

		TextView julian_TV = (TextView) findViewById(R.id.julian_TV);
		int julian = gc.get(Calendar.DAY_OF_YEAR);
		julian_TV.setText(String.valueOf(julian));

		int totalDays = 365;
		if (gc.isLeapYear(Calendar.YEAR)) {
			totalDays += 1;
		setgen2Dates(store, julian);
		}
	}
	private void setgen2Dates(String store, int julian) {
		//declare all the textviews
		TextView gen2_chilicheese_date = (TextView) findViewById(R.id.gen2_chilicheese_date);
		TextView gen2_wallcoolerpizzas_date = (TextView) findViewById(R.id.gen2_wallcoolerpizzas_date);
		TextView gen2_grillfood_date = (TextView) findViewById(R.id.gen2_grillfood_date);
		TextView gen2_hotzis_date = (TextView) findViewById(R.id.gen2_hotzis_date);
		TextView gen2_wallcoolerburritos_date = (TextView) findViewById(R.id.gen2_wallcoolerburritos_date);
		TextView gen2_nemo_date = (TextView) findViewById(R.id.gen2_nemo_date);
//TODO:lookup the division number
		int d = findDivision(store); //this is just a stub at the moment
//TODO:lookup the dates (dates? dating patterns?) for that division
		//If I store the dating patterns, how should I do that? Some categories have 2 dates, some have 3.
//TODO:set the text for the textview based on this data
//		gen2_chilicheese_date.setText("");
//		gen2_wallcoolerpizzas_date.setText("");
//		gen2_grillfood_date.setText("");
//		gen2_hotzis_date.setText("");
//		gen2_wallcoolerburritos_date.setText("");
//		gen2_nemo_date.setText("");
		
	}

	private int findDivision(String store) {
		// TODO Auto-generated method stub
		return 0;
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bundle bundle = getIntent().getExtras();
		store = bundle.getString("store");
		displayStoreNumber_TV = (TextView) findViewById(R.id.DisplayStoreNumber_TV);
		displayStoreNumber_TV.setText(store);
		gen3Mode = bundle.getBoolean("gen3Mode");
	}// end onCreate
}
