package gui;


import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ScoreScherm extends VBox 
{
	private DomeinController dc;
	private TextArea eindOverzicht;
	
	public ScoreScherm(DomeinController dc)
	{
		this.dc = dc;
		buildGui();
	}
	private void buildGui()
	{
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		
		Label lblTitel = new Label("SCORES");
		
		eindOverzicht = new TextArea(dc.geefEindOverzicht());
		
		
		this.getChildren().addAll(lblTitel,eindOverzicht);
	}

}
