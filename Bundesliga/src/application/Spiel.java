package application;

import java.util.Random;

/**
 * 
 * @author Selent
 *Klasse implementiert das Interface Comparable für Objekte der Klasse Spiel um zwei 
 *Spielobjekte miteinander vergleichen zu können.
 *
 *Attribute: 
 *- Konstanten GEWONNEN und UNENTSCHIEDEN, die jeweils die Anzahl der Punkte für das Spielergebnis enthält.
 *- Random random als Zufallsgenerator
 *- Vereinsobjekte m1 und m2
 *- int spielnummer in dem der Zufallswert für die Spielpaarung gespeichert wird um den 
 *  Spielplan danach sortieren zu können.
 *- int e1 und e2 um die Ergebnisse eines Spieles erfassen zu können.
 *
 * Konstruktor: 
 * - erwartet zwei Vereinsobjekte als Parameter. 
 * - erstellt eine zufällige Zahl zwischen 0 und 1000 die als Sortierkriterium für den Spielplan verwendet wird
 * 
 * Methoden: 
 * compareTo
 * - erwartet ein Spiel-Objekt als Parameter. Vergleicht die Zufallswerte beider Spielpaarumen um danach 
 *   die ArrayListe mit den Spielpaarungen sortieren zu können.
 *   
 *   Getter und Setter
 *
 */

public class Spiel implements Comparable<Spiel> {
	private static final int GEWONNEN = 3;
	private static final int UNENTSCHIEDEN = 1;
	
	Random random = new Random();
	private Verein m1; 
	private Verein m2;
	private int spielnummer;
	private int e1; 
	private int e2;
	private boolean ergebnisEingetragen;
	
	
	public Spiel (Verein m1, Verein m2) {
		this.m1 = m1; 
		this.m2 = m2;
		this.spielnummer = random.nextInt(1000);
	}
	
	@Override
	public int compareTo(Spiel s) {
		if (this.spielnummer < s.spielnummer) {
			return -1;
		} else {
			return 1;
		} 
		
	}
	
	public static void addResult(Spiel spiel, int ergebnis1, int ergebnis2) {
		//Spielergebnis zuweisen
		spiel.setE1(ergebnis1);
		spiel.setE2(ergebnis2);
		
		//Tore und Gegentore für Mannschaft 1 zuweisen
		spiel.getM1().setTore(spiel.getM1().getTore() + ergebnis1);
		spiel.getM1().setGegentore(spiel.getM1().getGegentore() + ergebnis2);
		
		//Tore und Gegentore für Mannschaft 2 zuweisen
		spiel.getM2().setTore(spiel.getM2().getTore() + ergebnis2);
		spiel.getM2().setGegentore(spiel.getM2().getGegentore() + ergebnis1);
		
		//Punkte verteilen
		if(ergebnis1 > ergebnis2) {
			spiel.getM1().setPunktestand(spiel.getM1().getPunktestand() + GEWONNEN);
		} else if (ergebnis1 < ergebnis2) {
			spiel.getM2().setPunktestand(spiel.getM2().getPunktestand() + GEWONNEN);
		} else if (ergebnis1 == ergebnis2) {
			spiel.getM1().setPunktestand(spiel.getM1().getPunktestand() + UNENTSCHIEDEN);
			spiel.getM2().setPunktestand(spiel.getM2().getPunktestand() + UNENTSCHIEDEN);
		}
		
		//Tordifferenz berechnen und setzen
		spiel.getM1().setTordifferenz();
		spiel.getM2().setTordifferenz();
		
		//Eintragen, dass das Spiel gewertet wurde
		spiel.ergebnisEingetragen = true;
		
		//Ausgabe Spielergebniss
		if(Bundesliga.LOGMODE) {
			System.out.println(spiel.getM1().getVereinsname() + " spielt gegen " + spiel.getM2().getVereinsname() + 
				" " + spiel.getE1() + ":" + spiel.getE2());
		System.out.println(spiel.getM1().getVereinsname() + " hat " + spiel.getM1().getPunktestand() + " Punkte.");
		System.out.println(spiel.getM2().getVereinsname() + " hat " + spiel.getM2().getPunktestand() + " Punkte.");
		}
		
	}
	
	
	//Getter und Setter
	public Verein getM1() {
		return m1;
	}

	public void setM1(Verein m1) {
		this.m1 = m1;
	}

	public Verein getM2() {
		return m2;
	}

	public void setM2(Verein m2) {
		this.m2 = m2;
	}

	public int getSpielnummer() {
		return spielnummer;
	}

	public void setSpielnummer(int spielnummer) {
		this.spielnummer = spielnummer;
	}

	public int getE1() {
		return e1;
	}

	public void setE1(int e1) {
		this.e1 = e1;
	}

	public int getE2() {
		return e2;
	}

	public void setE2(int e2) {
		this.e2 = e2;
	}

}
