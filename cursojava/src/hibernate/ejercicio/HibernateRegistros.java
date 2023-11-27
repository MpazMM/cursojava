package hibernate.ejercicio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateRegistros {
		
		private static final Logger logger = LogManager.getLogger(HibernateListar.class);
		
	    public static void main(String[] args) {
	    	logger.debug("Empezando");
	        EntityManager em = JpaUtil.getEntityManager();
	        
	        List<Usuario> usuarios = em.createQuery("from Usuario", Usuario.class).getResultList();
	        usuarios.forEach(System.out::println);
	        em.close();
	        logger.debug("Final");
	    }

}
