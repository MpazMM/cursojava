package hibernate.unounounidireccional.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="TB_BIBLIOTECAS")
public class Biblioteca implements Serializable
{
	@Id
	@SequenceGenerator(name="BIBLIOTECASGEN", sequenceName="BIBLIOTECAS_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BIBLIOTECASGEN")
	@Column(name="ID", nullable=false, updatable=false)
    private long id;
    private String nombre;
    @OneToOne (cascade={CascadeType.ALL})
    @JoinColumn (name = "FK_DIR", foreignKey = @ForeignKey (name = "FK_DIRECCION"))//El nombre de la Foreign Key es FK_DIRECCION y de la columna FK_DIR
    private Direccion direccion;

    public Biblioteca()
    {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


    
}
