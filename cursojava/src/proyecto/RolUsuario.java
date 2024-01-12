package proyecto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_ROLUSUARIO")
public class RolUsuario {

	@Id
	@SequenceGenerator(name="DIRECCIONESGEN", sequenceName="DIRECCIONES_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIRECCIONESGEN")
	@Column(name="ID", nullable=false, updatable=false)
    private long id;
    private String rolUsuario;
	/**
	 * 
	 */
	public RolUsuario() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRolUsuario() {
		return rolUsuario;
	}
	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
	@Override
	public String toString() {
		return "RolUsuario [id=" + id + ", " + (rolUsuario != null ? "rolUsuario=" + rolUsuario : "") + "]";
	}

 


}
