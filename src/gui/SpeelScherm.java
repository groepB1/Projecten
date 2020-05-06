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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SpeelScherm extends GridPane
{
	private DomeinController dc;
	private Label lblgetrokkenKaart;
	private ImageView kaart;
	private CheckBox cbrij1;
	private CheckBox cbrij2;
	private CheckBox cbrij3;
	private CheckBox cbrij4;
	private CheckBox cbrij5;
	private Image blauw;
	private Image  geel;
	private Image  grijs;
	private Image  groen;
	private Image joker;
	private Image  oranje;
	private Image  plus2;
	private Image  rood;
	private Image  roos;
	private Button btnLegOp;
	private Button btnNeemStapel;
	private Alert speler;
	private Button btnscore;
	private Button btnjoker;
	private Button btnOpslaan;
	private Button btnTrekKaart;
	private boolean heeftVijfSpelers;
	
	public SpeelScherm(DomeinController dc)
	{
		this.dc = dc;
		buildGui();
	}
	
	public void buildGui()
	{
		//layout van scherm
		this.setVgap(20);
		this.setHgap(20);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTSEAGREEN, null, null))); //layout van de scene
		
		//menu 
		MenuBar menu = new MenuBar(); //menu om het speler overzicht op te vragen
		Menu Spel = new Menu("Spel");
		MenuItem overzicht = new MenuItem("Speler overzicht");
		MenuItem exit = new MenuItem("Spel afsluiten"); //menu om het spel af te sluiten
		menu.getMenus().add(Spel);
		Spel.getItems().addAll(overzicht, exit);
		this.add(menu, 0,  0);
		
		//titel
		ImageView titel = new ImageView(new Image(getClass().getResourceAsStream("/images/ColorettoTitel.png")));
		titel.setFitHeight(50);
		titel.setFitWidth(150);
		this.add(titel, 1, 1);

		
		//button om de speler aan zet te zien
		Button btnSpeler = new Button("Speler aan zet");
		this.add(btnSpeler, 3, 1);
		
		Label lblmessage = new Label("Ga eerst kijken welke speler aan zet is voor je start.");
		this.add(lblmessage, 2, 1);
		
		

	
		btnTrekKaart = new Button("Trek een kaart");
		this.add(btnTrekKaart, 2, 3);
		
		Label lblgetrokkenKaart = new Label();
		this.add(lblgetrokkenKaart, 3, 3);
		
		
		
		blauw = new  Image(getClass().getResourceAsStream("/images/blauw.jpg"));
		geel = new  Image(getClass().getResourceAsStream("/images/geel.jpg"));
		grijs = new  Image(getClass().getResourceAsStream("/images/grijs.jpg"));
		groen = new  Image(getClass().getResourceAsStream("/images/groen.jpg"));
		joker = new  Image(getClass().getResourceAsStream("/images/joker.png"));
		oranje = new  Image(getClass().getResourceAsStream("/images/oranje.jpg"));
		plus2 = new  Image(getClass().getResourceAsStream("/images/plus 2.png"));
		rood = new  Image(getClass().getResourceAsStream("/images/rood.png"));
		roos = new  Image(getClass().getResourceAsStream("/images/Roos.png"));
		
		ImageView kaart = new ImageView();
		kaart.setFitHeight(100);
		kaart.setFitWidth(70);
		this.add(kaart, 4, 3);
		
		//button om score scherm op te roepen bij einde spel
		btnscore = new Button("Scores");
		this.add(btnscore, 6, 7);
		
		
		//button om jokerscherm op te roepen bij einde spel
		btnjoker = new  Button("Jokers");
		this.add(btnjoker, 3, 7);
	
	
	
		//checkboxen van de stapels
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
		cbrij5.setVisible(false);
		
		if(spelHeeftVijfSpelers(dc))
		{
			cbrij5.setVisible(true);
		}
		
		//button om een kaart op te leggen
		btnLegOp = new Button("Leg op een stapel"); //button om op stapel te leggen
		this.add(btnLegOp, 3, 5);
		
		//button om een stapel te nemen
		btnNeemStapel = new Button("Kies een stapel en neem ze");
		this.add(btnNeemStapel, 6, 5);
		
		//button om spel op te slaan
		btnOpslaan = new Button("Opslaan");
		this.add(btnOpslaan, 1, 8);
				
		//action events voor buttons: speler, exit, overzicht, leg op, neem stapel, jokerscherm, scorescherm
		
		btnTrekKaart.setOnAction(new EventHandler <ActionEvent>()
				{

					@Override
					public void handle(ActionEvent arg0) 
					{
						lblgetrokkenKaart.setText(dc.geefGetrokkenKaartWeer()); //update van de getrokken kaart na het leggen
						//afbeeldingen van kaarten gelijkstellen aan de kleur
						
						
						
						if(lblgetrokkenKaart.getText().contains("blauw"))
						{
							kaart.setImage(blauw);
						}
						else if(lblgetrokkenKaart.getText().contains("geel"))
						{
							kaart.setImage(geel);
						}
						else if(lblgetrokkenKaart.getText().contains("grijs"))
						{
							kaart.setImage(grijs);
						}
						else if(lblgetrokkenKaart.getText().contains("groen"))
						{
							kaart.setImage(groen);
						}
						else if(lblgetrokkenKaart.getText().contains("joker"))
						{
							kaart.setImage(joker);
						}
						else if(lblgetrokkenKaart.getText().contains("oranje"))
						{
						
							kaart.setImage(oranje);
						}
						else if(lblgetrokkenKaart.getText().contains("plus 2"))
						{
							kaart.setImage(plus2);
						}
						else if(lblgetrokkenKaart.getText().contains("rood"))
						{
							kaart.setImage(rood);
						}
						else if(lblgetrokkenKaart.getText().contains("roos"))
						{
							kaart.setImage(roos);
						}
						
						
						
						
					}
			
				});
		
		
		btnSpeler.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				speler = new Alert(Alert.AlertType.INFORMATION);
				speler.setTitle("De speler aan zet is: ");
				startRondeBeginSpeler(dc); //geeft de beginspeler weer
				speler.showAndWait();
			
			}
	
		});
		
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
		btnLegOp.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event) 
			{
				int stapelID = keuzeRij();
				
				dc.voegKaartAanStapelToe(stapelID); //methode om kaart te te voegen aan de rijen
				
				cbrij1.setSelected(false);
				cbrij2.setSelected(false);
				cbrij3.setSelected(false);
				cbrij4.setSelected(false);
				
				if(spelHeeftVijfSpelers(dc))
				{
					cbrij5.setSelected(false);
				}
				
				StapelScherm sts = new StapelScherm(dc); //overzichtscherm van de rijen worden getoont
				Scene scene = new Scene(sts, 400, 300);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				
				speler.setHeaderText(dc.geefSpelerAanZetWeer());//update van de speler aan zet
				
				
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
				
				if(spelHeeftVijfSpelers(dc))
				{
					cbrij5.setSelected(false);
				}
				
				dc.neemStapelRij(stapelID); //methode om een stapel te nemen
				StapelScherm sts = new StapelScherm(dc);
				Scene scene = new Scene(sts, 400, 300);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				
				
				
				startRondeAndereSpelers(dc);
				
				//als de ronde afgelopen is krijg je een alertscherm die je vertelt dat een nieuwe ronde van start gaat 
				
					if(dc.isEindeRonde())
					{
						
					Alert startRonde = new Alert(Alert.AlertType.INFORMATION);
					startRonde.setTitle("Beste spelers");
					startRonde.setHeaderText("Een nieuwe ronde gaat van start!");
					startRonde.showAndWait();
					
					
					dc.zetAllesKlaarVoorBeginRonde();
					startRondeBeginSpeler(dc);
					
				
						if(dc.isEindeSpel())
						{
				
				
						Alert einde = new Alert(Alert.AlertType.INFORMATION);
						einde.setHeaderText("Einde spel! Ga eerst de jokers bekijken en bekijk nadien jullie scores!");
						einde.showAndWait();
						
						btnjoker.setOnAction(new EventHandler<ActionEvent>() //kan jokerscherm oproepen
								{

									@Override
									public void handle(ActionEvent event) 
									{
										JokerScherm js = new JokerScherm(dc);
										Scene scene = new Scene(js, 400, 300);
										Stage stage = (Stage)(getScene().getWindow());
										stage.setScene(scene);
										stage.show();
										
									}
							
								});
									
					
						}
					}
				}
			});
			
			btnscore.setOnAction(new EventHandler<ActionEvent>() //kan het scorescherm oproepen
					{

								@Override
								public void handle(ActionEvent event) 
								{
									ScoreScherm ss = new ScoreScherm(dc);
									Scene scene2 = new Scene(ss, 400, 300);
									Stage stage2 = (Stage)(getScene().getWindow());
									stage2.setScene(scene2);
									stage2.show();
									
									
								}
						
							
							});
		
		
		
			btnOpslaan.setOnAction(new EventHandler<ActionEvent>()
					{

						@Override
						public void handle(ActionEvent event) 
						{
							dc.opslaanSpel();
							Alert opgeslagen = new Alert(Alert.AlertType.CONFIRMATION);
							opgeslagen.setHeaderText("Het spel is opgeslagen!");
							opgeslagen.showAndWait();
							
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
		
		if(spelHeeftVijfSpelers(dc))
		{
			if(cbrij5.isSelected())
			{
			stapelID = 5;
			}
		}
		
		return stapelID;
		
	

	}
	
	public void startRondeBeginSpeler(DomeinController dc)
	{
		speler.setHeaderText(dc.geefEersteSpelerAanZetWeer());
		
	}
	public void startRondeAndereSpelers(DomeinController dc)
	{
		speler.setHeaderText(dc.geefSpelerAanZetWeer());
	}
	public boolean spelHeeftVijfSpelers(DomeinController dc)
	{
		boolean heeftVijfSpelers = false;
		
		if(dc.geefAantalSpelers()==5) 
		{
			heeftVijfSpelers = true;
		}
		
		return heeftVijfSpelers;
	}
	
			

	
}

