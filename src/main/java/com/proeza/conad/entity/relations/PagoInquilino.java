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

import com.proeza.conad.entity.Inquilino;
import com.proeza.conad.entity.Pago;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_pago_inquilino", uniqueConstraints = @UniqueConstraint(columnNames = "fk_pago"))
public class PagoInquilino implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long		id;
	private Inquilino	inquilino;
	private Pago		pago;

	public PagoInquilino () {
	}

	public PagoInquilino (Inquilino inquilino, Pago pago) {
		this.inquilino = inquilino;
		this.pago = pago;
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
	@JoinColumn(name = "fk_inquilino", nullable = false)
	public Inquilino getInquilino () {
		return this.inquilino;
	}

	public void setInquilino (Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_pago", unique = true, nullable = false)
	public Pago getPago () {
		return this.pago;
	}

	public void setPago (Pago pago) {
		this.pago = pago;
	}
}
