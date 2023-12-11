package hibernate.unounounidireccional;

import es.curso.java.hibernate.relations.unounounidireccional.entities.Direccion;
import es.curso.java.hibernate.util.JpaUtil;
import hibernate.unounounidireccional.entities.Biblioteca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UAUUNIANOTMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Biblioteca biblioteca1 = new Biblioteca();
		biblioteca1.setNombre("Biblioteca1");

		Biblioteca biblioteca2 = new Biblioteca();
		biblioteca2.setNombre("Biblioteca2");

		Biblioteca biblioteca3 = new Biblioteca(); 
		biblioteca3.setNombre("Biblioteca3");
	    
		Direccion direccion1 = new Direccion();
		direccion1.setCalle("Calle 1");
		direccion1.setCodigoPostal("12345");

		Direccion direccion2 = new Direccion();
		direccion2.setCalle("Calle 2");
		direccion2.setCodigoPostal("54321");

		biblioteca1.setDireccion(direccion1);
		biblioteca2.setDireccion(direccion2);

		EntityManager em = JpaUtil.getEM("hibernateOracle");
		EntityTransaction transaction = em.getTransaction();

		/*
		 * Esta direccion se agrega para comprobar que las personas tomen el
		 * mismo identificador que las direcciones
		 */
		Direccion d = new Direccion();
		d.setCalle("Calle de Prueba de identificadores");
		d.setCodigoPostal("21345");

		/*
		 * En la primera transacción la base de datos almacenamos los dos objetos
		 * Persona los objetos Direccion se almacenaran en cascada
		 */
		transaction.begin();
		em.persist(biblioteca1);
		em.persist(biblioteca2);
		em.persist(biblioteca3);
		transaction.commit();


		/*
		 * En la segunda sesion eliminamos el objeto persona1, la direccion1
		 * sera borrada en cascada
		 */
		transaction.begin();
		em.remove(biblioteca1);
		transaction.commit();
		
		System.exit(0);
	}

}
