package hibernate.ejercicio;

import java.util.List;

import es.curso.java.introduccion.utils.Utilidades;
import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernateResultListWhereName {
    public static void main(String[] args) {


        EntityManager em = JpaUtil.getEntityManager();
        int fecha = Utilidades.pideDatoNumerico("Ingrese el año: ");
        Query query = em.createQuery("from Usuario u where u.fechaAlta=?1", Usuario.class);
       
        query.setParameter(1, fecha);
//        query.setMaxResults(1);
        List<Usuario> usuarios = query.getResultList();
        usuarios.forEach(usuario->System.out.println(usuario));
        em.close();
    }
}
