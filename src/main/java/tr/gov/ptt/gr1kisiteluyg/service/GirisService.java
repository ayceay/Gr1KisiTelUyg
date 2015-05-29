/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr1kisiteluyg.entity.Giris;
import tr.gov.ptt.gr1kisiteluyg.facade.GirisFacade;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisService {
    
    @EJB
    private GirisFacade girisFacade;
    
    public boolean girisKontrol(Giris p_giris)
    {
        return girisFacade.girisKontrol(p_giris);
    }
    
}
