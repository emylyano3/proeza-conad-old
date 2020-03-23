package proeza.mci.db;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static javax.persistence.GenerationType.*;

/**
 * Articulos generated by hbm2java
 */
@Entity
@Table(name = "articulos", catalog = "pescalotodo")
public class ArticuloMci implements java.io.Serializable, Comparable<ArticuloMci> {
    private static final long      serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idArt", unique = true, nullable = false)
    private Integer                idArt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria")
    private Categoria              categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipo")
    private TipoArticulo           tipoArticulo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMarca")
    private MarcaMci                  marca;

    @Column(name = "descripcion", length = 200)
    private String                 descripcion;

    @Column(name = "costo", precision = 12, scale = 0)
    private Float                  costo;

    @Column(name = "precio", nullable = false, precision = 12, scale = 0)
    private Float                  precio;

    @Column(name = "stock")
    private Integer                stock;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "articulo")
    private Set<ImagenArticulo>    imagenes         = new HashSet<ImagenArticulo>(0);

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idImagenPreset")
    private ImagenArticulo         imagenDefault;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "articulo")
    private Set<AtributosArticulo> atributos        = new HashSet<AtributosArticulo>(0);

    public ArticuloMci() {
    }

    public ArticuloMci(Float precio) {
        this();
        this.precio = precio;
    }

    public ArticuloMci(Categoria categorias, TipoArticulo tipoarticulo, MarcaMci marcas, String descripcion, Float costo, Float precio, Integer stock) {
        this(precio);
        this.categoria = categorias;
        this.tipoArticulo = tipoarticulo;
        this.marca = marcas;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer getIdArt() {
        return this.idArt;
    }

    public void setIdArt(Integer idArt) {
        this.idArt = idArt;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categorias) {
        this.categoria = categorias;
    }

    public TipoArticulo getTipoArticulo() {
        return this.tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoarticulo) {
        this.tipoArticulo = tipoarticulo;
    }

    public MarcaMci getMarca() {
        return this.marca;
    }

    public void setMarca(MarcaMci marcas) {
        this.marca = marcas;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getCosto() {
        return this.costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Float getPrecio() {
        return this.precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Agrega una nueva imagen al set de imagenes del articulo. Si el articulo no tiene imagen default setea la nueva como tal.
     *
     * @param imagen
     *            La imagen a agregar
     * @param thumb
     *            El thumbnail de la imagen
     */
    public void addImagen(Blob imagen, Blob thumb) {
        final ImagenArticulo nuevaImagen = new ImagenArticulo(thumb, imagen);
        nuevaImagen.setArticulo(this);
        this.imagenes.add(nuevaImagen);
        if (this.imagenDefault == null) {
            this.imagenDefault = nuevaImagen;
        }
    }

    public Set<ImagenArticulo> getImagenes() {
        return this.imagenes;
    }

    public void setImagenes(Set<ImagenArticulo> imagenes) {
        this.imagenes = imagenes;
    }

    public ImagenArticulo getImagenDefault() {
        return this.imagenDefault;
    }

    public void setImagenDefault(ImagenArticulo imagenArticulo) {
        this.imagenDefault = imagenArticulo;
    }

    public Set<AtributosArticulo> getAtributos() {
        return this.atributos;
    }

    public void setAtributos(Set<AtributosArticulo> atributos) {
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb
                .append("Articulo [ ")
                .append("Categoria: ")
                .append(getCategoria() == null ? "" : getCategoria().getDescripcion())
                .append(", Tipo: ")
                .append(getTipoArticulo() == null ? "" : getTipoArticulo().getDescripcion())
                .append(", Marca: ")
                .append(getMarca() == null ? "" : getMarca().getDescripcion())
                .append(", Descrip: " + getDescripcion())
                .append(", Precio: " + getPrecio())
                .append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(ArticuloMci o) {
        if (o == null) {
            return -1;
        }
        if (getTipoArticulo() == null) {
            if (o.getTipoArticulo() != null) {
                return 1;
            }
        }
        int comparacion = getTipoArticulo().compareTo(o.getTipoArticulo());
        if (comparacion != 0) {
            return comparacion;
        } else {
            if (getMarca() == null) {
                if (o.getMarca() != null) {
                    return 1;
                }
            }
            comparacion = getMarca().compareTo(o.getMarca());
            if (comparacion != 0) {
                return comparacion;
            } else {
                if (getDescripcion() == null) {
                    if (o.getDescripcion() != null) {
                        return 1;
                    }
                }
                comparacion = getDescripcion().compareTo(o.getDescripcion());
                if (comparacion != 0) {
                    return comparacion;
                } else {
                    return (int) (getPrecio() - o.getPrecio());
                }
            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getIdArt() == null ? 0 : getIdArt().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticuloMci other = (ArticuloMci) obj;
        if (getIdArt() == null) {
            if (other.getIdArt() != null) {
                return false;
            }
        } else if (!getIdArt().equals(other.getIdArt())) {
            return false;
        }
        return true;
    }
}