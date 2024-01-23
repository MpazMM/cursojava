package es.curso.java.ejercicio.repaso;

import java.util.Arrays;

public class Ferreteria {
	
	private long id;
	private String nombre;
	private String direccion;
	TornilloEnum [] tornillos;
	
	/**
	 * @param id
	 * @param nombre
	 * @param direccion
	 * @param tornillos
	 */
	public Ferreteria(long id, String nombre, String direccion, TornilloEnum[] tornillos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tornillos = tornillos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TornilloEnum[] getTornillos() {
		return tornillos;
	}

	public void setTornillos(TornilloEnum[] tornillos) {
		this.tornillos = tornillos;
	}

	@Override
	public String toString() {
		return "Ferreteria [id=" + id + ", " + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (direccion != null ? "direccion=" + direccion + ", " : "")
				+ (tornillos != null ? "tornillos=" + Arrays.toString(tornillos) : "") + "]";
	}
	
	
}
