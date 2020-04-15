package com.proeza.conad.entity;
// Generated Apr 15, 2020, 12:37:31 PM by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.WhereJoinTable;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_expensa")
public class Expensa implements java.io.Serializable {

	private static final long		serialVersionUID	= 1L;

	private Long					id;
	private String					nombre;
	private String					descripcion;
	private BigDecimal				valor;
	private Date					creacion;
	private Date					vigencia;
	private Integer					duracion;
	private Consorcio				consorcio;
	private ExpensaAplica			expensaAplica;
	private ExpensaTipo				expensaTipo;
	private Set<UnidadFuncional>	unidadesFuncionales	= new HashSet<>(0);
	private boolean					habilitado;

	public Expensa () {
	}

	public Expensa (Consorcio consorcio, ExpensaAplica expensaAplica, ExpensaTipo expensaTipo, String nombre, BigDecimal valor, Date creacion, Date vigencia, boolean habilitado) {
		this.consorcio = consorcio;
		this.expensaAplica = expensaAplica;
		this.expensaTipo = expensaTipo;
		this.nombre = nombre;
		this.valor = valor;
		this.creacion = creacion;
		this.vigencia = vigencia;
		this.habilitado = habilitado;
	}

	public Expensa (Consorcio consorcio, ExpensaAplica expensaAplica, ExpensaTipo expensaTipo, String nombre, String descripcion, BigDecimal valor, Date creacion, Date vigencia, Integer duracion, boolean habilitado) {
		this.consorcio = consorcio;
		this.expensaAplica = expensaAplica;
		this.expensaTipo = expensaTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.creacion = creacion;
		this.vigencia = vigencia;
		this.duracion = duracion;
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
	@JoinColumn(name = "fk_consorcio", nullable = false)
	public Consorcio getConsorcio () {
		return this.consorcio;
	}

	public void setConsorcio (Consorcio consorcio) {
		this.consorcio = consorcio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_aplica", nullable = false)
	public ExpensaAplica getExpensaAplica () {
		return this.expensaAplica;
	}

	public void setExpensaAplica (ExpensaAplica expensaAplica) {
		this.expensaAplica = expensaAplica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tipo", nullable = false)
	public ExpensaTipo getExpensaTipo () {
		return this.expensaTipo;
	}

	public void setExpensaTipo (ExpensaTipo expensaTipo) {
		this.expensaTipo = expensaTipo;
	}

	@Column(name = "nombre", nullable = false, length = 50)
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

	@Column(name = "valor", nullable = false, precision = 10, scale = 3)
	public BigDecimal getValor () {
		return this.valor;
	}

	public void setValor (BigDecimal valor) {
		this.valor = valor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "creacion", nullable = false, length = 10)
	public Date getCreacion () {
		return this.creacion;
	}

	public void setCreacion (Date creacion) {
		this.creacion = creacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "vigencia", nullable = false, length = 10)
	public Date getVigencia () {
		return this.vigencia;
	}

	public void setVigencia (Date vigencia) {
		this.vigencia = vigencia;
	}

	@Column(name = "duracion")
	public Integer getDuracion () {
		return this.duracion;
	}

	public void setDuracion (Integer duracion) {
		this.duracion = duracion;
	}

	@WhereJoinTable(clause = "habilitado = 1")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "cad_expensa_uf",
		joinColumns = {@JoinColumn(name = "fk_expensa", nullable = false, updatable = false)},
		inverseJoinColumns = {@JoinColumn(name = "fk_uf", nullable = false, updatable = false)})
	public Set<UnidadFuncional> getUnidadesFuncionales () {
		return this.unidadesFuncionales;
	}

	public void setUnidadesFuncionales (Set<UnidadFuncional> unidadesFuncionales) {
		this.unidadesFuncionales = unidadesFuncionales;
	}

	@Column(name = "habilitado", nullable = false, columnDefinition = "BIT")
	public boolean isHabilitado () {
		return this.habilitado;
	}

	public void setHabilitado (boolean habilitado) {
		this.habilitado = habilitado;
	}
}
