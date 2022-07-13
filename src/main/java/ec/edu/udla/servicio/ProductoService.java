package ec.edu.udla.servicio;

import java.util.List;
import javax.ejb.Local;
import ec.edu.udla.dominio.Producto;

@Local
public interface ProductoService {
    
    public List<Producto> listarProductos();

    public Producto encontrarProductoPorId(Producto producto);

}
