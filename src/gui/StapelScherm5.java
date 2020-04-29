package gui;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StapelScherm5 extends VBox
{
	private DomeinController dc;
	private SpeelScherm ss;
	
	public StapelScherm5(DomeinController dc)
	{
		this.dc = dc;
		BuildGui();
	}
	public void BuildGui()
	{
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		
		Label lblTitel = new Label("Overzicht van de stapel");
		
		TextArea overzichtStapels = new TextArea();
		overzichtStapels.setText(dc.geefOverzichtVanStapelRij());
		
		Button btnTerug = new Button("terug");
		btnTerug.setOnAction(new EventHandler<ActionEvent>() 
				{

					@Override
					public void handle(ActionEvent event) 
					{
						Stage stage = (Stage) btnTerug.getScene().getWindow();
						stage.close();
						
					}
			
				});
		
		
		this.getChildren().addAll(lblTitel, overzichtStapels,btnTerug);
		
	}

}
