package hibernate.ejercicio2;

import java.util.List;

import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class UsuarioHibernateDAO {

	private EntityManager em;

	public UsuarioHibernateDAO() {
		em = JpaUtil.getEM("hibernateOracle");
	}
	
	
	public List<UsuarioOracle> getUsers (){
		List<UsuarioOracle> usuarios;
		
		usuarios = em.createQuery("from Usuario", UsuarioOracle.class)
			.getResultList();
		
		return usuarios;
	}
	
	
}
