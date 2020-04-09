package com.proeza.security.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;

import com.proeza.sgs.business.entity.Persona;

import static org.hibernate.annotations.CacheConcurrencyStrategy.*;

@Entity
@Table(name = "seg_usuario", uniqueConstraints = @UniqueConstraint(columnNames = "alias"))
@PrimaryKeyJoinColumn(name = "fk_persona", referencedColumnName = "id")
@Cache(usage = NONSTRICT_READ_WRITE)
public class Usuario extends Persona implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				alias;
	private String				password;
	private Set<Rol>			roles				= new HashSet<>(0);
	private Set<Login>			logins				= new HashSet<>(0);

	public Usuario () {
	}

	@Column(name = "alias", unique = true, nullable = false, length = 12)
	public String getAlias () {
		return this.alias;
	}

	public void setAlias (String alias) {
		this.alias = alias;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword () {
		return this.password;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "seg_usuario_rol", joinColumns = {@JoinColumn(name = "fk_usuario", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "fk_rol", nullable = false, updatable = false)
	})
	public Set<Rol> getRoles () {
		return this.roles;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Login> getLogins () {
		return this.logins;
	}

	public void setLogins (Set<Login> logins) {
		this.logins = logins;
	}

	public void setRoles (Set<Rol> roles) {
		this.roles = roles;
	}
}