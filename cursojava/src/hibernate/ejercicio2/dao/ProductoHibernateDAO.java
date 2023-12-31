package hibernate.ejercicio2.dao;

import java.util.Date;
import java.util.List;

import hibernate.ejercicio2.entities.ProductoOracle;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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
	
	public List<ProductoOracle> getProductosByDate (Date fechaConsulta){
		
		TypedQuery<ProductoOracle> query = em.createQuery(
				"from ProductoOracle po where po.fechaAlta=?1", 
				ProductoOracle.class);
		
//		Query query = em.createQuery(
//				"from ProductoOracle po where po.fechaAlta=?1", 
//				ProductoOracle.class);
		
		query.setParameter(1, fechaConsulta);
		List<ProductoOracle> productos = query.getResultList();
		
		return productos;
	}
	
	public List<Object[]> operationsProductos (){
		
		List<Object[]> operations;

		Query query = em.createQuery(
				"select po.tipo, round (avg(po.precio),2) as precioMedio, sum(po.unidades) "
				+ "as totalUnidades from ProductoOracle po group by po.tipo");

		operations = query.getResultList();
		
		return operations;
	}

}
