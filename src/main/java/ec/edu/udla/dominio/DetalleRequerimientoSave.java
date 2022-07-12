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
 
public class DetalleRequerimientoSave implements Serializable {

    private Integer iddetalleRequerimiento;
    private String descripcion;
    private int cantidad;
    private float precioUnitario;
    private float precioTotal;
    private Date fechaRequerida;
    private String lugarRequerido;
    private int idproducto;
    private int idsolicitudCompraCompleta;

    public DetalleRequerimientoSave() {
    }

    public DetalleRequerimientoSave(Integer iddetalleRequerimiento) {
        this.iddetalleRequerimiento = iddetalleRequerimiento;
    }

    public DetalleRequerimientoSave(Integer iddetalleRequerimiento, String descripcion, int cantidad, float precioUnitario, float precioTotal, Date fechaRequerida, String lugarRequerido) {
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

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdsolicitudCompraCompleta() {
        return idsolicitudCompraCompleta;
    }

    public void setIdsolicitudCompraCompleta(int idsolicitudCompraCompleta) {
        this.idsolicitudCompraCompleta = idsolicitudCompraCompleta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleRequerimiento != null ? iddetalleRequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ec.edu.udla.dominio.DetalleRequerimiento[ iddetalleRequerimiento=" + iddetalleRequerimiento + " ]";
    }
    
}
