package com.bsipes.cutiedatehelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends Activity 
{
	public void main()
	{
		GregorianCalendar gc = (GregorianCalendar)GregorianCalendar.getInstance();

		TextView gregorian_TV = (TextView)findViewById(R.id.gregorian_TV);
		gregorian_TV.setText((gc.get(Calendar.MONTH)+1)+"/"+gc.get(Calendar.DAY_OF_MONTH)+"/"+gc.get(Calendar.YEAR));

		TextView julian_TV = (TextView)findViewById(R.id.julian_TV);
		int julian = gc.get(Calendar.DAY_OF_YEAR);
		julian_TV.setText(String.valueOf(julian));
		
		int totalDays = 365;
		if (gc.isLeapYear(Calendar.YEAR))
		{
			totalDays += 1;
		}
//TODO: test how the code handles julian+X = totalDays (likely display 0, where we want 365/366 instead)
		TextView five_TV = (TextView)findViewById(R.id.five_TV);
		five_TV.setText(String.format("%03d", (julian+5)%totalDays));

		TextView seven_TV = (TextView)findViewById(R.id.seven_TV);
		seven_TV.setText(String.format("%03d", (julian+1)%totalDays)+String.format("%03d", (julian+7)%totalDays));

		TextView seven_grillfood_TV = (TextView)findViewById(R.id.seven_grillfood_TV);
		seven_grillfood_TV.setText(String.format("%03d", julian)+", "+String.format("%03d", (julian+2)%totalDays)+", "+String.format("%03d", (julian+7)%totalDays));
		
		TextView ten_TV = (TextView)findViewById(R.id.ten_TV);
		ten_TV.setText(String.format("%03d", julian)+", "+String.format("%03d", (julian+2)%totalDays)+", "+String.format("%03d", (julian+10)%totalDays));

		TextView fourteen_TV = (TextView)findViewById(R.id.fourteen_TV);
		fourteen_TV.setText(String.format("%03d", (julian+1)%totalDays)+String.format("%03d", (julian+14)%totalDays));
		
		TextView thirty_TV = (TextView)findViewById(R.id.thirty_TV);
		thirty_TV.setText(String.format("%03d", (julian+1)%totalDays)+String.format("%03d", (julian+30)%totalDays));

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		main();
	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        switch (item.getItemId()) 
        {
        case R.id.menu_settings:
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);
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