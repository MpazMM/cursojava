package es.curso.java.ejercicio.repaso;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class FerreteriaMain{

	public static void main(String[] args) {
		FerreteriaMain ferreteria = new FerreteriaMain();

		try {
			ferreteria.datosFerreteria();
			ferreteria.totalTornillos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void totalTornillos() {
	    TornilloEnum[] tornillos = TornilloEnum.values();
	    double[] contador = {0.0};  // Utilizando un array mutable para almacenar el valor acumulado

	    Arrays.asList(tornillos).forEach(tornillo -> contador[0] += tornillo.getPrecio());

	    System.out.println("Total de precios de tornillos: " + contador[0]);
	}

	public void datosFerreteria() throws IOException {
		InputStream archivo = new FileInputStream("cursojava\\src\\ferreteria.properties");
		Properties p = new Properties(System.getProperties());
		p.load(archivo);
		TornilloEnum[] tornillos = TornilloEnum.values();
		String idString = p.getProperty("ferreteria.id");
		long id = Long.parseLong(idString);
		Ferreteria ferreteria1 = new Ferreteria(id, p.getProperty("ferreteria.nombre"),
				p.getProperty("ferreteria.direccion"), tornillos);
		System.out.println(ferreteria1);

	}

}
