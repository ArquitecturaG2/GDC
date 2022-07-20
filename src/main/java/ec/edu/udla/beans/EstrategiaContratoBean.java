package ec.edu.udla.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.udla.dominio.EstrategiaContrato;
import ec.edu.udla.dominio.SolicitudCompraCompleta;
import ec.edu.udla.servicio.EstrategiaContratoService;
import java.util.Date;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("estrategiaContratoBean")
@RequestScoped
public class EstrategiaContratoBean {
    @Inject
    private EstrategiaContratoService estrategiaContratoService;

    private EstrategiaContrato estrategiaContratoSeleccionada;

    List<EstrategiaContrato> estrategiaContrato;
    
    private Date currentDate;
    private boolean extension;

    public EstrategiaContratoBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        estrategiaContrato = estrategiaContratoService.listarEstrategiaContrato();
        estrategiaContratoSeleccionada = new EstrategiaContrato();
        currentDate = new Date();
    }

    public void editListener(RowEditEvent event) {
        EstrategiaContrato estrategiaContratoEditEvent = (EstrategiaContrato) event.getObject();
        estrategiaContratoService.modificarEstrategiaContrato(estrategiaContratoEditEvent);
        
    }

    public List<EstrategiaContrato> getEstrategiaContrato() {
        return estrategiaContrato;
    }

    public void setEstrategiaContrato(List<EstrategiaContrato> estrategiaContrato) {
        this.estrategiaContrato = estrategiaContrato;
    }

    public EstrategiaContrato getEstrategiaContratoSeleccionada() {
        return estrategiaContratoSeleccionada;
    }

    public void setEstrategiaContratoSeleccionada(EstrategiaContrato estrategiaContrato) {
        this.estrategiaContratoSeleccionada = estrategiaContrato;
    }

    public void reiniciarEstrategiaContratoSeleccionada() {
        this.estrategiaContratoSeleccionada = new EstrategiaContrato();
    }

    public void agregarEstrategiaContrato() {
        Short n = null;
        if(extension){
            n = 1;
        }else{
            n = 0;
        }
        this.estrategiaContratoSeleccionada.setExtension(n);
        
        
        estrategiaContratoService.registrarEstrategiaContrato(this.estrategiaContratoSeleccionada);
        this.estrategiaContratoSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarEstrategiaContrato() {
        estrategiaContratoService.eliminarEstrategiaContrato(this.estrategiaContratoSeleccionada);
        this.estrategiaContratoSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

    public EstrategiaContratoService getEstrategiaContratoService() {
        return estrategiaContratoService;
    }

    public void setEstrategiaContratoService(EstrategiaContratoService estrategiaContratoService) {
        this.estrategiaContratoService = estrategiaContratoService;
    }
    
    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
    public boolean getExtension(){
        return extension;
    }
    
    public void setExtension(boolean extension){
        this.extension = extension;
    }
}
