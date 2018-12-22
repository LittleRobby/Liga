package application;

import java.io.*;
import java.util.ArrayList;

/**
 * 
 * @author Selent
 * 
 * Methoden:
 * 
 * erstelleDemo
 * - Klassenmethode
 * - erwartet keine Parameter
 * - erstellt eine Liste mit Bundesligavereinen
 * - speichert die Liste in der Datei vereinsliste.txt
 * 
 * vereineSpeichern
 * - überladene Klassenmethode
 * - Erwartet eine ArrayList von Verein als Parameter
 * - überladene Version erwartet zusätzlich noch einen Dateinamen in den gespeichert werden soll
 * - speichert den Inhalt der Liste in eine Datei
 * - hat aktuell keinen Rückgabewert
 * 
 * vereineEinlesen
 * - überladene Klassenmethode 
 * - ohne Parameter: liest Vereinsobjekte aus der Standard-Datei "vereinsliste.txt"
 * - mit Parameter Dateiname: liest Vereinsobjekte aus der übergebenen Datei
 * - gibt die eingelesenen Vereine als ArrayList zurück
 *
 */
public class VereineVerwalten {
	
	public static void erstelleDemo() {
		Verein bd = new Verein("Dortmund");
		Verein mgl = new Verein("Mönchengladbach");
		Verein bm = new Verein("München");
		Verein lzg = new Verein("Leipzig");
		Verein fr = new Verein("Frankfurt");
		Verein ber = new Verein("Berlin");
		Verein hoff = new Verein("Hoffenheim");
		Verein wb = new Verein("Bremen");
		Verein wolfsb = new Verein("Wolfsburg");
		Verein mainz = new Verein("Mainz");
		Verein lvk = new Verein("Leverkusen");
		Verein fb = new Verein("Freiburg");
		Verein s04 = new Verein("Schalke 04");
		Verein augsb = new Verein("Augsburg");
		Verein nuernb = new Verein("Nürnberg");
		Verein sttg = new Verein("Stuttgart");
		Verein hanv = new Verein("Hannover");
		Verein ddorf = new Verein("Düsseldorf");
		
		//Neue Liga erstellen
		Liga bundesliga = new Liga();
		
		//Vereine der Liga zuweisen
		bundesliga.getLiga().add(bd);
		bundesliga.getLiga().add(mgl);
		bundesliga.getLiga().add(bm);
		bundesliga.getLiga().add(lzg);
		bundesliga.getLiga().add(fr);
		bundesliga.getLiga().add(ber);
		bundesliga.getLiga().add(hoff);
		bundesliga.getLiga().add(wb);
		bundesliga.getLiga().add(wolfsb);
		bundesliga.getLiga().add(mainz);
		bundesliga.getLiga().add(lvk);
		bundesliga.getLiga().add(fb);
		bundesliga.getLiga().add(s04);
		bundesliga.getLiga().add(augsb);
		bundesliga.getLiga().add(nuernb);
		bundesliga.getLiga().add(sttg);
		bundesliga.getLiga().add(hanv);
		bundesliga.getLiga().add(ddorf);
		
		//Vereinsliste in Datei speichern
		VereineVerwalten.vereineSpeichern(bundesliga.getLiga());
	}
	
	//speichert die übergebene Vereinsliste unter dem übergebenen Namen
	public static void vereineSpeichern(ArrayList<Verein> liste, String name) {
		try {
			File file = new File(name);
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			for(Verein verein : liste) {
				oos.writeObject(verein);
			}
			oos.close();
			System.out.println("Datei " + name + " geschrieben.");
			
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	//speichert die übergebene Liste unter dem Standard-Namen "vereinsliste.txt"
	public static void vereineSpeichern(ArrayList<Verein> liste) {
		vereineSpeichern(liste, "vereinsliste.txt");		
	}
	
	
	
	//liest die Standard-Datei vereinsliste.txt
	public static ArrayList<Verein> vereineEinlesen() {
		return vereineEinlesen("vereinsliste.txt");
	}
	
	//liest die Datei mit dem übergebenen Namen
	public static ArrayList<Verein> vereineEinlesen(String name) {
		ArrayList<Verein> liste = new ArrayList<Verein>();
		System.out.println("\nLesevorgang \"Vereine einlesen\" gestartet");
		try {
			File file = new File(name);
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			Verein verein;
			for (int i = 0; i < 50;i++) {
				verein = (Verein) ois.readObject();
				liste.add(verein);
				System.out.println(i+1 +". " + verein.toString());
				
			}
			ois.close();
						
		} 
		catch (FileNotFoundException e) {
			System.out.println("Datei " + name + "nicht gefunden");
			e.printStackTrace();
		}
		catch (EOFException e) {
			System.out.println("Datei " + name + " gelesen.");
			System.out.println("Lesevorgang \"Vereine einlesen\" beendet\n");
			//e.printStackTrace();
			//e.getMessage();
		} 
		catch (Exception e) {
			System.out.println("Es ist ein unbekannter Fehler aufgetreten.");
			e.printStackTrace();
		}
		finally {
			return liste;
		}
		
		
	}
	
}
