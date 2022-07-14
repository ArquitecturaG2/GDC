package ec.edu.udla.beans;

import ec.edu.udla.dominio.DetalleRequerimiento;
import ec.edu.udla.dominio.EstrategiaContrato;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.udla.dominio.SolicitudCompraCompleta;
import ec.edu.udla.servicio.SolicitudCompraCompletaService;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.RowEditEvent;

@Named("sccBean")
@RequestScoped
public class SccBean {
    @Inject
    private SolicitudCompraCompletaService solicitudCompraCompletaService;

    private SolicitudCompraCompleta solicitudCompraCompleta;

    private List<DetalleRequerimiento> detalles;
    
    private EstrategiaContrato estrategia;

    public SccBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        solicitudCompraCompleta = new SolicitudCompraCompleta();
        detalles = new ArrayList<>();
        estrategia = new EstrategiaContrato();
    }

    public void editListener(RowEditEvent event) {
        SolicitudCompraCompleta solicitudCompraCompletaEditListener = (SolicitudCompraCompleta) event.getObject();
        solicitudCompraCompletaService.modificarSolicitudCompraCompleta(solicitudCompraCompletaEditListener);
    }

    public List<DetalleRequerimiento> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleRequerimiento> detalles) {
        this.detalles = detalles;
    }

    public EstrategiaContrato getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaContrato estrategia) {
        this.estrategia = estrategia;
    }
    

    public SolicitudCompraCompleta getSolicitudCompraCompleta() {
        return solicitudCompraCompleta;
    }

    public void setSolicitudCompraCompleta(SolicitudCompraCompleta SolicitudCompraCompletaSeleccionada) {
        this.solicitudCompraCompleta = SolicitudCompraCompletaSeleccionada;
    }

    public void reiniciarSolicitudCompraCompleta() {
        this.solicitudCompraCompleta = new SolicitudCompraCompleta();
    }

    public void agregarSolicitudCompraCompleta() {
        solicitudCompraCompletaService.registrarSolicitudCompraCompleta(this.solicitudCompraCompleta);
        this.solicitudCompraCompleta = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarSolicitudCompraCompleta() {
        solicitudCompraCompletaService.eliminarSolicitudCompraCompleta(this.solicitudCompraCompleta);
        this.solicitudCompraCompleta = null;
        //actualizamos la lista
        this.inicializar();
    }

    public SolicitudCompraCompletaService getSolicitudCompraCompletaService() {
        return solicitudCompraCompletaService;
    }

    public void setSolicitudCompraCompletaService(SolicitudCompraCompletaService solicitudCompraCompletaService) {
        this.solicitudCompraCompletaService = solicitudCompraCompletaService;
    }
}
