package es.curso.java.poo.collecciones.ejercicio.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
	
	private String nombreBiblioteca;
	private Map<String, Libro> catalogoBiblioteca = new HashMap<>();
	
	/**
	 * @param nombreBiblioteca
	 * @param catalogoBiblioteca
	 */
	public Biblioteca(String nombreBiblioteca, Map<String, Libro> catalogoBiblioteca) {
		super();
		this.nombreBiblioteca = nombreBiblioteca;
		this.catalogoBiblioteca = catalogoBiblioteca;
	}
	
	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	public Map<String, Libro> getCatalogoBiblioteca() {
		return catalogoBiblioteca;
	}

	public void setCatalogoBiblioteca(Map<String, Libro> catalogoBiblioteca) {
		this.catalogoBiblioteca = catalogoBiblioteca;
	}

	@Override
	public String toString() {
		return "Biblioteca [" + (nombreBiblioteca != null ? "nombreBiblioteca=" + nombreBiblioteca + ", " : "")
				+ (catalogoBiblioteca != null ? "catalogoBiblioteca=" + catalogoBiblioteca : "") + "]";
	}

	public void agregarLibro(Libro libro) {
        String titulo = libro.getTitulo();
        int copiasDisponibles = libro.getCopiasDisponibles();

        if (catalogoBiblioteca.containsKey(titulo)) {
            int copiasTotales = copiasDisponibles + 1;
            
            System.out.println("Libro agregado al catálogo correctamente. "
            		+ "El libro " + libro.getTitulo() + " tiene " + libro.getCopiasDisponibles()
            		+ " copias disponibles.");
        }else {
            catalogoBiblioteca.put(titulo, libro);
        }
        System.out.println("Libro agregado al catálogo correctamente.");
    }
	
	Map<String,Libro> prestarLibro() {
		return null;
	}
	
	Map<String,Libro> devolverLibro() {
		return null;
	}
	

}
