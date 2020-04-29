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
	
	public ConfiguratieScherm(DomeinController dc)
	{
		this.dc = dc;
		BuildGui();
	}
	private void BuildGui() {
		
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(10);
		this.setPrefSize(400, 300);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		
		
		Label lblTitel = new Label("JE BENT ER BIJNA");	
		lblTitel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		lblTitel.setAlignment(Pos.TOP_CENTER);
		this.add(lblTitel, 1, 0);
		
		Label lblNaamSpel = new Label("Geef jouw spel een naam.");
		this.add(lblNaamSpel, 0, 1);
		
		TextField txfnaam = new TextField();
		txfnaam.setPromptText("naam");
		this.add(txfnaam, 1, 1);
	
		Label lblAantalSpelers = new Label("Geef aantal spelers in.");
		this.add(lblAantalSpelers, 0, 2);
		
		final ComboBox spelersComboBox = new ComboBox();
        spelersComboBox.getItems().addAll(
        		"4 spelers",
        		"5 spelers");
		this.add(spelersComboBox, 1,2);
		
		Button btnVerder = new Button("GA VERDER");
		this.add(btnVerder, 2, 4);
		
		
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
				if(spelersComboBox.getValue()=="4 spelers")
				{
					VierSpelerScherm vierss = new VierSpelerScherm(dc);
					Scene scene = new Scene(vierss, 700, 300);
					Stage stage = (Stage)(getScene().getWindow());
					stage.setScene(scene);
					stage.show();
					dc.startNieuwSpel(txfnaam.getText(), 4);
					
					
				}
				else if(spelersComboBox.getValue()=="5 spelers")
				{				
					VijfSpelerScherm vijfss = new VijfSpelerScherm(dc);
					Scene scene = new Scene(vijfss, 700, 400);
					Stage stage = (Stage)(getScene().getWindow());
					stage.setScene(scene);
					stage.show();
					dc.startNieuwSpel(txfnaam.getText(), 5);
				}
					
			}
			}
 		});
	}
 				
}

