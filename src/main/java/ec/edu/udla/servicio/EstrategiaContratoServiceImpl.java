package ec.edu.udla.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.udla.dominio.EstrategiaContrato;
import ec.edu.udla.eis.EstrategiaContratoFacadeLocal;


@Stateless
public class EstrategiaContratoServiceImpl implements EstrategiaContratoService{
    @Inject
    private EstrategiaContratoFacadeLocal estrategiaContratoFacadeLocal;

        @Override
    public List<EstrategiaContrato> listarEstrategiaContrato() {
        return estrategiaContratoFacadeLocal.findAll();
    }

        @Override
    public EstrategiaContrato encontrarEstrategiaContratoPorId(EstrategiaContrato estrategiaContrato) {
        return estrategiaContratoFacadeLocal.find(estrategiaContrato);
    }

        @Override
    public void registrarEstrategiaContrato(EstrategiaContrato estrategiaContrato) {
        estrategiaContratoFacadeLocal.create(estrategiaContrato);
    }

        @Override
    public void modificarEstrategiaContrato(EstrategiaContrato estrategiaContrato) {
        estrategiaContratoFacadeLocal.edit(estrategiaContrato);
    }

        @Override
    public void eliminarEstrategiaContrato(EstrategiaContrato estrategiaContrato) {
        estrategiaContratoFacadeLocal.remove(estrategiaContrato);
    }
}
