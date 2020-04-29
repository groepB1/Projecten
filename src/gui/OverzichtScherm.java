package gui;

import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class OverzichtScherm extends VBox
{

	private DomeinController dc;
	private TextArea overzicht;
	
	public OverzichtScherm(DomeinController dc)
	{
		this.dc = dc;
		BuildGui();
	}
	public void BuildGui()
	{
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		
		Label lblTitel = new Label("Overzicht van alle spelers");
		
		overzicht = new TextArea();
		overzicht.setText(dc.geefOverzichtVanAlleSpelers());
		
		this.getChildren().addAll(lblTitel, overzicht);
		
		
		
		
		
	}
}
