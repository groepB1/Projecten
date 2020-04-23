package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Speler 
{
	String naam;
	private List<Kaart> kaartLijstSpeler= new ArrayList <Kaart>();
	boolean heeftRijOpgenomen;


	public Speler(String naam) 
	{
		setNaam(naam);
	}
	
	
	public void voegKaartToe(Kaart kaart)
	{
		kaartLijstSpeler.add(kaart);
	}
	
	
	public int berekenScore()
	{
		Kaart kaart;
		int som = 0, aantalPlus2 = 0, aantalOranje = 0, aantalBlauw = 0, aantalGeel = 0, aantalRood = 0, aantalGroen = 0, aantalGrijs = 0, aantalRoos = 0;
		
		for (int teller = 0; teller <= kaartLijstSpeler.size()-1; teller++)
		{
			kaart = kaartLijstSpeler.get(teller);
			
			switch (kaart.getKleur()) 
			{
				case "oranje": aantalOranje++ ; break;
				case "blauw": aantalBlauw++; break;
				case "rood": aantalRood++ ; break;
				case "geel": aantalGeel++; break;
				case "grijs": aantalGrijs++ ; break;
				case "groen": aantalGroen++; break;
				case "roos": aantalRoos++; break;
				case "plus 2": aantalPlus2++; break; 
			}
		}
		
		int [] array = {aantalOranje, aantalBlauw, aantalGeel, aantalRood, aantalGroen,aantalGrijs, aantalRoos};
		Arrays.sort(array);
		
		for (int teller = array.length-1; teller>=array.length-3; teller--)
		{
			int aantal = array[teller];
			
			switch (aantal) 
			{
				case 0: ; break;
				case 1: som++ ;break;
				case 2: som += 3;break;
				case 3: som += 6;break;
				case 4: som += 10;break;
				case 5: som += 15;break;
				case 6: som += 21;break;
				default: som+= 21;break;
			}
		}
		
		
		for (int teller = array.length-4; teller>=0; teller--)
		{
			int aantal = array[teller];
			
			switch (aantal) 
			{
				case 0: ; break;
				case 1: som--;break;
				case 2: som -= 3;break;
				case 3: som -= 6;break;
				case 4: som -= 10;break;
				case 5: som -= 15;break;
				case 6: som -= 21;break;
				default: som-= 21;break;
			}
		}
		return som + aantalPlus2 *2;	
	}
		
	
	public boolean heeftJoker()
	{
		int aantalJokers = 0;
		for (int teller =0; teller<= kaartLijstSpeler.size()-1; teller++)
		{
			Kaart kaart = kaartLijstSpeler.get(teller);
			if (kaart.getKleur() == "joker")
				aantalJokers++;
		}
		return aantalJokers !=0;
	}
	
	
	public int  geefAantalJokers()
	{
		int aantalJokers = 0;
		for (int teller =0; teller<= kaartLijstSpeler.size()-1; teller++)
		{
			Kaart kaart = kaartLijstSpeler.get(teller);
			if (kaart.getKleur() == "joker")
				aantalJokers++;
		}
		return aantalJokers;
	}
	
	
	public void veranderJoker(String kleur)
	{
		for (int teller =0; teller<= kaartLijstSpeler.size()-1; teller++)
		{
			if(kaartLijstSpeler.get(teller).getKleur() == "joker")
			kaartLijstSpeler.get(teller).setKleur(kleur);
		}
	}
	
	
	public boolean isHeeftRijOpgenomen() 
	{
		return heeftRijOpgenomen;
	}
	
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setHeeftRijOpgenomen(boolean heeftRijOpgenomen) {
		this.heeftRijOpgenomen = heeftRijOpgenomen;
	}


	public String toString()
	{
		String kaarten="";
		for (int teller = 0; teller <kaartLijstSpeler.size(); teller++)
		{
			kaarten += kaartLijstSpeler.get(teller).toString();
		}
		return String.format("NAAM: %s%nKAARTEN:%n%s%n", getNaam(), kaarten );
	}
}
