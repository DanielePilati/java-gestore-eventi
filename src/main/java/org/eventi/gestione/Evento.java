package org.eventi.gestione;

import java.util.Calendar;

public class Evento {

	private String titolo;
	private Calendar data;
	private int postiTotali;
	private int postiPrenotati = 0;

	//Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore,tranne posti prenotati che va inizializzato a 0.
	public Evento(String titolo, Calendar data, int postiTotali) {
		this.titolo = titolo;
		//  Inserire il controllo che la data non sia già passata
		this.data = data;
		// Inserire Il controllo che il numero di posti totali sia positivo.
		this.postiTotali = postiTotali;
	}
  //In caso contrario mostrare i dovuti avvisi all’utente
}
