package es.curso.java.poo.ejercicios.hospital;

public class Hospital {
	
	private String nombre;
	private Habitacion [] habitaciones;
	private String []salaDeEspera;
	
	public Hospital(String nombre, Habitacion[] habitaciones, String[] salaDeEspera) {
		super();
		this.nombre = nombre;
		this.habitaciones = habitaciones;
		this.salaDeEspera = salaDeEspera;
	}
	
	public static void main (String [] args) {
		
	}
	
	
	public void abrirHospital() {
		
		Enfermero enfermero1 = new Enfermero (1, "Pepe", 28, "Mañana",2);
		Enfermero enfermero2 = new Enfermero (2, "María", 32, "Tarde",1);
		
		Doctor doctor1 = new Doctor (3, "Susana", 40, "Mañana", "Medicina general" );
		
		EmpleadosHospital [] empleados = {enfermero1,enfermero2,doctor1};
		
		
		
	}
	
	

}
