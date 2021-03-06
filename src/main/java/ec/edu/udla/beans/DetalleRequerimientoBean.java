package ec.edu.udla.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.udla.dominio.DetalleRequerimiento;
import ec.edu.udla.dominio.Producto;
import ec.edu.udla.dominio.SolicitudCompraCompleta;
import ec.edu.udla.servicio.DetalleRequerimientoService;
import java.util.Date;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;


@Named("detalleRequerimientoBean")
@RequestScoped
public class DetalleRequerimientoBean {
    @Inject
    private DetalleRequerimientoService detalleRequerimientoService;
    

    private DetalleRequerimiento detalleRequerimientoSeleccionada;

    List<DetalleRequerimiento> detalleRequerimientos;
    
    private Date currentDate;
    
    public DetalleRequerimientoBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        detalleRequerimientos = detalleRequerimientoService.listarDetalleRequerimiento();
        detalleRequerimientoSeleccionada = new DetalleRequerimiento();
        currentDate = new Date();
    }

    public void editListener(RowEditEvent event) {
        DetalleRequerimiento detalleRequerimientoEditEvent = (DetalleRequerimiento) event.getObject();
        detalleRequerimientoService.modificarDetalleRequerimiento(detalleRequerimientoEditEvent);
    }

    public List<DetalleRequerimiento> getDetalleRequerimientos() {
        return detalleRequerimientos;
    }

    public void setDetalleRequerimientos(List<DetalleRequerimiento> detalleRequerimientos) {
        this.detalleRequerimientos = detalleRequerimientos;
    }

    public DetalleRequerimiento getDetalleRequerimientoSeleccionada() {
        return detalleRequerimientoSeleccionada;
    }

    public void setDetalleRequerimientoSeleccionada(DetalleRequerimiento personaSeleccionada) {
        this.detalleRequerimientoSeleccionada = personaSeleccionada;
    }

    public void reiniciarDetalleRequerimientoSeleccionada() {
        this.detalleRequerimientoSeleccionada = new DetalleRequerimiento();
    }

    public void agregarDetalleRequerimiento() {
        this.detalleRequerimientoSeleccionada.setProducto(new Producto(this.detalleRequerimientoSeleccionada.getIdProducto()));
        this.detalleRequerimientoSeleccionada.setSolicitudCompraCompleta(new SolicitudCompraCompleta(detalleRequerimientoSeleccionada.getIdSolicitudCompraCompleta()));
        this.detalleRequerimientoSeleccionada.setPrecioTotal(
        this.detalleRequerimientoSeleccionada.getCantidad()*
        this.detalleRequerimientoSeleccionada.getPrecioUnitario());
        
        detalleRequerimientoService.registrarDetalleRequerimiento(this.detalleRequerimientoSeleccionada);
        this.detalleRequerimientoSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void agregarDetalleTemp() {
        this.detalleRequerimientoSeleccionada.setProducto(new Producto(this.detalleRequerimientoSeleccionada.getIdProducto()));
        this.detalleRequerimientoSeleccionada.setPrecioTotal(
        this.detalleRequerimientoSeleccionada.getCantidad()*
        this.detalleRequerimientoSeleccionada.getPrecioUnitario());
        
        detalleRequerimientos.add(this.detalleRequerimientoSeleccionada);
        
        this.detalleRequerimientoSeleccionada = new DetalleRequerimiento();
    }
    
    public void eliminarDetalleRequerimiento() {
        detalleRequerimientoService.eliminarDetalleRequerimiento(this.detalleRequerimientoSeleccionada);
        this.detalleRequerimientoSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

    public DetalleRequerimientoService getDetalleRequerimientoService() {
        return detalleRequerimientoService;
    }

    public void setDetalleRequerimientoService(DetalleRequerimientoService detalleRequerimientoService) {
        this.detalleRequerimientoService = detalleRequerimientoService;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
}
