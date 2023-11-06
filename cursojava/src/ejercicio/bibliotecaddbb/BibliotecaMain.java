package ejercicio.bibliotecaddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.curso.java.colecciones.ejercicios.guerra.VehiculoGuerra;
import es.curso.java.introduccion.utils.Utilidades;

public class BibliotecaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private List<Biblioteca> obtenerBibliotecas() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
		String username = "root";
		String password = "password";

		Connection connection = null;
		PreparedStatement prepareStament = null;
		ResultSet rs = null;

		List<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();

		try {

			System.out.println("Estableciendo conexión");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexión establecida");

			prepareStament = connection.prepareStatement("SELECT * FROM TB_BIBLIOTECA");

			rs = prepareStament.executeQuery();

			while (rs.next()) {
				long id = (rs.getLong("id"));
				String nombreBiblioteca = (rs.getString("nombre"));
				int bibliotecaDireccion = (rs.getInt("fk_direccion"));
				
				Biblioteca biblioteca = new Biblioteca(id, nombreBiblioteca, bibliotecaDireccion);
				bibliotecas.add(biblioteca);
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
		return bibliotecas;
	}

	private void iniciarMenu() throws SQLException {
		
		List<Biblioteca> bibliotecas = obtenerBibliotecas();
		int opcion = 0;
		
		do {
			int i = 1;
			for(Biblioteca biblioteca : bibliotecas){
				System.out.println(i + ". " + biblioteca.getNombreBiblioteca());
				i++;
			}
			System.out.println(bibliotecas.size() + 1 + ". Salir");
			opcion = Utilidades.pintarMenu("Indique una opción");

			switch (opcion) {
			case 1:
				submenuLibreria();
				break;
			case 2:
				submenuLibreria();
				break;
			case 3:
				submenuLibreria();
				break;
			case 4:
				System.out.println("Adios");
				cerrarConexion();
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opcion != 4);

	}

	private void submenuLibreria() {
		Biblioteca biblioteca = new Biblioteca();
		int opcion=0;
		do {
			//Pinta Menu
			String[] preguntas = {"1. Mostrar info biblioteca","2. Mostrar libros de la biblioteca ",
					"3. Buscar libro","4. Insertar libro","5. Modificar.","6.Borrar","7.Volver"};
			opcion = Utilidades.pintarMenu(preguntas, "Elige una opcion");
			
			switch (opcion) {
			case 1: infoBiblioteca(biblioteca); break;
			case 2: catalogoBiblioteca(biblioteca); break;
			case 3: buscarLibro(biblioteca); break;
			case 4: insertarLibro(biblioteca); break;
			case 5: modificarLibro(biblioteca); break;
			case 6: borrarLibro(biblioteca); break;
			case 7: volverMenu; break;
			default: System.out.println("Opción incorrecta");
			}
			
			
			
		}while(opcion!=7);
		
	}

}
