package es.curso.java.ejercicio.repaso;

public enum TornilloEnum {
	
	
	TORNILLO1 (1,"Color1",0.99,1.12,5.99),
	TORNILLO2 (2,"Color2",2,4.12,2.75),
	TORNILLO3 (3,"Color3",0.99,3.32,8.99);
	
	
	private long id;
	private String color;
	private double longitud;
	private double diametro;
	private double precio;
	
	/**
	 * @param id
	 * @param color
	 * @param longitud
	 * @param diametro
	 * @param precio
	 */
	private TornilloEnum(long id, String color, double longitud, double diametro, double precio) {
		this.id = id;
		this.color = color;
		this.longitud = longitud;
		this.diametro = diametro;
		this.precio = precio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}
