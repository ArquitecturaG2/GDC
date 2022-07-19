package ec.edu.udla.servicio;

import java.util.List;
import javax.ejb.Local;
import ec.edu.udla.dominio.DetalleRequerimiento;

@Local
public interface DetalleRequerimientoService {
    
    public List<DetalleRequerimiento> listarDetalleRequerimiento();
    
    public List<DetalleRequerimiento> listarDetalleRequerimientoPorSolicitudId(int solicitudId);

    public DetalleRequerimiento encontrarDetalleRequerimientoPorId(DetalleRequerimiento detalleRequerimiento);

    public void registrarDetalleRequerimiento(DetalleRequerimiento detalleRequerimiento);

    public void modificarDetalleRequerimiento(DetalleRequerimiento detalleRequerimiento);

    public void eliminarDetalleRequerimiento(DetalleRequerimiento detalleRequerimiento);
}
