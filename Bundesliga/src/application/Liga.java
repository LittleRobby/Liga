package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Selent
 * Eine Liga enthält eine ArrayList von Vereinen.
 * Es wird aktuell der Standardkonstruktor verwendet.
 * Methoden:
 * Getter und Setter für die ArrayList
 */

public class Liga {

	private ArrayList<Verein> liga = new ArrayList<Verein>();
	
	public void sortiereTabelle(ArrayList<Verein> liga) {
		Collections.sort(liga);
	}
	
	
	public String zeigeTabelle() {
		int counter = 1;
		sortiereTabelle(this.liga);
		String tabelle = "";
		for(Verein verein : liga) {
			System.out.println(counter + ". " + verein.toString());
			counter++;
		}
		return tabelle;
	}
		
	public ArrayList<Verein> getLiga() {
		return this.liga;
	}
	
	public void setLiga(ArrayList<Verein> liga) {
		this.liga = liga;
	}

	
}
