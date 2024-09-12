package pe.upeu.edu.Examen.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="proveedor")
public class Proveedores {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="ruc", length = 24)
	private String ruc;
	@Column(name="razon_social", length = 50)
	private String razon_social;
	@Column(name="contacto", length = 50)
	private String contacto;
	@Column(name="telefono", length = 9)
	private String telefono;
	@Column(name="estado")
	private char estado;
	
	@OneToMany(cascade=CascadeType.ALL, fetch =FetchType.LAZY,mappedBy = "proveedores")
	@JsonIgnore
	private Set<Ordenes> ordenes;
	
}
