package ec.edu.udla.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.udla.dominio.Producto;
import ec.edu.udla.servicio.ProductoService;
import javax.enterprise.context.RequestScoped;


@Named("productoBean")
@RequestScoped
public class ProductoBean {
    @Inject
    private ProductoService productoService;

    List<Producto> productos;
    
    public ProductoBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        productos = productoService.listarProductos();
    }
    
    public Producto getProducto(int id){
        return productoService.encontrarProductoPorId(new Producto(id));
    }
    
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

   
    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }
    
}
