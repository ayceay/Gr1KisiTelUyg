/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr1kisiteluyg.entity.Giris;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisFacade extends AbstractFacade<Giris> {
    @PersistenceContext(unitName = "ptt_Gr1KisiTelUygPU")
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
        Giris g = null;
        try{
        g = (Giris)em.createNamedQuery("Giris.findByAdandSifre")
                .setParameter("ad", p_giris.getAd())
                .setParameter("sifre", p_giris.getSifre())
                .getSingleResult();
        }
        catch( NoResultException exp )
        {
            System.out.println(exp.getMessage());
            
        }
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
