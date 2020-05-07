package domein;

import java.util.ArrayList;
import java.util.List;

public class StapelRij 
{
	private int rijID;
	private List<Kaart> kaartenPerRij= new ArrayList <Kaart>();
	private boolean isgenomen;


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
		return kaartenPerRij.size() ==0;
	}

	
	public boolean isIsgenomen() {
		return isgenomen;
	}
	
	
	public boolean isVol()
	{
		return kaartenPerRij.size()>2;
	}
	
	
	public int getRijID() 
	{
		return rijID;
	}
	private void setRijID(int rijID) 
	{
		this.rijID = rijID;
	}

	public List<Kaart> getKaartenPerRij() 
	{
		return kaartenPerRij;
	}

	public void setKaartenPerRij(List<Kaart> kaartenPerRij) 
	{
		this.kaartenPerRij = kaartenPerRij;
	}
	public void setIsgenomen(boolean isgenomen) 
	{
		this.isgenomen = isgenomen;
	}
	public boolean getIsgenomen()
	{
		return isgenomen;
	}

	 
	public String toString() 
	{
		String overzichtKaarten="";
		for (Kaart loper : kaartenPerRij)
		{
			overzichtKaarten += String.format("%s     ", loper.toString());
		}
		return String.format("rij %d: %s%n", getRijID()+1, overzichtKaarten);
	}
}
