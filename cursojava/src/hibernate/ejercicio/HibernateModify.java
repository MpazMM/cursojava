package hibernate.ejercicio;

import javax.swing.JOptionPane;

import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernateModify {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();
		try {

			String dni = String.valueOf(JOptionPane.showInputDialog("Ingrese el dni del usuario a modificar:"));
			Query query = em.createQuery("from Usuario u where u.dni=?1");
            query.setParameter(1, dni);
            Usuario usuario = (Usuario) query.getSingleResult();
//			Usuario usuario = em.find(Usuario.class, dni);

			String nombre = JOptionPane.showInputDialog("Ingrese el nombre:", usuario.getNombre());
			String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos:", usuario.getApellidos());

			em.getTransaction().begin();

			if (!nombre.isEmpty()) {
				usuario.setNombre(nombre);
			}
			if (!apellidos.isEmpty()) {
				usuario.setApellidos(apellidos);
			}

			em.merge(usuario);
			em.getTransaction().commit();

			System.out.println(usuario);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
