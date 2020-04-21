package domein;

import java.util.ArrayList;
import java.util.List;

public class StapelRij 
{
	int rijID;
	private List<Kaart> kaartenPerRij= new ArrayList <Kaart>();
	boolean isgenomen;
	//1.1.1.1constructor stapelRij
	public StapelRij(int rijID)
	{
		setRijID(rijID);
	}
	
	public void voegKaartToe(Kaart getrokkenKaart)
	{
		kaartenPerRij.add(getrokkenKaart);
	}
	public void maakLijstLeeg()
	{
		kaartenPerRij.clear();
	}
	
	public boolean kaartenRijIsLeeg()
	{
		if (kaartenPerRij.size() ==0)
			return true;
		else return false;
	}
	
	//getters en setters
	public int getRijID() {
		return rijID;
	}
	private void setRijID(int rijID) {
		this.rijID = rijID;
	}

	public List<Kaart> getKaartenPerRij() {
		return kaartenPerRij;
	}

	public void setKaartenPerRij(List<Kaart> kaartenPerRij) 
	{
		this.kaartenPerRij = kaartenPerRij;
	}


	public boolean isIsgenomen() {
		return isgenomen;
	}
	
	public boolean isVol()
	{
		return kaartenPerRij.size()>2;
	}

	public void setIsgenomen(boolean isgenomen) {
		this.isgenomen = isgenomen;
	}

	//toString
	public String toString() // klopt maar hou er rekening mee dat de rij op 0 begint. 
	{
		String overzichtKaarten="";
		for (Kaart loper : kaartenPerRij)
		{
			overzichtKaarten += String.format("%s     ", loper.toString());
		}
		
		
		return String.format("rij %d: %s%n", getRijID()+1, overzichtKaarten);
	}
}
