package ejercicio.bibliotecaddbb;

public class Libros {
	
	private long id;
	private String titulo;
	private String autor;
	private int isbn;
	private int libroBiblioteca;
	
	/**
	 * @param id
	 * @param titulo
	 * @param autor
	 * @param isbn
	 * @param libroBiblioteca
	 */
	public Libros(long id, String titulo, String autor, int isbn, int libroBiblioteca) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.libroBiblioteca = libroBiblioteca;
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

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getLibroBiblioteca() {
		return libroBiblioteca;
	}

	public void setLibroBiblioteca(int libroBiblioteca) {
		this.libroBiblioteca = libroBiblioteca;
	}

	public long getId() {
		return id;
	}
	
	

}
