package es.curso.java.poo.ejercicios.dispositivos;

public abstract class Vehiculo implements SistemaEncendido{
	
	private long id;
	private String matricula;
	private String marca;
	
	/**
	 * @param id
	 * @param matricula
	 * @param marca
	 */
	public Vehiculo(long id, String matricula, String marca) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public long getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}
	

}
