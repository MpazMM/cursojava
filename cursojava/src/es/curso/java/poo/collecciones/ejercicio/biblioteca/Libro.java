package es.curso.java.poo.collecciones.ejercicio.biblioteca;

public class Libro {
	
	private String titulo;
	private String autor;
	private int copiasDisponibles;
	
	/**
	 * @param titulo
	 * @param autor
	 * @param copiasDisponibles
	 */
	public Libro(String titulo, String autor, int copiasDisponibles) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.copiasDisponibles = copiasDisponibles;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCopiasDisponibles() {
		return copiasDisponibles;
	}

	public void setCopiasDisponibles(int copiasDisponibles) {
		this.copiasDisponibles = copiasDisponibles;
	}

	@Override
	public String toString() {
		return "Libro [" + (titulo != null ? "titulo=" + titulo + ", " : "")
				+ (autor != null ? "autor=" + autor + ", " : "") + "copiasDisponibles=" + copiasDisponibles + "]";
	}
	
	

}
