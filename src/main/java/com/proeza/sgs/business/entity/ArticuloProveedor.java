package com.proeza.sgs.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.*;

@Entity
@Table(
    name = "art_articulo_proveedor")
public class ArticuloProveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long              id;
    private Articulo          articulo;
    private Proveedor         proveedor;

    public ArticuloProveedor () {
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
    @JoinColumn(name = "fk_articulo", nullable = false)
    public Articulo getArticulo () {
        return this.articulo;
    }

    public void setArticulo (Articulo articulo) {
        this.articulo = articulo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_proveedor", nullable = false, referencedColumnName = "id")
    public Proveedor getProveedor () {
        return this.proveedor;
    }

    public void setProveedor (Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}