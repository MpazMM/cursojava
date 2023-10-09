package excepciones.ejercicios.temperatura;

public class ClienteCafeteria {

	private String nombreCliente;
	private CoffeCup coffeCliente;

	public ClienteCafeteria(String nombreCliente) {
		super();
		this.nombreCliente = nombreCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public CoffeCup getCoffeCliente() {
		return coffeCliente;
	}

	public void setCoffeCliente(CoffeCup coffeCliente) {
		this.coffeCliente = coffeCliente;
	}

	//Método tomar taza de café
	public void tomarTazaCafe () throws TooColdTemperatureException, TooHotTemperatureException {
		if (coffeCliente.getTemperature()<=20) {
			throw new TooColdTemperatureException ();
		}
		if (coffeCliente.getTemperature()>=80) {
			throw new TooHotTemperatureException ();
		}
		System.out.println("Al cliente le ha encantado el café");
	}
	
}
