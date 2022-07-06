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

/**
 *
 * @author diana
 */
@Entity
@Table(name = "estrategia_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstrategiaContrato.findAll", query = "SELECT e FROM EstrategiaContrato e"),
    @NamedQuery(name = "EstrategiaContrato.findByIdestrategiaContrato", query = "SELECT e FROM EstrategiaContrato e WHERE e.idestrategiaContrato = :idestrategiaContrato"),
    @NamedQuery(name = "EstrategiaContrato.findByFechaRequerida", query = "SELECT e FROM EstrategiaContrato e WHERE e.fechaRequerida = :fechaRequerida"),
    @NamedQuery(name = "EstrategiaContrato.findByDuracion", query = "SELECT e FROM EstrategiaContrato e WHERE e.duracion = :duracion"),
    @NamedQuery(name = "EstrategiaContrato.findByLugarEntrega", query = "SELECT e FROM EstrategiaContrato e WHERE e.lugarEntrega = :lugarEntrega"),
    @NamedQuery(name = "EstrategiaContrato.findByExtension", query = "SELECT e FROM EstrategiaContrato e WHERE e.extension = :extension"),
    @NamedQuery(name = "EstrategiaContrato.findByCantidadContrato", query = "SELECT e FROM EstrategiaContrato e WHERE e.cantidadContrato = :cantidadContrato"),
    @NamedQuery(name = "EstrategiaContrato.findByJustificacion", query = "SELECT e FROM EstrategiaContrato e WHERE e.justificacion = :justificacion"),
    @NamedQuery(name = "EstrategiaContrato.findByTipoContrato", query = "SELECT e FROM EstrategiaContrato e WHERE e.tipoContrato = :tipoContrato")})
public class EstrategiaContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestrategia_contrato")
    private Integer idestrategiaContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRequerida")
    @Temporal(TemporalType.DATE)
    private Date fechaRequerida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugarEntrega")
    private String lugarEntrega;
    @Column(name = "extension")
    private Short extension;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadContrato")
    private int cantidadContrato;
    @Size(max = 45)
    @Column(name = "justificacion")
    private String justificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "tipoContrato")
    private String tipoContrato;
    @JoinColumn(name = "idsolicitud_compra_completa", referencedColumnName = "idsolicitud_compra_completa")
    @ManyToOne(optional = false)
    private SolicitudCompraCompleta idsolicitudCompraCompleta;

    public EstrategiaContrato() {
    }

    public EstrategiaContrato(Integer idestrategiaContrato) {
        this.idestrategiaContrato = idestrategiaContrato;
    }

    public EstrategiaContrato(Integer idestrategiaContrato, Date fechaRequerida, int duracion, String lugarEntrega, int cantidadContrato, String tipoContrato) {
        this.idestrategiaContrato = idestrategiaContrato;
        this.fechaRequerida = fechaRequerida;
        this.duracion = duracion;
        this.lugarEntrega = lugarEntrega;
        this.cantidadContrato = cantidadContrato;
        this.tipoContrato = tipoContrato;
    }

    public Integer getIdestrategiaContrato() {
        return idestrategiaContrato;
    }

    public void setIdestrategiaContrato(Integer idestrategiaContrato) {
        this.idestrategiaContrato = idestrategiaContrato;
    }

    public Date getFechaRequerida() {
        return fechaRequerida;
    }

    public void setFechaRequerida(Date fechaRequerida) {
        this.fechaRequerida = fechaRequerida;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public Short getExtension() {
        return extension;
    }

    public void setExtension(Short extension) {
        this.extension = extension;
    }

    public int getCantidadContrato() {
        return cantidadContrato;
    }

    public void setCantidadContrato(int cantidadContrato) {
        this.cantidadContrato = cantidadContrato;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public SolicitudCompraCompleta getIdsolicitudCompraCompleta() {
        return idsolicitudCompraCompleta;
    }

    public void setIdsolicitudCompraCompleta(SolicitudCompraCompleta idsolicitudCompraCompleta) {
        this.idsolicitudCompraCompleta = idsolicitudCompraCompleta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestrategiaContrato != null ? idestrategiaContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstrategiaContrato)) {
            return false;
        }
        EstrategiaContrato other = (EstrategiaContrato) object;
        if ((this.idestrategiaContrato == null && other.idestrategiaContrato != null) || (this.idestrategiaContrato != null && !this.idestrategiaContrato.equals(other.idestrategiaContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.udla.dominio.EstrategiaContrato[ idestrategiaContrato=" + idestrategiaContrato + " ]";
    }
    
}
