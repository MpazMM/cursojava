package hibernate.ejercicio2.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hibernate.ejercicio2.entities.ProductoOracle;

public class DirectorioProductos {
	
	public static void main(String[] args) {
		
		DirectorioProductos dp = new DirectorioProductos();
		try {
			dp.leerFicheroProductos("./recursos/fichero_carga_ejercicio2.txt", 1);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		

}
	
	
	public List<ProductoOracle> leerFicheroProductos(String rutaFichero) 
			throws IOException, ParseException{
		
		return leerFicheroProductos(rutaFichero,0);
		
	}
	
	
	public List<ProductoOracle> leerFicheroProductos(String rutaFichero, 
			int skipLines) throws IOException, ParseException{
		Path path = Paths.get(rutaFichero);
		List<ProductoOracle> productos = new ArrayList();

		List<String> lines = Files.readAllLines(path);
		int numLinea = 1;
		for (String linea : lines) {
			if (numLinea>skipLines) {
				String[] datos = linea.split("\\;");
				
				String nombre = datos[0];
				String tipo = datos[1];
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String fechaStr = datos [2];
				
				Date fechaAlta = df.parse(fechaStr);
				
				
				int precio = Integer.parseInt(datos[3]);
				int unidades = Integer.parseInt(datos[4]);
				
				ProductoOracle producto = new ProductoOracle (nombre,tipo,fechaAlta,precio,unidades);
				productos.add(producto);
				
			}
			numLinea++;
		}

		return productos;
	}
	
}
