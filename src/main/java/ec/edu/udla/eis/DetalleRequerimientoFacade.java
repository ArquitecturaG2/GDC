/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.udla.eis;

import ec.edu.udla.dominio.DetalleRequerimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diana
 */
@Stateless
public class DetalleRequerimientoFacade extends AbstractFacade<DetalleRequerimiento> implements DetalleRequerimientoFacadeLocal {

    @PersistenceContext(unitName = "gdcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleRequerimientoFacade() {
        super(DetalleRequerimiento.class);
    }
    
}
