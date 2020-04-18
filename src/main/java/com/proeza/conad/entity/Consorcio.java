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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.WhereJoinTable;

import com.proeza.core.entity.Direccion;

@Entity
@Table(name = "cad_consorcio", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Consorcio implements java.io.Serializable {

	private static final long		serialVersionUID	= 1L;

	private Long					id;
	private String					nombre;
	private String					descripcion;
	private String					email;
	private boolean					habilitado			= true;
	private Direccion				direccion;
	private Set<Consorcista>		consorcistas		= new HashSet<Consorcista>(0);
	private Set<UnidadFuncional>	unidadesFuncionales	= new HashSet<UnidadFuncional>(0);

	public Consorcio () {
	}

	public Consorcio (long id, Direccion direccion, String nombre, String email, boolean habilitado) {
		this.id = id;
		this.direccion = direccion;
		this.nombre = nombre;
		this.email = email;
		this.habilitado = habilitado;
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

	@Cascade(CascadeType.PERSIST)
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

	@Column(name = "habilitado", nullable = false, columnDefinition = "BIT")
	public boolean isHabilitado () {
		return this.habilitado;
	}

	public void setHabilitado (boolean habilitado) {
		this.habilitado = habilitado;
	}

	@WhereJoinTable(clause = "habilitado = 1")
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
}
