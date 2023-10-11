package es.curso.java.poo.ejercicios.dispositivos;

public class Coche extends Vehiculo{

	private int numPuertas;

	/**
	 * @param id
	 * @param matricula
	 * @param marca
	 * @param numPuertas
	 */
	public Coche(long id, String matricula, String marca, int numPuertas) {
		super(id, matricula, marca);
		this.numPuertas = numPuertas;
	}

	
	public int getNumPuertas() {
		return numPuertas;
	}


	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}


	@Override
	public void encender() {
		System.out.println("El coche se ha encendido");
	}

	@Override
	public void apagar() {
		// TODO Auto-generated method stub
		
	}

	
}
