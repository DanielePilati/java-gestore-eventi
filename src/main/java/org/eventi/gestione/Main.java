package org.eventi.gestione;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Evento event;
		String eventName;
		int eventTickets;
		Date eventDate;
		int userBookNum;
			
		System.out.println("--| Benvenuto nella creazione dell'Evento");
		System.out.println("-| Prima di tutto inseriamo la data");
		while (true) {
			eventDate = Main.addInputDate();
			if (eventDate.before(Calendar.getInstance().getTime())) {
				System.out.println("Data Passata");	
			} else {
				break;
			}
		}
		
		eventName = Main.requestString("-| Inserisci ora il titolo dell'Evento: ");		
		eventTickets = Main.requestNumberInt("-| Numero di Prenotazioni Disponibili : ");
		event = new Evento(eventName, eventDate, eventTickets);
		System.out.println("--| Il tuo evento è stato Istanziato");
		
																											// chiede all’utente se e quante prenotazioni vuole fare e provare ad effettuarle			
		if (Main.wantDoIt("Vuoi effettuare una o piu prenotazioni? S / N")) {										
			userBookNum = Main.requestNumberInt("Inserisci il numero di prenotazioni che vuoi effettuare");
			event.prenota(userBookNum);
			event.checkPosti();
		}
			
																											// Chiedere all’utente se e quanti posti vuole disdire e provare ad effettuarle	
		if (Main.wantDoIt("Vuoi disdire una o piu prenotazioni? S / N")) {											
			userBookNum = Main.requestNumberInt("Inserisci il numero di prenotazioni che vuoi disdire");
			event.disdici(userBookNum);
			event.checkPosti();
		}	
	}
																											// chiede all’utente di inserire una Data con tutti i parametri.
	public static Date addInputDate() {																		
;
		Calendar date = Calendar.getInstance();

		int eventDay = Main.requestNumberInt("-| Si terrà il Giorno (in numeri) : ");
		int eventMonth = Main.requestNumberInt("-| Del Mese (in numeri) : ");
		int eventYear = Main.requestNumberInt("-| Nell'Anno (in numeri) : ");
		int eventHour = Main.requestNumberInt("-| Alle Ore (in numeri) : ");
		int eventMinutes = Main.requestNumberInt("-| E Minuti (in numeri) : ");
		date.set(eventYear, eventMonth, eventDay, eventHour, eventMinutes);
		
		return date.getTime();
	}
																														// invia su terminale una richiesta e restituisce il valore preso in input.
	public static int requestNumberInt(String request) {													
		System.out.println(request);
		int number = scanner.nextInt();
		scanner.nextLine();
		return number;
	}
	public static String requestString(String request) {		
		System.out.println(request);
		String string = scanner.nextLine();
		return string;
	}
																														// chiede all'utente se vuole effettuare una prenotazione o no.
	public static boolean wantDoIt(String request) {
		boolean want = false;
	
		String renspose = Main.requestString(request).toUpperCase();
		while (true) {
			if (renspose.equals("S")) {
				want = true;
				break;
			} 
			if (renspose.equals("N")) {
				System.out.println("hai inserito N");
				System.out.println("Chiusura applicazione");
				want = false ;
				break;
			} else {
				Main.requestString("inserisci S o N").toUpperCase();
			}
		}
	
		return want;
	}
	
}
