package hibernate.ejercicio;

import es.curso.java.introduccion.utils.Utilidades;
import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class HibernateEliminar {
    public static void main(String[] args) {
        String nombre = Utilidades.pideDatoTexto("Ingrese el nombre del usuario a eliminar:");
        EntityManager em = JpaUtil.getEntityManager();
        
        try {
            // Realiza una consulta para obtener el usuario por su nombre
            Query query = em.createQuery("from Usuario u where u.nombre=?1");
            query.setParameter(1, nombre);
            Usuario usuario = (Usuario) query.getSingleResult();
            
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("No se encontró ningún usuario con el nombre proporcionado.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

