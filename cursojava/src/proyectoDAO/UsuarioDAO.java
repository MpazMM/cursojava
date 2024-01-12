package proyectoDAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import proyecto.Usuario;

public class UsuarioDAO {
	private EntityManager em;
	
	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<Usuario> getUsuario() {
		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}
	
	public void insertarUsuario(Usuario usuario) {
		em.getTransaction().begin();
		try {
				em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
	
	public void insertarUsuarios(List<Usuario> usuarios) {
		em.getTransaction().begin();
		try {

			for (Usuario usuario : usuarios) {
				em.persist(usuario);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
	
}
