package org.eventi.gestione;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Evento {

	private String titolo;
	private Calendar data;
	private int postiTotali;
	private int postiPrenotati = 0;

	//Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, tranne posti prenotati che va inizializzato a 0.
	public Evento(String titolo, Calendar data, int postiTotali) {
		this.setTitolo(titolo);
		if (data == Calendar.getInstance()) {  // Inserire il controllo che la data non sia già passata
			this.data = data;		
		}
		if(postiTotali > 0) { 					// Controllo che il numero di posti totali sia positivo.
			this.postiTotali = postiTotali;
		} else {								// In caso contrario mostrare i dovuti avvisi all’utente
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
	public Calendar getData() {
		return this.data;
	}

	public void setData(Calendar data) {
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

	public void prenota() { // aggiunge uno ai posti prenotati.
		// TODO Se l’evento è già passato o non ha posti disponibili deve restituire un messaggio di avviso.
		
	}
	
	public void disdici() { // riduce di uno i posti prenotati. 
		// TODO Se l’evento è già passato o non ci sono prenotazioni restituisce un messaggio di avviso.
		
	}

	@Override
	public String toString() { // l’override del metodo toString() 
		//TODO  in modo che venga restituita una stringa contenente: data formattata - titolo
		return "";
	}

}
