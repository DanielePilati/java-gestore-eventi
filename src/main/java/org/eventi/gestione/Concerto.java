package org.eventi.gestione;

import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

public class Concerto extends Evento {

	private Time ora;
	private double prezzo;
	
	public Concerto(String titolo, Date data, int postiTotali, Time ora, double prezzo) {                  	// Aggiungere gli attributi nel costruttore 
		super(titolo, data, postiTotali);
		this.setOra(ora);
		this.setPrezzo(prezzo);
	}
																											//implementarne getter e setter.
	public Time getOra() {
		return ora;
	}

	public void setOra(Time ora) {
		this.ora = ora;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	// TODO Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€) 
	
	
	@Override   																							// l’override del metodo toString() 
	public String toString() { 	
		return DateFormat.getInstance().format(this.getData()) + " - "+ this.getTitolo( )+ " - "+ this.priceFormatter(this.prezzo);   
		// in modo che venga restituita una stringa del tipo:  data e ora formattata - titolo - prezzo formattato
	}
	
	public String priceFormatter (double price) {															// aggiunto metodo per formattare il prezzo
		DecimalFormat decfor = new DecimalFormat("0.00");  
		return  decfor .format(prezzo);
	}


}
