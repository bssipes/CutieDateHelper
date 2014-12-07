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
	
	//STL, CAR, WIC, and IA are all currently identical. May change in the future.
	//Refer to Division Constructor to see what all the numbers are being linked to
	Division STL = new	Division("STL", 	5,7,7 ,7, 14,13,30);
	Division CAR = new	Division("CAR", 	5,7,7 ,7, 14,13,30);
	Division WIC = new	Division("WIC", 	5,7,7 ,7, 14,13,30); //Wichita
	Division IA = new	Division("IA",  	5,7,7 ,7, 14,13,30);
	Division ATL = new	Division("ATL", 	5,7,10,7 ,14,13,30); //10 days for grillfood
	Division PHO = new	Division("PHO", 	5,7,7 ,10,14,13,30); //10 days for hotzi
	Division KC = new	Division("KC",		5,7,7 ,10,14,13,30); //10 days for hotzi
	Division OTHER = new Division("OTHER",	5,7,10,10,14,13,30); //10 days for grillfood AND 10 days for hotzi
	
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

		TextView gregorian_TV = (TextView) findViewById(R.id.gregorian_TV);
		gregorian_TV.setText("Today's Calendar Date: " + (gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));

		TextView julian_TV = (TextView) findViewById(R.id.julian_TV);
		int julian = gc.get(Calendar.DAY_OF_YEAR);
		julian_TV.setText("Today's Julian Date: \t\t" + String.valueOf(julian));

		if (gc.isLeapYear(Calendar.YEAR)) 
		{
			totalDays += 1;
		}
		setgen2Dates(julian);
		setgen3Dates(julian);
	}//end main
	
	private void setgen2Dates(int julian) {
		//declare all the textviews
		TextView gen2_chilicheese_date = (TextView) findViewById(R.id.gen2_chilicheese_date);
		TextView gen2_whippedTopper_date = (TextView) findViewById(R.id.gen2_whippedTopper_date);
		TextView gen2_wallcoolerpizzas_date = (TextView) findViewById(R.id.gen2_wallcoolerpizzas_date);
		TextView gen2_grillfood_date = (TextView) findViewById(R.id.gen2_grillfood_date);
		TextView gen2_hotzis_date = (TextView) findViewById(R.id.gen2_hotzis_date);
		TextView gen2_wallcoolerburritos_date = (TextView) findViewById(R.id.gen2_wallcoolerburritos_date);
		TextView gen2_wallcoolerhotpockets_date = (TextView) findViewById(R.id.gen2_wallcoolerhotpockets_date);
		TextView gen2_nemo_date = (TextView) findViewById(R.id.gen2_nemo_date);
		
		gen2_chilicheese_date.setText("Chili and Cheese:\t\t\t".concat(String.format("%03d", 
				(julian+divisions.get(divisionName).getCC())%totalDays)));
		
		gen2_whippedTopper_date.setText("Creamer BiB:\t\t\t\t\t\t".concat(String.format("%03d",julian+14%totalDays)));
		
		gen2_wallcoolerpizzas_date.setText("WallCooler Pizzas:\t\t\t".concat(String.format("%03d", (julian+1)%totalDays)+
				String.format("%03d", (julian+divisions.get(divisionName).getWCP())%totalDays)));
		
		gen2_grillfood_date.setText("Backstock GrillFood:\t\t".concat(String.format("%03d", julian)+", "+
				String.format("%03d", (julian+2)%totalDays)+", "+
				String.format("%03d", (julian+divisions.get(divisionName).getGF())%totalDays)));
		
		gen2_hotzis_date.setText("Hotzis:\t\t\t\t\t\t\t\t".concat(String.format("%03d", julian)+", "+
				String.format("%03d", (julian+2)%totalDays)+", "+
				String.format("%03d", (julian+divisions.get(divisionName).getHotzi())%totalDays)));
		
		gen2_wallcoolerburritos_date.setText("WallCooler Burritos:\t\t".concat(String.format("%03d", (julian+1)%totalDays)+
				String.format("%03d", (julian+divisions.get(divisionName).getWCB())%totalDays)));
		
		gen2_wallcoolerhotpockets_date.setText("Hot Pockets:\t\t\t\t\t\t".concat(String.format("%03d", (julian+1)%totalDays)+
				String.format("%03d", (julian+divisions.get(divisionName).getWCHP())%totalDays)));
		
		gen2_nemo_date.setText("Nemo Cakes:\t\t\t\t\t".concat(String.format("%03d", julian)+
				String.format("%03d", (julian+divisions.get(divisionName).getNemo())%totalDays)));
		return;
	}
	
	private void setgen3Dates(int julian) {
		//declare all the textviews
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
		TextView gen3_intenseGreenAppleMix = (TextView) findViewById(R.id.gen3_intenseGreenAppleMix);
		TextView gen3_chickenTenders = (TextView) findViewById(R.id.gen3_chickenTenders);
		TextView gen3_honeyMustardSqueeze = (TextView) findViewById(R.id.gen3_honeyMustardSqueeze);
		TextView gen3_honeyMustardGallon = (TextView) findViewById(R.id.gen3_honeyMustardGallon);
		TextView gen3_hamSlice = (TextView) findViewById(R.id.gen3_hamSlice);
		TextView gen3_sausagePatty = (TextView) findViewById(R.id.gen3_sausagePatty);

		gen3_softServe.setText("Soft Serve:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_nonfatYogurt.setText("NonFat Yogurt:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_smoothieBaseMix.setText("Smoothie Base Mix:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_moninDavinciSyrup.setText("Monin/Davinci Syrup:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_ghiradelliDavinciSauce.setText("Ghiradelli/Davinci Sauce:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_candyPieces.setText("Candy Pieces:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_espressoBiB.setText("Espresso BiB:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_smoothieJuice.setText("Smoothie Juice:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_smoothieAddins.setText("Smoothie Add-ins:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_frozenLemonades.setText("Frozen Lemonades:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_phaseButterSub.setText("Phase Butter Sub:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pretzels.setText("Pretzels".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pretzelCheeseMarinara.setText("Pretzel Cheese & Marinara:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pretzelToppings.setText("Pretzel Toppings & Icing Dip:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pizzaCrust7.setText("Pizza Crust 7\":".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pizzaCrust16.setText("Pizza Crust 16\":".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pizzaCheese.setText("Pizza Cheese:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pepperoni.setText("Pepperoni:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_sausage.setText("Sausage:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pizzaSauce.setText("Pizza Sauce:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_pizzaVegetables.setText("Pizza Vegetables:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_kolaches.setText("Kolaches:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_toastedSandwiches.setText("Toasted Sandwiches:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_flatbreads.setText("Flatbreads:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_ranchSqueeze.setText("Ranch Squeeze Bottle:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_ranchGallon.setText("Ranch Gallon:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_chipMayoSqueeze.setText("Chipotle Mayo Squeeze Bottle:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_bbqSqueeze.setText("BBQ Squeeze Bottle:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_bbqGallon.setText("BBQ Gallon:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_eggPatty.setText("Egg Patty:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_cherries.setText("Cherries:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_sausageGravy.setText("Sausage Gravy:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_scrambledEggs.setText("Scrambled Eggs:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_baconStrips.setText("Bacon Strips:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_baconCrumbles.setText("Bacon Crumbles:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_joyCones.setText("Joy Cones:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_frappeBase.setText("Frappe Base:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_intenseGreenAppleMix.setText("Intense Green Apple Mix:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_chickenTenders.setText("Chicken Tenders:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_honeyMustardSqueeze.setText("Honey Mustard Squeeze:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_honeyMustardGallon.setText("Honey Mustard Gallon:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_hamSlice.setText("Ham Slices:".concat(String.format("%03d",julian+0%totalDays)));
		gen3_sausagePatty.setText("Sausage Patty:".concat(String.format("%03d",julian+0%totalDays)));

		return;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_scroll);
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
		displayStoreNumber_TV.setText("Code Dates For: " + divisionName + " Division");
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
