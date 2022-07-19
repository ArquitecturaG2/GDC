package ec.edu.udla.beans;

import ec.edu.udla.dominio.DetalleRequerimiento;
import ec.edu.udla.dominio.EstrategiaContrato;
import ec.edu.udla.dominio.Producto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.udla.dominio.SolicitudCompraCompleta;
import ec.edu.udla.servicio.DetalleRequerimientoService;
import ec.edu.udla.servicio.EstrategiaContratoService;
import ec.edu.udla.servicio.SolicitudCompraCompletaService;
import java.util.ArrayList;
import java.util.HashSet;
import static java.util.stream.Collectors.toList;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.RowEditEvent;

@Named("sccBean")
@RequestScoped
public class SccBean {
    @Inject
    private SolicitudCompraCompletaService solicitudCompraCompletaService;
    @Inject
    private DetalleRequerimientoService detalleRequerimientoService;
    @Inject
    private EstrategiaContratoService estrategiaContratoService;
     
    private SolicitudCompraCompleta solicitudCompraCompleta;

    private List<DetalleRequerimiento> detalles;
    private DetalleRequerimiento detalleSeleccionado;
    
    private DetalleRequerimientoBean dtBean;
    
    private EstrategiaContrato estrategia;

    public SccBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        //dtBean = new DetalleRequerimientoBean();
        solicitudCompraCompleta = new SolicitudCompraCompleta();
        //dtBean.detalleRequerimientos = new ArrayList<>();
        //detalles = new ArrayList<>();
        //getDetallesSolicitud();
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
        //estrategiaContratoService.registrarEstrategiaContrato(estrategia);
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
    
    
    public void getDetallesSolicitud(){
        //detalles = solicitudCompraCompletaService.encontrarSolicitudCompraCompletaPorId(new SolicitudCompraCompleta(2)).getDetalleRequerimientoCollection().stream().collect(toList());
        detalles = detalleRequerimientoService.listarDetalleRequerimientoPorSolicitudId(2);
    }
    
    /*Detalle de requerimietos
    
    public addDetalleRequerimiento(){
        
    }*/
    
    /*public void initDetalles(){
        detalles = solicitu
    }*/
    public void agregarDetalleRequerimiento() {
        solicitudCompraCompleta.getDetalleRequerimientoCollection().add(dtBean.getDetalleRequerimientoSeleccionada());
        dtBean.setDetalleRequerimientoSeleccionada(null);
        //actualizamos la lista
        this.inicializar();
    }

    public DetalleRequerimientoBean getDtBean() {
        return dtBean;
    }

    public void setDtBean(DetalleRequerimientoBean dtBean) {
        this.dtBean = dtBean;
    }
    
    
}
