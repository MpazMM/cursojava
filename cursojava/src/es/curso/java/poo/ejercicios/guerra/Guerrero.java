package es.curso.java.poo.ejercicios.guerra;

public class Guerrero {

	private String nombreGuerrero;
	private String tipo;
	private int fuerzaGuerrero;
	private int resistenciaGuerrero;
	
	/**
	 * @param nombreGuerrero
	 * @param tipo
	 * @param fuerzaGuerrero
	 * @param resistenciaGuerrero
	 */
	public Guerrero(String nombreGuerrero, String tipo, int fuerzaGuerrero, int resistenciaGuerrero) {
		super();
		this.nombreGuerrero = nombreGuerrero;
		this.tipo = tipo;
		this.fuerzaGuerrero = fuerzaGuerrero;
		this.resistenciaGuerrero = resistenciaGuerrero;
	}

	public String getNombreGuerrero() {
		return nombreGuerrero;
	}

	public void setNombreGuerrero(String nombreGuerrero) {
		this.nombreGuerrero = nombreGuerrero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getFuerzaGuerrero() {
		return fuerzaGuerrero;
	}

	public int getResistenciaGuerrero() {
		return resistenciaGuerrero;
	}
	
	
	
}
