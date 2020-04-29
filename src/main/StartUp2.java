package main;
	
import domein.DomeinController;
import gui.StartScherm;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class StartUp2 extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		DomeinController dc = new DomeinController();
		
		StartScherm root = new StartScherm(dc);
	
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setTitle("Coloretto");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
