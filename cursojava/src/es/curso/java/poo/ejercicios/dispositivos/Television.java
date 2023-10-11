package es.curso.java.poo.ejercicios.dispositivos;

public class Television extends DispositivoElectronico{
	
	private int hdmi;

	/**
	 * @param id
	 * @param precio
	 * @param fabricante
	 * @param hdmi
	 */
	public Television(long id, double precio, String fabricante, int hdmi) {
		super(id, precio, fabricante);
		this.hdmi = hdmi;
	}

	public int getHdmi() {
		return hdmi;
	}

	public void setHdmi(int hdmi) {
		this.hdmi = hdmi;
	}

	@Override
	public void encender() {
		System.out.println("La television se ha encendido");
		
	}

	@Override
	public void apagar() {
		// TODO Auto-generated method stub
		
	}
	

}
