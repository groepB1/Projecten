package gui;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ConfiguratieScherm extends GridPane
{
	private DomeinController dc;
	private Label lblNaamSpel;
	private int aantalSpelers;
	
	public ConfiguratieScherm(DomeinController dc)
	{
		this.dc = dc;
		buildGui();
	}
	private void buildGui() {
		
		//lay out van het scherm
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(10);
		this.setPrefSize(400, 300);
		
		//achtergrond kleur
		this.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		
		//label met de titel
		Label lblTitel = new Label("JE BENT ER BIJNA");	
		lblTitel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		lblTitel.setAlignment(Pos.TOP_CENTER);
		this.add(lblTitel, 1, 0);
		
		//label naam van het spel
		lblNaamSpel = new Label("Geef jouw spel een naam.");
		this.add(lblNaamSpel, 0, 1);
		
		//tekstveld waar je de naam van het spel ingeeft
		TextField txfnaam = new TextField();
		txfnaam.setPromptText("naam");
		this.add(txfnaam, 1, 1);
	
		//label voor het aantal spelers
		Label lblAantalSpelers = new Label("Geef aantal spelers in.");
		this.add(lblAantalSpelers, 0, 2);
		
		//combobox om het aantalspelers aan te duiden
		final ComboBox spelersComboBox = new ComboBox();
        spelersComboBox.getItems().addAll(
        		"4 spelers",
        		"5 spelers");
		this.add(spelersComboBox, 1,2);
		
		
		//een button om verder te gaan 
		Button btnVerder = new Button("GA VERDER");
		this.add(btnVerder, 2, 4);
		
		
		//action event van de Button verder
		btnVerder.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent btnVerder) 
			{
				if (txfnaam.getText().isEmpty())
				{
					  Alert nietIngevuld = new Alert(AlertType.WARNING);
					  nietIngevuld.setContentText("Je moet je spel een naam geven");
					  nietIngevuld.show();
				}
			else
			{
				if(spelersComboBox.getValue().equals("4 spelers")) 
				{
					aantalSpelers = 4;
					
					dc.startNieuwSpel(txfnaam.getText(), aantalSpelers);
					
					SpelerScherm sps = new SpelerScherm(dc);
					Scene scene = new Scene(sps, 700, 300);
					Stage stage = (Stage)(getScene().getWindow());
					stage.setScene(scene);
					stage.show();
					
					
					
				}
				else if(spelersComboBox.getValue().equals("5 spelers")) 
				{			
					aantalSpelers = 5;
					
					dc.startNieuwSpel(txfnaam.getText(), aantalSpelers);
					
					SpelerScherm sps = new SpelerScherm(dc);
					Scene scene = new Scene(sps, 700, 400);
					Stage stage = (Stage)(getScene().getWindow());
					stage.setScene(scene);
					stage.show();
					
				}
					
			}
			}
 		});
	}

 				
}


