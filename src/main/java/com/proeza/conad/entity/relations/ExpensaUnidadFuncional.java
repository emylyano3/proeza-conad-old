package com.proeza.conad.entity.relations;
// Generated Apr 15, 2020, 12:37:31 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.proeza.conad.entity.Expensa;
import com.proeza.conad.entity.UnidadFuncional;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_expensa_uf")
public class ExpensaUnidadFuncional implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private Expensa				expensa;
	private UnidadFuncional		unidadFuncional;
	private boolean				habilitado;

	public ExpensaUnidadFuncional () {
	}

	public ExpensaUnidadFuncional (Expensa expensa, UnidadFuncional unidadFuncional, boolean habilitado) {
		this.expensa = expensa;
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
	@JoinColumn(name = "fk_expensa", nullable = false)
	public Expensa getExpensa () {
		return this.expensa;
	}

	public void setExpensa (Expensa expensa) {
		this.expensa = expensa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_uf", nullable = false)
	public UnidadFuncional getUnidadFuncional () {
		return this.unidadFuncional;
	}

	public void setUnidadFuncional (UnidadFuncional unidadFuncional) {
		this.unidadFuncional = unidadFuncional;
	}

	@Column(name = "habilitado", nullable = false)
	public boolean isHabilitado () {
		return this.habilitado;
	}

	public void setHabilitado (boolean habilitado) {
		this.habilitado = habilitado;
	}
}
