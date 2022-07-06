package ec.edu.udla.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.udla.dominio.SolicitudCompraCompleta;
import ec.edu.udla.eis.SolicitudCompraCompletaFacadeLocal;

@Stateless
public class SolicitudCompraCompletaServiceImpl implements SolicitudCompraCompletaService{
    @Inject
    private SolicitudCompraCompletaFacadeLocal solicitudCompraCompletaFacadeLocal;

        @Override
    public List<SolicitudCompraCompleta> listarSolicitudCompraCompleta() {
        return solicitudCompraCompletaFacadeLocal.findAll();
    }

        @Override
    public SolicitudCompraCompleta encontrarSolicitudCompraCompletaPorId(SolicitudCompraCompleta solicitudCompraCompleta) {
        return solicitudCompraCompletaFacadeLocal.find(solicitudCompraCompleta);
    }

        @Override
    public void registrarSolicitudCompraCompleta(SolicitudCompraCompleta solicitudCompraCompleta) {
        solicitudCompraCompletaFacadeLocal.create(solicitudCompraCompleta);
    }

        @Override
    public void modificarSolicitudCompraCompleta(SolicitudCompraCompleta solicitudCompraCompleta) {
        solicitudCompraCompletaFacadeLocal.edit(solicitudCompraCompleta);
    }

        @Override
    public void eliminarSolicitudCompraCompleta(SolicitudCompraCompleta solicitudCompraCompleta) {
        solicitudCompraCompletaFacadeLocal.remove(solicitudCompraCompleta);
    }
}
