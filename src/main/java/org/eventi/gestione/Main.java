package org.eventi.gestione;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);		
																							// creo due metodi statici che chiedono cosa scrivere all'utente 
	public static int inserisciIntero(String spiegazione) {									
		System.out.println(spiegazione);
		return scanner.nextInt();
	}

	public static void main(String[] args) {
	
		Calendar dataEvento = Calendar.getInstance();
																							// chiedere all’utente di inserire un nuovo evento con tutti i parametri.
		System.out.println("inserisci nome dell'evento");
		String nomeEvento = scanner.nextLine();
		System.out.println("Inseriamo la data e l'ora dell'evento");						
		dataEvento.set(	Main.inserisciIntero("inserisci anno"),
						Main.inserisciIntero("inserisci mese"),
						Main.inserisciIntero("inserisci giorno"),
						Main.inserisciIntero("inserisci ora"),
						Main.inserisciIntero("inserisci minuti")
						);		
		Evento evento = new Evento(	nomeEvento,
									dataEvento.getTime(),
									Main.inserisciIntero("inserisci il numero di posti")
									);
		scanner.close();
		System.out.println(evento.toString());
		
																						// chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, 
		System.out.println("Vuoi fare prenotazioni? S/N");
		String rispostaUtente = scanner.nextLine().toUpperCase();
		if (!rispostaUtente.equals("S")) {
			System.out.println("Hai deciso di non eseguire una o piu prenotazioni");
		} else {
			int numeroPrenotazioni = inserisciIntero("Quanti posti vuoi prenotare?");
			System.out.println("inserisci la data");
			dataEvento.set(	Main.inserisciIntero("inserisci anno"),
							Main.inserisciIntero("inserisci mese"),
							Main.inserisciIntero("inserisci giorno")
							);
			evento.prenota(numeroPrenotazioni);
		}

		
	// 	implementando opportuni controlli
		
		
	
	/*	event.prenota(calendario.getTime());
		event.disdici(calendario.getTime());
		System.out.println(event.toString());
		
	
	/*	calendario.set(2035, 12, 24, 23, 45);
		Concerto c = new Concerto("Giochi senza Frontiere", calendario.getTime(), 10, Time.valueOf(LocalTime.now()), 25.50);
		System.out.println(c.toString());
		
/*		1.Creare una classe Main di test, in cui si 
		 
		3.Stampare a video il numero di posti prenotati e quelli disponibili
		4.Chiedere all’utente se e quanti posti vuole disdire
		5.Provare ad effettuare le disdette, implementando opportuni controlli
		6.Stampare a video il numero di posti prenotati e quelli disponibili
*/
		
	}

}
