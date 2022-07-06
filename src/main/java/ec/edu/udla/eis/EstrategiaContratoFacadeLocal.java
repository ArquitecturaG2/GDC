/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.udla.eis;

import ec.edu.udla.dominio.EstrategiaContrato;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diana
 */
@Local
public interface EstrategiaContratoFacadeLocal {

    void create(EstrategiaContrato estrategiaContrato);

    void edit(EstrategiaContrato estrategiaContrato);

    void remove(EstrategiaContrato estrategiaContrato);

    EstrategiaContrato find(Object id);

    List<EstrategiaContrato> findAll();

    List<EstrategiaContrato> findRange(int[] range);

    int count();
    
}
