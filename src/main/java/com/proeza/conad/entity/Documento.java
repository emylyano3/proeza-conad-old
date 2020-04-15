package com.proeza.conad.entity;
// Generated Apr 15, 2020, 4:05:48 PM by Hibernate Tools 5.2.12.Final

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static com.proeza.core.util.Constants.*;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_documento")
public class Documento implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private String				nombre;
	private String				descripcion;
	private String				mediaType;
	private Date				fechaCreacion;
	private Blob				data;

	public Documento () {
	}

	public Documento (String mediaType, Date fechaCreacion, Blob data) {
		this.mediaType = mediaType;
		this.fechaCreacion = fechaCreacion;
		this.data = data;
	}

	public Documento (String nombre, String descripcion, String mediaType, Date fechaCreacion, Blob data) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.mediaType = mediaType;
		this.fechaCreacion = fechaCreacion;
		this.data = data;
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

	@Column(name = "nombre", length = 50)
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

	@Column(name = "media_type", nullable = false, length = 50)
	public String getMediaType () {
		return this.mediaType;
	}

	public void setMediaType (String mediaType) {
		this.mediaType = mediaType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "f_creacion", nullable = false, length = 10)
	public Date getFechaCreacion () {
		return this.fechaCreacion;
	}

	public void setFechaCreacion (Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "data", length = 5 * MB, nullable = false)
	public Blob getData () {
		return this.data;
	}

	public void setData (Blob data) {
		this.data = data;
	}
}
