package es.curso.java.ficheros;

import java.io.IOException;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        //String nombreArchivo = "D:\\Cursos\\Java\\archivo\\java.txt";
    	String nombreArchivo = "./cursojava";
        ArchivoServicio servicio = new ArchivoServicio();

        
        try {
			System.out.println(servicio.leerArchivo(nombreArchivo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
