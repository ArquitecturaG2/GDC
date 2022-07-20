/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.udla.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author diana
 */
@Entity
@Table(name = "detalle_requerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleRequerimiento.findAll", query = "SELECT d FROM DetalleRequerimiento d"),
    @NamedQuery(name = "DetalleRequerimiento.findByIddetalleRequerimiento", query = "SELECT d FROM DetalleRequerimiento d WHERE d.iddetalleRequerimiento = :iddetalleRequerimiento"),
    @NamedQuery(name = "DetalleRequerimiento.findByDescripcion", query = "SELECT d FROM DetalleRequerimiento d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleRequerimiento.findByCantidad", query = "SELECT d FROM DetalleRequerimiento d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleRequerimiento.findByPrecioUnitario", query = "SELECT d FROM DetalleRequerimiento d WHERE d.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "DetalleRequerimiento.findByPrecioTotal", query = "SELECT d FROM DetalleRequerimiento d WHERE d.precioTotal = :precioTotal"),
    @NamedQuery(name = "DetalleRequerimiento.findByFechaRequerida", query = "SELECT d FROM DetalleRequerimiento d WHERE d.fechaRequerida = :fechaRequerida"),
    @NamedQuery(name = "DetalleRequerimiento.findByLugarRequerido", query = "SELECT d FROM DetalleRequerimiento d WHERE d.lugarRequerido = :lugarRequerido")})
public class DetalleRequerimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_requerimiento")
    private Integer iddetalleRequerimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnitario")
    private float precioUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioTotal")
    private float precioTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRequerida")
    @Temporal(TemporalType.DATE)
    private Date fechaRequerida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugarRequerido")
    private String lugarRequerido;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto",insertable=false,updatable=false)
    private Producto producto;
    @Basic(optional = false)
    @Column(name = "idproducto")
    private int idProducto;
    @JoinColumn(name = "idsolicitud_compra_completa", referencedColumnName = "idsolicitud_compra_completa",insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private SolicitudCompraCompleta solicitudCompraCompleta;
    @Basic(optional = false)
    @Column(name = "idsolicitud_compra_completa")
    private int idSolicitudCompraCompleta;

    public DetalleRequerimiento() {
        producto = new Producto();
        solicitudCompraCompleta = new SolicitudCompraCompleta();
    }

    public DetalleRequerimiento(Integer iddetalleRequerimiento) {
        this.iddetalleRequerimiento = iddetalleRequerimiento;
    }

    public DetalleRequerimiento(Integer iddetalleRequerimiento, String descripcion, int cantidad, float precioUnitario, float precioTotal, Date fechaRequerida, String lugarRequerido) {
        this.iddetalleRequerimiento = iddetalleRequerimiento;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.fechaRequerida = fechaRequerida;
        this.lugarRequerido = lugarRequerido;
    }

    public Integer getIddetalleRequerimiento() {
        return iddetalleRequerimiento;
    }

    public void setIddetalleRequerimiento(Integer iddetalleRequerimiento) {
        this.iddetalleRequerimiento = iddetalleRequerimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }
    
    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaRequerida() {
        return fechaRequerida;
    }

    public void setFechaRequerida(Date fechaRequerida) {
        this.fechaRequerida = fechaRequerida;
    }

    public String getLugarRequerido() {
        return lugarRequerido;
    }

    public void setLugarRequerido(String lugarRequerido) {
        this.lugarRequerido = lugarRequerido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto idproducto) {
        this.producto = idproducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public SolicitudCompraCompleta getSolicitudCompraCompleta() {
        return solicitudCompraCompleta;
    }

    public void setSolicitudCompraCompleta(SolicitudCompraCompleta solicitudCompraCompleta) {
        this.solicitudCompraCompleta = solicitudCompraCompleta;
    }

    public int getIdSolicitudCompraCompleta() {
        return idSolicitudCompraCompleta;
    }

    public void setIdSolicitudCompraCompleta(int idSolicitudCompraCompleta) {
        this.idSolicitudCompraCompleta = idSolicitudCompraCompleta;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleRequerimiento != null ? iddetalleRequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleRequerimiento)) {
            return false;
        }
        DetalleRequerimiento other = (DetalleRequerimiento) object;
        if ((this.iddetalleRequerimiento == null && other.iddetalleRequerimiento != null) || (this.iddetalleRequerimiento != null && !this.iddetalleRequerimiento.equals(other.iddetalleRequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.udla.dominio.DetalleRequerimiento[ iddetalleRequerimiento=" + iddetalleRequerimiento + " ]";
    }
    
}
