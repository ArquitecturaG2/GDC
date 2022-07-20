/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.udla.eis;

import ec.edu.udla.dominio.DetalleRequerimiento;
import java.util.List;
import java.util.stream.Collectors;
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
    
    public List<DetalleRequerimiento> findbySolicitudId(int idSolicitud) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(DetalleRequerimiento.class));
        List<DetalleRequerimiento> all = getEntityManager().createQuery(cq).getResultList();
        return all.stream().filter(n->n.getIdsolicitudCompraCompleta().getIdsolicitudCompraCompleta()==idSolicitud).collect(Collectors.toList());
    }
    
}
