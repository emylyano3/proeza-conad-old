package com.proeza.conad.entity;
// Generated Apr 15, 2020, 4:26:15 PM by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_pago")
public class Pago implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;
	private Long				id;
	private BigDecimal			monto;
	private Date				fechaAlta;
	private Date				fechaRevision;
	private Documento			recibo;
	private Estado				estado;

	public Pago () {
	}

	public Pago (Estado estado, BigDecimal monto, Date fechaAlta) {
		this.estado = estado;
		this.monto = monto;
		this.fechaAlta = fechaAlta;
	}

	public Pago (Documento recibo, Estado estado, BigDecimal monto, Date fechaAlta, Date fechaRevision) {
		this.recibo = recibo;
		this.estado = estado;
		this.monto = monto;
		this.fechaAlta = fechaAlta;
		this.fechaRevision = fechaRevision;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recibo")
	public Documento getRecibo () {
		return this.recibo;
	}

	public void setRecibo (Documento recibo) {
		this.recibo = recibo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_estado", nullable = false)
	public Estado getEstado () {
		return this.estado;
	}

	public void setEstado (Estado estado) {
		this.estado = estado;
	}

	@Column(name = "monto", nullable = false, precision = 10, scale = 3)
	public BigDecimal getMonto () {
		return this.monto;
	}

	public void setMonto (BigDecimal monto) {
		this.monto = monto;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "f_alta", nullable = false, length = 10)
	public Date getFechaAlta () {
		return this.fechaAlta;
	}

	public void setFechaAlta (Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "f_revision", length = 10)
	public Date getFechaRevision () {
		return this.fechaRevision;
	}

	public void setFechaRevision (Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

}
