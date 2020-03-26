package domein;

public class Kaart 
{
	String kleur;
	//1.1.1.1 constructor kaart 
	public Kaart(String kleur)
	{
		setKleur(kleur);
	}

	//getters en setters
	public String getKleur() {
		return kleur;
	}
	public void setKleur(String kleur) {
		this.kleur = kleur;
	}
	
	public String toString()
	{
		return String.format("%s%n", getKleur());
	}
}
