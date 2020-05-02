module Projecten
{
	exports persistentie;
	exports ui;
	exports gui;
	exports main;
	exports domein;
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	requires java.sql;
	
	opens main to javafx.controls, javafx.graphics;
	
}