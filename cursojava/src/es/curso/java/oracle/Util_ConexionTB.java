package es.curso.java.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util_ConexionTB {
	
	private static Connection connection;
	
	public Util_ConexionTB(java.sql.Connection connection){
		super();
		this.connection = connection;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		Util_ConexionTB.connection = connection;
	}
	
	public static Connection conexion (String url, String username, String password) {
		Connection connection = null;
		
		System.out.println("Estableciendo conexion");
		
		try {
			connection = DriverManager.getConnection(url,username,password);
			System.out.println("Conexión establecida");
		}catch (SQLException e){
			e.printStackTrace();
		}
		return connection;
		
	}

}
