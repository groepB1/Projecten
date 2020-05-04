package ui;

import java.util.Scanner;
import domein.DomeinController;

public class ColorettoApplicatie 
{
	Scanner invoer = new Scanner(System.in);
	private final DomeinController dc;
	public ColorettoApplicatie(DomeinController dc)
	{
		this.dc = dc;
		int aantalSpelers=0;
		boolean spelOpgeslagen = false;
		System.out.println("geef 1 in om het vorige spel te hervatten. Geef 2 om om een nieuw spel te starten.");
		int startNieuwSpelOfSpelHervatten = invoer.nextInt();
		
		if (startNieuwSpelOfSpelHervatten ==1)
		{
			dc.zetVorigSpelKlaar();
			aantalSpelers = dc.geefAantalSpelers();
			System.out.println(dc.geefOverzichtVanAlleSpelers());
			while (!dc.isEindeSpel())
			{
				for (int teller =0; teller<aantalSpelers; teller++)
				{
					startRondeAndereSpelers(dc);
				}	
				speelRonde2En3(dc, aantalSpelers);
				
				//test opslaanSpel
				System.out.println("geef 9999 in om het spel op te slaan en te stoppen. geef iets anders in om door te gaan. ");
				int stoppen = invoer.nextInt();
				if (stoppen == 9999)
				{
					dc.opslaanSpel();
					spelOpgeslagen=true;
					break;
				}
				
			}
			
		}
		else if (startNieuwSpelOfSpelHervatten == 2) 
		{
			//spel klaarzetten
			String Spelnaam=geefSpelNaamIn(dc);
			aantalSpelers = geefSpelersIn(dc, Spelnaam);
			System.out.println(geefSpelerNamenIn(aantalSpelers, dc));
			
			//spel effectief spelen
			int ronde=1;
			while (/*!dc.isEindeSpel()*/ronde !=3)
			{
				System.out.printf("Ronde %d%n", ronde);
				speelRonde1(dc, aantalSpelers);
				speelRonde2En3(dc, aantalSpelers);
				ronde++;
				
				//test opslaanSpel
				System.out.println("geef 9999 in om het spel op te slaan en te stoppen. geef iets anders in om door te gaan. ");
				int stoppen = invoer.nextInt();
				if (stoppen == 9999)
				{
					dc.opslaanSpel();
					spelOpgeslagen=true;
					break;
				}
				
			}
		}
		
		//einde spel (joker + score)
		if (spelOpgeslagen)
			System.out.println("spel is opgeslaan");
		
		else 
		{
			jokerInstellen(dc, aantalSpelers);
			System.out.println(dc.geefEindOverzicht());
			System.out.println(dc.geefOverzichtHighscores());
		}
	}	

	
	public String geefSpelNaamIn(DomeinController dc)
	{
		System.out.println("geef een spelnaam In");
		String Spelnaam = invoer.next();
		return Spelnaam;
	}
	
	
	public int geefSpelersIn(DomeinController dc, String Spelnaam)
	{
		int aantalSpelers =0;
		do 
		{
			System.out.println("Geef aantal spelers in");
			aantalSpelers = invoer.nextInt();
		} while (aantalSpelers != 4 && aantalSpelers !=5);
		dc.startNieuwSpel(Spelnaam, aantalSpelers);
		return aantalSpelers;
	}
	
	
	public String geefSpelerNamenIn(int aantalSpelers, DomeinController dc)
	{
		String result ="";
		for (int teller = 0; teller<=aantalSpelers-1; teller++) 
		{
			System.out.printf("geef de naam van speler %d in.%n", teller+1);
			String naam = invoer.next();
			result += dc.geefSpelerNaamIn(naam);
		}
		return result;
	}
	
	
	public void speelRonde1(DomeinController dc, int aantalSpelers)
	{
		startRondeBeginSpeler(dc);
		for (int teller2 =0; teller2<aantalSpelers-1; teller2++)
		{
			startRondeAndereSpelers(dc);
		}		
	}
	
	
	public void speelRonde2En3(DomeinController dc, int aantalSpelers)
	{
		
		for (int teller = 0; teller <=1; teller++)
		{
			if(dc.isEindeRonde())
				break;
			for (int teller2 = 0; teller2 <= aantalSpelers-1; teller2++)
			{
				System.out.println(dc.geefSpelerAanZetWeer());
				int uitkomst = geefOptie();
				
				if (uitkomst == 1)
					trekKaart(dc);
				if (uitkomst == 2)
					neemStapelRij(dc);
				if(dc.isEindeRonde())
					break;	
			}
		}
		while (!dc.isEindeRonde())
		{
			System.out.println(dc.geefSpelerAanZetWeer());
			neemStapelRij(dc);
		}
		System.out.println(dc.geefOverzichtVanAlleSpelers());
		dc.zetAllesKlaarVoorBeginRonde();
	}
	
	
	public void startRondeBeginSpeler(DomeinController dc)
	{
		System.out.println(dc.geefEersteSpelerAanZetWeer());
		trekKaart(dc);
	}
	
	
	public void startRondeAndereSpelers(DomeinController dc)
	{
		System.out.println(dc.geefSpelerAanZetWeer());
		trekKaart(dc);
	}
	
	
	public int geefOptie()
	{
		System.out.println("geef 1 in om een kaart te leggen. Geef 2 in om een stapel te ");
		int keuze = invoer.nextInt();
		return keuze;
	}
	
	
	public void trekKaart(DomeinController dc)
	{
		System.out.println(dc.geefGetrokkenKaartWeer());
		System.out.println("Aan welke stapel wil je de kaart toevoegen?");
		int stapelID = invoer.nextInt();
		dc.voegKaartAanStapelToe(stapelID);
		System.out.println(dc.geefOverzichtVanStapelRij());	
	}
	
	
	public void neemStapelRij(DomeinController dc)
	{
		System.out.println("Welke stapel wilt u nemen?");
		int stapelID= invoer.nextInt();
		dc.neemStapelRij(stapelID);
		System.out.println(dc.geefOverzichtVanStapelRij());		
	}
	
	
	public void jokerInstellen(DomeinController dc, int aantalSpelers)
	{
		for (int teller = 0 ; teller <=aantalSpelers-1; teller++)
		{
			System.out.println(dc.geefSpelerMetJokerWeer(teller));
		
			for (int teller2 = 0; teller2< dc.geefAantalJokers(teller); teller2++)
			{
				System.out.println("In welke kleur wil je de joker veranderen? Geef 1 in voor oranje. Geef 2 in voor blauw. Geef 3 in voor rood. Geef 4 in voor geel. Geef 5 in voor grijs. Geef 6 in voor groen. Geef 7 in voor roos.");
				int kleurGetal = invoer.nextInt();
				dc.veranderKleur(kleurGetal, teller);
			}
		}
		
		}
	
	
	}