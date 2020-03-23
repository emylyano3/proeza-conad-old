package com.proeza.core.tracking.entity;

// Generated 23/08/2014 10:46:17 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.*;

/**
 * Movimiento generated by hbm2java
 */
@Entity
@Table(name = "cmn_movimiento")
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long              id;
    private String            tipoMov;
    private Long              idEntidad;
    private String            tipoEntidad;
    private Date              fecha;
    private String            valorAnte;
    private String            valorPost;

    public Movimiento () {
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false, length = 10)
    public Date getFecha () {
        return this.fecha;
    }

    public void setFecha (Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "valor_ant", length = 100)
    public String getValorAnte () {
        return this.valorAnte;
    }

    public void setValorAnte (String valor) {
        this.valorAnte = valor;
    }

    @Column(name = "valor_post", nullable = false, length = 100)
    public String getValorPost () {
        return this.valorPost;
    }

    public void setValorPost (String valor) {
        this.valorPost = valor;
    }

    @Column(name = "tipo_mov", nullable = false, length = 15)
    public String getTipoMov () {
        return this.tipoMov;
    }

    public void setTipoMov (String tipo) {
        this.tipoMov = tipo;
    }

    @Column(name = "fk_entidad", nullable = false)
    public Long getIdEntidad () {
        return this.idEntidad;
    }

    public void setIdEntidad (Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    @Column(name = "tipo_entidad", nullable = false, length = 15)
    public String getTipoEntidad () {
        return this.tipoEntidad;
    }

    public void setTipoEntidad (String tipo) {
        this.tipoEntidad = tipo;
    }

    @Override
    public String toString () {
        return "Movimiento [id=" + this.id + ", tipoMov=" + this.tipoMov + ", tipoEntidad=" + this.tipoEntidad + ", valorAnte=" + this.valorAnte + ", valorPost=" + this.valorPost + "]";
    }
}