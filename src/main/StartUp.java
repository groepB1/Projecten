package main;

import domein.DomeinController;
import gui.ColorettoApplicatie;

public class StartUp {

	public static void main(String[] args) 
	{
		DomeinController dc = new DomeinController();
		new ColorettoApplicatie(dc);

	}

}
