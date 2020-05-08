package domein;

public class DomeinController 
{
	Spel spel;

	public void startNieuwSpel(String naam,int aantalSpelers)
	{
		spel = new Spel(naam, aantalSpelers);
	}

	
	public String geefSpelerNaamIn(String naam)
	{
		return spel.geefSpelerNaam(naam);
	}
	 
	
	public String geefEersteSpelerAanZetWeer()
	{
		return spel.geefEersteSpelerAanZetWeer();
	}
	
	
	public String geefGetrokkenKaartWeer()
	{
		return spel.geefGetrokkenKaartWeer();			
	}
	
	
	public void voegKaartAanStapelToe(int stapelID)
	{
		spel.voegKaartAanStapelToe(stapelID);
	}
	
	
	public String geefOverzichtVanStapelRij()
	{
		return spel.geefOverzichtVanStapelRij();
	}
	
	
	public String geefSpelerAanZetWeer()
	{
		return spel.geefSpelerAanZetWeer();
	}
	
	
	public void neemStapelRij(int stapelID)
	{
		spel.neemStapelRij(stapelID);
	}
	
	
	public String geefOverzichtVanAlleSpelers()
	{
		return spel.geefOverzichtVanAlleSpelers();
	}
	
	
	public boolean isEindeRonde()
	{
		return spel.isEindeRonde();
	}
	
	
	public boolean isEindeSpel()
	{
		return spel.isEindeSpel();
	}
	
	
	public void zetAllesKlaarVoorBeginRonde()
	{
		spel.zetAllesKlaarVoorBeginRonde();
	}
	
	
	public String geefEindOverzicht()
	{
		return spel.geefEindOverzicht();
	}
	
	
	public String geefSpelerMetJokerWeer(int spelerIndex)
	{
		return spel.geefSpelerMetJokerWeer(spelerIndex);
	}
	
	
	public int geefAantalJokers(int index)
	{
		return spel.geefAantalJokers(index);
	}
	
	
	public void veranderKleur(int kleurGetal, int index)
	{
		spel.veranderKleur(kleurGetal, index);
	}
	
	
	public String geefOverzichtHighscores()
	{
		return spel.geefOverzichtHighscores();
	}
	
	
	public boolean opslaanSpel()
	{
		return spel.spelOpslaan();
	}
	
	
	public void zetVorigSpelKlaar()
	{
		spel = new Spel();
	}
	
	
	public int geefAantalSpelers()
	{
		return spel.getAantalSpelers();
	}
	public boolean stapelIsGenomen(int stapelID)
	{
		return spel.stapelIsGenomen(stapelID);
	}
	public boolean rijIsVol(int stapelID)
	{
		return spel.rijIsVol(stapelID);
	}
}
