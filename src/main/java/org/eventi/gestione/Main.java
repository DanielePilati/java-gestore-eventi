package org.eventi.gestione;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Evento event;
		String eventName;
		int eventTickets;
		LocalDate eventDate;
		int userBookNum;
																											// chiedere all’utente di inserire una Data con tutti i parametri.
		System.out.println("--| Benvenuto nella creazione dell'Evento");
		System.out.println("-| Prima di tutto inseriamo la data");
		while (true) {
			eventDate = Main.addInputDate();
			if (eventDate.isBefore(LocalDate.now())) {
				System.out.println("-| Data Passata |-");	
			} else {
				break;
			}
		}
	
		eventName = Main.requestString("-| Inserisci ora il titolo dell'Evento: ");		
		eventTickets = Main.requestNumberInt("-| Numero di Prenotazioni Disponibili : ");
		
		event = new Evento(eventName, eventDate, eventTickets);
		System.out.println("--| Il tuo evento è stato Istanziato");	
		System.out.println(event.toString());
																											// chiede all’utente se e quante prenotazioni vuole fare e provare ad effettuarle			
		while (Main.wantDoIt("--| Vuoi effettuare una o piu prenotazioni? S / N")) {										
			userBookNum = Main.requestNumberInt("-| Inserisci il numero di prenotazioni che vuoi effettuare: ");
			event.prenota(userBookNum);
			event.checkPosti();
		}			
																											// Chiedere all’utente se e quanti posti vuole disdire e provare ad effettuarle	
		while (Main.wantDoIt("--| Vuoi disdire una o piu prenotazioni? S / N")) {											
			userBookNum = Main.requestNumberInt("-| Inserisci il numero di prenotazioni che vuoi disdire: ");
			event.disdici(userBookNum);
			event.checkPosti();
		}

/*																											// test classe Concerto
		Concerto concerto = new Concerto("Concertazzo", addInputDate(), 10, addInputTime(), 20.50 );	
		System.out.println(concerto.toString());
				System.out.println(event.compareTo(event));
																											// test classe ProgrammaEventi
		ProgrammaEventi programma = new ProgrammaEventi("Lancio del Corriandolo");
		System.out.println(programma.toString());
		programma.addEvent(event);
		programma.addEvent(concerto);
		programma.searchEventFromDate(eventDate);
		System.out.println("ci sono " + programma.howManyEvents() + " Eventi");
		System.out.println(programma.toString());
		programma.resetEventList();
		System.out.println(programma.toString());
*/	
	}
																											// chiede all’utente di inserire una Data con tutti i parametri.
	public static LocalDate addInputDate() {	
			
		int eventDay = 0;
		int eventMonth = 0;
		int eventYear = 0;
		
		boolean isOk = false;
																											// verifico se viene messo un giorno corretto 
		while(!isOk) {
			eventDay = Main.requestNumberInt("-| Si terrà il Giorno (in numeri) : ");
			if (eventDay > 0 && eventDay <= 31) {
				isOk = true;
				break;
			} else {
				System.out.println("-| Inserisci un Numero da 1 a 31 |-");
				isOk = false;
			}
		}
		isOk = false;
																											// verifico se viene messo il mese corretto 
		while(!isOk) {
			eventMonth = Main.requestNumberInt("-| Del Mese (in numeri) : ");
			if (eventMonth > 0 && eventMonth <= 12) {
				isOk = true;
				break;
			} else {
				System.out.println("-| Inserisci un Numero da 1 a 12 |-");
				isOk = false;
			}
		}
		isOk = false;	
																											// verifico se viene messo un anno reale 
		while(!isOk) {
			eventYear = Main.requestNumberInt("-| Nell'Anno (in numeri) : ");
			if (eventYear > 1900 && eventYear <= 3000) {
				isOk = true;
				break;
			} else {
				System.out.println("-| Inserisci un Anno Reale|-");
				isOk = false;
			}
		}
		isOk = false;
	
		LocalDate date = LocalDate.of(eventYear, eventMonth, eventDay);
		
		return date;
	}
																											// chiede all’utente di inserire l'ora con tutti i parametri.
	public static LocalTime addInputTime() {
		int eventHour = Main.requestNumberInt("-| Inserisci Ora (in numeri) : ");
		int eventMinutes = Main.requestNumberInt("-| E Minuti (in numeri) : ");
		LocalTime time = LocalTime.of(eventHour, eventMinutes);
		
		return time;
	}
																											// invia su terminale una richiesta e restituisce il valore intero preso in input.
	public static int requestNumberInt(String request) {
		
		int number = 0;
		while (number == 0){
			System.out.println(request);
			try {
				number =  scanner.nextInt();
			} catch (Exception InputMismatchException) {
				System.out.println("-| Inserisci un numero |-");
			} finally {
				scanner.nextLine();
			}				
		}	
		return number;
	}
																											// invia su terminale una richiesta e restituisce il valore Stringa preso in input.
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
				want = false ;
				break;
			} else {
				renspose = Main.requestString("-| inserisci S o N |-").toUpperCase();
			}
		}
		return want;  
	}
	
}
