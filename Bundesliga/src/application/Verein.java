package application;

import java.io.*;

/**
 * 
 * @author Selent
 *
 *Ein Verein hat einen Namen, einen Punktestand, Tore, Gegentore und eine Tordifferenz. 
 *Im Konstruktor werden Punktestand und Tordifferenz mit 0 initialisiert.
 *Methoden:
 *toString gibt aktuelle nur den Namen des Vereins zurück
 *Getter und Setter für Name, Punktestand und Tordifferenz
 *
 *
 */

public class Verein implements Serializable, Comparable<Verein> {

	private String vereinsname;
	private int punktestand;
	private int tore;
	private int gegentore;
	private int tordifferenz;
	
	

	public Verein(String name) {
		this.vereinsname = name;
		this.punktestand = 0;
		this.tore = 0; 
		this.gegentore = 0;
		this.tordifferenz = 0;
	}
	
	public String toString () {
		
		return String.format("\t "
				+ "%-20s" + "\t " + 
		this.punktestand + "\t " + 
		this.tore + "\t " + 
		this. gegentore + "\t " + 
		"%4d", 
		this.vereinsname, this.tordifferenz);
	}
	
	@Override
	public int compareTo(Verein v) {
		if(this.punktestand < v.punktestand) {
			return 1;
		} else if(this.punktestand > v.punktestand) {
			return -1;
		} else if(this.punktestand == v.punktestand) {
			if(this.tordifferenz < v.tordifferenz) {
				return 1;
			} else if(this.tordifferenz > v.tordifferenz) {
				return -1;
			} else if(this.tordifferenz == v.tordifferenz) {
				return 0;
			}
		}
		return 0;
	}
	
	
	//Getter und Setter;
	
	public Verein getVerein() {
		return this;
	}

	public String getVereinsname() {
		return vereinsname;
	}

	public void setVereinsname(String vereinsname) {
		this.vereinsname = vereinsname;
	}

	public int getPunktestand() {
		return punktestand;
	}

	public void setPunktestand(int punktestand) {
		this.punktestand = punktestand;
	}

	public int getTore() {
		return tore;
	}

	public void setTore(int tore) {
		this.tore = tore;
	}

	public int getGegentore() {
		return gegentore;
	}

	public void setGegentore(int gegentore) {
		this.gegentore = gegentore;
	}

	public int getTordifferenz() {
		return tordifferenz;
	}

	public void setTordifferenz() {
		this.tordifferenz = this.tore - this.gegentore;
	}

	
}
