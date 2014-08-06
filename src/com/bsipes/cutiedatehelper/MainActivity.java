package com.bsipes.cutiedatehelper;
import java.util.Calendar;
import java.util.GregorianCalendar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	String divisionName; //set in onCreate
	public boolean gen3Mode; // set in onCreate
	TextView displayStoreNumber_TV;
	//STL, CAR, WIC, and IA are all currently identical. May change in the future.
	Division STL = new	Division("STL", 	5,7,7 ,7, 14,13,30);
	Division CAR = new	Division("CAR", 	5,7,7 ,7, 14,13,30);
	Division WIC = new	Division("WIC", 	5,7,7 ,7, 14,13,30);
	Division IA = new	Division("IA",  	5,7,7 ,7, 14,13,30);
	Division ATL = new	Division("ATL", 	5,7,10,7 ,14,13,30); //10 days for grillfood
	Division PHO = new	Division("PHO", 	5,7,7 ,10,14,13,30); //10 days for hotzi
	Division KC = new	Division("KC",		5,7,7 ,10,14,13,30); //10 days for hotzi
	Division OTHER = new Division("OTHER",	5,7,10,10,14,13,30); //10 days for grillfood AND 10 days for hotzi
	
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
		setgen2Dates(julian);
		}
	}
	private void setgen2Dates(int julian) {
		//declare all the textviews
		TextView gen2_chilicheese_date = (TextView) findViewById(R.id.gen2_chilicheese_date);
		TextView gen2_wallcoolerpizzas_date = (TextView) findViewById(R.id.gen2_wallcoolerpizzas_date);
		TextView gen2_grillfood_date = (TextView) findViewById(R.id.gen2_grillfood_date);
		TextView gen2_hotzis_date = (TextView) findViewById(R.id.gen2_hotzis_date);
		TextView gen2_wallcoolerburritos_date = (TextView) findViewById(R.id.gen2_wallcoolerburritos_date);
		TextView gen2_wallcoolerhotpockets_date = (TextView) findViewById(R.id.gen2_wallcoolerhotpockets_date);
		TextView gen2_nemo_date = (TextView) findViewById(R.id.gen2_nemo_date);
//TODO:set the text for the textview based on this data
//		gen2_chilicheese_date.setText("");
//		gen2_wallcoolerpizzas_date.setText("");
//		gen2_grillfood_date.setText("");
//		gen2_hotzis_date.setText("");
//		gen2_wallcoolerburritos_date.setText("");
//		gen2_wallcoolerhotpockets_date.setText("");
//		gen2_nemo_date.setText("");
		
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bundle bundle = getIntent().getExtras();
		divisionName = bundle.getString("divisionName");
		displayStoreNumber_TV = (TextView) findViewById(R.id.DisplayStoreNumber_TV);
		displayStoreNumber_TV.setText(divisionName);
		gen3Mode = bundle.getBoolean("gen3Mode");
	}// end onCreate
}
