package ec.edu.udla.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.udla.dominio.Producto;
import ec.edu.udla.eis.ProductoFacadeLocal;

@Stateless
public class ProductoServiceImpl implements ProductoService{
    @Inject
    private ProductoFacadeLocal ProductoFacadeLocal;

    @Override
    public List<Producto> listarProductos() {
        return ProductoFacadeLocal.findAll();
    }

    @Override
    public Producto encontrarProductoPorId(Producto producto) {
        return ProductoFacadeLocal.find(producto);
    }
}
