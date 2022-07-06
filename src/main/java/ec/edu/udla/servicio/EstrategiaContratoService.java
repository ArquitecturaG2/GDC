package ec.edu.udla.servicio;

import java.util.List;
import javax.ejb.Local;
import ec.edu.udla.dominio.EstrategiaContrato;

@Local
public interface EstrategiaContratoService {
    public List<EstrategiaContrato> listarEstrategiaContrato();

    public EstrategiaContrato encontrarEstrategiaContratoPorId(EstrategiaContrato estrategiaContrato);

    public void registrarEstrategiaContrato(EstrategiaContrato estrategiaContrato);

    public void modificarEstrategiaContrato(EstrategiaContrato estrategiaContrato);

    public void eliminarEstrategiaContrato(EstrategiaContrato estrategiaContrato);
}
