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
    
    private boolean propuestaCompetitiva;
    private boolean adjudicacionDirecta;

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
        Short n1 = null;
        Short n2 = null;
        if(propuestaCompetitiva){
            n1 = 1;
        }else{
            n1 = 0;
        }
        if(adjudicacionDirecta){
            n2 = 1;
        }else{
            n2 = 0;
        }
        this.solicitudCompraCompletaSeleccionada.setPropuestaCompetitiva(n1);
        this.solicitudCompraCompletaSeleccionada.setAdjudicacionDirecta(n2);
        
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

    public boolean isPropuestaCompetitiva() {
        return propuestaCompetitiva;
    }

    public void setPropuestaCompetitiva(boolean propuestaCompetitiva) {
        this.propuestaCompetitiva = propuestaCompetitiva;
    }

    public boolean isAdjudicacionDirecta() {
        return adjudicacionDirecta;
    }

    public void setAdjudicacionDirecta(boolean adjudicacionDirecta) {
        this.adjudicacionDirecta = adjudicacionDirecta;
    }
    
    
}
