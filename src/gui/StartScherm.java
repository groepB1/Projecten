package gui;

import domein.DomeinController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartScherm  extends GridPane
{
	private DomeinController dc;
	private ConfiguratieScherm cs;
	
	
	public StartScherm(DomeinController dc)
	{
		this.cs = cs;
		this.dc = dc;
		BuildGui();
		
	}
	
	private void BuildGui()
	{
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(10);
		this.setAlignment(Pos.CENTER);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		//titel van startscherm
		Label lblColoretto = new Label("COLORETTO");
		lblColoretto.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		lblColoretto.setAlignment(Pos.CENTER);
		this.add(lblColoretto, 2, 1);
		
		//button om nieuw spel te starten
		Button btnStartNieuwSpel = new Button("START NIEUW SPEL");
		btnStartNieuwSpel.setAlignment(Pos.CENTER);
		this.add(btnStartNieuwSpel, 2, 3);
		btnStartNieuwSpel.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) //action event om het configuratiescherm op te roepen
					{
					cs = new ConfiguratieScherm(dc);
					Scene scene = new Scene(cs, 500, 200);
					Stage stage = (Stage)(getScene().getWindow());
					stage.setScene(scene);
					stage.show();
					
						
					/*cs = new ConfiguratieScherm(dc);
					Scene scene = new Scene(cs,  500, 200);
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.show();*/
					}
			
				}
				);
		
		// button om huidig spel verder te zetten
		Button btnHuidigSpel = new Button("HERVAT HUIDIG SPEL");
		btnStartNieuwSpel.setAlignment(Pos.CENTER);
		this.add(btnHuidigSpel, 2, 5);
		
		//menu om spel te kunnen afsluiten
		MenuBar menu = new MenuBar();
		Menu Spel = new Menu("Spel");
		MenuItem exit = new MenuItem("Sluiten");
		menu.getMenus().add(Spel);
		Spel.getItems().add(exit);
		this.setAlignment(Pos.TOP_LEFT);
		this.add(menu, 0, 0);
		
		exit.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) 
					{
						Platform.exit();
						
					}
			
				});
		
	}
	


		
	

}
