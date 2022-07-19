/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.udla.eis;

import ec.edu.udla.dominio.SolicitudCompraCompleta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diana
 */
@Stateless
public class SolicitudCompraCompletaFacade extends AbstractFacade<SolicitudCompraCompleta> implements SolicitudCompraCompletaFacadeLocal {

    @PersistenceContext(unitName = "gdcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudCompraCompletaFacade() {
        super(SolicitudCompraCompleta.class);
    }
    
    public int createReturnID(SolicitudCompraCompleta solicitudCompraCompleta) {
        em.persist(solicitudCompraCompleta);
        em.flush();
        return solicitudCompraCompleta.getIdsolicitudCompraCompleta();
    }
}
