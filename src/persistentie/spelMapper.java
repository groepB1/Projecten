package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domein.Kaart;
import domein.Spel;
import domein.Speler;

public class spelMapper 
{
	public int voegSpelToe(Spel spel) //  dit klopt!
	{
		 try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {
			 PreparedStatement querySpelNaamToevoegen = conn.prepareStatement("INSERT INTO spel(spelNaam, vorigeSpelerIndex) VALUES (?,?);");
			 querySpelNaamToevoegen.setString(1,spel.getNaam());
			 querySpelNaamToevoegen.setInt(2, spel.getVorigeSpelerIndex());
			 querySpelNaamToevoegen.executeUpdate();
			 
			 PreparedStatement queryGeefSpelIndex = conn.prepareStatement("SELECT * FROM coloretto_2.spel WHERE spelNaam = ? ORDER BY idSpel DESC;");
			 queryGeefSpelIndex.setString(1, spel.getNaam());
			 try (ResultSet rsSpelers = queryGeefSpelIndex.executeQuery()){
				 rsSpelers.next();
				 int id = rsSpelers.getInt("idspel");
				return id;	
			 }
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            return -1;
		 }
	}
	
	
	public boolean voegSpelerToe(Speler speler, int spelid, int spelerid)	//OK , eventueel sleutel nog concat van maken
	{
		 try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {		 
			 PreparedStatement querySpelerToevoegen = conn.prepareStatement("INSERT INTO speler(idspeler, idSpel, naam) VALUES(?,?,?);");
			 querySpelerToevoegen.setString(3, speler.getNaam());
			 querySpelerToevoegen.setInt(2, spelid);
			 querySpelerToevoegen.setInt(1, spelerid);
			 querySpelerToevoegen.executeUpdate();
			 return true;
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            return false;
		 }
	}
	
	
	public boolean voegKaartDeck(String kleur, int aantal, int spelid)
	{
		 try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {		 
			 PreparedStatement queryKaartenToevoegen = conn.prepareStatement("INSERT INTO kaarten(idSpel, kleur, aantal) VALUES( ?,?,?);");
			 queryKaartenToevoegen.setString(2, kleur);
			 queryKaartenToevoegen.setInt(3, aantal);
			 queryKaartenToevoegen.setInt(1, spelid);
			 queryKaartenToevoegen.executeUpdate();
			 return true;
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            return false;
		 }
	}
	
	
	public boolean voegKaartenSpelersToe(String kleur, int aantal, int spelID, int spelerID)
	{
				
		try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {		 
			PreparedStatement querySpelersToevoegen = conn.prepareStatement("INSERT INTO spelerkaarten(idSpel,idSpeler,kleur,aantal) VALUES(?,?,?,?)");
			querySpelersToevoegen.setString(3, kleur );
			querySpelersToevoegen.setInt(4,aantal);
			querySpelersToevoegen.setInt(1,spelID);
			querySpelersToevoegen.setInt(2,spelerID);
			querySpelersToevoegen.executeUpdate();
			return true;
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            
	            return false;
		 }
		 }
	
	

//zoekSpelOpNaam zie vb
	public String LaadSpelNaam()
	{
		String naam = "";
		try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {		 
			PreparedStatement querygeefLaatsteSpel = conn.prepareStatement("SELECT * FROM spel ORDER  BY idspel DESC;");
			try(ResultSet rs = querygeefLaatsteSpel.executeQuery())
			{
				rs.next();
				naam = rs.getString("spelNaam");
			}

		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            
	            
		 }
		return naam;
	}
	
	public int laadVorigeSpeler()
	{
		int vorigeSpeler =0;
		try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {		 
			PreparedStatement querygeefspelerIndex = conn.prepareStatement("SELECT * FROM spel ORDER  BY idspel DESC;");
			try(ResultSet rs = querygeefspelerIndex.executeQuery())
			{
				rs.next();
				vorigeSpeler= rs.getInt("vorigeSpelerIndex");
			}

		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            
	            
		 }
		return vorigeSpeler;
	}
	
	public List<Speler> LaadSpelers()
	{
		List<Speler> spelers = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {
			PreparedStatement querygeefSpeler = conn.prepareStatement("SELECT * FROM speler ORDER  BY idspel DESC;");
			try(ResultSet rs = querygeefSpeler.executeQuery())
			{
				int id=0;
				rs.next();
				do
				{
				id = rs.getInt("idSpel");
				String naam = rs.getString("naam");
				Speler speler = new Speler(naam);
				spelers.add(speler);
				rs.next();
				}while (id==rs.getInt("idSpel"));
				
			}
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	}
		return spelers;
	}
	
	public List<Kaart> laadKaarten()
	{
		
		List<Kaart> kaarten = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {
			PreparedStatement querygeefKaarten = conn.prepareStatement("SELECT * FROM kaarten ORDER  BY idspel DESC;");
			
			try(ResultSet rs = querygeefKaarten.executeQuery())
			{
				int id=0;
				rs.next();
				do
				{
				id = rs.getInt("idSpel");
				String kleur = rs.getString("kleur");
				int aantal = rs.getInt("aantal");
				for (int teller = 0; teller <=aantal-1; teller++)
				{
					Kaart kaart = new Kaart(kleur);
					kaarten.add(kaart);
				}
				rs.next();
				}while (id==rs.getInt("idSpel"));
				
			}
			
		
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	}
		return kaarten;
	}
	
	public List<Kaart> laadSpelerKaarten(int spelerid)
	{
		List<Kaart> spelerKaarten = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {
			PreparedStatement querygeefSpelerKaarten = conn.prepareStatement("SELECT * FROM spelerkaarten where idSpeler = 1 ORDER  BY idspel DESC;");
			
			try(ResultSet rs = querygeefSpelerKaarten.executeQuery())
			{
				int id=0;
				rs.next();
				do
				{
				id = rs.getInt("idSpel");
				String kleur = rs.getString("kleur");
				int aantal = rs.getInt("aantal");
				for (int teller = 0; teller <=aantal-1; teller++)
				{
					Kaart kaart = new Kaart(kleur);
					spelerKaarten.add(kaart);
				}
				rs.next();
				}while (id==rs.getInt("idSpel"));
				
			}
			
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            
	}
		return spelerKaarten;
	}
	
// verwijder spel zie vb
	
	
	
	
}
