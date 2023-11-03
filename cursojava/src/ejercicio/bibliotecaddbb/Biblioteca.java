package ejercicio.bibliotecaddbb;

public class Biblioteca {
	
	private long id;
	private String nombreBiblioteca;
	private int bibliotecaDireccion;

	/**
	 * @param id
	 * @param nombreBiblioteca
	 * @param fk_direccion
	 */
	public Biblioteca(long id, String nombreBiblioteca, int bibliotecaDireccion) {
		super();
		this.id = id;
		this.nombreBiblioteca = nombreBiblioteca;
		this.bibliotecaDireccion = bibliotecaDireccion;
	}

	public Biblioteca() {
		// TODO Auto-generated constructor stub
	}

	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	public int getBibliotecaDireccion() {
		return bibliotecaDireccion;
	}

	public void setBibliotecaDireccion(int bibliotecaDireccion) {
		this.bibliotecaDireccion = bibliotecaDireccion;
	}

	public long getId() {
		return id;
	}
	
	

}
