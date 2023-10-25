package ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;


public class ObjetosFacilities {

	public static void main(String[] args) {
		ObjetosFacilities conexion = new ObjetosFacilities();
		conexion.generarObjeto();

	}
	
	public void generarObjeto() {
		
		String url = "jdbc:mysql://localhost:3306/curso?serverTimezone=Europe/Madrid";
	    String username = "root";
	    String password = "password";
	    
	    Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    // El linked hash set te da los registros ordenados
	    Set<Facilities> facilities = new LinkedHashSet<Facilities>();
	    
		try {
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM TB_FACILITIES");
			//Funciona como un bucle, recorre todos los datos
			while (rs.next()) {
//				Facilities facilitie1 = new Facilities(rs.getLong("id"),rs.getInt("guid"),

				facilities.add(new Facilities(rs.getLong("id"),rs.getInt("guid"),
						rs.getString("name"),rs.getString("description"),rs.getString("category")));
            }		
			
			
		} catch (SQLException e) {
//			e.printStackTrace();
		}finally {
			try {
				connection.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Facilities facility : facilities) {
			System.out.println(facility.getId() + " " + facility.getGuid() + " " 
					+ facility.getName() + " " + facility.getDescription() + " "
					+ facility.getCategory());
		}
		System.out.println("Número de registros: " + facilities.size());
	}
	
	
}
