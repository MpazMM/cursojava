package es.curso.java.poo.ejercicios.hospital;

public class EmpleadosHospital extends Persona {

	private String turno;

	public EmpleadosHospital(long id, String nombre, int edad, String turno) {
		super(id, nombre, edad);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public void comer() {
		System.out.println("El empleado " + getNombre() + " está comiendo en el comedor");
	}

	public void fichar() {
		System.out.println("El empleado " + getNombre() + " está fichando en el turno " + this.turno);
	}

}
