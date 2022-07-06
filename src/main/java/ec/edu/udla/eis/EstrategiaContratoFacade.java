/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.udla.eis;

import ec.edu.udla.dominio.EstrategiaContrato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diana
 */
@Stateless
public class EstrategiaContratoFacade extends AbstractFacade<EstrategiaContrato> implements EstrategiaContratoFacadeLocal {

    @PersistenceContext(unitName = "gdcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstrategiaContratoFacade() {
        super(EstrategiaContrato.class);
    }
    
}
