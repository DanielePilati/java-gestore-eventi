package org.eventi.gestione;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammaEventi {

	private String titolo;
	private List<Evento> eventi;
	
																			// Nel costruttore valorizzare il titolo, passato come parametro,
	public ProgrammaEventi(String titolo) {									//  e inizializzare la lista di eventi come una nuova ArrayList
		this.titolo = titolo;
		this.eventi = new ArrayList<Evento>();
		
	}
																			// un metodo che aggiunge alla lista un Evento, passato come parametro
	public void addEvent(Evento event) {
		this.eventi.add(event);
	}
																			// un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
	public void searchEventFromDate(LocalDate date) {
		
		boolean thereIs = false;
		
		System.out.println("Ecco la lista degli eventi in data " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		for (Evento event : this.eventi) {
			if (event.getData().equals(date))
			System.out.println(event);
			thereIs = true;
		}
		if (!thereIs) {
			System.out.println("non ci sono eventi in questa data");
		}
	}
																			// un metodo che restituisce quanti eventi sono presenti nel programma
	public int howManyEvents() {
	
		int counter = 0;
		
		for (@SuppressWarnings("unused")Evento event : this.eventi) {
			counter++;
		}
		return counter;
	}
																			// un metodo che svuota la lista di eventi
	public void resetEventList () {
		this.eventi.clear();
	}
																			// un metodo che restituisce una stringa che mostra
	@Override																// il titolo del programma e tutti gli eventi 
	public String toString() {												// ordinati per data  nella forma: data1 - titolo1 data2 - titolo2 …
		
		String sequence = "-| " + this.titolo + ": ";
		Collections.sort(this.eventi);
		for(Evento event : this.eventi) {
			sequence += "\n " + event.toString();
		}
		return sequence ;
	}
}
