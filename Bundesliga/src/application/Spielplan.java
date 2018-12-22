package application;

import java.util.ArrayList;
import java.util.Comparator;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * 
 * @author Selent
 *Enthält eine ArrayList "liste" von Vereinen, diese wird im Konstruktor als Parameter übergeben und im Konstruktor initiailisert.
 *
 *Konstruktor:
 *- erwartet eine ArrayList mit Vereinen als Parameter, weist diese dem Attribut "liste" zu.
 *- erstellt eine neue ArrayList "spiele" vom Typ Spiel
 *- ruft die Methode erstelleSpielplan auf und übergibt die Vereinsliste als Parameter
 *
 *Methoden: 
 *erstelleSpielplan:
 *- erwartet eine ArrayListe von Vereinen als Parameter
 *- erstellt in zwei verschachtelten for-Schleifen Spielpaarungen und speichert jede Paarung in einem neuen Spiel-Objekt
 *- fügt die erstellten Spiel-Objekte der ArrayList "spiele" hinzu
 *
 *Getter und Setter
 *
 */

public class Spielplan {
	private ArrayList<Verein> liste;
	private ArrayList<Spiel> spiele;
	
	public Spielplan(ArrayList<Verein> liste) {
		this.liste = liste;
		this.spiele = new ArrayList<Spiel>();
		erstelleSpielplan(this.liste);
	}
	
	public void erstelleSpielplan(ArrayList<Verein> liste) {
		for (int i = 0; i < liste.size()-1; i++) {
			for (int j = i + 1; j < liste.size(); j++) {
				Spiel s = new Spiel(liste.get(i), liste.get(j));
				spiele.add(s);
				if(Bundesliga.LOGMODE) {
					System.out.println("Paarung: " + liste.get(i).getVereinsname() + " gegen " + liste.get(j).getVereinsname() 
							+ " Spielnummer: " + s.getSpielnummer());
				}
				
			}
			
		}
		
	}
	

	public ArrayList<Verein> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Verein> liste) {
		this.liste = liste;
	}

	public ArrayList<Spiel> getSpiele() {
		return spiele;
	}

	public void setSpiele(ArrayList<Spiel> spiele) {
		this.spiele = spiele;
	}
	

}
