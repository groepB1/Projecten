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
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
	import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

	public class VijfSpelerScherm extends GridPane
	{
		private DomeinController dc;
		
		public VijfSpelerScherm(DomeinController dc)
		{
			this.dc = dc;
			BuildGui();
		}
		
		public void BuildGui()
		{

			this.setPadding(new Insets(10, 10, 10, 10));
			this.setVgap(10);
			this.setHgap(10);
			this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
			
			MenuBar menu = new MenuBar();
			Menu Spel = new Menu("Spel");
			MenuItem exit = new MenuItem("Sluiten");
			MenuItem terug = new MenuItem("Terug");
			menu.getMenus().add(Spel);
			Spel.getItems().addAll(terug, exit);
			this.setAlignment(Pos.TOP_LEFT);
			this.add(menu, 0, 0);
			terug.setOnAction(new EventHandler<ActionEvent>()
						{

							@Override
							public void handle(ActionEvent event) 
							{
								ConfiguratieScherm cs = new ConfiguratieScherm(dc);
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
				
					}
			);
			
			Label lblTitel = new Label("GEEF DE NAMEN IN VAN ALLE SPELERS."); //titel van het scherm
			lblTitel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
			lblTitel.setAlignment(Pos.TOP_CENTER);
			this.add(lblTitel, 2, 0);
			
			Label s1 = new Label("Speler 1"); // labels met de spelers
			this.add(s1, 1, 1); //beginnend vanaf eerste rij , eerste kolom van de GridPane
			
			TextField txfSpeler1 = new TextField();
			txfSpeler1.setPromptText("naam");
			this.add(txfSpeler1, 2, 1);
			
			Label s2 = new Label("Speler 2");
			this.add(s2, 1, 3);
			
			TextField txfSpeler2 = new TextField();
			txfSpeler2.setPromptText("naam");
			this.add(txfSpeler2, 2, 3);
			
			Label s3 = new Label("Speler 3");
			this.add(s3, 1, 5);
			
			TextField txfSpeler3 = new TextField();
			txfSpeler3.setPromptText("naam");
			this.add(txfSpeler3, 2, 5);
			
			Label s4 = new Label("Speler 4");
			this.add(s4, 1, 7);
			
			TextField txfSpeler4 = new TextField();
			txfSpeler4.setPromptText("naam");
			this.add(txfSpeler4, 2, 7);
			
			Label s5 = new Label("Speler 5");
			this.add(s5, 1, 8);
			
			TextField txfSpeler5 = new TextField();
			txfSpeler5.setPromptText("naam");
			this.add(txfSpeler5, 2, 8);
			
			Button btnStartSpel = new Button("START SPELEN");
			this.add(btnStartSpel, 3, 9);
			
			

			btnStartSpel.setOnAction(new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent btnStartSpel) 
				{
					dc.geefSpelerNaamIn(txfSpeler1.getText());
					dc.geefSpelerNaamIn(txfSpeler2.getText());
					dc.geefSpelerNaamIn(txfSpeler3.getText());
					dc.geefSpelerNaamIn(txfSpeler4.getText());
					dc.geefSpelerNaamIn(txfSpeler5.getText());
					
					SpeelScherm5 spel = new SpeelScherm5(dc);
					Scene scene = new Scene(spel, 1200, 600);
					Stage stage = (Stage)(getScene().getWindow());
					stage.setScene(scene);
					stage.show();
				}
				
			});
		}

	}



