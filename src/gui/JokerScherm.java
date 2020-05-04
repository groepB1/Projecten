package gui;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JokerScherm extends VBox
{
	private DomeinController dc;
	private Label lblTitel;
	private Label lblKleur;
	private ComboBox<String> cbKleur;
	private int kleurGetal;
	private Button btnOk;
	private Button btnTerug;
	private TextArea txaSpelerMetJoker;
	private int teller;
	private int teller2;
	
	public JokerScherm(DomeinController dc)
	{
		this.dc = dc;
		buildGui();
		
	}
	
	public void buildGui()
	{
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, null, null)));				/*public void jokerInstellen(DomeinController dc, int aantalSpelers)
																												{
																													for (int teller = 0 ; teller <=aantalSpelers-1; teller++)																									{
																														System.out.println(dc.geefSpelerMetJokerWeer(teller));
																													
																														for (int teller2 = 0; teller2< dc.geefAantalJokers(teller); teller2++)
																														{
																															System.out.println("In welke kleur wil je de joker veranderen? Geef 1 in voor oranje. 
																															Geef 2 in voor blauw. Geef 3 in voor rood. 
																															Geef 4 in voor geel. Geef 5 in voor grijs. 
																															Geef 6 in voor groen. Geef 7 in voor roos.");
																															int kleurGetal = invoer.nextInt();
																															dc.veranderKleur(kleurGetal, teller);
																												}
																													}
																													
																													}
																												}*/
		
		//titel van het scherm
		lblTitel = new Label("SPELERS MET EEN JOKER");
		txaSpelerMetJoker = new TextArea();
		lblKleur = new Label("Kies de kleur van je joker");
		//combobox waaruit je de kleur kan kiezen die je wil
		cbKleur = new ComboBox<String>();
		cbKleur.getItems().addAll("blauw","geel","grijs","oranje", "groen", "rood", "roos");
		btnOk = new Button("OK");
			
		
		for(teller = 0; teller <= dc.geefAantalSpelers()-1; teller++ )
		{
		
		//tekstvak met spelers die een joker bezitten
			txaSpelerMetJoker.setText(dc.geefSpelerMetJokerWeer(teller));
			
		for(teller2 = 0; teller2<dc.geefAantalJokers(teller); teller2++)
		{
			
		
		
			//button om je kleur te bevestigen
		btnOk.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) 
					{
						dc.veranderKleur(kleurGetal, teller);
						
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("Bevestiging");
						alert.setHeaderText("Deze kleur wordt toegevoegd!");
						alert.showAndWait();
						
						
					}
			
				});
			}
		}
					
			
		
		
		btnTerug = new Button("Terug");
		btnTerug.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) 
					{
						if(dc.geefAantalSpelers()==4)
						{
						SpeelScherm spel = new SpeelScherm(dc);
						
						Scene scene = new Scene(spel, 1200, 600);
						Stage stage = (Stage)(getScene().getWindow());
						stage.setScene(scene);
						stage.show();
						}
						else if(dc.geefAantalSpelers()==5)
						{
							SpeelScherm5 spel = new SpeelScherm5(dc);
							
							Scene scene = new Scene(spel, 1200, 600);
							Stage stage = (Stage)(getScene().getWindow());
							stage.setScene(scene);
							stage.show();	
						}
						
						
						
					}
			
				});
		
		this.getChildren().addAll(lblTitel, txaSpelerMetJoker,lblKleur, cbKleur, btnOk, btnTerug);
		
	}
	
	public int kiesKleur()
	{
		if(cbKleur.getValue().equals("blauw"))
		{
			kleurGetal = 2 ;
		}
		else if(cbKleur.getValue().equals("geel"))
		{
			kleurGetal = 4 ;
		}
		else if(cbKleur.getValue().equals("grijs"))
		{
			kleurGetal = 5;
		}
		else if(cbKleur.getValue().equals("oranje"))
		{
			kleurGetal = 1 ;
		}
		else if(cbKleur.getValue().equals("groen"))
		{
			kleurGetal = 6;
		}
		else if(cbKleur.getValue().equals("rood"))
		{
			kleurGetal = 3;
		}
		else if(cbKleur.getValue().equals("roos"))
		{
			kleurGetal = 7;
		}
		
		return kleurGetal;
	}
	
	

}

