package es.curso.java.poo.ejercicios.hospital;

public class Habitacion {
	
	private int numeroHabitacion;
	private Enfermo enfermo;
	
	
	public Habitacion() {
		super();
	}

	public Habitacion(int numeroHabitacion, Enfermo enfermo) {
		super();
		this.numeroHabitacion = numeroHabitacion;
		this.enfermo = enfermo;
	}

	public Enfermo getEnfermo() {
		return enfermo;
	}

	public void setEnfermo(Enfermo enfermo) {
		this.enfermo = enfermo;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}
	
	

}
