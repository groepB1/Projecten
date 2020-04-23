package domein;

public class Kaart 
{
	private String kleur;
	
	public Kaart(String kleur)
	{
		setKleur(kleur);
	}

	
	public String getKleur() 
	{
		return kleur;
	}
	public void setKleur(String kleur) 
	{
		this.kleur = kleur;
	}
	public String toString()
	{
		return String.format("%s%n", getKleur());
	}
}
