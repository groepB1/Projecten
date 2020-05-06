package gui;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
					/*public void jokerInstellen(DomeinController dc, int aantalSpelers)
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
		
																													
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN, null, null)));	
		
		lblTitel = new Label("JOKER INSTELLEN");
		lblTitel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		
		txaSpelerMetJoker = new TextArea();
		
		lblKleur = new Label("Stel de kleur in van jouw joker");
		
		cbKleur = new ComboBox();
		cbKleur.getItems().addAll("blauw","geel", "grijs","groen", "oranje","rood", "roos");
		
		btnOk = new Button("Bevestig kleur");
	
		
		for(teller = 0; teller <= dc.geefAantalSpelers()-1; teller++)
		{
			txaSpelerMetJoker.setText(dc.geefSpelerMetJokerWeer(teller));
			
			for(teller2 = 0; teller2< dc.geefAantalJokers(teller); teller2++)
			{
				if(btnOk.isArmed())
				{
				dc.veranderKleur(kiesKleur(), teller);
				}
			}
		}
		btnOk.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText("Bevestig je kleur.");
				alert.showAndWait();
				
			}
			
			
		});
		btnTerug = new Button("Terug");
		btnTerug.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent arg0) 
					{
						SpeelScherm spel = new SpeelScherm(dc);
						Scene scene = new Scene(spel, 1400, 600);
						Stage stage = (Stage)(getScene().getWindow());
						stage.setScene(scene);
						stage.show();
						
					}
			
				});
		
		this.getChildren().addAll(lblTitel, txaSpelerMetJoker, lblKleur, cbKleur, btnOk, btnTerug);
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

