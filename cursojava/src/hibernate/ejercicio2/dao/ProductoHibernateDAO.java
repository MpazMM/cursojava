package hibernate.ejercicio2.dao;

import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class ProductoHibernateDAO {
	
	private EntityManager em;
	
	public ProductoHibernateDAO() {
		em = JpaUtil.getEM("hibernateOracle");
	}
	
	

}
