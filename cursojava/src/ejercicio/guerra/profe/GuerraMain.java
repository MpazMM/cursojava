package ejercicio.guerra.profe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.curso.java.poo.ejercicios.guerra.excepcionts.LimiteValoresException;
import es.curso.java.poo.ejercicios.guerra.excepcionts.UnidadesPermitadasException;

public class GuerraMain {

	public static void main(String[] args) { 
		GuerraMain gm = new GuerraMain();
		gm.guerrerosEmbarcadosTryWithResources();
	}
	
	
	private List<VehiculoGuerra> generaVehiculosTryWithResources() {
		
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
		String username = "root";
		String password = "password";
		
		ArrayList<VehiculoGuerra> vehiculosBatalla = new ArrayList<VehiculoGuerra>();
		Nave nave = null;
		Tanque tanque = null;
		try (
				Connection connection = DriverManager.getConnection(url, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM TB_VEHICULOS_GUERRA");
			) {

			
			while (rs.next()) {
				if(rs.getLong("id") == 2) {
					tanque = (new Tanque(rs.getString("nombre"),rs.getInt("ataque"),rs.getInt("defensa")));
				}else {
					nave = (new Nave(rs.getString("nombre"),rs.getInt("ataque"),rs.getInt("defensa")));
				}
			}
		} catch (SQLException e) {
			System.err.println("Ha habido un error " + e.getMessage());
		} catch (LimiteValoresException e) {
				System.err.println("Ha habido una excepción "+e.getMessage());
				e.printStackTrace();
			}
		
		vehiculosBatalla.add(tanque);
		vehiculosBatalla.add(nave);

		return vehiculosBatalla;
	}
	
	
	private List<Guerrero> guerrerosEmbarcadosTryWithResources (ArrayList<VehiculoGuerra> vehiculos)   {
		
		
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
		String username = "root";
		String password = "password";
		
		ArrayList<Guerrero> guerrerosEmbarcados = new ArrayList<Guerrero>();
		Guerrero guerreroNave = null;
		Guerrero guerreroTanque = null;
		
		try (
				Connection connection = DriverManager.getConnection(url, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM TB_GUERRERO");
			) {

			
			while (rs.next()) {
				if(rs.getLong("vehiculo_id") == 1) {
					guerreroNave = (new Guerrero(rs.getString("nombre"),rs.getString("tipo"),
						rs.getInt("fuerza"),rs.getInt("resistencia")));
					vehiculos.add(guerreroNave);
				}else {
					guerreroTanque = (new Guerrero(rs.getString("nombre"),rs.getString("tipo"),
						rs.getInt("fuerza"),rs.getInt("resistencia")));
				}
			}

		} catch (SQLException e) {
			System.err.println("Ha habido un error " + e.getMessage());
			e.printStackTrace();
		}catch (LimiteValoresException lve) {
			System.err.println("Error generando guerreros " + lve.getMessage());
			lve.printStackTrace();
		}
		
		guerrerosEmbarcados.add(guerreroTanque);
		guerrerosEmbarcados.add(guerreroNave);

		return guerrerosEmbarcados;
	}

}
