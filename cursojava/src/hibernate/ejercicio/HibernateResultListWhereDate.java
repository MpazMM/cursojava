package hibernate.ejercicio;

import java.util.List;
import java.util.Scanner;

import es.curso.java.introduccion.utils.Utilidades;
import hibernate.basics.entities.Cliente;
import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernateResultListWhereDate {
	
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("from Usuario u where u.nombre=?1", Usuario.class);
        String nombre = Utilidades.pideDatoTexto("Ingrese el nombre: ");
       
        query.setParameter(1, nombre);
//        query.setMaxResults(1);
        List<Usuario> usuarios = query.getResultList();
        usuarios.forEach(usuario->System.out.println(usuario));
        em.close();
    }
	
}
