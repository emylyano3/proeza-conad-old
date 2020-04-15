package com.proeza.conad.entity;
//Generated Apr 15, 2020, 12:37:31 PM by Hibernate Tools 5.2.12.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.WhereJoinTable;

import com.proeza.security.entity.Usuario;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_inquilino")
public class Inquilino implements Serializable {

	private static final long		serialVersionUID	= 1L;

	private Long					id;
	private Usuario					usuario;
	private Cuenta					cuenta;
	private Set<UnidadFuncional>	unidadesFuncionales	= new HashSet<UnidadFuncional>(0);
	private Set<Pago>				pagos				= new HashSet<Pago>(0);

	public Inquilino () {
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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_usuario")
	public Usuario getUsuario () {
		return this.usuario;
	}

	public void setUsuario (Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cuenta")
	public Cuenta getCuenta () {
		return this.cuenta;
	}

	public void setCuenta (Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@WhereJoinTable(clause = "habilitado = 1")
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "cad_uf_inquilino",
		joinColumns = {@JoinColumn(name = "fk_inquilino")},
		inverseJoinColumns = {@JoinColumn(name = "fk_uf")})
	public Set<UnidadFuncional> getUnidadesFuncionales () {
		return this.unidadesFuncionales;
	}

	public void setUnidadesFuncionales (Set<UnidadFuncional> unidadesFuncionales) {
		this.unidadesFuncionales = unidadesFuncionales;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "cad_pago_inquilino",
		joinColumns = {@JoinColumn(name = "fk_inquilino")},
		inverseJoinColumns = {@JoinColumn(name = "fk_pago")})
	public Set<Pago> getPagos () {
		return pagos;
	}

	public void setPagos (Set<Pago> pagos) {
		this.pagos = pagos;
	}
}
