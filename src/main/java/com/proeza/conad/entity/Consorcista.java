package com.proeza.conad.entity;
// Generated Apr 11, 2020, 7:13:39 PM by Hibernate Tools 5.2.12.Final

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.WhereJoinTable;

import com.proeza.security.entity.Usuario;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "cad_consorcista")
public class Consorcista implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private Usuario				usuario;
	private Set<Consorcio>		consorcios			= new HashSet<Consorcio>(0);

	public Consorcista () {
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

	@WhereJoinTable(clause = "habilitado = 1")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "cad_consorcio_consorcista",
		joinColumns = {@JoinColumn(name = "fk_consorcista", nullable = false, updatable = false)},
		inverseJoinColumns = {@JoinColumn(name = "fk_consorcio", nullable = false, updatable = false)
		})
	public Set<Consorcio> getConsorcios () {
		return this.consorcios;
	}

	public void setConsorcios (Set<Consorcio> consorcios) {
		this.consorcios = consorcios;
	}
}
