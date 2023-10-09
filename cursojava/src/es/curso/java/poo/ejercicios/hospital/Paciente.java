package es.curso.java.poo.ejercicios.hospital;

public class Paciente extends Persona{
	
	private String [] sintomas;

	public Paciente(long id, String nombre, int edad, String[] sintomas) {
		super(id, nombre, edad);
		this.sintomas = sintomas;
	}

	public String[] getSintomas() {
		return sintomas;
	}

	public void setSintomas(String[] sintomas) {
		this.sintomas = sintomas;
	}

	@Override
	public void comer() {
		System.out.println("El paciente " + getNombre() + " está comiendo en la cafetería");
	}

}
