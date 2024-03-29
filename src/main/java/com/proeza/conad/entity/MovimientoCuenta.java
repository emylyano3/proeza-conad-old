package com.proeza.conad.entity;
// Generated Apr 13, 2020, 10:45:32 PM by Hibernate Tools 5.2.12.Final

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
@Table(name = "cad_cuenta_movimiento")
public class MovimientoCuenta implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private Cuenta				cuenta;
	private BigDecimal			monto;
	private Date				fecha;

	public MovimientoCuenta () {
	}

	public MovimientoCuenta (Cuenta cuenta, BigDecimal monto, Date fecha) {
		this.cuenta = cuenta;
		this.monto = monto;
		this.fecha = fecha;
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
	@JoinColumn(name = "fk_cuenta", nullable = false)
	public Cuenta getCuenta () {
		return this.cuenta;
	}

	public void setCuenta (Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Column(name = "monto", nullable = false, precision = 10, scale = 3)
	public BigDecimal getMonto () {
		return this.monto;
	}

	public void setMonto (BigDecimal monto) {
		this.monto = monto;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	public Date getFecha () {
		return this.fecha;
	}

	public void setFecha (Date fecha) {
		this.fecha = fecha;
	}

}
