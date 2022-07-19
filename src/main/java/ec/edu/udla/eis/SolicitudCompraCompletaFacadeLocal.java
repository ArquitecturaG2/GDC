/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.udla.eis;

import ec.edu.udla.dominio.SolicitudCompraCompleta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diana
 */
@Local
public interface SolicitudCompraCompletaFacadeLocal {

    void create(SolicitudCompraCompleta solicitudCompraCompleta);
    
    int createReturnID(SolicitudCompraCompleta solicitudCompraCompleta);

    void edit(SolicitudCompraCompleta solicitudCompraCompleta);

    void remove(SolicitudCompraCompleta solicitudCompraCompleta);

    SolicitudCompraCompleta find(Object id);

    List<SolicitudCompraCompleta> findAll();

    List<SolicitudCompraCompleta> findRange(int[] range);

    int count();
    
}
