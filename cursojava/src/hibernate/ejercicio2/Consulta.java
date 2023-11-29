package hibernate.ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hibernate.ejercicio.entities.Usuario;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class Consulta {
	
	private static final Logger logger = LogManager.getLogger(Consulta.class);

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEM("hibernateOracle");
        Usuario usuario1 = new Usuario("Nombre1","Apellido1","DNI1", obtenerFechaActual());
        Usuario usuario2 = new Usuario("Nombre2","Apellido2","DNI2", obtenerFechaActual());
        Usuario usuario3 = new Usuario("Nombre3","Apellido3","DNI3", obtenerFechaActual());
        Usuario usuario4 = new Usuario("Nombre4","Apellido4","DNI4", nuevaFechaActual(2014));
        
        em.getTransaction().begin();
        em.persist(usuario1);
        em.persist(usuario2);
        em.persist(usuario3);
        em.persist(usuario4);
        em.getTransaction().commit();
        
        List<UsuarioOracle> usuarios = em.createQuery("from UsuarioOracle", UsuarioOracle.class).getResultList();
        usuarios.forEach(System.out::println);//Método Referencia
        //clientes.forEach(cliente->System.out.println(cliente));
        em.close();
        logger.debug("Final");
        
		Consulta cm = new Consulta();
		UsuarioHibernateDAO userDao = new UsuarioHibernateDAO();
		cm.crearArchivo("./recursos/consultausuarios.txt",userDao);

	}


	
	public void crearArchivo(String nombre, UsuarioHibernateDAO usuarioDAO) {
		File archivo = new File(nombre);
		
		logger.info("Creando archivo");
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, false))) {

            buffer.append("ID, NOMBRE, APELLIDOS, DNI, FECHA ALTA");
            buffer.newLine();
            
			List<UsuarioOracle> usuarios = usuarioDAO.getUsers();
			Date fechaAlta;
			
			for (UsuarioOracle usuario : usuarios) {
				buffer.append(String.valueOf(usuario.getId()));
				logger.info("Incluyendo ID");
				buffer.append(usuario.getNombre());
				logger.info("Incluyendo nombre");
				buffer.append(usuario.getApellidos());
				logger.info("Incluyendo apellidos");
				buffer.append(usuario.getDni());

                fechaAlta = usuario.getFechaAlta();
                SimpleDateFormat fechaFormateada = new SimpleDateFormat("yyyyMMdd a");         
                buffer.append((String.valueOf(fechaFormateada)));
                buffer.newLine();
                logger.info(usuario.toString());

			}
			System.out.println("El archivo se ha creado con éxito!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	  private static Date obtenerFechaActual() {
	        return Calendar.getInstance().getTime();
	    }
	  
	  private static Date nuevaFechaActual(int año) {
  		Calendar c = Calendar.getInstance();
  		c.set(Calendar.YEAR,año);
  		return c.getTime();
	    }
}