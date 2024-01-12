package proyecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_USUARIOPROYECTO")
public class Usuario {

	@Id
	@SequenceGenerator(name="USUARIOGEN", sequenceName="USUARIOS_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOGEN")
	@Column(name="ID", nullable=false, updatable=false)
	private long idUsuario;
	private String usuario;
	private String nombreUsuario;
	private String apellidosUsuario;
	private String dniUsuario;
	private String sexo;
	private String password;
	private String emailUsuario;
	private int telefono;
	private Date fechaNacimiento;
	@ManyToMany
	    @JoinColumn (name = "FK_ROLUSUARIO", foreignKey = @ForeignKey (name = "FK_ROLUSUARIO"))
	    private List<RolUsuario> rolesUsuario = new ArrayList<RolUsuario>();
	
	/**
	 * 
	 */
	public Usuario() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<RolUsuario> getRolesUsuario() {
		return rolesUsuario;
	}

	public void setRolesUsuario(List<RolUsuario> rolesUsuario) {
		this.rolesUsuario = rolesUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", " + (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (nombreUsuario != null ? "nombreUsuario=" + nombreUsuario + ", " : "")
				+ (apellidosUsuario != null ? "apellidosUsuario=" + apellidosUsuario + ", " : "")
				+ (dniUsuario != null ? "dniUsuario=" + dniUsuario + ", " : "")
				+ (sexo != null ? "sexo=" + sexo + ", " : "") + (password != null ? "password=" + password + ", " : "")
				+ (emailUsuario != null ? "emailUsuario=" + emailUsuario + ", " : "") + "telefono=" + telefono + ", "
				+ (fechaNacimiento != null ? "fechaNacimiento=" + fechaNacimiento + ", " : "")
				+ (rolesUsuario != null ? "rolesUsuario=" + rolesUsuario : "") + "]";
	}


	
}
