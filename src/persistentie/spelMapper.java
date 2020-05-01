package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domein.Spel;
import domein.Speler;

public class spelMapper 
{
	public int voegSpelToe(Spel spel) //  dit klopt!
	{
		 try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {
			 PreparedStatement querySpelNaamToevoegen = conn.prepareStatement("INSERT INTO spel(spelNaam) VALUES (?);");
			 querySpelNaamToevoegen.setString(1,spel.getNaam());
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
	
	
	/*public boolean voegStapelRijToe(int id, int spelid)
	{
		 try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {		 
			 PreparedStatement queryKaartenToevoegen = conn.prepareStatement(" INSERT INTO stapelrijen VALUES( ?, ? ,?);");
			 queryKaartenToevoegen.setInt(1, id);
			 queryKaartenToevoegen.setInt(2, spelid);
			 queryKaartenToevoegen.executeUpdate();
			 return true;
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            return false;
		 }
	}*/
	
	
	/*public boolean voegKaartenPerRijToe(String kleur, int aantal, int spelID, int rijID)
	{
		try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {		 
			PreparedStatement querySpelersToevoegen = conn.prepareStatement("INSERT INTO spelerkaarten VALUES(?,?,?,?);");
			querySpelersToevoegen.setString(1, kleur );
			querySpelersToevoegen.setInt(2,aantal);
			querySpelersToevoegen.setInt(3,spelID);
			querySpelersToevoegen.setInt(4,rijID);
			return true;
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            
	            return false;
		 }
	}*/
//zoekSpelOpNaam zie vb
	
// verwijder spel zie vb
	
	
	
}
