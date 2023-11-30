package hibernate.ejercicio2.dao;

import java.util.List;

import hibernate.ejercicio2.entities.ProductoOracle;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class ProductoHibernateDAO {
	
	private EntityManager em;
	
	public ProductoHibernateDAO() {
		em = JpaUtil.getEM("hibernateOracle");
	}
	
	public ProductoHibernateDAO(String persitenceUnitName) {
		em = JpaUtil.getEM(persitenceUnitName);
	}
	
	public ProductoHibernateDAO(EntityManager em) {
		this.em = em;
	}
	
	public void insertarProducto (ProductoOracle producto) {
		 em.getTransaction().begin();
		 try {
			 em.persist(producto);
			 em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
		 }
	     
	}
	
	public List<ProductoOracle> getProductos (){
		List<ProductoOracle> productos;
		
		productos = em.createQuery("from ProductoOracle", ProductoOracle.class)
			.getResultList();
		
		return productos;
	}

}
