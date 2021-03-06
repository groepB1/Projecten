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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
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

		this.dc = dc;
		BuildGui();
		
	}
	
	private void BuildGui()
	{
		//lay out van de pagina
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(10);
		this.setAlignment(Pos.CENTER);
		
		//achtergrond kleur
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
		
		//titel van startscherm
		ImageView titel = new ImageView(new Image(getClass().getResourceAsStream("/images/ColorettoTitel.png")));
		titel.setFitHeight(120);
		titel.setFitWidth(300);
		this.add(titel, 3, 1);
	
		
		//button om nieuw spel te starten
		Button btnStartNieuwSpel = new Button("START NIEUW SPEL");
		btnStartNieuwSpel.setAlignment(Pos.CENTER);
		
		this.add(btnStartNieuwSpel, 2, 5);
	
		
		// button om huidig spel verder te zetten
		Button btnHuidigSpel = new Button("HERVAT HUIDIG SPEL");
		btnStartNieuwSpel.setAlignment(Pos.CENTER);
		this.add(btnHuidigSpel, 4, 5);
		
		//menu om spel te kunnen afsluiten
		MenuBar menu = new MenuBar();
		Menu Spel = new Menu("Spel");
		MenuItem exit = new MenuItem("Sluiten");
		menu.getMenus().add(Spel);
		Spel.getItems().add(exit);
		this.setAlignment(Pos.TOP_LEFT);
		this.add(menu, 0, 0);
		
		
		//ActionEvents van Button startNieuwSpel en menuItem 'afsluiten'
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
			}
	
		}
		);
		
		exit.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) 
					{
						Platform.exit();
						
					}
			
				});
		
		btnHuidigSpel.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent arg0) 
					{
						dc.zetVorigSpelKlaar();
						
						SpeelScherm spel = new SpeelScherm(dc);
						Scene scene = new Scene(spel, 1200, 600);
						Stage stage = (Stage)(getScene().getWindow());
						stage.setScene(scene);
						stage.show();
						
					}
			
				});
	}
	


		
	

}

