package es.curso.java.poo.ejercicios.hospital;

public class Hospital {

	private String nombre;
	private Habitacion[] habitaciones;
	private Paciente [] salaDeEspera;

	public Hospital(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Hospital(String nombre, Habitacion[] habitaciones, Paciente[] salaDeEspera) {
		super();
		this.nombre = nombre;
		this.habitaciones = new Habitacion [2];
		this.salaDeEspera = new Paciente [3];
	}

	public static void main(String[] args) {

		Hospital hospital = new Hospital("Hospital Buendia");
		hospital.abrirHospital();
	}

	public void abrirHospital() {
		
		Habitacion habitacion1 = new Habitacion(1);
		Habitacion habitacion2 = new Habitacion(2);
		this.habitaciones[0] = habitacion1;
		this.habitaciones[1] = habitacion2;
		
		String [] sintomas1 = {"Fiebre", "Vómitos"};
		String [] sintomas2 = {"Dolor de cabeza", "Malestar"};
		String [] sintomas3 = {"Fiebre", "Deshidratación"};
		
		Paciente paciente1 = new Paciente (1, "Vero", 33, sintomas1);
		Paciente paciente2 = new Paciente (2, "Isra", 22, sintomas2);
		Paciente paciente3 = new Paciente (3, "Fran", 15, sintomas3);
		
		this.salaDeEspera[0] = paciente1;
		this.salaDeEspera[1] = paciente2;
		this.salaDeEspera[2] = paciente3;
		
		Enfermero enfermero1 = new Enfermero (1, "Pepe", 28, "Mañana",2);
		Enfermero enfermero2 = new Enfermero (2, "María", 32, "Mañana",1);
		
		Doctor doctor1 = new Doctor (3, "Susana", 40, "Mañana", "Medicina general");
		
		EmpleadosHospital [] empleados = {enfermero1,enfermero2,doctor1};
		ficharEmpleados(empleados);
		comerHospital(empleados,salaDeEspera);
		
	}
	
	//Método en el que fichan todos los empleados
	public void ficharEmpleados(EmpleadosHospital[] empleados) {
		for (EmpleadosHospital empleado : empleados) {
			empleado.fichar();
		}
	}
	
	//Método en el que comen todos los que están en el hospita
	public void comerHospital(EmpleadosHospital[] empleados, Persona[] persona) {
		for (EmpleadosHospital empleado : empleados) {
			empleado.comer();
		}
		for (Persona personaComer : persona) {
			if(personaComer != null) {
			personaComer.comer();
			}}
	}

}
