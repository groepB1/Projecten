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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ScoreScherm extends VBox 
{
	private DomeinController dc;
	private TextArea eindOverzicht;
	private Button btnTerug;
	
	public ScoreScherm(DomeinController dc)
	{
		this.dc = dc;
		buildGui();
	}
	private void buildGui()
	{
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		
		Label lblTitel = new Label("SCOREBORD");
		lblTitel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		
		Label lblOverzicht = new Label("Het eindoverzicht van alle spelers.");
		
		eindOverzicht = new TextArea(dc.geefEindOverzicht());
		
		Label lblScore = new Label("De scores van alle spelers.");
		
		TextArea txaScore = new TextArea(dc.geefOverzichtHighscores());
		
		btnTerug = new Button("Terug");
		
		btnTerug.setOnAction(new EventHandler <ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) 
					{
						SpeelScherm spel = new SpeelScherm(dc);
						
						Scene scene = new Scene(spel, 1400, 600);
						Stage stage = (Stage)(getScene().getWindow());
						stage.setScene(scene);
						stage.show();
						
					}
			
				});
		
		this.getChildren().addAll(lblTitel,lblOverzicht, eindOverzicht,lblScore, txaScore, btnTerug);
	}

}

