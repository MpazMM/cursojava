package es.curso.java.poo.ejercicios;

public class Alumno {
	

	//Variables de instancia
	String nombre;
	String apellidos;
	String dni;
	double nota;
	
	
	//Constructores
	public Alumno() {
		this.nombre = "";
	}
	
	public Alumno(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Alumno(String dni, String nombre, String apellidos, double nota) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nota = nota;
	}
	
	//Métodos
	public void estudiar () {
		System.out.println("El alumno " + this.nombre );
		if (this.nota==0) {
			System.out.println(" no ha estudiado nada.");
		}else if (this.nota<5) {
				System.out.println(" ha estudiado poco");
		}else if (this.nota>5 && nota<9) {
			System.out.println(" ha estudiado mucho");
		}else if (this.nota==10) {
			System.out.println(" es un genio");
		}else {
			System.out.println("Nota incorrecta");
		}
	}

}
