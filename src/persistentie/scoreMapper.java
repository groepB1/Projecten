package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domein.Speler;

public class scoreMapper 
{
	public boolean voegScoreToe(Speler speler)
	{
		 try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {
			 PreparedStatement queryScoreToevoegen = conn.prepareStatement("insert into highscores(spelernaam,score) values (?,?);");
			 queryScoreToevoegen.setString(1, speler.getNaam());
			 queryScoreToevoegen.setInt(2, speler.getScore());
			 queryScoreToevoegen.executeUpdate();
			 return true;
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	            return false;
		 }
	}
	
	public List<Speler> geefScorebord()
	{
		List<Speler> spelerHighScorelijst = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(MapperConfig.JDBC_URL))
		 {
			PreparedStatement querygeefScorebordWeer = conn.prepareStatement("SELECT * FROM highscores order by score;");
			try (ResultSet rsScoreBord = querygeefScorebordWeer.executeQuery()){
			while (rsScoreBord.next())
			{
				String naam = rsScoreBord.getString("spelernaam");
				int score = rsScoreBord.getInt("score");
				Speler speler = new Speler(naam);
				speler.setScore(score);
				spelerHighScorelijst.add(speler);
			}
			}
		 }catch (SQLException ex) {
	            for (Throwable t : ex) 
	            {
	                t.printStackTrace();
	            }
	}
		return spelerHighScorelijst;
	}
}
