package hibernate.ejercicio.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UsuarioHibernateDAO {

	private static final Logger logger = LogManager.getLogger(UsuarioHibernateDAO.class);
	private static EntityManager em = JpaUtil.getEntityManager();


	public static List<Usuario> listarUsuarios() {
		logger.debug("Listando usuarios");
		List<Usuario> usuarios = em.createQuery("from Alumno", Usuario.class).getResultList();
		usuarios.forEach(usuario -> logger.trace(usuario));// Método Referencia

		logger.debug("Numero de alumnos" + usuarios.size());
		return usuarios;
	}

	public static Usuario buscarPorNombre(String nombre) {
		logger.debug("buscarPorNombre " + nombre);
		Usuario usuario = em.find(Usuario.class, nombre);

		logger.debug("Usuario encontrado " + usuario);
		return usuario;
	}

	public static Usuario buscarPorFecha(Date fecha) {
		logger.debug("buscarPorFecha " + fecha);
		Query query = em.createQuery("from Alumno a where a.dni=?1", Usuario.class);
		query.setParameter(1, fecha);

		Usuario usuario = null;
		try {
			usuario = (Usuario) query.getSingleResult();
		}catch(NoResultException nre) {
			logger.error("No se ha econtrado altas en esa fecha "+ fecha);
		}
		
		return usuario;

	}
}
