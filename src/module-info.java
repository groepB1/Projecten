module Projecten {
	exports persistentie;
	exports ui;
	exports gui;
	exports main;
	exports domein;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	
	opens main to javafx.graphics, javafx.controls;
	
}