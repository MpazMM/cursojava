package es.curso.java.poo.ejercicios.guerra;

import java.util.ArrayList;
import java.util.List;

public abstract class VehiculoGuerra implements Tripulable{
	
	int puntosVida = 1000;
	int ataque = 5;
	int defensa = 5;
	private String nombreNave;
	List<Guerrero> GuerrerosNave = new ArrayList<Guerrero>();
	
	

}
