package es.curso.java.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FicherosBibliotecas {


	public static void main(String[] args) {
		FicherosBibliotecas bibliotecas = new FicherosBibliotecas();
		try {
			bibliotecas.insertarDirecciones("./directorios2/bibliotecas.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public void insertarBibliotecas(String rutaFichero) throws IOException {

		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
		String username = "root";
		String password = "password";

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		try {

			System.out.println("Estableciendo conexión");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexión establecida");

			Path path = Paths.get(rutaFichero);
			List<String> lines = Files.readAllLines(path);
			
			

			for (String linea : lines) {
				String[] datos = linea.split("\\|");

				String tipo = datos[0];
				String nombre = datos[1];
				String ciudad = datos[2];
				String provincia = datos[3];
				int codPostal = Integer.parseInt(datos[4]);
				String nomBiblioteca = datos[5];
				
				

				String insert = "INSERT INTO TB_BIBLIOTECA " + "(TIPO_DIRECCION,DIRECCION,CIUDAD,PROVINCIA,CP) "
						+ "VALUES (?,?,?,?,?)";

				prepareStament = connection.prepareStatement(insert);
				prepareStament.setString(1, tipo);
				prepareStament.setString(2, nombre);
				prepareStament.setString(3, ciudad);
				prepareStament.setString(4, provincia);
				prepareStament.setInt(5, codPostal);

				boolean insertado = prepareStament.execute();
				System.out.println("Insertado: " + insertado);
			}

		} catch (SQLException e) {
			System.err.println("Ha habido un error " + e.getMessage());

		} finally {

			try {
				if (connection != null) {
					connection.close();
				}
				if (prepareStament != null)
					prepareStament.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void insertarDirecciones(String rutaFichero) throws IOException{
		
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
		String username = "root";
		String password = "password";

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		try {

			System.out.println("Estableciendo conexión");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexión establecida");

			Path path = Paths.get(rutaFichero);
			List<String> lines = Files.readAllLines(path);
			
			
			for (String linea : lines) {
					String[] datos = linea.split("\\|");
					
					String tipo = datos[0];
					String nombre = datos[1];
					String ciudad = datos[2];
					String provincia = datos[3];
					int codPostal = Integer.parseInt(datos[4]);
					
					String insert = "INSERT INTO TB_DIRECCION " + "(TIPO_DIRECCION,DIRECCION,CIUDAD,PROVINCIA,CP) " + "VALUES (?,?,?,?,?)";

					prepareStament = connection.prepareStatement(insert);
					prepareStament.setString(1, tipo);
					prepareStament.setString(2, nombre);
					prepareStament.setString(3, ciudad);
					prepareStament.setString(4, provincia);
					prepareStament.setInt(5,codPostal);
					
					boolean insertado = prepareStament.execute();
					System.out.println("Insertado: " + insertado);
			}

		} catch (SQLException e) {
			System.err.println("Ha habido un error " + e.getMessage());

		} finally {

			try {
				if (connection != null) {
					connection.close();
				}
				if (prepareStament != null)
					prepareStament.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
		

}
