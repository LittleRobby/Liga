package application;


import java.util.ArrayList;
import java.util.Collections;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;


public class Bundesliga {
	public static final boolean LOGMODE = false;

	public static void main(String[] args) {
		
		// Zum Bundesliga-Vereine neu anlegen auf true setzen
		if(false) {
		VereineVerwalten.erstelleDemo();
		}
		
		//leere Testliga anlegen
		Liga testliga = new Liga();
		
		//Vereine aus Datei in leere Liga einlesen
		testliga.setLiga(VereineVerwalten.vereineEinlesen());
		
		//Neues Spielplanobjekt anlegen und Liga als Parameter übergeben
		Spielplan bLigaPlan = new Spielplan(testliga.getLiga());
		
		//Spielpaarungen nach Zufallswert sortieren
		Collections.sort(bLigaPlan.getSpiele());
		
		//Ausgabe aller Elemente des Spielplans in einer for each-Schleife
		for (Spiel spiel : bLigaPlan.getSpiele()) {
			System.out.println(spiel.getM1().getVereinsname() + " gegen " + spiel.getM2().getVereinsname());		
		}
		
		System.out.println("\n----------------------------------------------------------------\n");

		System.out.println("Ausgabe Tabelle");
		System.out.println("Platz \tName \t\t\tPunkte Tore Gegentore Tordifferenz");
		for (Spiel spiel : bLigaPlan.getSpiele()) {
			spiel.addResult(spiel, spiel.random.nextInt(5), spiel.random.nextInt(5));
		}
		
		testliga.zeigeTabelle();
		
		VereineVerwalten.vereineSpeichern(testliga.getLiga(), "ergebnisliste.txt");
		
		VereineVerwalten.vereineEinlesen("ergebnisliste.txt");
		
		
		
		
	
	



	}

}
