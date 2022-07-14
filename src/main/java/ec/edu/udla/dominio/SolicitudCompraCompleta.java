/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.udla.dominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diana
 */
@Entity
@Table(name = "solicitud_compra_completa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCompraCompleta.findAll", query = "SELECT s FROM SolicitudCompraCompleta s"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByIdsolicitudCompraCompleta", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.idsolicitudCompraCompleta = :idsolicitudCompraCompleta"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByNumero", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.numero = :numero"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByUnidad", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.unidad = :unidad"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByValor", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.valor = :valor"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByDescripcion", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByFuncionRequiriente", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.funcionRequiriente = :funcionRequiriente"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByFuncionDelegado", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.funcionDelegado = :funcionDelegado"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByPropuestaCompetitiva", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.propuestaCompetitiva = :propuestaCompetitiva"),
    @NamedQuery(name = "SolicitudCompraCompleta.findByAdjudicacionDirecta", query = "SELECT s FROM SolicitudCompraCompleta s WHERE s.adjudicacionDirecta = :adjudicacionDirecta")})
public class SolicitudCompraCompleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsolicitud_compra_completa")
    private Integer idsolicitudCompraCompleta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "unidad")
    private String unidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "funcionRequiriente")
    private String funcionRequiriente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "funcionDelegado")
    private String funcionDelegado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propuestaCompetitiva")
    private short propuestaCompetitiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "adjudicacionDirecta")
    private short adjudicacionDirecta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitudCompraCompleta")
    private Collection<EstrategiaContrato> estrategiaContratoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitudCompraCompleta")
    private Collection<DetalleRequerimiento> detalleRequerimientoCollection;
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne(optional = false)
    private Proveedor idproveedor;

    public SolicitudCompraCompleta() {
    }

    public SolicitudCompraCompleta(Integer idsolicitudCompraCompleta) {
        this.idsolicitudCompraCompleta = idsolicitudCompraCompleta;
    }

    public SolicitudCompraCompleta(Integer idsolicitudCompraCompleta, String numero, String unidad, String valor, String descripcion, String funcionRequiriente, String funcionDelegado, short propuestaCompetitiva, short adjudicacionDirecta) {
        this.idsolicitudCompraCompleta = idsolicitudCompraCompleta;
        this.numero = numero;
        this.unidad = unidad;
        this.valor = valor;
        this.descripcion = descripcion;
        this.funcionRequiriente = funcionRequiriente;
        this.funcionDelegado = funcionDelegado;
        this.propuestaCompetitiva = propuestaCompetitiva;
        this.adjudicacionDirecta = adjudicacionDirecta;
    }

    public Integer getIdsolicitudCompraCompleta() {
        return idsolicitudCompraCompleta;
    }

    public void setIdsolicitudCompraCompleta(Integer idsolicitudCompraCompleta) {
        this.idsolicitudCompraCompleta = idsolicitudCompraCompleta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFuncionRequiriente() {
        return funcionRequiriente;
    }

    public void setFuncionRequiriente(String funcionRequiriente) {
        this.funcionRequiriente = funcionRequiriente;
    }

    public String getFuncionDelegado() {
        return funcionDelegado;
    }

    public void setFuncionDelegado(String funcionDelegado) {
        this.funcionDelegado = funcionDelegado;
    }

    public short getPropuestaCompetitiva() {
        return propuestaCompetitiva;
    }

    public void setPropuestaCompetitiva(short propuestaCompetitiva) {
        this.propuestaCompetitiva = propuestaCompetitiva;
    }

    public short getAdjudicacionDirecta() {
        return adjudicacionDirecta;
    }

    public void setAdjudicacionDirecta(short adjudicacionDirecta) {
        this.adjudicacionDirecta = adjudicacionDirecta;
    }

    @XmlTransient
    public Collection<EstrategiaContrato> getEstrategiaContratoCollection() {
        return estrategiaContratoCollection;
    }

    public void setEstrategiaContratoCollection(Collection<EstrategiaContrato> estrategiaContratoCollection) {
        this.estrategiaContratoCollection = estrategiaContratoCollection;
    }

    @XmlTransient
    public Collection<DetalleRequerimiento> getDetalleRequerimientoCollection() {
        return detalleRequerimientoCollection;
    }

    public void setDetalleRequerimientoCollection(Collection<DetalleRequerimiento> detalleRequerimientoCollection) {
        this.detalleRequerimientoCollection = detalleRequerimientoCollection;
    }

    public Proveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedor idproveedor) {
        this.idproveedor = idproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitudCompraCompleta != null ? idsolicitudCompraCompleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCompraCompleta)) {
            return false;
        }
        SolicitudCompraCompleta other = (SolicitudCompraCompleta) object;
        if ((this.idsolicitudCompraCompleta == null && other.idsolicitudCompraCompleta != null) || (this.idsolicitudCompraCompleta != null && !this.idsolicitudCompraCompleta.equals(other.idsolicitudCompraCompleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.udla.dominio.SolicitudCompraCompleta[ idsolicitudCompraCompleta=" + idsolicitudCompraCompleta + " ]";
    }
    
}
