package com.proeza.conad.entity;
// Generated Apr 15, 2020, 12:37:31 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import static javax.persistence.GenerationType.*;

@Entity
@Immutable
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "cad_expensa_tipo", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class ExpensaTipo implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private String				nombre;
	private String				descripcion;

	public ExpensaTipo () {
	}

	public ExpensaTipo (String nombre) {
		this.nombre = nombre;
	}

	public ExpensaTipo (String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId () {
		return this.id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	@NaturalId
	@Column(name = "nombre", unique = true, nullable = false, length = 45)
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
