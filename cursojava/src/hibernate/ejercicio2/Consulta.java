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

import es.curso.java.hibernateprofe.ejercicios.ejercicio1.dao.UserDao;
import es.curso.java.hibernateprofe.ejercicios.ejercicio1.entity.UserEntity;
import hibernate.ejercicio.entities.Usuario;
import hibernate.ejercicio2.dao.UsuarioHibernateDAO;
import hibernate.ejercicio2.entities.UsuarioOracle;
import hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class Consulta {

	private static final Logger logger = LogManager.getLogger(Consulta.class);

	public static void main(String[] args) {
		Consulta cm = new Consulta();
		UsuarioHibernateDAO userDAO = new UsuarioHibernateDAO();
		userDAO.insertarUsuario(new UsuarioOracle("Nombre1", "Apellido1", "DNI1", obtenerFechaActual()));
		userDAO.insertarUsuario(new UsuarioOracle("Nombre2", "Apellido2", "DNI2", obtenerFechaActual()));
		userDAO.insertarUsuario(new UsuarioOracle("Nombre3", "Apellido3", "DNI3", obtenerFechaActual()));
		userDAO.insertarUsuario(new UsuarioOracle("Nombre4", "Apellido4", "DNI4", nuevaFechaActual(2014)));
		
		cm.parte1(userDAO);
		cm.crearArchivo("./recursos/consultausuarios.txt", userDAO);

	}
	
	public void parte1 (UsuarioHibernateDAO userDao) {
		List<UsuarioOracle> usuarios = userDao.getUsers();
		logger.info("Empieza");
		for (UsuarioOracle userEntity : usuarios) {
			logger.info(userEntity);
		}
		logger.info("Termina");
	}

	public void crearArchivo(String nombre, UsuarioHibernateDAO usuarioDAO) {
		File archivo = new File(nombre);

		logger.info("Creando archivo");
		
		//El false es para sobreescribir con el append
		//Añadir la información
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, false))) {

			buffer.append("ID, NOMBRE, APELLIDOS, DNI, FECHA ALTA");
			buffer.newLine();

			List<UsuarioOracle> usuarios = usuarioDAO.getUsers();

			for (UsuarioOracle usuario : usuarios) {
				buffer.append(String.valueOf(usuario.getId()) + "\t");
				logger.info("Incluyendo ID");
				buffer.append(usuario.getNombre() + "\t");
				logger.info("Incluyendo nombre");
				buffer.append(usuario.getApellidos() + "\t");
				logger.info("Incluyendo apellidos");
				buffer.append(usuario.getDni() + "\t");

//				fechaAlta = usuario.getFechaAlta();
				SimpleDateFormat fechaFormateada = new SimpleDateFormat("yyyyMMdd");
				String fechaStr = fechaFormateada.format(usuario.getFechaAlta());
				buffer.append(fechaStr);
				buffer.newLine();
				logger.info(usuario.toString());

			}
			logger.info("El archivo se ha creado con éxito");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static Date obtenerFechaActual() {
		return Calendar.getInstance().getTime();
	}

	private static Date nuevaFechaActual(int año) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, año);
		return c.getTime();
	}
}