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

import com.proeza.conad.entity.Inquilino;
import com.proeza.conad.entity.UnidadFuncional;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_uf_inquilino")
public class UnidadFuncionalInquilino implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private Inquilino			inquilino;
	private UnidadFuncional		unidadFuncional;
	private boolean				habilitado;

	public UnidadFuncionalInquilino () {
	}

	public UnidadFuncionalInquilino (Inquilino inquilino, UnidadFuncional unidadFuncional, boolean habilitado) {
		this.inquilino = inquilino;
		this.unidadFuncional = unidadFuncional;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_inquilino", nullable = false)
	public Inquilino getInquilino () {
		return this.inquilino;
	}

	public void setInquilino (Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_uf", nullable = false)
	public UnidadFuncional getUnidadFuncional () {
		return this.unidadFuncional;
	}

	public void setUnidadFuncional (UnidadFuncional unidadFuncional) {
		this.unidadFuncional = unidadFuncional;
	}

	@Column(name = "habilitado", nullable = false, columnDefinition = "BIT")
	public boolean isHabilitado () {
		return this.habilitado;
	}

	public void setHabilitado (boolean habilitado) {
		this.habilitado = habilitado;
	}
}
