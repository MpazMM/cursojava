package es.curso.java.poo.ejercicios.hospital;

public class Enfermero extends EmpleadosHospital{
	
	private int planta;

	public Enfermero(long id, String nombre, int edad, String turno, int planta) {
		super(id, nombre, edad, turno);
		this.planta = planta;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}
	
	public void atenderPaciente() {
		
	}

}
