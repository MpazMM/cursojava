package hibernate.ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consulta {
	
	private static final Logger logger = LogManager.getLogger(Consulta.class);

	public static void main(String[] args) {
		
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

}
