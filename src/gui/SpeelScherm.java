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
	private DomeinController dc;;
	private ImageView getrokkenKaart;
	private Label lblgetrokkenKaart;
	private ImageView kaart;
	private CheckBox cbrij1;
	private CheckBox cbrij2;
	private CheckBox cbrij3;
	private CheckBox cbrij4;
	private TextArea txaSpelerAanZet;
	private ImageView blauw;
	private ImageView geel;
	private ImageView grijs;
	private ImageView groen;
	private ImageView joker;
	private ImageView oranje;
	private ImageView plus2;
	private ImageView rood;
	private ImageView roos;
	
	public SpeelScherm(DomeinController dc)
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
		lblTitel.setFont(Font.font("verdana", FontWeight.BOLD,30));
		this.add(lblTitel, 2, 1);
		
		
		
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
		
		System.out.println(dc.geefEersteSpelerAanZetWeer());
		TextArea txaSpelerAanZet = new TextArea(dc.geefEersteSpelerAanZetWeer());
		this.add(txaSpelerAanZet, 3, 1);

	
		Label lblgk = new Label("De getrokken kaart is: ");
		this.add(lblgk, 2, 3);
		Label lblgetrokkenKaart = new Label(dc.geefGetrokkenKaartWeer());
		this.add(lblgetrokkenKaart, 3, 3);
		
		ImageView kaart = new ImageView();
		kaart.setFitHeight(100);
		kaart.setFitWidth(70);
		this.add(kaart, 4, 3);
		kaart.setVisible(false);
		
		Image blauw = new  Image(getClass().getResourceAsStream("/images/blauw.jpg"));
		Image geel = new  Image(getClass().getResourceAsStream("/images/geel.jpg"));
		Image grijs = new  Image(getClass().getResourceAsStream("/images/grijs.jpg"));
		Image groen = new  Image(getClass().getResourceAsStream("/images/groen.jpg"));
		Image joker = new  Image(getClass().getResourceAsStream("/images/joker.png"));
		Image oranje = new  Image(getClass().getResourceAsStream("/images/oranje.jpg"));
		Image plus2 = new  Image(getClass().getResourceAsStream("/images/plus 2.png"));
		Image rood = new  Image(getClass().getResourceAsStream("/images/rood.png"));
		Image Roos = new  Image(getClass().getResourceAsStream("/images/Roos.png"));
		
		if(lblgetrokkenKaart.getText().contentEquals("blauw"))
		{
			kaart.setImage(blauw);
			kaart.setVisible(true);
		}

		else if(lblgetrokkenKaart.getText().contentEquals("geel"))
		{
			kaart.setImage(geel);
			kaart.setVisible(true);
		}

		else if(lblgetrokkenKaart.getText().contentEquals("grijs"))
		{
			kaart.setImage(grijs);
			kaart.setVisible(true);
		}

		else if(lblgetrokkenKaart.getText().contentEquals("groen"))
		{
			kaart.setImage(groen);
			kaart.setVisible(true);
		}

		else if(lblgetrokkenKaart.getText().contentEquals("joker"))
		{
			kaart.setImage(joker);
			kaart.setVisible(true);
		}

		else if(lblgetrokkenKaart.getText().contentEquals("oranje"))
		{
			kaart.setImage(oranje);
			kaart.setVisible(true);
		}

		else if(lblgetrokkenKaart.getText().contentEquals("plus 2"))
		{
			kaart.setImage(plus2);
			kaart.setVisible(true);
		}

		else if(lblgetrokkenKaart.getText().contentEquals("rood"))
		{
			kaart.setImage(rood);
			kaart.setVisible(true);
		}

		else if(lblgetrokkenKaart.getText().contentEquals("roos"))
		{
			kaart.setImage(Roos);
			kaart.setVisible(true);
		}
		
		
	
	
		cbrij1 = new CheckBox("Eerste stapel");
		this.add(cbrij1, 3, 4);
		cbrij2 = new CheckBox("Tweede stapel");
		this.add(cbrij2, 4, 4);
		cbrij3 = new CheckBox("Derde stapel");
		this.add(cbrij3, 5, 4);
		cbrij4 = new CheckBox("Vierde stapel");
		this.add(cbrij4, 6, 4);
		
		Button btnLegOp = new Button("Leg op een stapel");
		this.add(btnLegOp, 3, 5);
		btnLegOp.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) 
					{
						int stapelID = keuzeRij();
						
						dc.voegKaartAanStapelToe(stapelID);
						
						lblgetrokkenKaart.setText(dc.geefGetrokkenKaartWeer());
						
						
						cbrij1.setSelected(false);
						cbrij2.setSelected(false);
						cbrij3.setSelected(false);
						cbrij4.setSelected(false);
						
						StapelScherm sts = new StapelScherm(dc);
						Scene scene = new Scene(sts, 400, 300);
						Stage stage = new Stage();
						stage.setScene(scene);
						stage.show();
					}
			
				});
		
		Button btnNeemStapel = new Button("Kies een stapel en neem ze");
		this.add(btnNeemStapel, 6, 5);
		btnNeemStapel.setOnAction(new EventHandler<ActionEvent>() 
				{

					@Override
					public void handle(ActionEvent event) 
					{
						
						int stapelID = keuzeRij();
						
						
						lblgetrokkenKaart.setText(dc.geefGetrokkenKaartWeer());
						
						cbrij1.setSelected(false);
						cbrij2.setSelected(false);
						cbrij3.setSelected(false);
						cbrij4.setSelected(false);
						
						dc.neemStapelRij(stapelID);
						StapelScherm sts = new StapelScherm(dc);
						Scene scene = new Scene(sts, 400, 300);
						Stage stage = new Stage();
						stage.setScene(scene);
						stage.show();
						
					}
			
				}
				);
		
		
	
		
			
			
		
		
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
		
		return stapelID;
		
	}
	





	
}
