module Projecten 
{
	exports persistentie;
	exports ui;
	exports gui;
	exports main;
	exports domein;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	
	opens gui to javafx.graphics, javafx.controls;
	opens main to javafx.graphics, javafx.controls;
	
}