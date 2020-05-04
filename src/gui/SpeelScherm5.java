package gui;

import domein.DomeinController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

public class SpeelScherm5 extends GridPane
{
	private DomeinController dc;;
	private ImageView getrokkenKaart;
	private Label lblgetrokkenKaart;
	private ImageView kaart;
	private CheckBox cbrij1;
	private CheckBox cbrij2;
	private CheckBox cbrij3;
	private CheckBox cbrij4;
	private CheckBox cbrij5;
	private Button btnLegOp;
	private Button btnNeemStapel;
	private Alert speler;
	private Button btnscore;
	private Button btnjoker;
	private Button btnOpslaan;
	
	public SpeelScherm5(DomeinController dc)
	{
		this.dc = dc;
		BuildGui();
	
		
	}
	public void BuildGui()
	{
		this.setVgap(20);
		this.setHgap(20);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		
		MenuBar menu = new MenuBar(); //menu om het speler overzicht op te vragen
		Menu Spel = new Menu("Spel");
		MenuItem overzicht = new MenuItem("Speler overzicht");
		MenuItem exit = new MenuItem("Spel afsluiten");
		menu.getMenus().add(Spel);
		Spel.getItems().addAll(overzicht, exit);
		this.add(menu, 0,  0);
		
		Label lblTitel = new Label("COLLORETTO");
		lblTitel.setFont(Font.font("verdana", FontWeight.BOLD, 30));
		this.add(lblTitel, 2, 1);
		
		
		Button btnSpeler = new Button("Speler aan zet");
		this.add(btnSpeler, 3, 1);
		
		
		
		
		Label lblgk = new Label("De getrokken kaart is: ");
		this.add(lblgk, 2, 3);
		Label lblgetrokkenKaart = new Label(dc.geefGetrokkenKaartWeer());
		this.add(lblgetrokkenKaart, 3, 3);
		
		
		
		
		
	
	
		cbrij1 = new CheckBox("Eerste stapel");
		this.add(cbrij1, 3, 4);
		cbrij2 = new CheckBox("Tweede stapel");
		this.add(cbrij2, 4, 4);
		cbrij3 = new CheckBox("Derde stapel");
		this.add(cbrij3, 5, 4);
		cbrij4 = new CheckBox("Vierde stapel");
		this.add(cbrij4, 6, 4);
		cbrij5 = new CheckBox("Vijfde stapel");
		this.add(cbrij5, 7, 4);
		
		Button btnLegOp = new Button("Leg op een stapel");
		this.add(btnLegOp, 3, 5);
		
		
		Button btnNeemStapel = new Button("Kies een stapel en neem ze");
		this.add(btnNeemStapel, 7, 5);
		
							
				
		
		btnscore = new Button("Scores");
		this.add(btnscore, 6, 7);
		
		btnjoker = new  Button("Jokers");
		this.add(btnjoker, 3, 7);
		
		//button om spel op te slaan
		btnOpslaan = new Button("Opslaan");
		this.add(btnOpslaan, 1, 8);
		
		//actionEvents
		exit.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				Platform.exit();
				
			}
		
		});

		
		overzicht.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event) 
					{
						OverzichtScherm os = new OverzichtScherm(dc); // oproepen overzichtscherm
						Scene scene = new Scene(os, 400, 300);
						Stage stage = new Stage();
						stage.setScene(scene);
						stage.show();
						
					}
			
				});
		btnSpeler.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				speler = new Alert(Alert.AlertType.INFORMATION);
				speler.setTitle("De speler aan zet is: ");
				speler.setHeaderText(dc.geefEersteSpelerAanZetWeer()); //geeft de beginspeler weer
				speler.showAndWait();
			
			}
	
		});
		
		btnLegOp.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event) 
			{
				int stapelID = keuzeRij();
				
				dc.voegKaartAanStapelToe(stapelID);
				
				
				cbrij1.setSelected(false);
				cbrij2.setSelected(false);
				cbrij3.setSelected(false);
				cbrij4.setSelected(false);
				cbrij5.setSelected(false);
				
				StapelScherm5 sts = new StapelScherm5(dc);
				Scene scene = new Scene(sts, 400, 300);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				
				lblgetrokkenKaart.setText(dc.geefGetrokkenKaartWeer());
				speler.setHeaderText(dc.geefSpelerAanZetWeer());
			}
	
		});
		
		btnNeemStapel.setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent event) 
			{
				int stapelID = keuzeRij();
				
				
				cbrij1.setSelected(false);
				cbrij2.setSelected(false);
				cbrij3.setSelected(false);
				cbrij4.setSelected(false);
				cbrij5.setSelected(false);
				
				dc.neemStapelRij(stapelID);
				StapelScherm sts = new StapelScherm(dc);
				Scene scene = new Scene(sts, 400, 300);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				
				lblgetrokkenKaart.setText(dc.geefGetrokkenKaartWeer());
				speler.setHeaderText(dc.geefSpelerAanZetWeer());
				
				if(dc.isEindeRonde()) //als de ronde afgelopen is krijg je een alertscherm die je vertelt dat een nieuwe ronde van start gaat 
				{
					Alert startRonde = new Alert(Alert.AlertType.INFORMATION);
					startRonde.setTitle("Beste spelers");
					startRonde.setHeaderText("Een nieuwe ronde gaat van start!");
					startRonde.showAndWait();
					
					dc.zetAllesKlaarVoorBeginRonde();
				}
					
				else if(dc.isEindeSpel())
					{
						Alert einde = new Alert(Alert.AlertType.INFORMATION);
						einde.setHeaderText("Einde spel! Ga eerst de jokers bekijken en bekijk nadien jullie scores!");
						einde.showAndWait();
						
						btnjoker.setOnAction(new EventHandler<ActionEvent>()
								{

									@Override
									public void handle(ActionEvent event) 
									{
										JokerScherm js = new JokerScherm(dc);
										Scene scene = new Scene(js, 400, 500);
										Stage stage = (Stage)(getScene().getWindow());
										stage.setScene(scene);
										stage.show();
										
									}
					
							});
						
								btnscore.setOnAction(new EventHandler<ActionEvent>()
								{

									@Override
									public void handle(ActionEvent event) 
									{
										ScoreScherm ss = new ScoreScherm(dc);
										Scene scene = new Scene(ss, 400, 500);
										Stage stage = (Stage)(getScene().getWindow());
										stage.setScene(scene);
										stage.show();
										
										
									}
							
								
								});
						}
					}	
			
				});
		
		btnOpslaan.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event) 
			{
				dc.opslaanSpel();
				
			}
	
		});
	}
	
	public int keuzeRij()
	{
		int stapelID=0;
		
		if(cbrij1.isSelected())
		{
			stapelID = 1;
		}
		else if(cbrij2.isSelected())
		{
			stapelID = 2;
		}
		else if(cbrij3.isSelected())
		{
			stapelID = 3;
		}
		else if(cbrij4.isSelected())
		{
			stapelID = 4;
		}
		else if(cbrij4.isSelected())
		{
			stapelID = 5;
		}
		
		return stapelID;
		
	}

}

