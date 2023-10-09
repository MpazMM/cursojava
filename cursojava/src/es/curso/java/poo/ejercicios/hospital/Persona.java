package es.curso.java.poo.ejercicios.hospital;

public abstract class Persona {

	private long id;
	private String nombre;
	private int edad;
	
	public Persona(long id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public long getId() {
		return id;
	}

	public abstract void comer();
	
}
