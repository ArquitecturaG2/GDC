package ec.edu.udla.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.udla.dominio.SolicitudCompraCompleta;
import ec.edu.udla.servicio.SolicitudCompraCompletaService;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.RowEditEvent;

@Named("solicitudCompraCompletaBean")
@RequestScoped
public class SolicitudCompraCompletaBean {
    @Inject
    private SolicitudCompraCompletaService solicitudCompraCompletaService;

    private SolicitudCompraCompleta solicitudCompraCompletaSeleccionada;

    List<SolicitudCompraCompleta> solicitudCompraCompleta;

    public SolicitudCompraCompletaBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        solicitudCompraCompleta = solicitudCompraCompletaService.listarSolicitudCompraCompleta();
        solicitudCompraCompletaSeleccionada = new SolicitudCompraCompleta();
    }

    public void editListener(RowEditEvent event) {
        SolicitudCompraCompleta solicitudCompraCompletaEditListener = (SolicitudCompraCompleta) event.getObject();
        solicitudCompraCompletaService.modificarSolicitudCompraCompleta(solicitudCompraCompletaEditListener);
    }

    public List<SolicitudCompraCompleta> getSolicitudCompraCompleta() {
        return solicitudCompraCompleta;
    }

    public void setSolicitudCompraCompleta(List<SolicitudCompraCompleta> solicitudCompraCompleta) {
        this.solicitudCompraCompleta = solicitudCompraCompleta;
    }

    public SolicitudCompraCompleta getSolicitudCompraCompletaSeleccionada() {
        return solicitudCompraCompletaSeleccionada;
    }

    public void setSolicitudCompraCompletaSeleccionada(SolicitudCompraCompleta SolicitudCompraCompletaSeleccionada) {
        this.solicitudCompraCompletaSeleccionada = SolicitudCompraCompletaSeleccionada;
    }

    public void reiniciarSolicitudCompraCompletaSeleccionada() {
        this.solicitudCompraCompletaSeleccionada = new SolicitudCompraCompleta();
    }

    public void agregarSolicitudCompraCompleta() {
        solicitudCompraCompletaService.registrarSolicitudCompraCompleta(this.solicitudCompraCompletaSeleccionada);
        this.solicitudCompraCompletaSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarSolicitudCompraCompleta() {
        solicitudCompraCompletaService.eliminarSolicitudCompraCompleta(this.solicitudCompraCompletaSeleccionada);
        this.solicitudCompraCompletaSeleccionada = null;
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
