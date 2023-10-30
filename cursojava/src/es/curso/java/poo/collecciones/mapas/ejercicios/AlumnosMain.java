package es.curso.java.poo.collecciones.mapas.ejercicios;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import es.curso.java.introduccion.utils.Utilidades;

public class AlumnosMain {

	public static void main(String[] args) {

		AlumnosMain am = new AlumnosMain();
//		Map<String, Alumno> alumnosColegio = am.crearAlumnos();
//		am.buscarAlumno(alumnosColegio);
//		am.notaMedia(alumnosColegio);

		Map<String, Set<Alumno>> alumnosColegios = am.crearColegios();

		am.buscarAlumnoColegios(alumnosColegios);

	}

	public void pintarAlumnos(Map<String, Alumno> args) {
		Set<Entry<String, Alumno>> entries = args.entrySet();
		for (Entry<String, Alumno> alumno : entries) {
			System.out.println(alumno.getKey() + " " + alumno.getValue());
		}
	}

	public Map<String, Alumno> crearAlumnos() {

		Alumno alumno1 = new Alumno("DNI1", "Alumno1", "Apellidos1", 7);
		Alumno alumno2 = new Alumno("DNI2", "Alumno2", "Apellidos2", 4);
		Alumno alumno3 = new Alumno("DNI3", "Alumno3", "Apellidos3", 9);
		Alumno alumno4 = new Alumno("DNI4", "Alumno4", "Apellidos4", 9);

		Map<String, Alumno> colegio = new HashMap<String, Alumno>();

		colegio.put(alumno1.getDni(), alumno1);
		colegio.put(alumno2.getDni(), alumno2);
		colegio.put(alumno3.getDni(), alumno3);
		colegio.put(alumno4.getDni(), alumno4);

		pintarAlumnos(colegio);

		return colegio;
	}

	public void buscarAlumno(Map<String, Alumno> args) {
		String datoSolicitado = Utilidades.pideDatoTexto("Introduce el dni del alumno a buscar");
		if (args.containsKey(datoSolicitado)) {
			Alumno alumno = args.get(datoSolicitado);
			System.out.println(alumno.toString());
		} else {
			System.out.println("El alumno no se encuentra en el colegio");
		}

	}

	public void buscarAlumnoColegios(Map<String, Set<Alumno>> args) {
		String datoSolicitado = Utilidades.pideDatoTexto("Introduce el dni del alumno a buscar");
		boolean encontrado = false;

		Set<Entry<String, Set<Alumno>>> entries = args.entrySet();
		for (Entry<String, Set<Alumno>> entry : entries) {
			for (Alumno alumno : entry.getValue()) {
				if (alumno.getDni().equals(datoSolicitado)) {
					System.out.println(alumno.getDni() + " " + alumno.getNombre());
					System.out.println(entry.getKey());
					encontrado = true;
					break;

				}

			}
		}
		if (!encontrado) {
			System.out.println("El alumno no está en el colegio");
		}

	}

	public void notaMedia(Map<String, Alumno> args) {
		double notaAlumnos = 0;
		Collection<Alumno> alumnos = args.values();
		for (Alumno alumno : alumnos) {
			notaAlumnos += alumno.getNota();
		}
		double notaMedia = notaAlumnos / alumnos.size();
		System.out.println(notaMedia);
	}

	Map<String, Set<Alumno>> crearColegios() {

		Alumno alumno1 = new Alumno("DNI1", "Alumno1", "Apellidos1", 7);
		Alumno alumno2 = new Alumno("DNI2", "Alumno2", "Apellidos2", 4);
		Alumno alumno3 = new Alumno("DNI3", "Alumno3", "Apellidos3", 9);
		Alumno alumno4 = new Alumno("DNI4", "Alumno4", "Apellidos4", 9);

		Set<Alumno> colegio1 = new HashSet<Alumno>();
		colegio1.add(alumno1);
		colegio1.add(alumno2);

		Set<Alumno> colegio2 = new HashSet<Alumno>();
		colegio2.add(alumno3);
		colegio2.add(alumno4);

		Map<String, Set<Alumno>> colegios = new HashMap<String, Set<Alumno>>();
		colegios.put("Colegio1", colegio1);
		colegios.put("Colegio2", colegio2);

		Set<Entry<String, Set<Alumno>>> entries = colegios.entrySet();
		for (Entry<String, Set<Alumno>> entry : entries) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		return colegios;
	}

}
