package com.proeza.conad.entity.relations;
// Generated Apr 15, 2020, 8:45:40 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.proeza.conad.entity.Pago;
import com.proeza.conad.entity.Propietario;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_pago_propietario", uniqueConstraints = @UniqueConstraint(columnNames = "fk_pago"))
public class PagoPropietario implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private Pago				pago;
	private Propietario			propietario;

	public PagoPropietario () {
	}

	public PagoPropietario (Pago pago, Propietario propietario) {
		this.pago = pago;
		this.propietario = propietario;
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
	@JoinColumn(name = "fk_pago", unique = true, nullable = false)
	public Pago getPago () {
		return this.pago;
	}

	public void setPago (Pago pago) {
		this.pago = pago;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_propietario", nullable = false)
	public Propietario getPropietario () {
		return this.propietario;
	}

	public void setPropietario (Propietario propietario) {
		this.propietario = propietario;
	}

}
