package hibernate.ejercicio.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String nombre;
	
	@Column(length = 40)
	private String apellidos;
	
	@Column(length = 10, unique = true)
	private String dni;
	
	@Column
	private Date fechaAlta;

	/**
	 * 
	 */
	public Usuario() {
		super();
	}

	
	
	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param fechaAlta
	 */
	public Usuario(String nombre, String apellidos, String dni, Date fechaAlta) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
	}



	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param fechaAlta
	 */
	public Usuario(Long id, String nombre, String apellidos, String dni, Date fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Usuario [" + (id != null ? "id=" + id + ", " : "") + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellidos != null ? "apellidos=" + apellidos + ", " : "") + (dni != null ? "dni=" + dni + ", " : "")
				+ (fechaAlta != null ? "fechaAlta=" + fechaAlta : "") + "]";
	}
	
}
