package es.curso.java.poo.ejercicios.dispositivos;

public class Movil extends DispositivoElectronico{

	private String sistemaOperativo;

	/**
	 * @param id
	 * @param precio
	 * @param fabricante
	 * @param sistemaOperativo
	 */
	public Movil(long id, double precio, String fabricante, String sistemaOperativo) {
		super(id, precio, fabricante);
		this.sistemaOperativo = sistemaOperativo;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	@Override
	public void encender() {
		System.out.println("El móvil se ha encendido");
		
	}

	@Override
	public void apagar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
