package org.eventi.gestione;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Evento implements Comparable<Evento> {
	
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;  															// tranne posti prenotati che va inizializzato a 0.	
							
	public Evento(String titolo, LocalDate data, int postiTotali) {								//Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore
		
		this.titolo = titolo;;
				
		if (!data.equals(LocalDate.now())) {  													// Inserire il controllo che la data non sia già passata
			this.data = data;		
		} else {
			System.out.println("la data è passata");
		}
		if(postiTotali > 0) { 																	// Controllo che il numero di posti totali sia positivo.
			this.postiTotali = postiTotali;
		} else {																				// In caso contrario mostrare i dovuti avvisi all’utente
			System.out.println("Inserisci un numero di posti totali maggiore di 0"); 	
		}
	}
																								// titolo sia in lettura e in scrittura
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
																								// data sia in lettura e scrittura
	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
																								//	numero di posti totale sia solo in lettura
	public int getPostiTotali() {
		return postiTotali;
	}
																								// numero di posti prenotati sia solo in lettura
	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}
																								// aggiunge un posto prenotato
	public void prenota(LocalDate data) { 
		
		if (data.isBefore(LocalDate.now())) {	
			System.out.println("L'evento è gia passato");										// Se l’evento è già passato deve restituire un messaggio di avviso
		} else {
			if (this.postiPrenotati < this.postiTotali) {		
				this.postiPrenotati++;
				System.out.println("Posto Prenotato");											// aggiunge uno ai posti prenotati.
			} else {
				System.out.println("Posti Non Disponibili");									//  non ha posti disponibili deve restituire un messaggio di avviso
			}
		}	
	}
																								// faccio un overload del metodo prendendo in input il numero di prenotazioni da effettuare sul test nel main
	public void prenota(int number) {
		
		int postiLiberi = this.postiTotali - this.postiPrenotati;
		
		if (postiLiberi >= number) {
			this.postiPrenotati += number;
			System.out.println("Posti Prenotato");
		} else {
			System.out.println("non ci sono posti disponibili");
			}																						
	}
																								// metodo per Stampare a video il numero di posti prenotati e quelli disponibili
	public void checkPosti() {
		
		System.out.println("Posti Totali: " + this.postiTotali);
		System.out.println("Posti Prenotati: " + this.postiPrenotati);
		System.out.println("Posti Disponibili: " + (this.postiTotali - this.postiPrenotati));
	}
																								// rimuove un posto prenotato
	public void disdici(Date data) {  
		
		if (data.before(Calendar.getInstance().getTime())) {	
			System.out.println("-| L'evento è gia passato");										// Se l’evento è già passato deve restituire un messaggio di avviso
		} else {
			if (this.postiPrenotati > 0 ) {		
				this.postiPrenotati++;
				System.out.println("Prenotazione Disdetta");									// riduce di uno i posti prenotati.
			} else {
				System.out.println("Non ci sono prenotazioni");									//  non ci sono prenotazioni restituisce un messaggio di avviso.
			}
		}	
	}
																								// faccio un overload del metodo prendendo in input il numero di prenotazioni da disdire sul test nel main
	public void disdici(int number) {
		
		if (this.postiPrenotati >= number) {
			this.postiPrenotati -= number;
			System.out.println("Posti Disdetti");
		} else {
			System.out.println("Ci sono solo " + this.postiPrenotati + " posti prenotati");
		}																						
	}

	@Override   																				// l’override del metodo toString() 
	public String toString() { 
		return this.dateFormatter(this.data) + " - "+ this.titolo;   							// in modo che venga restituita una stringa contenente: data formattata - titolo
	}
																								// aggiunto metodo per formattare la data
	public String dateFormatter (LocalDate date) {								
		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	@Override																					// override del metodo dell'interfaccia Comparable<Evento>
	public int compareTo(Evento otherEvent) {	
		
		if(this.equals(otherEvent)) {
			return 1;
		} else {
			return 0;
		}
	}

}
