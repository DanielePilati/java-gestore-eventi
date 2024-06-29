package org.eventi.gestione;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
	
		Calendar calendario = Calendar.getInstance();
		calendario.set(2025, 2, 23);
		Evento event = new Evento("Lancio del corriandolo", calendario.getTime(), 10);
		event.prenota(calendario.getTime());
		event.disdici(calendario.getTime());
		System.out.println(event.toString());
	}

}
