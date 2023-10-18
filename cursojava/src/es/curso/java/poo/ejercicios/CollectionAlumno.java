package es.curso.java.poo.ejercicios;

import java.util.ArrayList;
import java.util.List;

import es.curso.java.introduccion.utils.Utilidades;

public class CollectionAlumno {

	public static void main(String[] args) {

		List<Alumno> listaAlumnos = new ArrayList<Alumno>();

		if (listaAlumnos.isEmpty()) {
			listaAlumnos.add(new Alumno("Alumno1", "Apellidos1", "DNI1"));
			listaAlumnos.add(new Alumno("Alumno2", "Apellidos2", "DNI2"));
			listaAlumnos.add(new Alumno("Alumno3", "Apellidos3", "DNI3"));
			listaAlumnos.add(new Alumno("Alumno4", "Apellidos4", "DNI4"));
		}
		
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno.getNombre());
		}
		
		
		String dniSolicitado = Utilidades.pideDatoTexto("Indique DNI");
		for (Alumno alumno : listaAlumnos) {
			if (dniSolicitado.equalsIgnoreCase(alumno.getDni())) {
				listaAlumnos.remove(alumno);
			}
	
		}
		
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno.getNombre());
		}

	}

}
