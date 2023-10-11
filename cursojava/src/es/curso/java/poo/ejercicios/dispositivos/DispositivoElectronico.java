package es.curso.java.poo.ejercicios.dispositivos;

public abstract class DispositivoElectronico implements SistemaEncendido{
	
	private long id;
	private double precio;
	private String fabricante;
	
	/**
	 * @param id
	 * @param precio
	 * @param fabricante
	 */
	public DispositivoElectronico(long id, double precio, String fabricante) {
		super();
		this.id = id;
		this.precio = precio;
		this.fabricante = fabricante;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public long getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}
	

}
