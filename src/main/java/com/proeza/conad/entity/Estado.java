package com.proeza.conad.entity;
// Generated Apr 15, 2020, 4:26:15 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import static javax.persistence.GenerationType.*;

@Entity
@Immutable
@NaturalIdCache
@Table(name = "cad_estado", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Estado implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;
	private Long				id;
	private String				nombre;

	public Estado () {
	}

	public Estado (String nombre) {
		this.nombre = nombre;
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
}
