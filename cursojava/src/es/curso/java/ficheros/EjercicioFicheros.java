package es.curso.java.ficheros;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.curso.java.poo.ejercicios.Alumno;

public class EjercicioFicheros {

	private static final Logger logger = LogManager.getLogger(EjercicioFicheros.class);

	private int jpgs = 0;

	public static void main(String[] args) {

		String nombreDirectorio = "./directorios2";
		EjercicioFicheros ef = new EjercicioFicheros();
//		ef.mostrarArchivosJPG(nombreDirectorio);
//		ef.mostrarArchivosAnio(nombreDirectorio);
		ef.renombrarArchivo(nombreDirectorio);

	}

	public void mostrarArchivosJPG(String nombreDirectorio) {
		File dir = new File(nombreDirectorio);
		System.out.println(dir.getAbsolutePath());
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				mostrarArchivosJPG(file.getAbsolutePath());
			} else {
				if (file.getName().endsWith(".jpg")) {
					logger.debug("es un jpg");
					this.jpgs++;
				}
			}

		}
		System.out.println(this.jpgs);
	}

	public void mostrarArchivosAnio(String nombreDirectorio) {
		File dir = new File(nombreDirectorio);

		System.out.println(dir.getAbsolutePath());
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				mostrarArchivosAnio(file.getAbsolutePath());
			} else if (file.isFile()) {
				LocalDate fechaActual = LocalDate.now();
				if (file.getName().contains(String.valueOf(fechaActual.getYear()))) {
					System.out.println(file.getName());
				}
			}
		}

	}

	public void renombrarArchivo(String nombreDirectorio) {
		File dir = new File(nombreDirectorio);
		LocalDate fechaActual = LocalDate.now();
		String anio = Integer.toString((fechaActual.getYear() + 1));
		String mes = Integer.toString(fechaActual.getMonthValue());
		
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				renombrarArchivo(file.getAbsolutePath());
			} else if (file.isFile()) {
				logger.debug(file.isFile());
				if (file.getName().contains(anio) && file.getName().contains(mes)) {
//					StringBuilder rename = new StringBuilder(file.getName());
//					rename.append(".done");
//					File newFile = new File(rename.toString());
//					file.renameTo(newFile);
					File newFile = new File(file.getAbsolutePath()+ ".done");
					logger.debug(newFile.getName());
				}
			}
		}

	}
	
	public List<Alumno> leerFicheroAlumnos (String nombreDirectorio){
		
		File dir = new File(nombreDirectorio);
		
		
		return null;
	}

}
