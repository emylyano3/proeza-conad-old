package com.proeza.conad.entity;
// Generated Apr 11, 2020, 7:13:39 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.proeza.core.entity.Direccion;

/**
 * Consorcio generated by hbm2java
 */
@Entity
@Table(name = "cad_consorcio")
public class Consorcio implements java.io.Serializable {

	private static final long		serialVersionUID	= 1L;

	private Long					id;
	private String					nombre;
	private String					descripcion;
	private String					email;
	private int						estado;
	private Direccion				direccion;
	private Set<Consorcista>		consorcistas		= new HashSet<Consorcista>(0);
	private Set<UnidadFuncional>	unidadesFuncionales	= new HashSet<UnidadFuncional>(0);
	// private Set<Propietario> propietarios = new HashSet<Propietario>(0);
	// private Set<Inquilino> inquilinos = new HashSet<Inquilino>(0);

	public Consorcio () {
	}

	public Consorcio (long id, Direccion direccion, String nombre, String email, int estado) {
		this.id = id;
		this.direccion = direccion;
		this.nombre = nombre;
		this.email = email;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId () {
		return this.id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_direccion", nullable = false)
	public Direccion getDireccion () {
		return this.direccion;
	}

	public void setDireccion (Direccion direccion) {
		this.direccion = direccion;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre () {
		return this.nombre;
	}

	public void setNombre (String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 1000)
	public String getDescripcion () {
		return this.descripcion;
	}

	public void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "email", nullable = false, length = 200)
	public String getEmail () {
		return this.email;
	}

	public void setEmail (String email) {
		this.email = email;
	}

	@Column(name = "estado", nullable = false)
	public int getEstado () {
		return this.estado;
	}

	public void setEstado (int estado) {
		this.estado = estado;
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "consorcio")
	// public Set<Propietario> getPropietarios () {
	// return this.propietarios;
	// }
	//
	// public void setPropietarios (Set<Propietario> propietarios) {
	// this.propietarios = propietarios;
	// }

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "cad_consorcio_consorcista",
		joinColumns = {@JoinColumn(name = "fk_consorcio", nullable = false, updatable = false)},
		inverseJoinColumns = {@JoinColumn(name = "fk_consorcista", nullable = false, updatable = false)
		})
	public Set<Consorcista> getConsorcistas () {
		return this.consorcistas;
	}

	public void setConsorcistas (Set<Consorcista> consorcistas) {
		this.consorcistas = consorcistas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "consorcio")
	public Set<UnidadFuncional> getUnidadesFuncionales () {
		return this.unidadesFuncionales;
	}

	public void setUnidadesFuncionales (Set<UnidadFuncional> unidadesFuncionales) {
		this.unidadesFuncionales = unidadesFuncionales;
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "consorcio")
	// public Set<Inquilino> getInquilinos () {
	// return this.inquilinos;
	// }
	//
	// public void setInquilinos (Set<Inquilino> inquilinos) {
	// this.inquilinos = inquilinos;
	// }
}
