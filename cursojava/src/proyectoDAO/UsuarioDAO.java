package proyectoDAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import proyecto.Usuario;

public class UsuarioDAO {
	private EntityManager em;

	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}

	public List<Usuario> getUsuario() {
		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}

	public List<Usuario> getUsersByName(String usuario) {
		List<Usuario> usuarios;

		Query query = em.createQuery("from Usuario ue where ue.usuario=?1", Usuario.class);
		query.setParameter(1, usuario);
		usuarios = query.getResultList();

		return usuarios;
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

	public void borrarUsuarioPorNombre(String usuario) {
		em.getTransaction().begin();
		try {
			List<Usuario> usuarios = getUsersByName(usuario);

			for (Usuario userEntity : usuarios) {
				em.remove(userEntity);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public void modificarUsuarioPorUsuario(String usuario, Usuario userModified) {

		TypedQuery<Usuario> query = em.createQuery("from UserEntity where usuario=?1", Usuario.class);
		query.setParameter(1, usuario);

		try {
			Usuario user = query.getSingleResult();
			em.getTransaction().begin();
			// user.setId(userModified.getId());
			user.setNombreUsuario(userModified.getNombreUsuario());
			user.setApellidosUsuario(userModified.getApellidosUsuario());
			user.setEmailUsuario(userModified.getEmailUsuario());
			user.setTelefono(userModified.getTelefono());

			em.merge(user);

			em.getTransaction().commit();
		} catch (NoResultException nre) {
			System.out.println("Usuario " + usuario + " no encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

}
