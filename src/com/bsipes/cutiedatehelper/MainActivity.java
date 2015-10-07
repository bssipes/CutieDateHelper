package com.bsipes.cutiedatehelper;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
	private String divisionName; //set in onCreate
	public TextView displayStoreNumber_TV;
	public HashMap<String, Division> divisions = new HashMap<String, Division>();
	public Button toggleGen2;
	public boolean gen2jul; 
	public boolean gen3jul;
	public Button toggleGen3;
	public int totalDays = 365;
	public int julian = 0;
	
	//Refer to Division Constructor to see what all the numbers are being linked to
//public Division(String inName, int inCC, int inWCP, int inGF, int inHotzi, int inWCB, int inWCHP, int inNemo, int inPepSaus, int inEP, int inBacon, int inHam, int inSP)
	Division STL = new	Division("STL", 	5,8,8 ,7 ,15,14,31,11,8,8,8,8); //St Louis
	Division CAR = new	Division("CAR", 	5,8,8 ,7 ,15,14,31,6 ,6,6,8,8); //Carolinas
	Division WIC = new	Division("WIC", 	5,8,8 ,7 ,15,14,31,8 ,8,8,8,8); //Wichita
	Division IA = new	Division("IA",  	5,8,7 ,7 ,15,14,31,11,8,8,8,8); //Iowa
	Division ATL = new	Division("ATL", 	5,8,11,7 ,15,14,31,11,8,8,8,8); //11 days for grillfood
	Division PHO = new	Division("PHO", 	5,8,8 ,11,15,14,31,6 ,8,8,6,6); //11 days for hotzi
	Division KC = new	Division("KC",		5,8,8 ,11,15,14,31,8 ,8,8,8,8); //11 days for hotzi
	Division OTHER = new Division("OTHER",	5,8,11,11,15,14,31,11,8,8,8,8); //11 days for grillfood AND 11 days for hotzi
	
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
		gregorian_TV.setText((gc.get(Calendar.MONTH) + 1) + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));

		TextView julian_TV = (TextView) findViewById(R.id.julian_TV);
		julian = gc.get(Calendar.DAY_OF_YEAR);
		julian_TV.setText(String.format("%03d", julian));

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
		GregorianCalendar gc2 = (GregorianCalendar) GregorianCalendar.getInstance();
		String temp = "";
		String longYear = String.valueOf(gc2.get(Calendar.YEAR));
		int shortYear = Integer.parseInt(longYear.substring(2,4));
		
		TextView gen2_chilicheese_date = (TextView) findViewById(R.id.gen2_chilicheese_date);
		TextView gen2_whippedTopper_date = (TextView) findViewById(R.id.gen2_whippedTopper_date);
		TextView gen2_wallcoolerpizzas_date = (TextView) findViewById(R.id.gen2_wallcoolerpizzas_date);
		TextView gen2_grillfood_date = (TextView) findViewById(R.id.gen2_grillfood_date);
		TextView gen2_hotzis_date = (TextView) findViewById(R.id.gen2_hotzis_date);
		TextView gen2_wallcoolerburritos_date = (TextView) findViewById(R.id.gen2_wallcoolerburritos_date);
		TextView gen2_wallcoolerhotpockets_date = (TextView) findViewById(R.id.gen2_wallcoolerhotpockets_date);
		TextView gen2_nemo_date = (TextView) findViewById(R.id.gen2_nemo_date);
		TextView gen2_keylime_date = (TextView) findViewById(R.id.gen2_keylime_date);
		TextView gen2_cakeballz_date = (TextView) findViewById(R.id.gen2_cakeballz_date);
		
		if (gen2jul == true) 
		{
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
					checkRollover(2))+", "+ String.format("%03d", 
					checkRollover(divisions.get(divisionName).getHotzi())));
			gen2_wallcoolerburritos_date.setText(String.format("%03d", 
					checkRollover(1))+ String.format("%03d", 
					checkRollover(divisions.get(divisionName).getWCB())));
			gen2_wallcoolerhotpockets_date.setText(String.format("%03d", 
					checkRollover(1))+ String.format("%03d", 
					checkRollover(divisions.get(divisionName).getWCHP())));
			gen2_nemo_date.setText(String.format("%03d", julian) + String.format("%03d", 
					checkRollover(divisions.get(divisionName).getNemo())));
			gen2_keylime_date.setText(String.format("%03d", julian) + String.format("%03d", 
					checkRollover(10))); //TODO: WARNING HARDCODED VALUE
			gen2_cakeballz_date.setText(String.format("%03d", julian) + String.format("%03d", 
					checkRollover(41))); //TODO: WARNING HARDCODED VALUE
		} 
		else
		{
			gc2.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getCC());
			gen2_chilicheese_date.setText(String.format("%02d", gc2.get(Calendar.MONTH)+1)+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+
					String.valueOf(shortYear));
			gc2.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getCC());
			
			gc2.add(Calendar.DAY_OF_MONTH, 14);
			gen2_whippedTopper_date.setText(String.format("%02d", gc2.get(Calendar.MONTH)+1)+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+
					String.valueOf(shortYear));
			gc2.add(Calendar.DAY_OF_MONTH, -14);
			
			gc2.add(Calendar.DAY_OF_MONTH, 1);
			gc2.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getWCP());
			gen2_wallcoolerpizzas_date.setText(String.format("%02d", gc2.get(Calendar.MONTH)+1)+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+
					String.valueOf(shortYear));
			gc2.add(Calendar.DAY_OF_MONTH, -1);
			gc2.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getWCP());
			
			temp = (String.format("%02d", gc2.get(Calendar.MONTH)+1)+"/"+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+"/"+
					String.valueOf(shortYear)+"\n");
			gc2.add(Calendar.DAY_OF_MONTH, 2);
			temp = temp.concat((String.format("%02d", gc2.get(Calendar.MONTH)+1)+"/"+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH)))+"/"+
					String.valueOf(shortYear)+"\n");
			gc2.add(Calendar.DAY_OF_MONTH, -2);
			gc2.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getGF());
			temp = temp.concat((String.format("%02d", gc2.get(Calendar.MONTH)+1)+"/"+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH)))+"/"+
					String.valueOf(shortYear));
			gen2_grillfood_date.setText(temp);
			gc2.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getGF());
			
			temp = (String.format("%02d", gc2.get(Calendar.MONTH)+1)+"/"+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+"/"+
					String.valueOf(shortYear)+"\n");
			gc2.add(Calendar.DAY_OF_MONTH, 2);
			temp = temp.concat((String.format("%02d", gc2.get(Calendar.MONTH)+1)+"/"+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH)))+"/"+
					String.valueOf(shortYear)+"\n");
			gc2.add(Calendar.DAY_OF_MONTH, -2);
			gc2.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getHotzi());
			temp = temp.concat((String.format("%02d", gc2.get(Calendar.MONTH)+1)+"/"+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+"/"+
							String.valueOf(shortYear)));
			gen2_hotzis_date.setText(temp);
			gc2.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getHotzi());
			
			gc2.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getWCB());
			gen2_wallcoolerburritos_date.setText(String.format("%02d", gc2.get(Calendar.MONTH)+1)+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+
					String.valueOf(shortYear));
			gc2.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getWCB());
			
			gc2.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getWCHP());
			gen2_wallcoolerhotpockets_date.setText(String.format("%02d", gc2.get(Calendar.MONTH)+1)+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+
					String.valueOf(shortYear));
			gc2.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getWCHP());
			
			gc2.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getNemo());
			gen2_nemo_date.setText(String.format("%02d", gc2.get(Calendar.MONTH)+1)+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+
					String.valueOf(shortYear));
			gc2.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getNemo());
			
			gc2.add(Calendar.DAY_OF_MONTH, 10);
			gen2_keylime_date.setText(String.format("%02d", gc2.get(Calendar.MONTH)+1)+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+
					String.valueOf(shortYear));
			gc2.add(Calendar.DAY_OF_MONTH, -10);
			
			gc2.add(Calendar.DAY_OF_MONTH, 41);
			gen2_cakeballz_date.setText(String.format("%02d", gc2.get(Calendar.MONTH)+1)+
					String.format("%02d", gc2.get(Calendar.DAY_OF_MONTH))+
					String.valueOf(shortYear));
			gc2.add(Calendar.DAY_OF_MONTH, -41);
		}
	}
	
	private void setgen3Dates() {
		//declare all the textviews
		GregorianCalendar gc3 = (GregorianCalendar) GregorianCalendar.getInstance();
		String temp = "";
		
		TextView gen3_softServe = (TextView) findViewById(R.id.gen3_softServe);	
		TextView gen3_softServeOpen = (TextView) findViewById(R.id.gen3_softServeOpen);
		TextView gen3_moninDavinciSyrup = (TextView) findViewById(R.id.gen3_moninDavinciSyrup);
		TextView gen3_ghiradelliDavinciSauce = (TextView) findViewById(R.id.gen3_ghiradelliDavinciSauce);
		TextView gen3_candyPieces = (TextView) findViewById(R.id.gen3_candyPieces);
		TextView gen3_milk = (TextView) findViewById(R.id.gen3_milkDate);
		TextView gen3_smoothieJuice = (TextView) findViewById(R.id.gen3_smoothieJuice);
		TextView gen3_smoothieAddins = (TextView) findViewById(R.id.gen3_smoothieAddins);
		TextView gen3_frozenLemonadesShelf = (TextView) findViewById(R.id.gen3_frozenLemonadesShelf);
		TextView gen3_frozenLemonadesOpen = (TextView) findViewById(R.id.gen3_frozenLemonadesOpen);
		TextView gen3_phaseButterSub = (TextView) findViewById(R.id.gen3_phaseButterSub);
		TextView gen3_phaseButterBottle = (TextView) findViewById(R.id.gen3_phaseButterBottle);
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
		TextView gen3_tomatoPacks = (TextView) findViewById(R.id.gen3_tomato);
		TextView gen3_lettuceBags = (TextView) findViewById(R.id.gen3_lettuce);
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
		TextView gen3_sausageGravyShelf = (TextView) findViewById(R.id.gen3_sausageGravyShelf);
		TextView gen3_sausageGravyOpen = (TextView) findViewById(R.id.gen3_sausageGravyOpen);
		TextView gen3_scrambledEggsShelf = (TextView) findViewById(R.id.gen3_scrambledEggsShelf);
		TextView gen3_scrambledEggsOpen = (TextView) findViewById(R.id.gen3_scrambledEggsOpen);
		TextView gen3_baconStrips = (TextView) findViewById(R.id.gen3_baconStrips);
		TextView gen3_baconCrumbles = (TextView) findViewById(R.id.gen3_baconCrumbles);
		TextView gen3_joyCones = (TextView) findViewById(R.id.gen3_joyCones);
		TextView gen3_frappeBase = (TextView) findViewById(R.id.gen3_frappeBase);
		TextView gen3_chickenTenders = (TextView) findViewById(R.id.gen3_chickenTenders);
		TextView gen3_honeyMustardSqueeze = (TextView) findViewById(R.id.gen3_honeyMustardSqueeze);
		TextView gen3_turkeySlice = (TextView) findViewById(R.id.gen3_turkeySlice);
		TextView gen3_hamSlice = (TextView) findViewById(R.id.gen3_hamSlice);
		TextView gen3_sausagePatty = (TextView) findViewById(R.id.gen3_sausagePatty);
		TextView gen3_cinnamonRoll = (TextView) findViewById(R.id.gen3_cinnamonRoll);
		TextView gen3_creamCheese = (TextView) findViewById(R.id.gen3_creamCheese);
		TextView gen3_sauceCups = (TextView) findViewById(R.id.gen3_sauceCups);
		TextView gen3_11tortilla = (TextView) findViewById(R.id.gen3_11tortilla);
		
		if (gen3jul == false) {
			gc3.add(Calendar.DAY_OF_MONTH, 3);
			temp = (gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n";
			gc3.add(Calendar.DAY_OF_MONTH, 11);
			temp = temp.concat((gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gen3_softServe.setText(temp);
			gc3.add(Calendar.DAY_OF_MONTH, -14);
			
			temp = (gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n";
			gc3.add(Calendar.DAY_OF_MONTH, 8);
			temp = temp.concat((gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gen3_softServeOpen.setText(temp + "\nOR ORIGINAL\nSTICKER DATE");
			gc3.add(Calendar.DAY_OF_MONTH, -8);
			
			gc3.add(Calendar.DAY_OF_MONTH, 46);
			gen3_moninDavinciSyrup.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -46);
			
			gc3.add(Calendar.DAY_OF_MONTH, 22);
			gen3_ghiradelliDavinciSauce.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -22);
			
			gen3_candyPieces.setText("MFG DATE");
		
			gc3.add(Calendar.DAY_OF_MONTH, 7);
			gen3_milk.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -7);		
					
			gc3.add(Calendar.DAY_OF_MONTH, 4);
			gen3_smoothieJuice.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -4);
			
			gen3_smoothieAddins.setText("MFG DATE");
					
			gc3.add(Calendar.DAY_OF_MONTH, 61);
			gen3_frozenLemonadesShelf.setText((gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -61);
			
			
			gc3.add(Calendar.DAY_OF_MONTH, 22);
			gen3_frozenLemonadesOpen.setText((gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nSTICKER DATE");
			gc3.add(Calendar.DAY_OF_MONTH, -22);
				
			gen3_phaseButterSub.setText("MFG DATE +270D");
			
			gc3.add(Calendar.DAY_OF_MONTH, 60);
			gen3_phaseButterBottle.setText((gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nSTICKER DATE");
			gc3.add(Calendar.DAY_OF_MONTH, -60);
			
			gc3.add(Calendar.DAY_OF_MONTH, 3);
			gc3.add(Calendar.HOUR_OF_DAY, 4);
			gen3_pretzels.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
			gc3.add(Calendar.DAY_OF_MONTH, -3);
			gc3.add(Calendar.HOUR_OF_DAY, -4);
			
			gc3.add(Calendar.DAY_OF_MONTH, 6);
			gen3_pretzelCheeseMarinara.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -6);

			gen3_pretzelToppings.setText("QTK DATED");
			
			gc3.add(Calendar.HOUR_OF_DAY, 54);
			gen3_pizzaCrust7.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
			gc3.add(Calendar.HOUR_OF_DAY, -54);
			
			gc3.add(Calendar.HOUR_OF_DAY, 36);
			gen3_pizzaCrust16.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
			gc3.add(Calendar.HOUR_OF_DAY, -36);
			
			gc3.add(Calendar.DAY_OF_MONTH, 8);
			gen3_pizzaCheese.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -8);
				
			gc3.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getPS());
			gc3.add(Calendar.HOUR_OF_DAY, 4);
			gen3_pepperoni.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
			gen3_sausage.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n"+gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
			gc3.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getPS());
			gc3.add(Calendar.HOUR_OF_DAY, -4);
			
			
			gc3.add(Calendar.DAY_OF_MONTH, 6);
			gen3_pizzaSauce.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -6);
			
			gen3_pizzaVegetables.setText("QTK DATED");
			gen3_tomatoPacks.setText("QTK DATED");
			
			gc3.add(Calendar.DAY_OF_MONTH, 4);
			gen3_lettuceBags.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nSTICKER DATE");
			gc3.add(Calendar.DAY_OF_MONTH, -4);
			
			temp = (gc3.get(Calendar.MONTH)+1) + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n";
			gc3.add(Calendar.DAY_OF_MONTH, 1);
			temp = temp.concat(gc3.get(Calendar.MONTH)+1 + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n");
			gc3.add(Calendar.DAY_OF_MONTH, 9);
			temp = temp.concat(gc3.get(Calendar.MONTH)+1 + "/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n");
			gen3_kolaches.setText(temp + gc3.get(Calendar.HOUR_OF_DAY)+":"+String.format("%02d",gc3.get(Calendar.MINUTE)));
			gc3.add(Calendar.DAY_OF_MONTH, -10);
			
			gen3_toastedSandwiches.setText("QTK DATED");
			gen3_flatbreads.setText("QTK DATED");
			
			gen3_ranchSqueeze.setText("Use Date On\nOpened Gallon");
			
			gc3.add(Calendar.MONTH, 2);
			gen3_ranchGallon.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.MONTH, -2);
			
			gc3.add(Calendar.DAY_OF_MONTH, 22);
			gen3_chipMayoSqueeze.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR MFG+180D");
			gc3.add(Calendar.DAY_OF_MONTH, -22);

			gc3.add(Calendar.DAY_OF_MONTH, 30);
			gen3_bbqSqueeze.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nGALLON DATE");
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
			temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gen3_sausageGravyShelf.setText(temp);
			gc3.add(Calendar.DAY_OF_MONTH, -33);
			
			gc3.add(Calendar.DAY_OF_MONTH, 5);
			gen3_sausageGravyOpen.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -5);
			
			gc3.add(Calendar.DAY_OF_MONTH, 13);
			gen3_scrambledEggsShelf.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -8);
			gen3_scrambledEggsOpen.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -5);
			
		
			gc3.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getB());
			gen3_baconStrips.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gen3_baconCrumbles.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getB());
			
			gen3_joyCones.setText("MFG DATE + 24M");
			
			gc3.add(Calendar.DAY_OF_MONTH, 15);
			gen3_frappeBase.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -15);
			
//TODO: Ask for clarification. CD Guide says "5 days or ..." instead of "5 days from open or ..." like others do.			
			temp = (gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+" - ";
			gc3.add(Calendar.DAY_OF_MONTH, 2);
			temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\n\t");
			gc3.add(Calendar.DAY_OF_MONTH, 5);
			temp = temp.concat((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR));
			gc3.add(Calendar.DAY_OF_MONTH, -7);
			gen3_chickenTenders.setText(temp);
	 
			gc3.add(Calendar.DAY_OF_MONTH, 30);
			gen3_honeyMustardSqueeze.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR ORIGINAL\nBOTTLE DATE");
			gc3.add(Calendar.DAY_OF_MONTH, -30);
			
			gc3.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getH());	
			gen3_hamSlice.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR DATE ON\nPACKAGE");	
			gc3.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getH());
			
			gc3.add(Calendar.DAY_OF_MONTH, 6);	
			gen3_turkeySlice.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR DATE ON\nPACKAGE");
			gc3.add(Calendar.DAY_OF_MONTH, -6);
			
//TODO: Ask for clarification. CD Guide says 2 days thaw and then "8 days or ..." instead of "8 days from open or ..." like others do.		
			gc3.add(Calendar.DAY_OF_MONTH, divisions.get(divisionName).getSP());
			gen3_sausagePatty.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR MFG+180D");
			gc3.add(Calendar.DAY_OF_MONTH, -divisions.get(divisionName).getSP());
			
			gen3_cinnamonRoll.setText("QTK DATED");
			gen3_creamCheese.setText("MFG +8Months");
			gen3_sauceCups.setText("MFG +6Months");
			gc3.add(Calendar.DAY_OF_MONTH, 15);
			gen3_11tortilla.setText((gc3.get(Calendar.MONTH) + 1)+"/"+gc3.get(Calendar.DAY_OF_MONTH)+"/"+gc3.get(Calendar.YEAR)+"\nOR MFG+45D");
			gc3.add(Calendar.DAY_OF_MONTH, -15);
			
		} else {
//Gen3 products in Julian Dating			
			gen3_softServe.setText(String.format("%03d", 
					checkRollover(3)) + ", " + String.format("%03d", 
					checkRollover(14)));
			gen3_softServeOpen.setText(String.format("%03d", 
					checkRollover(0)) + ", " + String.format("%03d", 
					checkRollover(8)) + "\nOR ORIGINAL\nSTICKER DATE");
			gen3_moninDavinciSyrup.setText(String.format("%03d",
					checkRollover(46)));
			gen3_ghiradelliDavinciSauce.setText(String.format("%03d",
					checkRollover(22)));
			gen3_candyPieces.setText("MFG DATE");
			gen3_milk.setText(String.format("%03d", 
					checkRollover(7)));		
			gen3_smoothieJuice.setText(String.format("%03d",
					checkRollover(0)) + ", " + String.format("%03d", 
					checkRollover(4)));
			gen3_smoothieAddins.setText("MFG DATE");
			gen3_frozenLemonadesShelf.setText(String.format("%03d",
					checkRollover(1)) + ", " + String.format("%03d",
					checkRollover(61)));
			gen3_frozenLemonadesOpen.setText(String.format("%03d", 
					checkRollover(22)) + "\nOR ORIGINAL\nSTICKER DATE");
			gen3_phaseButterSub.setText("MFG DATE + 270D");
			gen3_phaseButterBottle.setText(String.format("%03d",
					checkRollover(60)) + "\nOR ORIGINAL\nSTICKER DATE");
			gen3_pretzels.setText(String.format("%03d",
					checkRollover(3)) + "+4HOURS");
			gen3_pretzelCheeseMarinara.setText(String.format("%03d",
					checkRollover(6)));
			gen3_pretzelToppings.setText("QTK DATED");
			gen3_pizzaCrust7.setText(String.format("%03d",
					checkRollover(2)) + "+6HOURS");
			gen3_pizzaCrust16.setText(String.format("%03d",
					checkRollover(1)) + "+12HOURS");
			gen3_pizzaCheese.setText(String.format("%03d",
					checkRollover(8)));
			gen3_pepperoni.setText(String.format("%03d",
					checkRollover(divisions.get(divisionName).getPS())) + "+4HOURS");
			gen3_sausage.setText(String.format("%03d",
					checkRollover(divisions.get(divisionName).getPS())) + "+4HOURS");
			gen3_pizzaSauce.setText(String.format("%03d",
					checkRollover(6)));
			gen3_pizzaVegetables.setText("QTK DATED");
			gen3_tomatoPacks.setText("QTK DATED");
			gen3_lettuceBags.setText(String.format("%03d",
					checkRollover(4)));
			gen3_kolaches.setText(String.format("%03d",
					checkRollover(0)) + ", " + String.format("%03d", 
					checkRollover(1)) + ", " + String.format("%03d",
					checkRollover(10)));
			gen3_toastedSandwiches.setText("QTK DATED");
			gen3_flatbreads.setText("QTK DATED");
			gen3_ranchSqueeze.setText("Use Date On\nOpened Gallon");
//Technically, Ranch gallon is specified at "2 months" instead of X days
			gc3.add(Calendar.MONTH, 2);
				gen3_ranchGallon.setText(String.format("%03d",
						(gc3.get(Calendar.DAY_OF_YEAR))));
				gc3.add(Calendar.MONTH, -2);
			gen3_chipMayoSqueeze.setText(String.format("%03d",
					checkRollover(22)) + "\nOR MFG+180D"); 
			gen3_bbqSqueeze.setText(String.format("%03d",
					checkRollover(30))+"\nOR ORIGINAL\nGALLON DATE");
			gen3_bbqGallon.setText(String.format("%03d",
					checkRollover(90)));
			gen3_eggPatty.setText(String.format("%03d",
					checkRollover(2)) + ", " + String.format("%03d",
					checkRollover(divisions.get(divisionName).getEP())));
			gen3_cherries.setText(String.format("%03d",
					checkRollover(60)));
			gen3_sausageGravyShelf.setText(String.format("%03d",
					checkRollover(0)) + ", "+ String.format("%03d",
					checkRollover(3)) + ", " + String.format("%03d",
					checkRollover(33)));
			gen3_sausageGravyOpen.setText(String.format("%03d",
					checkRollover(5)));
			gen3_scrambledEggsShelf.setText(String.format("%03d",
					checkRollover(13)));
			gen3_scrambledEggsOpen.setText(String.format("%03d",
					checkRollover(7)));
			gen3_baconStrips.setText(String.format("%03d",
					checkRollover(divisions.get(divisionName).getB())));
			gen3_baconCrumbles.setText(String.format("%03d",
					checkRollover(divisions.get(divisionName).getB())));
			gen3_joyCones.setText("MFG DATE + 24M");
			gen3_frappeBase.setText(String.format("%03d",
					checkRollover(0)) + ", " + String.format("%03d", 
					checkRollover(15)));
//TODO: Ask for clarification. CD Guide says "5 days or ..." instead of "5 days from open or ..." like others do.
			gen3_chickenTenders.setText(String.format("%03d",
					checkRollover(2)) + ", " + String.format("%03d",
					checkRollover(7)));
			gen3_honeyMustardSqueeze.setText(String.format("%03d",
					checkRollover(30)));
			gen3_hamSlice.setText(String.format("%03d",
					checkRollover(8)));
			gen3_turkeySlice.setText(String.format("%03d",
					checkRollover(6)));
//TODO: Ask for clarification. CD Guide says "8 days or ..." instead of "8 days from open or ..." like others do.			
			gen3_sausagePatty.setText(String.format("%03d",
					checkRollover(2)) + ", " + String.format("%03d",
					checkRollover(10)));
			gen3_cinnamonRoll.setText("QTK DATED");
			gen3_creamCheese.setText("MFG +4Months");
			gen3_sauceCups.setText("MFG +6Months");
			gen3_11tortilla.setText(String.format("%03d",
					checkRollover(15)) + "\nOR MFG+45D"); 
		}
		return;
	}
	public void swapGen3(View v) 
	{
		if (gen3jul == true)
		{
			gen3jul = false;
			setgen3Dates();
		}else{
			gen3jul = true;
			setgen3Dates();
		}
	}
	public void swapGen2(View v) 
	{
		if (gen2jul == true)
		{
			gen2jul = false;
			setgen2Dates();
		}else{
			gen2jul = true;
			setgen2Dates();
		}
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
		
		if (getIntent().hasExtra("gen2jul"))
		{
			gen2jul = bundle.getBoolean("gen2jul");
		}
		else
		{
			gen2jul = false;
		}
		
		if (getIntent().hasExtra("gen3jul"))
		{
			gen3jul = bundle.getBoolean("gen3jul");
		}
		else
		{
			gen3jul = false;
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