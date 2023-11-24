package hibernate.ejercicio;

import es.curso.java.introduccion.utils.Utilidades;
import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateEliminar {
    public static void main(String[] args) {

        String nombre = Utilidades.pideDatoTexto("Ingrese el nombre del usuario a eliminar:");
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Usuario usuario = em.find(Usuario.class, nombre);
            //Cliente cliente1 = new Cliente();
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
