package ec.edu.udla.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.udla.dominio.DetalleRequerimiento;
import ec.edu.udla.servicio.DetalleRequerimientoService;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("detalleRequerimientoBean")
@RequestScoped
public class DetalleRequerimientoBean {
    @Inject
    private DetalleRequerimientoService detalleRequerimientoService;

    private DetalleRequerimiento detalleRequerimientoSeleccionada;

    List<DetalleRequerimiento> detalleRequerimientos;

    public DetalleRequerimientoBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        detalleRequerimientos = detalleRequerimientoService.listarDetalleRequerimiento();
        detalleRequerimientoSeleccionada = new DetalleRequerimiento();
    }

    public void editListener(RowEditEvent event) {
        DetalleRequerimiento detalleRequerimientoEditEvent = (DetalleRequerimiento) event.getObject();
        detalleRequerimientoService.modificarDetalleRequerimiento(detalleRequerimientoEditEvent);
    }

    public List<DetalleRequerimiento> getDetalleRequerimiento() {
        return detalleRequerimientos;
    }

    public void setDetalleRequerimiento(List<DetalleRequerimiento> detalleRequerimiento) {
        this.detalleRequerimientos = detalleRequerimiento;
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
        detalleRequerimientoService.registrarDetalleRequerimiento(this.detalleRequerimientoSeleccionada);
        this.detalleRequerimientoSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
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
}
