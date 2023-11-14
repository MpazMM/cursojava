package es.curso.java.poo.collecciones.mapas.ejercicios.futbol;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class FutbolMain {

	public static void main(String[] args) {
		
		FutbolMain fm = new FutbolMain();
		fm.iniciarLiga();
		
	}
	
	public void iniciarLiga() {
	Jugador jugador1 = new Jugador("Jugador1", 18, "Posicion1");
	Jugador jugador2 = new Jugador("Jugador2", 19, "Posicion2");
	Jugador jugador3 = new Jugador("Jugador3", 20, "Posicion3");
	Jugador jugador4 = new Jugador("Jugador4", 21, "Posicion4");
	Jugador jugador5 = new Jugador("Jugador5", 22, "Posicion5");
	Jugador jugador6 = new Jugador("Jugador6", 23, "Posicion6");
	
	
	Set<Jugador> equipo1 = new HashSet<Jugador>();
	equipo1.add(jugador1);
	equipo1.add(jugador2);
	equipo1.add(jugador3);
	
	Set<Jugador> equipo2 = new HashSet<Jugador>();
	equipo2.add(jugador4);
	equipo2.add(jugador5);
	equipo2.add(jugador6);

	Equipo madrid = new Equipo ("Madrid",2,1);
	Equipo atleti = new Equipo ("Atleti",3,1);
	
	Map<Equipo,Set<Jugador>> futbol = new HashMap<Equipo,Set<Jugador>>();
	futbol.put(atleti, equipo2);
	futbol.put(madrid, equipo1);
	
	
	Set<Equipo> equipos = futbol.keySet();
	
	for (Equipo equipo : equipos) {
		System.out.println(equipo.getNombreEquipo());
	//	System.out.println("\t"+futbol.get(equipo).get(0).getNombre());
	}
	
	Set<Entry<Equipo, Set<Jugador>>> futbolEntry = futbol.entrySet();
	for (Entry<Equipo,Set<Jugador>> entry : futbolEntry) {
		Set<Jugador> jugadoresEquipo = entry.getValue();
		for (Jugador jugador : jugadoresEquipo) {
			System.out.println(jugador.getNombreJugador());
		}
	}

	
	Set<Entry<Equipo, Set<Jugador>>> futbolEntry2 = futbol.entrySet();
	for (Entry<Equipo,Set<Jugador>> entry : futbolEntry2) {
		System.out.println(entry.getKey().getNombreEquipo() );
		Set<Jugador> jugadoresEquipo = entry.getValue();
		for (Jugador jugador : jugadoresEquipo) {
			System.out.println("\t"+jugador);
		}
	}
}
}
