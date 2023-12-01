package hibernate.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.curso.java.hibernate.util.JpaUtil;
import es.curso.java.introduccion.utils.Utilidades;
import hibernate.ejercicio2.dao.ProductoHibernateDAO;
import hibernate.ejercicio2.entities.ProductoOracle;
import jakarta.persistence.EntityManager;

public class DirectorioProductos {

	private static final Logger logger = LogManager.getLogger(DirectorioProductos.class);

	public static void main(String[] args) {
		DirectorioProductos dp = new DirectorioProductos();
		dp.iniciar();
	}

	public void iniciar() {

		EntityManager em = JpaUtil.getEM("hibernateOracle");
		ProductoHibernateDAO productoDAO = new ProductoHibernateDAO(em);
		try {
			// Insertar los usuarios
			insertarProductos(productoDAO);
			// Mostrar los productos
			mostrarProductos(productoDAO);
			// Mostrar por fecha (pidiendo fecha)
			mostrarFecha(productoDAO);
			// Mostrar media precio por tipo producto y total de productos
			mostrarOperaciones(productoDAO);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void mostrarOperaciones(ProductoHibernateDAO productoDao) {
		logger.info("Entrando a mostrar las operaciones");
		List<Object[]> operaciones = productoDao.operationsProductos();
		for (Object[] operacion : operaciones) {
			System.out.println(operacion[0] + " " + operacion[1] + " " + operacion[2]);
		}
	}

	public void mostrarFecha(ProductoHibernateDAO productoDao) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String fechaStr = Utilidades.pideDatoTexto("Ingrese la fecha del producto yyyy-MM-dd ");
		Date fecha = df.parse(fechaStr);

		logger.info("fecha: " + fecha);
		List<ProductoOracle> productos = productoDao.getProductosByDate(fecha);
		logger.info("Empieza");
		for (ProductoOracle producto : productos) {
			logger.info(producto);
		}
		logger.info("Termina");
	}

	public void mostrarProductos(ProductoHibernateDAO productoDao) {
		List<ProductoOracle> productos = productoDao.getProductos();
		logger.info("Empieza");
		for (ProductoOracle producto : productos) {
			logger.info(producto);
		}
		logger.info("Termina");
	}

	public void insertarProductos(ProductoHibernateDAO productoDao) {

		List<ProductoOracle> productos;
		try {
			productos = leerFicheroProductos("./recursos/fichero_carga_ejercicio2.txt", 1);
			for (ProductoOracle productoOracle : productos) {
				productoDao.insertarProducto(productoOracle);
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<ProductoOracle> leerFicheroProductos(String rutaFichero) throws IOException, ParseException {

		return leerFicheroProductos(rutaFichero, 0);

	}

	public List<ProductoOracle> leerFicheroProductos(String rutaFichero, int skipLines)
			throws IOException, ParseException {

		Path path = Paths.get(rutaFichero);
		logger.info("rutaFichero: " + rutaFichero + " skipLines: " + skipLines);
		List<ProductoOracle> productos = new ArrayList();

		logger.info("Leyendo documento");

		List<String> lines = Files.readAllLines(path);
		int numLinea = 1;
		for (String linea : lines) {
			if (numLinea > skipLines) {
				String[] datos = linea.split("\\;");

				String nombre = datos[0];
				String tipo = datos[1];

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String fechaStr = datos[2];

				Date fechaAlta = df.parse(fechaStr);
				logger.info("Fecha alta " + fechaAlta);

				int precio = Integer.parseInt(datos[3]);
				int unidades = Integer.parseInt(datos[4]);

				ProductoOracle producto = new ProductoOracle(nombre, tipo, fechaAlta, precio, unidades);
				logger.info("Producto alta " + producto);
				productos.add(producto);

			}
			numLinea++;
		}

		return productos;
	}

}
