package com.proeza.conad.entity;
// Generated Apr 11, 2020, 7:13:39 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import static javax.persistence.GenerationType.*;

@Entity
@Immutable
@Table(name = "cad_uf_tipo")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TipoUnidadFuncional implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private String				nombre;
	private String				descripcion;

	public TipoUnidadFuncional () {
	}

	public TipoUnidadFuncional (String nombre) {
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Long getId () {
		return this.id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	@NaturalId
	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre () {
		return this.nombre;
	}

	public void setNombre (String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 200)
	public String getDescripcion () {
		return this.descripcion;
	}

	public void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}
}
