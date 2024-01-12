package proyecto;

import es.curso.java.hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class ProyectoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void iniciar() {
		EntityManager em = JpaUtil.getEM("hibernateOracle");
		
		
	}
	
}
