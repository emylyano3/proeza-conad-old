package com.proeza.conad.entity;
// Generated Apr 11, 2020, 7:13:39 PM by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.WhereJoinTable;

import com.proeza.conad.entity.relations.UnidadFuncionalInquilino;
import com.proeza.conad.entity.relations.UnidadFuncionalPropietario;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_unidad_funcional")
public class UnidadFuncional implements java.io.Serializable {
	private static final long				serialVersionUID	= 1L;

	public static final String				UF_DEPTO			= "UFDPTO";
	public static final String				UF_COCHE			= "UFCOCH";

	private Long							id;
	private String							codigo;
	private BigDecimal						incidencia;
	private boolean							habilitado;
	private Consorcio						consorcio;
	private TipoUnidadFuncional				tipoUnidadFuncional;
	private Set<Expensa>					expensas			= new HashSet<Expensa>(0);
	private Set<UnidadFuncionalPropietario>	propietarios		= new HashSet<UnidadFuncionalPropietario>(0);
	private Set<UnidadFuncionalInquilino>	inquilinos			= new HashSet<UnidadFuncionalInquilino>(0);

	public UnidadFuncional () {
	}

	public UnidadFuncional (Consorcio consorcio, TipoUnidadFuncional tipoUnidadFuncional, String codigo) {
		this.consorcio = consorcio;
		this.tipoUnidadFuncional = tipoUnidadFuncional;
		this.codigo = codigo;
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
	@JoinColumn(name = "fk_consorcio", nullable = false)
	public Consorcio getConsorcio () {
		return this.consorcio;
	}

	public void setConsorcio (Consorcio consorcio) {
		this.consorcio = consorcio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tipo", nullable = false)
	public TipoUnidadFuncional getTipoUnidadFuncional () {
		return this.tipoUnidadFuncional;
	}

	public void setTipoUnidadFuncional (TipoUnidadFuncional tipoUnidadFuncional) {
		this.tipoUnidadFuncional = tipoUnidadFuncional;
	}

	@Column(name = "codigo", nullable = false, length = 20)
	public String getCodigo () {
		return this.codigo;
	}

	public void setCodigo (String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "incidencia", nullable = false, precision = 10, scale = 3)
	public BigDecimal getIncidencia () {
		return this.incidencia;
	}

	public void setIncidencia (BigDecimal incidencia) {
		this.incidencia = incidencia;
	}

	@Column(name = "habilitado", nullable = false, columnDefinition = "BIT")
	public boolean isHabilitado () {
		return this.habilitado;
	}

	public void setHabilitado (boolean habilitado) {
		this.habilitado = habilitado;
	}

	@WhereJoinTable(clause = "habilitado = 1")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "cad_expensa_uf",
		joinColumns = {@JoinColumn(name = "fk_uf", nullable = false, updatable = false)},
		inverseJoinColumns = {@JoinColumn(name = "fk_expensa", nullable = false, updatable = false)})
	public Set<Expensa> getExpensas () {
		return this.expensas;
	}

	public void setExpensas (Set<Expensa> expensas) {
		this.expensas = expensas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadFuncional")
	Set<UnidadFuncionalPropietario> getPropietarios () {
		return this.propietarios;
	}

	void setPropietarios (Set<UnidadFuncionalPropietario> propietarios) {
		this.propietarios = propietarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadFuncional")
	Set<UnidadFuncionalInquilino> getInquilinos () {
		return this.inquilinos;
	}

	void setInquilinos (Set<UnidadFuncionalInquilino> inquilinos) {
		this.inquilinos = inquilinos;
	}

	@Transient
	public Inquilino getInquilino () {
		for (UnidadFuncionalInquilino ufi : this.inquilinos) {
			if (ufi.isHabilitado()) {
				return ufi.getInquilino();
			}
		}
		return null;
	}

	@Transient
	public Propietario getPropietario () {
		for (UnidadFuncionalPropietario ufp : this.propietarios) {
			if (ufp.isHabilitado()) {
				return ufp.getPropietario();
			}
		}
		return null;
	}
}
