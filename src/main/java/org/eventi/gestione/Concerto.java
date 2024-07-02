package org.eventi.gestione;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime ora;
	private double prezzo;
	
	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) {         // Aggiungere gli attributi nel costruttore 
		super(titolo, data, postiTotali);
		this.ora = ora;
		this.prezzo = prezzo;
	}
																											//implementarne getter e setter.
	public LocalTime getOra() {
		return this.ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override   																							// l’override del metodo toString() 
	public String toString() { 	
		return this.dateTimeFormatter(super.getData(), this.ora) + " - " + super.getTitolo() + " - " + this.priceFormatter(this.prezzo) + " codice: " + super.getCodice();   
		// in modo che venga restituita una stringa del tipo:  data e ora formattata - titolo - prezzo formattato  // aggiunto codice per test ricerca evento dato  codice
	}
	
	public String priceFormatter (double price) {															// aggiunto metodo per formattare il prezzo
		
		DecimalFormat decfor = new DecimalFormat("0.00");  
		
		return  decfor .format(prezzo);
	}
																											//  metodo per formattare anche l'ora
	public String dateTimeFormatter (LocalDate date, LocalTime time) {
		
		LocalDateTime dateTime = time.atDate(date);
		
		return dateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
	}

}
