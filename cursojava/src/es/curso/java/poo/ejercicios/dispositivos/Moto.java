package es.curso.java.poo.ejercicios.dispositivos;

public class Moto extends Vehiculo{
	
	private int numRuedas;

	/**
	 * @param id
	 * @param matricula
	 * @param marca
	 * @param numRuedas
	 */
	public Moto(long id, String matricula, String marca, int numRuedas) {
		super(id, matricula, marca);
		this.numRuedas = numRuedas;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	@Override
	public void encender() {
		System.out.println("La moto se ha encendido");
		
	}

	@Override
	public void apagar() {
		// TODO Auto-generated method stub
		
	}
	
	

}
