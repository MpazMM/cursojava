package hibernate.ejercicio2.dao;

import java.util.List;

import hibernate.ejercicio2.entities.UsuarioOracle;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class UsuarioHibernateDAO {

	private EntityManager em;

	public UsuarioHibernateDAO() {
		em = JpaUtil.getEM("hibernateOracle");
	}
	
	
	public List<UsuarioOracle> getUsers (){
		List<UsuarioOracle> usuarios;
		
		usuarios = em.createQuery("from UsuarioOracle", UsuarioOracle.class)
			.getResultList();
		
		return usuarios;
	}
	
	public void insertarUsuario (UsuarioOracle user) {
		 em.getTransaction().begin();
		 try {
			 em.persist(user);
			 
			 em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
		 }
	     
	}


}
