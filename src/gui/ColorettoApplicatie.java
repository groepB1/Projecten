package gui;
//test voor gitHub
import java.util.Scanner;

import domein.DomeinController;

public class ColorettoApplicatie 
{
	Scanner invoer = new Scanner(System.in);
	
	public ColorettoApplicatie(DomeinController dc)
	{
		// spelnaam + aantalspelers ingeven. 1, 2.1
		System.out.println("geef een spelnaam In");
		String Spelnaam = invoer.nextLine();
		
		int aantalSpelers =0;
		do {
		System.out.println("Geef aantal spelers in");
		aantalSpelers = invoer.nextInt();
		dc.startNieuwSpel(Spelnaam, aantalSpelers);
		} while (aantalSpelers != 4 && aantalSpelers !=5);
		//spelersnamen ingeven 2.2
		for (int teller = 0; teller<=aantalSpelers-1; teller++) 
		{
		System.out.printf("geef de naam van speler %d in.%n", teller+1);
		String naam = invoer.next();
		String spelerOverzicht = dc.geefSpelerNaamIn(naam);
		System.out.println(spelerOverzicht);
		}
		

		
		startRondeBeginSpeler(dc);
		//A_ rond dit deel moet do while tot einde spel bereikt wordt(boolean methode isEindeSpel)komen dat alle ronden kunnen gespeeld worden. 	
		//ronde 1, 2 en 3 worden weergegeven
		
		
		  
		while (dc.isEindeSpel() == false)  
		{
		
		for (int teller2 =0; teller2<aantalSpelers-1; teller2++)
		{
		startRondeAndereSpelers(dc);
		}
		
		for (int teller = 0; teller <=1; teller++)
		{
			for (int teller2 = 0; teller2 <= aantalSpelers-1; teller2++)
			{
				ronde2En3(dc);
				if (dc.isEindeRonde() == true)
					break;
			}
			if (dc.isEindeRonde() == true)
				break;
		}
		for (int teller3 = 0; teller3 <= aantalSpelers-1; teller3++)
		{
			System.out.println(dc.geefSpelerAanZetWeer());
			neemStapelRij(dc);
		}
		System.out.println(dc.geefOverzichtVanAlleSpelers());
		dc.zetAllesKlaarVoorBeginRonde();
		}
		jokerInstellen(dc, aantalSpelers);
		
		System.out.println(dc.geefEindOverzicht());	
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
	
	public void ronde2En3(DomeinController dc)
	{
		System.out.println(dc.geefSpelerAanZetWeer());
		
		int uitkomst = geefOptie();
		if (uitkomst == 1)
			trekKaart(dc);
		if (uitkomst == 2)
			neemStapelRij(dc);
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
		if (dc.geefSpelerMetJokerWeer(teller)!="")
		{
			dc.geefSpelerMetJokerWeer(teller);
		
			for (int teller2 = 0; teller2<= dc.geefAantalJokers(teller); teller2++)
			{
				System.out.println("In welke kleur wil je de joker veranderen? Geef 1 in voor oranje. Geef 2 in voor blauw. Geef 3 in voor rood. Geef 4 in voor geel. Geef 5 in voor grijs. Geef 6 in voor groen. Geef 7 in voor roos.");
				int kleurGetal = invoer.nextInt();
				dc.veranderKleur(kleurGetal, teller);
			}
		}
		
		}
	}
//	1.	keuze tussen start nieuw spel of opgeslagen spel.
	
//	2.1	Geef aantal spelers in. ==> niet nodig. gewoon invoercontrole toepassen! do while rond!
	
//	2.2	Geef de naam van speler.. in (afh van aantal spelers)
	
//	4.	Overzicht alle spelers+ inventory  
	
//	5.	1 spelernaam (spelerAanZet)+getrokkenKaart weergeven. 
	
//	6.	Keuze stapel invoeren
	
//	7.	Alle stapels weergeven
	
//	8.	Herhaal vanaf stap 5 tot iedereen geweest is.
	
//	9.	Vanaf hier Keuze stapel invoeren of neem stapel invoeren
	
//	10.	Als stapel genomen wordt toestand van iedereen zijn stapel weergeven. 
	
//	11.	Herhaal vanaf stap 9 tot alle stapels genomen zijn. 

}
