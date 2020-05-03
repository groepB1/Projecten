package domein;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import persistentie.scoreMapper;
import persistentie.spelMapper;

public class Spel 
{
	private String naam;
	private int aantalSpelers;
	private Kaart getrokkenKaart;
	private int vorigeSpelerIndex;
	
	private List<Kaart> deckKaarten= new ArrayList <Kaart>();
	private List<StapelRij> stapelRijen	= new ArrayList <StapelRij>();
	private List<Speler> spelerLijst = new ArrayList<Speler>();
	private scoreMapper scoreMap = new scoreMapper();
	private spelMapper spelMap = new spelMapper();
	
	public Spel(String naam, int aantalSpelers)
	{
		setNaam(naam);
		setAantalSpelers(aantalSpelers);
		setDeckKaarten(maakDeckAan());
		setStapelRijen(maakStapelRijAan());
		setAantalSpelers(aantalSpelers);
	}
	
	public Spel()
	{
		//spel aanmaken
		setNaam(spelMap.LaadSpelNaam());
		setVorigeSpelerIndex(spelMap.laadVorigeSpeler());
		//kaartendeck aanmaken
		deckKaarten = spelMap.laadKaarten();
		//spelersAanmaken
		spelerLijst = spelMap.LaadSpelers();
		setAantalSpelers(spelerLijst.size());
		//kaarten spelers toeveogen
		for (int teller = 0; teller <=spelerLijst.size()-1; teller++)
		{
			spelerLijst.get(teller).setKaartLijstSpeler(spelMap.laadSpelerKaarten(teller));
		}
		//stapelrijenAanmaken
		setStapelRijen(maakStapelRijAan());
		
		zetAllesKlaarVoorBeginRonde();
	}


	public List<Kaart> maakDeckAan()
	{
		List<Kaart> kaartenLijst	= new ArrayList <Kaart>();
		String kleur = null;
		
		for (int teller = 0; teller <= 6; teller++)
		{
			switch (teller) 
			{
				case 0: kleur = "oranje"; break;
				case 1: kleur = "blauw"; break;
				case 2: kleur = "rood"; break;
				case 3: kleur = "geel"; break;
				case 4: kleur = "grijs"; break;
				case 5: kleur = "groen"; break;
				case 6: kleur = "roos"; break;
			}
			
			for (int teller2=0; teller2<=8;teller2++)
			{
				Kaart kaart = new Kaart (kleur);
				kaartenLijst.add(kaart);
			}
		}
		
		for (int teller3 = 0; teller3<10; teller3++)
		{
			Kaart kaart = new Kaart ("plus 2");
			kaartenLijst.add(kaart);
		}
		
		for (int teller4 = 0; teller4<3; teller4++)
		{
			Kaart kaart = new Kaart ("joker");
			kaartenLijst.add(kaart);
		}
		
		return kaartenLijst;
	}

	
	public  List<StapelRij> maakStapelRijAan() 
	{
		List<StapelRij> stapelRij	= new ArrayList <>();
		
		for (int teller = 0; teller <= aantalSpelers-1; teller++)
		{
			StapelRij stapel = new StapelRij(teller);
			stapelRij.add(stapel);
		}
		
		return stapelRij;
	}
	
	
	public String geefSpelerNaam(String naam)
	{
		Speler speler  = new Speler(naam);
		spelerLijst.add(speler);
		geefBeginKaart(speler);
		return geefOverzichtSpeler(speler);
	}

	
	private void geefBeginKaart(Speler speler)
	{
		Kaart getrokkenKaart = trekKaart();
		speler.voegKaartToe(getrokkenKaart);
	}
	
	
	public Kaart trekKaart()
	{
		SecureRandom random = new SecureRandom();
		int randomKaart = random.nextInt(deckKaarten.size());
		Kaart kaart = deckKaarten.get(randomKaart);
		deckKaarten.remove(randomKaart);
		return kaart;
	}

	
	public String geefOverzichtSpeler(Speler speler)
	{
		return String.format("speleroverzicht: %n%s", speler.toString());
	}
	
	
	public Speler bepaalEersteSpelerAanZet()
	{
		SecureRandom random = new SecureRandom();
		int index = random.nextInt(spelerLijst.size());
		vorigeSpelerIndex = index;
		return spelerLijst.get(index);
	}
	
	
	public String geefEersteSpelerAanZetWeer()
	{
		return String.format("De speler aan zet is:%n%s%n", bepaalEersteSpelerAanZet().toString());	
	}

	
	public String geefGetrokkenKaartWeer()
	{
		getrokkenKaart = trekKaart();
		return String.format("De getrokken kaart is: %s%n", getrokkenKaart.toString());		
	}
	
	
	public void voegKaartAanStapelToe(int stapelID)
	{
		if (stapelRijen.get(stapelID-1).isIsgenomen() || stapelRijen.get(stapelID-1).isVol() )
		{
			if (stapelRijen.get(stapelID-1).isIsgenomen())
				throw new IllegalArgumentException("Fout, de rij is reeds genomen!");
			else 
				throw new IllegalArgumentException("Fout, de rij is vol!");
		} 
		else 
		{
			 stapelRijen.get(stapelID-1).voegKaartToe(getrokkenKaart);
			 getrokkenKaart = null;
		}	
	}
	
	
	public String geefOverzichtVanStapelRij()
	{
		String uitvoer = "";
		for (StapelRij loper: stapelRijen)
		{
			if (loper.isIsgenomen() == false)
			uitvoer += loper.toString();
		}
		return uitvoer;
	}
	
	
	public Speler bepaalSpelerAanZet()  
	{
		Speler speler = null;
		do
		{
		
			if (getAantalSpelers() == 5)
			{
				switch (vorigeSpelerIndex) 
				{
					case 0: vorigeSpelerIndex = 1; break;
					case 1: vorigeSpelerIndex = 2; break;	
					case 2: vorigeSpelerIndex = 3; break;
					case 3: vorigeSpelerIndex = 4; break;
					case 4: vorigeSpelerIndex = 0; break;
				}
			}
			if (getAantalSpelers() == 4)
			{
				switch (vorigeSpelerIndex) 
				{
					case 0: vorigeSpelerIndex = 1; break;
					case 1: vorigeSpelerIndex = 2; break;	
					case 2: vorigeSpelerIndex = 3; break;
					case 3: vorigeSpelerIndex = 0; break;
				}
			}
			speler = spelerLijst.get(vorigeSpelerIndex);
		}while(speler.isHeeftRijOpgenomen());
		
		return speler;
	}
	
	
	public String geefSpelerAanZetWeer()
	{
		return geefOverzichtSpeler(bepaalSpelerAanZet());
	}
	
	
	public void neemStapelRij(int stapelID)
	{
		StapelRij stapelRij;
		List<Kaart> temp= new ArrayList <Kaart>();
		stapelRij = stapelRijen.get(stapelID-1);
		Speler spelerAanBod = spelerLijst.get(vorigeSpelerIndex);
		temp = stapelRij.getKaartenPerRij();
		
		for (int teller = 0; teller < temp.size(); teller++)
		{
			spelerAanBod.voegKaartToe(temp.get(teller));
		}
		
		stapelRij.maakLijstLeeg();
		spelerAanBod.setHeeftRijOpgenomen(true);
		stapelRij.setIsgenomen(true);
	}
	
	
	public String geefOverzichtVanAlleSpelers()
	{
		String uitkomst = "";
		for(int teller = 0; teller <=spelerLijst.size()-1; teller++)
			uitkomst += String.format("%s%n", geefOverzichtSpeler(spelerLijst.get(teller)));
		return uitkomst;
	}
	
	
	public boolean isEindeRonde()
	{
		int aantalRijenLeeg = 0;
		for (int teller = 0; teller <=stapelRijen.size()-1; teller++)
		{
			if (stapelRijen.get(teller).kaartenRijIsLeeg())
				aantalRijenLeeg++;
		}
		return stapelRijen.size() == aantalRijenLeeg;			
	}
	
	
	public boolean isEindeSpel()
	{
		return deckKaarten.size()==0;
	}
		
	
	public void zetAllesKlaarVoorBeginRonde()
	{
		for (int teller =0; teller<spelerLijst.size(); teller++)
		{
			spelerLijst.get(teller).setHeeftRijOpgenomen(false);
		}
		for (int teller =0; teller<stapelRijen.size(); teller++)
		{
			stapelRijen.get(teller).setIsgenomen(false);
		}
	}
	
	
	public String geefEindOverzicht()
	{
		String EindOverzicht= "";
		for (int teller = 0; teller <spelerLijst.size(); teller++)
		{
			Speler speler = spelerLijst.get(teller);
			String spelerOverzicht = geefOverzichtSpeler(speler);
			int Score = speler.berekenScore();
			EindOverzicht += String.format("%s%nScore:%d%n", spelerOverzicht, Score);	
			scoreMap.voegScoreToe(speler);
		}
		return EindOverzicht;
	}
	
	
	public String geefSpelerMetJokerWeer(int spelerIndex)
	{
		if (spelerLijst.get(spelerIndex).heeftJoker())
			return geefOverzichtSpeler(spelerLijst.get(spelerIndex));
		else 
			return "";
	}
	
	
	public int geefAantalJokers(int index)
	{
		return spelerLijst.get(index).geefAantalJokers();
	}
	
	
	public void veranderKleur(int kleurGetal, int index)
	{
		String kleur="";
		switch (kleurGetal) 
		{
			case 1: kleur = "oranje"; break; 
			case 2: kleur ="blauw"; break; 
			case 3: kleur = "rood"; break; 
			case 4: kleur = "geel"; break;
			case 5: kleur = "grijs"; break; 
			case 6: kleur = "groen"; break; 
			case 7: kleur = "roos"; break; 
		}
		spelerLijst.get(index).veranderJoker(kleur);
	}
	
	
	public String geefOverzichtHighscores()
	{
		List<Speler> spelers = scoreMap.geefScorebord();
		String result="";
		
		for (Speler speler : spelers)
		{
			result += String.format("%s %15d%n", speler.getNaam(), speler.getScore());
		}
		
		return result;
	}
	
	public boolean spelOpslaan()
	{
		//spelopslaan
		int spelid = spelMap.voegSpelToe(this);
		
		//speleropslaan
		for (int teller = 0; teller <= spelerLijst.size()-1; teller++)
		{
			Speler speler = spelerLijst.get(teller);
			spelMap.voegSpelerToe(speler, spelid, teller);
		}
		
		// kaartendeck opslaan
		int [] aantalKaartenInDeck = telKaarten(deckKaarten);
		for (int teller = 0; teller <= 8; teller++)
		{
			spelMap.voegKaartDeck(bepaalKleurKaart(teller),aantalKaartenInDeck[teller],spelid);
		}
		
		
		for (int teller = 0 ; teller <= spelerLijst.size()-1; teller++)
		{
			int[] aantalKaartenPerSpeler = telKaarten(spelerLijst.get(teller).getKaartLijstSpeler());
			for (int teller2 = 0; teller2 <= aantalKaartenPerSpeler.length-1; teller2++)
			{
				spelMap.voegKaartenSpelersToe(bepaalKleurKaart(teller2), aantalKaartenPerSpeler[teller2], spelid, teller);
			}
		}
		return true;
		
	}
	
	
	private String bepaalKleurKaart(int teller)
	{
		String kleur = "";
		switch (teller) 
		{
			case 0: kleur = "oranje"; break;
			case 1: kleur = "blauw" ;break;
			case 2: kleur = "rood";break;
			case 3: kleur = "geel";break;
			case 4: kleur = "grijs";break;
			case 5: kleur = "groen";break;
			case 6: kleur = "roos";break;
			case 7: kleur = "plus 2";break;
			case 8: kleur = "joker";break;
		}
		return kleur;
	}
	private int[] telKaarten(List<Kaart> kaartenLijst)
	{
		int  aantalPlus2 = 0, aantalOranje = 0, aantalBlauw = 0, aantalGeel = 0, aantalRood = 0, aantalGroen = 0, aantalGrijs = 0, aantalRoos = 0, aantalJoker=0;
		
		for (int teller = 0; teller <= kaartenLijst.size()-1; teller++)
		{
			Kaart kaart = kaartenLijst.get(teller);
			
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
				case "joker": aantalJoker++; break;
			}
		}
		int [] array = {aantalOranje, aantalBlauw, aantalRood,aantalGeel, aantalGrijs,aantalGroen, aantalRoos,aantalPlus2, aantalJoker};
		return array;
		
	}
		
	
	public String getNaam() {
		return naam;
	}
	private void setNaam(String naam) {
		this.naam = naam;
	}
	public int getAantalSpelers() {
		return aantalSpelers;
	}
	private void setAantalSpelers(int aantalSpelers) {
		this.aantalSpelers = aantalSpelers;
	}
	public List<Kaart> getDeckKaarten() {
		return deckKaarten;
	}
	private void setDeckKaarten(List<Kaart> deckKaarten) {
		this.deckKaarten = deckKaarten;
	}
	
	public List<StapelRij> getStapelRijen() {
		return stapelRijen;
	}
	private void setStapelRijen(List<StapelRij> stapelRijen) {
		this.stapelRijen = stapelRijen;
	}
	public List<Speler> getSpelerLijst() {
		return spelerLijst;
	}

	public int getVorigeSpelerIndex() {
		return vorigeSpelerIndex;
	}

	public void setVorigeSpelerIndex(int vorigeSpelerIndex) {
		this.vorigeSpelerIndex = vorigeSpelerIndex;
	}
	
	
}

