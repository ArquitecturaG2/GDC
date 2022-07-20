/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.udla.eis;

import ec.edu.udla.dominio.DetalleRequerimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diana
 */
@Local
public interface DetalleRequerimientoFacadeLocal {

    void create(DetalleRequerimiento detalleRequerimiento);

    void edit(DetalleRequerimiento detalleRequerimiento);

    void remove(DetalleRequerimiento detalleRequerimiento);

    DetalleRequerimiento find(Object id);

    List<DetalleRequerimiento> findAll();

    List<DetalleRequerimiento> findRange(int[] range);
    
    List<DetalleRequerimiento> findbySolicitudId(int idSolicitud);

    int count();
    
}
