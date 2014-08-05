package com.bsipes.cutiedatehelper;

public class Division 
{
	private String divisionName;
	private int gen2_chilicheese_offset;
	private int gen2_wallcoolerpizzas_offset;
	private int gen2_grillfood_date_offset;
	private int gen2_hotzis_offset;
	private int gen2_wallcoolerburritos_offset;
	private int gen2_wallcoolerhotpockets_offset;
	private int gen2_nemo_offset;
	
	public Division(String inName, int inCC, int inWCP, int inGF, int inHotzi, int inWCB, int inWCHP, int inNemo)
	{
		divisionName = inName;
		gen2_chilicheese_offset = inCC;
		gen2_wallcoolerpizzas_offset = inWCP;
		gen2_grillfood_date_offset = inGF;
		gen2_hotzis_offset = inHotzi;
		gen2_wallcoolerburritos_offset = inWCB;
		gen2_wallcoolerhotpockets_offset = inWCHP;
		gen2_nemo_offset = inNemo;
	}
	
	public String getD()	{return divisionName;}
	public int getCC()		{return gen2_chilicheese_offset;}
	public int getWCP()		{return gen2_wallcoolerpizzas_offset;}
	public int getGF()		{return gen2_grillfood_date_offset;}
	public int getHotzi()	{return gen2_hotzis_offset;}
	public int getWCB()		{return gen2_wallcoolerburritos_offset;}
	public int getWCHP()	{return gen2_wallcoolerhotpockets_offset;}
	public int getNemo()	{return gen2_nemo_offset;}
}
