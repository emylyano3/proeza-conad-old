package com.proeza.conad.entity;
// Generated Apr 13, 2020, 10:45:32 PM by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_cuenta")
public class Cuenta implements java.io.Serializable {

	private static final long		serialVersionUID	= 1L;

	private Long					id;
	private BigDecimal				saldo;
	private boolean					habilitado;
	private Set<MovimientoCuenta>	movimientos			= new HashSet<MovimientoCuenta>(0);

	public Cuenta () {
	}

	public Cuenta (BigDecimal saldo, boolean habilitado) {
		this.saldo = saldo;
		this.habilitado = habilitado;
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

	@Column(name = "saldo", nullable = false, precision = 10, scale = 3)
	public BigDecimal getSaldo () {
		return this.saldo;
	}

	public void setSaldo (BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Column(name = "habilitado", nullable = false, columnDefinition = "BIT")
	public boolean isHabilitado () {
		return this.habilitado;
	}

	public void setHabilitado (boolean habilitado) {
		this.habilitado = habilitado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
	public Set<MovimientoCuenta> getMovimientos () {
		return this.movimientos;
	}

	public void setMovimientos (Set<MovimientoCuenta> movimientoCuentas) {
		this.movimientos = movimientoCuentas;
	}
}
