package proeza.mci.db;

// Generated 21/11/2012 21:44:10 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Categorias generated by hbm2java
 */
@Entity
@Table(name = "categorias", catalog = "pescalotodo")
public class Categoria implements Serializable, Comparable<Categoria> {
    private static final long serialVersionUID = 1L;

    private Integer           idCategoria;
    private String            descripcion;

    public Categoria() {
    }

    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idCategoria", unique = true, nullable = false)
    public Integer getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Column(name = "descripcion", length = 50)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }

    @Override
    public int compareTo(Categoria o) {
        if (o == null)
            return -1;
        return getDescripcion().compareTo(o.getDescripcion());
    }
}
