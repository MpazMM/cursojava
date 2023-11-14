package es.curso.java.poo.collecciones.mapas.ejercicios.futbol;

public class Equipo {
	
	private String nombreEquipo;
	private int numLigas;
	private int numChampions;
	
	/**
	 * @param nombreEquipo
	 * @param numLigas
	 * @param numChampions
	 */
	public Equipo(String nombreEquipo, int numLigas, int numChampions) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.numLigas = numLigas;
		this.numChampions = numChampions;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getNumLigas() {
		return numLigas;
	}

	public void setNumLigas(int numLigas) {
		this.numLigas = numLigas;
	}

	public int getNumChampions() {
		return numChampions;
	}

	public void setNumChampions(int numChampions) {
		this.numChampions = numChampions;
	}

	@Override
	public String toString() {
		return "Equipo [" + (nombreEquipo != null ? "nombreEquipo=" + nombreEquipo + ", " : "") + "numLigas=" + numLigas
				+ ", numChampions=" + numChampions + "]";
	}
	
	

}
