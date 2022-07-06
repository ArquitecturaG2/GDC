package ec.edu.udla.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.udla.dominio.EstrategiaContrato;
import ec.edu.udla.servicio.EstrategiaContratoService;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("estrategiaContratoBean")
@RequestScoped
public class EstrategiaContratoBean {
    @Inject
    private EstrategiaContratoService estrategiaContratoService;

    private EstrategiaContrato estrategiaContratoSeleccionada;

    List<EstrategiaContrato> estrategiaContrato;

    public EstrategiaContratoBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        estrategiaContrato = estrategiaContratoService.listarEstrategiaContrato();
        estrategiaContratoSeleccionada = new EstrategiaContrato();
    }

    public void editListener(RowEditEvent event) {
        EstrategiaContrato estrategiaContratoEditEvent = (EstrategiaContrato) event.getObject();
        estrategiaContratoService.modificarEstrategiaContrato(estrategiaContratoEditEvent);
    }

    public List<EstrategiaContrato> getEstrategiaContrato() {
        return estrategiaContrato;
    }

    public void setEstrategiaContrato(List<EstrategiaContrato> personas) {
        this.estrategiaContrato = personas;
    }

    public EstrategiaContrato getEstrategiaContratoSeleccionada() {
        return estrategiaContratoSeleccionada;
    }

    public void setEstrategiaContratoSeleccionada(EstrategiaContrato personaSeleccionada) {
        this.estrategiaContratoSeleccionada = personaSeleccionada;
    }

    public void reiniciarEstrategiaContratoSeleccionada() {
        this.estrategiaContratoSeleccionada = new EstrategiaContrato();
    }

    public void agregarEstrategiaContrato() {
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
}
