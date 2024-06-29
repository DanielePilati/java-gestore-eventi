package org.eventi.gestione;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Evento {
	
	private String titolo;
	private Date data;
	private int postiTotali;
	private int postiPrenotati = 0;  															// tranne posti prenotati che va inizializzato a 0.	
																								
	public Evento(String titolo, Date data, int postiTotali) {									//Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore
		this.setTitolo(titolo);
				
		if (!data.before(Calendar.getInstance().getTime())) {  									// Inserire il controllo che la data non sia già passata
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
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
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
	public void prenota(Date data) { 
		if (data.before(Calendar.getInstance().getTime())) {	
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
																								// rimuove un posto prenotato
	public void disdici(Date data) {  
		if (data.before(Calendar.getInstance().getTime())) {	
			System.out.println("L'evento è gia passato");										// Se l’evento è già passato deve restituire un messaggio di avviso
		} else {
			if (this.postiPrenotati > 0 ) {		
				this.postiPrenotati++;
				System.out.println("Prenotazione Disdetta");									// riduce di uno i posti prenotati.
			} else {
				System.out.println("Non ci sono prenotazioni");									//  non ci sono prenotazioni restituisce un messaggio di avviso.
			}
		}	
	}

	@Override   																				// l’override del metodo toString() 
	public String toString() { 
		return DateFormat.getInstance().format(this.data) + " - "+ this.titolo;   				// in modo che venga restituita una stringa contenente: data formattata - titolo
	}

}
