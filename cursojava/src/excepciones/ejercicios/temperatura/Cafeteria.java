package excepciones.ejercicios.temperatura;

import java.io.IOException;
import java.util.Random;

import es.curso.java.excepciones.MiExcepcion;

public class Cafeteria {

	private String nombreCafeteria;
	private CoffeCup cupCoffe;
	private ClienteCafeteria cliente;

	public Cafeteria(String nombreCafeteria) {
		super();
		this.nombreCafeteria = nombreCafeteria;
	}

	public static void main(String[] args) {

		Cafeteria cafeteria = new Cafeteria("Rico café");
		cafeteria.abrirCafeteria();

//		try {
//			cafeteria.tomarTazaCafe();
//		} catch (TooColdTemperatureException e) {
//			System.out.println(e.getMessage());
//		} catch (TooHotTemperatureException f) {
//			System.out.println(f.getMessage());
//		}

	}

	// Método abrir cafetería
	// Crear taza café temperatura aleatoria
	// Crear cliente
	// Cliente tomarTazaCafe
	// Si el cliente se queja se le pone otra taza

	public void abrirCafeteria() {
		System.out.println("Bienvenido a la cafetería " + this.nombreCafeteria);
		cupCoffeAl();
		clienteCafe();
		this.cliente.setCoffeCliente(cupCoffe);
		this.cliente.tomarTazaCafe();
	}

	public int cupCoffeAl() {
		Random rd1 = new Random();
		int temperature = rd1.nextInt(1, 100);
		this.cupCoffe = new CoffeCup(temperature);
		return temperature;
	}

	public void clienteCafe() {
		this.cliente = new ClienteCafeteria("Manolo");
	}

}
