package ec.edu.udla.servicio;

import java.util.List;
import javax.ejb.Local;
import ec.edu.udla.dominio.SolicitudCompraCompleta;


@Local
public interface SolicitudCompraCompletaService {
    public List<SolicitudCompraCompleta> listarSolicitudCompraCompleta();

    public SolicitudCompraCompleta encontrarSolicitudCompraCompletaPorId(SolicitudCompraCompleta solicitudCompraCompleta);

    public void registrarSolicitudCompraCompleta(SolicitudCompraCompleta solicitudCompraCompleta);

    public void modificarSolicitudCompraCompleta(SolicitudCompraCompleta solicitudCompraCompleta);

    public void eliminarSolicitudCompraCompleta(SolicitudCompraCompleta solicitudCompraCompleta);
}
