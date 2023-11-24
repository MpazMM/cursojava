package hibernate.ejercicio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateListar {
	
	private static final Logger logger = LogManager.getLogger(HibernateListar.class);
    public static void main(String[] args) {
    	logger.debug("Empezando");
        EntityManager em = JpaUtil.getEntityManager();
        Usuario usuario1 = new Usuario("Nombre1","Apellido1","DNI1", obtenerFechaActual());
        Usuario usuario2 = new Usuario("Nombre2","Apellido2","DNI2", obtenerFechaActual());
        Usuario usuario3 = new Usuario("Nombre3","Apellido3","DNI3", obtenerFechaActual());
        em.getTransaction().begin();
        em.persist(usuario1);
        em.persist(usuario2);
        em.persist(usuario3);
        em.getTransaction().commit();
        
        List<Usuario> usuarios = em.createQuery("from Usuario", Usuario.class).getResultList();
        usuarios.forEach(System.out::println);//Método Referencia
        //clientes.forEach(cliente->System.out.println(cliente));
        em.close();
        logger.debug("Final");
    }
    
	  private static Date obtenerFechaActual() {
	        return Calendar.getInstance().getTime();
	    }
}
