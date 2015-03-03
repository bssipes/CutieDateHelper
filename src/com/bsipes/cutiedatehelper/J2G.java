package com.bsipes.cutiedatehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
	int input = 0;
	GregorianCalendar gc;
	// manual julian calculator
	TextView mjc_final_j_tv;
	TextView mjc_final_g_tv;
	Button mjc_button;
	EditText mjc_plus_et;
	EditText mjc_orig_et;

	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_j2g);
		// manual julian calculator (has 2 edittext, 1 button, 2 textviews)
		mjc_final_j_tv = (TextView) findViewById(R.id.mjc_final_j_tv);
		mjc_final_g_tv = (TextView) findViewById(R.id.mjc_final_g_tv);
		mjc_button = (Button) findViewById(R.id.mjc_button);
		mjc_plus_et = (EditText) findViewById(R.id.mjc_plus_et);
		mjc_orig_et = (EditText) findViewById(R.id.mjc_orig_et);
		gc = (GregorianCalendar) GregorianCalendar.getInstance();
		super.onCreate(savedInstanceState);

		main();
	}// end onCreate

	public void addmjc(View v) {
		//4 previous functions got smashed into this bad boy in order to help the user
		//by eliminating the need to decide WHICH they needed to use. The name is deprecated.
		int plus = 0;
		String george = mjc_orig_et.getText().toString();
		// george is a play on words from jorg, julian or gregorian.
		String[] items = george.split("/");
		if (items.length == 3) {
			// gregorian calendar date entered
			if (TextUtils.isDigitsOnly(items[0])
					&& TextUtils.isDigitsOnly(items[1])
					&& TextUtils.isDigitsOnly(items[2])) {
				if (Integer.valueOf(items[0]) > 0
						&& Integer.valueOf(items[0]) <= 12) {
					gc.set(Calendar.MONTH, (Integer.valueOf(items[0])) - 1);
					// calendar month is 0 based
				} else {
					Toast.makeText(this, "Invalid MONTH entered",
							Toast.LENGTH_LONG).show();
					mjc_final_j_tv.setText("final date (julian)");
					mjc_final_g_tv.setText("final date (gregorian)");
					return;
				}
				if ((Integer.valueOf(items[1]) > 0) && (Integer.valueOf(items[1]) <= 31)) {
					gc.set(Calendar.DAY_OF_MONTH, Integer.valueOf(items[1]));
				} else {
					Toast.makeText(this, "Invalid DAY entered",
							Toast.LENGTH_LONG).show();
					mjc_final_j_tv.setText("final date (julian)");
					mjc_final_g_tv.setText("final date (gregorian)");
					gc = (GregorianCalendar) GregorianCalendar.getInstance(); // reset the calendar
					return;
				}
				// no check for years. as long as they are only digits and
				// month/day passed, let it fly.
				gc.set(Calendar.YEAR, Integer.valueOf(items[2]));
				// add the requested amount of days
				if (mjc_plus_et.getText().toString().length() == 0) {
					mjc_plus_et.setText("0");
				} else if (TextUtils.isDigitsOnly(mjc_plus_et.getText()
						.toString())) {
					plus = Integer.valueOf(mjc_plus_et.getText().toString());
				} else {
					Toast.makeText(this,
							"Can't add that amount (no letters or symbols)",
							Toast.LENGTH_LONG).show();
					mjc_final_j_tv.setText("final date (julian)");
					mjc_final_g_tv.setText("final date (gregorian)");
					return;
				}
				gc.add(Calendar.DAY_OF_MONTH, plus);
				mjc_final_j_tv.setText(String.format("%03d",
						gc.get(Calendar.DAY_OF_YEAR))); // displays julian day
				mjc_final_g_tv.setText((gc.get(Calendar.MONTH) + 1) + "/"
						+ gc.get(Calendar.DAY_OF_MONTH) + "/"
						+ gc.get(Calendar.YEAR)); // display the calendar date
				gc = (GregorianCalendar) GregorianCalendar.getInstance(); // reset the calendar
				return;
			} else {
				Toast.makeText(this, "3 entries found, but not all numbers. Please use DDD for Julian and MM/DD/YYYY for Calendar Dates.",
						Toast.LENGTH_LONG).show();
				mjc_final_j_tv.setText("final date (julian)");
				mjc_final_g_tv.setText("final date (gregorian)");
				return;
			}
		} else if (items.length == 1) {
			// julian day entered
			if ((mjc_orig_et.getText().toString().length() == 0)) {
				// since items.length==1, this shouldn't ever happen, but
				// better safe than sorry.
				Toast.makeText(this, "The original date is blank",
						Toast.LENGTH_LONG).show();
				mjc_final_j_tv.setText("final date (julian)");
				mjc_final_g_tv.setText("final date (gregorian)");
				return;
			}
			if (TextUtils.isDigitsOnly(mjc_orig_et.getText().toString())) {
				input = Integer.valueOf(mjc_orig_et.getText().toString());
			} else {
				Toast.makeText(
						this,
						"Found 1 entry, but not all numbers. Please use DDD for Julian and MM/DD/YYYY for Calendar Dates.",
						Toast.LENGTH_LONG).show();
				mjc_final_j_tv.setText("final date (julian)");
				mjc_final_g_tv.setText("final date (gregorian)");
				return;
			}
			if ((input > 0 && input <= 365)
					|| (gc.isLeapYear(Calendar.YEAR) && input == 365)) {
				if (mjc_plus_et.getText().toString().length() == 0) {
					mjc_plus_et.setText("0");

				} else if (TextUtils.isDigitsOnly(mjc_plus_et.getText()
						.toString())) {
					plus = Integer.valueOf(mjc_plus_et.getText().toString());
				} else {
					Toast.makeText(this,
							"Can't add that amount (no letters or symbols)",
							Toast.LENGTH_LONG).show();
					mjc_final_j_tv.setText("final date (julian)");
					mjc_final_g_tv.setText("final date (gregorian)");
					return;
				}
				gc.set(Calendar.DAY_OF_YEAR, input); // set the original date
				gc.add(Calendar.DAY_OF_MONTH, plus);
				mjc_final_j_tv.setText(String.format("%03d",
						gc.get(Calendar.DAY_OF_YEAR))); // display the julian
				mjc_final_g_tv.setText((gc.get(Calendar.MONTH) + 1) + "/"
						+ gc.get(Calendar.DAY_OF_MONTH) + "/"
						+ gc.get(Calendar.YEAR)); // display the calendar date
				gc = (GregorianCalendar) GregorianCalendar.getInstance(); // reset the calendar
				return;
				// add the plus amount (doing it this way ensures the year
				// is correct, thus ensuring leap years are accounted for)
			} else {
				// couldn't figure out what they entered
				Toast.makeText(this, "Invalid day entered.", Toast.LENGTH_LONG)
						.show();
				return;
			}
		} else { // items.length != 3 && != 1
			Toast.makeText(
					this,
					"Couldn't make heads or tails of that. Please use DDD for Julian and MM/DD/YYYY for Calendar Dates.",
					Toast.LENGTH_LONG).show();
			return;
		}
	}// addmjc

	public void main() {}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
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
		case R.id.Home:
        	Intent intent5 = new Intent(this, MainActivity.class);
        	startActivity(intent5);
        	break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
