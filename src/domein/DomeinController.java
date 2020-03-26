package domein;

public class DomeinController 
{
	Spel spel;
	//1.1startnieuwspel
	public void startNieuwSpel(String naam,int aantalSpelers)
	{
		spel = new Spel(naam, aantalSpelers);
	}
	//1.2opgeslagenspel
	
	// 2.1 GeefAantalSpelers(int aantalSpelers) ==> set aantal spelers oproepen
	
	//2.2.1geefSpelerNaam(String naam)
	public String geefSpelerNaamIn(String naam)
	{
		return spel.geefSpelerNaam(naam);
	}
	//4.1geefOverzichtPerSpeler()
	
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
}
