package es.curso.java.poo.collecciones.ejercicio.biblioteca;

import es.curso.java.introduccion.utils.Utilidades;

public class BibliotecaMain {
	
	public static void main (String [] args) {
		
		
	}

	
	public void menuBiblioteca() {
		String menu [] = {"1. Agregar un libro a la biblioteca","2. Préstamos de un libro","3. Devolver un libro", "4.Salir"};
		String pregunta = "Elige opción";
		int opcionSeleccionada = Utilidades.pintarMenu(menu,pregunta);	
		
		switch(opcionSeleccionada) {
		case 1: 
			agregarLibro();
			break;
		case 2: 
			prestarLibro();
			break;
		case 3: 
			devolverLibro();
			break;
		case 4: System.out.println("Adiós");
			break;
		default: System.out.println("Opcion incorrecta");
		}
	}
	
	public void crearBiblioteca() {
		
	}
}
