package com.bsipes.cutiedatehelper;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	private String divisionName; //set in onCreate
	public TextView displayStoreNumber_TV;
	public HashMap<String, Division> divisions = new HashMap<String, Division>();
	public int totalDays = 365;
	public int julian = 0;
	
	//STL, CAR, WIC, and IA are all currently identical. May change in the future.
	//Refer to Division Constructor to see what all the numbers are being linked to
	Division STL = new	Division("STL", 	5,7,7 ,7, 14,13,30,10,7,7); //St Louis
	Division CAR = new	Division("CAR", 	5,7,7 ,7, 14,13,30,5,5,5); //Carolinas
	Division WIC = new	Division("WIC", 	5,7,7 ,7, 14,13,30,7,7,7); //Wichita
	Division IA = new	Division("IA",  	5,7,7 ,7, 14,13,30,10,7,7); //Iowa
	Division ATL = new	Division("ATL", 	5,7,10,7 ,14,13,30,10,7,7); //10 days for grillfood
	Division PHO = new	Division("PHO", 	5,7,7 ,10,14,13,30,7,7,7); //10 days for hotzi
	Division KC = new	Division("KC",		5,7,7 ,10,14,13,30,7,7,7); //10 days for hotzi
	Division OTHER = new Division("OTHER",	5,7,10,10,14,13,30,10,7,7); //10 days for grillfood AND 10 days for hotzi
	
	public void main() 
	{
		divisions.put("STL", STL);
		divisions.put("CAR", CAR);
		divisions.put("WIC", WIC);
		divisions.put("IA",  IA);
		divisions.put("ATL", ATL);
		divisions.put("PHO", PHO);
		divisions.put("KC", KC);
		divisions.put("OTHER", OTHER);
		
		GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
		//gc.add(Calendar.DAY_OF_MONTH, 3);
		//gc.add(Calendar.DAY_OF_MONTH, -3);
		TextView gregorian_TV = (TextView) findViewById(R.id.gregorian_TV);
		gregorian_TV.setText((gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));

		TextView julian_TV = (TextView) findViewById(R.id.julian_TV);
		julian = gc.get(Calendar.DAY_OF_YEAR);
		julian_TV.setText(String.valueOf(julian));

		if (gc.isLeapYear(Calendar.YEAR)) 
		{
			totalDays += 1;
		}
		setgen2Dates();
		setgen3Dates();
	}//end main
	private int checkRollover(int offset) {
		if ((julian+offset)==totalDays) {
			offset = totalDays;
		}
		else {
			offset = ((julian+offset)%totalDays);
		}
			
		return offset;
	}
	private void setgen2Dates() {
		//declare all the textviews
		TextView gen2_chilicheese_date = (TextView) findViewById(R.id.gen2_chilicheese_date);
		TextView gen2_whippedTopper_date = (TextView) findViewById(R.id.gen2_whippedTopper_date);
		TextView gen2_wallcoolerpizzas_date = (TextView) findViewById(R.id.gen2_wallcoolerpizzas_date);
		TextView gen2_grillfood_date = (TextView) findViewById(R.id.gen2_grillfood_date);
		TextView gen2_hotzis_date = (TextView) findViewById(R.id.gen2_hotzis_date);
		TextView gen2_wallcoolerburritos_date = (TextView) findViewById(R.id.gen2_wallcoolerburritos_date);
		TextView gen2_wallcoolerhotpockets_date = (TextView) findViewById(R.id.gen2_wallcoolerhotpockets_date);
		TextView gen2_nemo_date = (TextView) findViewById(R.id.gen2_nemo_date);
		
		gen2_chilicheese_date.setText(String.format("%03d", 
				checkRollover(divisions.get(divisionName).getCC())));
		
		gen2_whippedTopper_date.setText(String.format("%03d", 
				checkRollover(14)));
		
		gen2_wallcoolerpizzas_date.setText(String.format("%03d", 
				checkRollover(1)) +	String.format("%03d", 
				checkRollover(divisions.get(divisionName).getWCP())));
		
		gen2_grillfood_date.setText(String.format("%03d", julian)+", "+ String.format("%03d", 
				checkRollover(2))+", "+ String.format("%03d", 
				checkRollover(divisions.get(divisionName).getGF())));
		
		gen2_hotzis_date.setText(String.format("%03d", julian)+", "+ String.format("%03d", 
				checkRollover(2)%totalDays)+", "+ String.format("%03d", 
				checkRollover(divisions.get(divisionName).getHotzi())));
		
		gen2_wallcoolerburritos_date.setText(String.format("%03d", 
				checkRollover(1))+ String.format("%03d", 
				checkRollover(divisions.get(divisionName).getWCB())));
		
		gen2_wallcoolerhotpockets_date.setText(String.format("%03d", 
				checkRollover(1))+ String.format("%03d", 
				checkRollover(divisions.get(divisionName).getWCHP())));
		
		gen2_nemo_date.setText(String.format("%03d", julian) + String.format("%03d", 
				checkRollover(divisions.get(divisionName).getNemo())));
		return;
	}
	
	private void setgen3Dates() {
		//declare all the textviews
		GregorianCalendar gc3 = (GregorianCalendar) GregorianCalendar.getInstance();
		String temp = "";
		
		TextView gen3_softServe = (TextView) findViewById(R.id.gen3_softServe);
		TextView gen3_nonfatYogurt = (TextView) findViewById(R.id.gen3_nonfatYogurt);
		TextView gen3_smoothieBaseMix = (TextView) findViewById(R.id.gen3_smoothieBaseMix);
		TextView gen3_moninDavinciSyrup = (TextView) findViewById(R.id.gen3_moninDavinciSyrup);
		TextView gen3_ghiradelliDavinciSauce = (TextView) findViewById(R.id.gen3_ghiradelliDavinciSauce);
		TextView gen3_candyPieces = (TextView) findViewById(R.id.gen3_candyPieces);
		TextView gen3_espressoBiB = (TextView) findViewById(R.id.gen3_espressoBiB);
		TextView gen3_smoothieJuice = (TextView) findViewById(R.id.gen3_smoothieJuice);
		TextView gen3_smoothieAddins = (TextView) findViewById(R.id.gen3_smoothieAddins);
		TextView gen3_frozenLemonades = (TextView) findViewById(R.id.gen3_frozenLemonades);
		TextView gen3_phaseButterSub = (TextView) findViewById(R.id.gen3_phaseButterSub);
		TextView gen3_pretzels = (TextView) findViewById(R.id.gen3_pretzels);
		TextView gen3_pretzelCheeseMarinara = (TextView) findViewById(R.id.gen3_pretzelCheeseMarinara);
		TextView gen3_pretzelToppings = (TextView) findViewById(R.id.gen3_pretzelToppings);
		TextView gen3_pizzaCrust7 = (TextView) findViewById(R.id.gen3_pizzaCrust7);
		TextView gen3_pizzaCrust16 = (TextView) findViewById(R.id.gen3_pizzaCrust16);
		TextView gen3_pizzaCheese = (TextView) findViewById(R.id.gen3_pizzaCheese);
		TextView gen3_pepperoni = (TextView) findViewById(R.id.gen3_pepperoni);
		TextView gen3_sausage = (TextView) findViewById(R.id.gen3_sausage);
		TextView gen3_pizzaSauce = (TextView) findViewById(R.id.gen3_pizzaSauce);
		TextView gen3_pizzaVegetables = (TextView) findViewById(R.id.gen3_pizzaVegetables);
		TextView gen3_kolaches = (TextView) findViewById(R.id.gen3_kolaches);
		TextView gen3_toastedSandwiches = (TextView) findViewById(R.id.gen3_toastedSandwiches);
		TextView gen3_flatbreads = (TextView) findViewById(R.id.gen3_flatbreads);
		TextView gen3_ranchSqueeze = (TextView) findViewById(R.id.gen3_ranchSqueeze);
		TextView gen3_ranchGallon = (TextView) findViewById(R.id.gen3_ranchGallon);
		TextView gen3_chipMayoSqueeze = (TextView) findViewById(R.id.gen3_chipMayoSqueeze);
		TextView gen3_bbqSqueeze = (TextView) findViewById(R.id.gen3_bbqSqueeze);
		TextView gen3_bbqGallon = (TextView) findViewById(R.id.gen3_bbqGallon);
		TextView gen3_eggPatty = (TextView) findViewById(R.id.gen3_eggPatty);
		TextView gen3_cherries = (TextView) findViewById(R.id.gen3_cherries);
		TextView gen3_sausageGravy = (TextView) findViewById(R.id.gen3_sausageGravy);
		TextView gen3_scrambledEggs = (TextView) findViewById(R.id.gen3_scrambledEggs);
		TextView gen3_baconStrips = (TextView) findViewById(R.id.gen3_baconStrips);
		TextView gen3_baconCrumbles = (TextView) findViewById(R.id.gen3_baconCrumbles);
		TextView gen3_joyCones = (TextView) findViewById(R.id.gen3_joyCones);
		TextView gen3_frappeBase = (TextView) findViewById(R.id.gen3_frappeBase);
		TextView gen3_chickenTenders = (TextView) findViewById(R.id.gen3_chickenTenders);
		TextView gen3_honeyMustardSqueeze = (TextView) findViewById(R.id.gen3_honeyMustardSqueeze);
		TextView gen3_honeyMustardGallon = (TextView) findViewById(R.id.gen3_honeyMustardGallon);
		TextView gen3_hamSlice = (TextView) findViewById(R.id.gen3_hamSlice);
		TextView gen3_sausagePatty = (TextView) findViewById(R.id.gen3_sausagePatty);
		
		
//(gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+gc3.get(Calendar.MINUTE)
		
		gc3.add(Calendar.DAY_OF_MONTH, 10);
		gen3_softServe.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gen3_nonfatYogurt.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gen3_smoothieBaseMix.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -10);
		
		gc3.add(Calendar.DAY_OF_MONTH, 45);
		gen3_moninDavinciSyrup.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -45);
		
		gc3.add(Calendar.DAY_OF_MONTH, 21);
		gen3_ghiradelliDavinciSauce.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -21);
		
		gc3.add(Calendar.DAY_OF_MONTH, 60);
		gen3_candyPieces.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -60);
		
		gc3.add(Calendar.MONTH, 6);
		gen3_espressoBiB.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.MONTH, -6);
		
		gc3.add(Calendar.DAY_OF_MONTH, 3);
		gen3_smoothieJuice.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -3);
		
		gen3_smoothieAddins.setText("MFR Code Date");
				
		gc3.add(Calendar.DAY_OF_MONTH, 60);
		temp = (gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n\n";
		gc3.add(Calendar.DAY_OF_MONTH, -60);
		gc3.add(Calendar.DAY_OF_MONTH, 21);
		temp = temp.concat((gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nSTICKER DATE");
		gc3.add(Calendar.DAY_OF_MONTH, -21);
		gen3_frozenLemonades.setText(temp);
			
		gen3_phaseButterSub.setText("MFG DATE + 270D");
		
		gc3.add(Calendar.DAY_OF_MONTH, 2);
		gc3.add(Calendar.HOUR_OF_DAY, 4);
		gen3_pretzels.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.DAY_OF_MONTH, -2);
		gc3.add(Calendar.HOUR_OF_DAY, -4);
		
		gc3.add(Calendar.DAY_OF_MONTH, 5);
		gen3_pretzelCheeseMarinara.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -5);

		gen3_pretzelToppings.setText("QTK DATED");
		
		gc3.add(Calendar.HOUR_OF_DAY, 54);
		gen3_pizzaCrust7.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.HOUR_OF_DAY, -54);
		
		gc3.add(Calendar.HOUR_OF_DAY, 30);
		gen3_pizzaCrust16.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.HOUR_OF_DAY, -30);
		
		gc3.add(Calendar.DAY_OF_MONTH, 7);
		gen3_pizzaCheese.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.DAY_OF_MONTH, -7);
			
		gc3.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getPS());
		gen3_pepperoni.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gen3_sausage.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getPS());
		
		gc3.add(Calendar.DAY_OF_MONTH, 5);
		gen3_pizzaSauce.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.DAY_OF_MONTH, -5);
		
		gen3_pizzaVegetables.setText("QTK DATED");
		
		gc3.add(Calendar.HOUR_OF_DAY, 29);
		gen3_kolaches.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.HOUR_OF_DAY, -29);
		
		gen3_toastedSandwiches.setText("QTK DATED");
		gen3_flatbreads.setText("QTK DATED");
		
		gen3_ranchSqueeze.setText("Use Date On\nOpened Gallon");
		
		gc3.add(Calendar.MONTH, 2);
		gen3_ranchGallon.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.MONTH, -2);
			
		gc3.add(Calendar.DAY_OF_MONTH, 21);
		gen3_chipMayoSqueeze.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nSTICKER DATE");
		gc3.add(Calendar.DAY_OF_MONTH, -21);

		gc3.add(Calendar.DAY_OF_MONTH, 30);
		gen3_bbqSqueeze.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nSTICKER DATE");
		gc3.add(Calendar.DAY_OF_MONTH, -30);
		
		gc3.add(Calendar.DAY_OF_MONTH, 90);
		gen3_bbqGallon.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -90);

		temp = (gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+" - ";
		gc3.add(Calendar.DAY_OF_MONTH, 2);
		temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n\t");
		gc3.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getEP());
		temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getEP());
		gc3.add(Calendar.DAY_OF_MONTH, -2);
		gen3_eggPatty.setText(temp);
		
		gc3.add(Calendar.DAY_OF_MONTH, 60);
		gen3_cherries.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -60);
		
		temp = (gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+" - ";
		gc3.add(Calendar.DAY_OF_MONTH, 3);
		temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n\t");
		gc3.add(Calendar.DAY_OF_MONTH, 30);
		temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n\nMFG DATE + 180D");
		gc3.add(Calendar.DAY_OF_MONTH, -30);
		gc3.add(Calendar.DAY_OF_MONTH, -3);
		gen3_sausageGravy.setText(temp);
		
		gc3.add(Calendar.DAY_OF_MONTH, 5);
		gen3_scrambledEggs.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.DAY_OF_MONTH, -5);
	
		gc3.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getB());
		gen3_baconStrips.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gen3_baconCrumbles.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getB());
		
		gen3_joyCones.setText("MFG DATE + 18M");
		
		gc3.add(Calendar.DAY_OF_MONTH, 14);
		gen3_frappeBase.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
		gc3.add(Calendar.DAY_OF_MONTH, -14);
		
		temp = (gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+" - ";
		gc3.add(Calendar.DAY_OF_MONTH, 2);
		temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n\t");
		gc3.add(Calendar.DAY_OF_MONTH, 4);
		temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
		gc3.add(Calendar.DAY_OF_MONTH, -6);
		gen3_chickenTenders.setText(temp);
 
		gen3_honeyMustardSqueeze.setText("Use Date On\nOpened Gallon");
		gc3.add(Calendar.DAY_OF_MONTH, 15);
		gen3_honeyMustardGallon.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nBOTTLE DATE");
		gc3.add(Calendar.DAY_OF_MONTH, -15);
		
		gc3.add(Calendar.DAY_OF_MONTH, 7);
		gen3_hamSlice.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR DATE ON\nPACKAGE");	
		gc3.add(Calendar.DAY_OF_MONTH, -7);
		
		gc3.add(Calendar.DAY_OF_MONTH, 7);
		gen3_sausagePatty.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR MFG DATE+180D");
		
		return;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_scroll_table);
		Bundle bundle = getIntent().getExtras();
		if (getIntent().hasExtra("divisionName")) 
		{
			divisionName = bundle.getString("divisionName");
		}
		else //this will be empty before the user opens the Settings and saves a default
		{
			divisionName = "KC";
		}
		displayStoreNumber_TV = (TextView) findViewById(R.id.DisplayStoreNumber_TV);
		displayStoreNumber_TV.setText(divisionName);
		main();
	}// end onCreate
	
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
        case R.id.Home:
        	Intent intent5 = new Intent(this, MainActivity.class);
        	startActivity(intent5);
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
