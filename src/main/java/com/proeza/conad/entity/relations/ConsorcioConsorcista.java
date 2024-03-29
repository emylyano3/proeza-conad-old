package com.proeza.conad.entity.relations;
// Generated Apr 11, 2020, 7:13:39 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.proeza.conad.entity.Consorcio;
import com.proeza.conad.entity.Consorcista;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_consorcio_consorcista", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class ConsorcioConsorcista implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private Consorcio			consorcio;
	private Consorcista			consorcista;
	private boolean				habilitado;

	public ConsorcioConsorcista () {
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
	@JoinColumn(name = "fk_consorcio", nullable = false, insertable = false, updatable = false)
	public Consorcio getConsorcio () {
		return this.consorcio;
	}

	public void setConsorcio (Consorcio consorcio) {
		this.consorcio = consorcio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_consorcista", nullable = false, insertable = false, updatable = false)
	public Consorcista getConsorcista () {
		return this.consorcista;
	}

	public void setConsorcista (Consorcista consorcista) {
		this.consorcista = consorcista;
	}

	@Column(name = "habilitado", nullable = false, columnDefinition = "BIT")
	public boolean isHabilitado () {
		return this.habilitado;
	}

	public void setHabilitado (boolean habilitado) {
		this.habilitado = habilitado;
	}
}
