/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr1kisiteluyg.entity.Giris;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisFacade extends AbstractFacade<Giris> {
    @PersistenceContext(unitName = "tr.gov.ptt_Gr1KisiTelUyg_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }
    
    public boolean girisKontrol(Giris p_giris)
    {
        Giris g = (Giris)em.createNamedQuery("findByAdandSifre")
                .setParameter("ad", p_giris.getAd())
                .setParameter("sifre", p_giris.getSifre())
                .getSingleResult();
        
        if(g != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
