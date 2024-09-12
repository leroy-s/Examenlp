package pe.upeu.edu.Examen.entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="orden")
public class Ordenes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private String apellidos;
	
	@Column(name="fecha_orden")
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha_orden;
	
	@Column(name="fecha_solicita")
	@Temporal (TemporalType.TIMESTAMP)
	private Date fecha_solicita;
	
	@Column(name="estado")
	private char estado;
	
	@ManyToOne 
	@JoinColumn(name = "almacenes_id", nullable = false)
	private Almacenes almacenes;
	
	@ManyToOne
	@JoinColumn(name = "proveedores_id", nullable = false)
	private Proveedores proveedores;
	
	@ManyToOne
	@JoinColumn(name = "tipo_orden_id", nullable = false)
	private Tipo_orden tipo_orden;
	
	@ManyToOne
	@JoinColumn(name = "forma_pago_id", nullable = false)
	private Forma_pago forma_pago;
	
}
