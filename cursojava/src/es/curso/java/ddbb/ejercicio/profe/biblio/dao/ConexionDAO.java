package es.curso.java.ddbb.ejercicio.profe.biblio.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConexionDAO {
	private Connection conexion;

	public ConexionDAO() throws SQLException {
		super();
		this.conexion = UtilsDataBase.getInstance();
	}

	/**
	 * @return the conexion
	 */
	public Connection getConexion() {
		return conexion;
	}
	
	
	
}
