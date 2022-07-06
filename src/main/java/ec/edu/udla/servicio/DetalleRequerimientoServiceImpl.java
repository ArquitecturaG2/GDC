package ec.edu.udla.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.udla.eis.DetalleRequerimientoFacadeLocal;
import ec.edu.udla.dominio.DetalleRequerimiento;

@Stateless
public class DetalleRequerimientoServiceImpl implements DetalleRequerimientoService{
    @Inject
    private DetalleRequerimientoFacadeLocal DetalleRequerimientoFacadeLocal;

    @Override
    public List<DetalleRequerimiento> listarDetalleRequerimiento() {
        return DetalleRequerimientoFacadeLocal.findAll();
    }

    @Override
    public DetalleRequerimiento encontrarDetalleRequerimientoPorId(DetalleRequerimiento detalleRequerimiento) {
        return DetalleRequerimientoFacadeLocal.find(detalleRequerimiento);
    }

        @Override
    public void registrarDetalleRequerimiento(DetalleRequerimiento detalleRequerimiento) {
        DetalleRequerimientoFacadeLocal.create(detalleRequerimiento);
    }

        @Override
    public void modificarDetalleRequerimiento(DetalleRequerimiento detalleRequerimiento) {
        DetalleRequerimientoFacadeLocal.edit(detalleRequerimiento);
    }

        @Override
    public void eliminarDetalleRequerimiento(DetalleRequerimiento detalleRequerimiento) {
        DetalleRequerimientoFacadeLocal.remove(detalleRequerimiento);
    }
}
