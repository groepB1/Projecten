package main;

import domein.DomeinController;
import ui.ColorettoApplicatie;

public class StartUp {

	public static void main(String[] args) 
	{
		DomeinController dc = new DomeinController();
		new ColorettoApplicatie(dc);

	}

}
