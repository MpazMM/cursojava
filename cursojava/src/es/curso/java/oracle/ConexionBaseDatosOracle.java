package es.curso.java.oracle;

import java.sql.Connection;

public class ConexionBaseDatosOracle {

	public static void main(String[] args) {
	
		String url = "jdbc:oracle:thin:curso/password@localhost:1521/XE";
		String username = "system";
		String password = "password";

		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conexionOracle = Util_ConexionTB.conexion(url, username, password);				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

	}
	
}
