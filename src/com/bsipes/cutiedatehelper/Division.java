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
	private int gen3_pepsaus_offset;
	private int gen3_eggpatty_offset;
	private int gen3_bacon_offset;
	private int gen3_ham_offset;
	private int gen3_sausagepatty_offset;
	
	public Division(String inName, int inCC, int inWCP, int inGF, int inHotzi, int inWCB, int inWCHP, int inNemo, int inPepSaus, int inEP, int inBacon, int inHam, int inSP)
	{
		divisionName = inName;
		gen2_chilicheese_offset = inCC;
		gen2_wallcoolerpizzas_offset = inWCP;
		gen2_grillfood_date_offset = inGF;
		gen2_hotzis_offset = inHotzi;
		gen2_wallcoolerburritos_offset = inWCB;
		gen2_wallcoolerhotpockets_offset = inWCHP;
		gen2_nemo_offset = inNemo;
		gen3_pepsaus_offset = inPepSaus;
		gen3_eggpatty_offset = inEP;
		gen3_bacon_offset = inBacon;
		gen3_ham_offset = inHam;
		gen3_sausagepatty_offset = inSP;
	}
	
	public String getD()	{return divisionName;}
	public int getCC()		{return gen2_chilicheese_offset;}
	public int getWCP()		{return gen2_wallcoolerpizzas_offset;}
	public int getGF()		{return gen2_grillfood_date_offset;}
	public int getHotzi()	{return gen2_hotzis_offset;}
	public int getWCB()		{return gen2_wallcoolerburritos_offset;}
	public int getWCHP()	{return gen2_wallcoolerhotpockets_offset;}
	public int getNemo()	{return gen2_nemo_offset;}
	public int getPS() 		{return gen3_pepsaus_offset;}
	public int getEP()		{return gen3_eggpatty_offset;}
	public int getB()		{return gen3_bacon_offset;}
	public int getH()		{return gen3_ham_offset;}
	public int getSP()		{return gen3_sausagepatty_offset;}
}
