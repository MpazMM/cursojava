package es.curso.java.poo.ejercicios.hospital;

public class Doctor extends EmpleadosHospital{
	
	private String especialidad;

	public Doctor(long id, String nombre, int edad, String turno, String especialidad) {
		super(id, nombre, edad, turno);
		this.especialidad = especialidad;
		//Hola
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public void diagnosticarPaciente () {
		
	}
	
}
