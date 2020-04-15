package com.proeza.conad.entity;
// Generated Apr 15, 2020, 12:37:31 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_expensa_aplica", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class ExpensaAplica implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private String				nombre;
	private String				descripcion;

	public ExpensaAplica () {
	}

	public ExpensaAplica (String nombre) {
		this.nombre = nombre;
	}

	public ExpensaAplica (String nombre, String descripcion) {
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
