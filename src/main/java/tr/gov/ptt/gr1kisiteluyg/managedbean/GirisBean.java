/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.gr1kisiteluyg.entity.Giris;
import tr.gov.ptt.gr1kisiteluyg.service.GirisService;
import tr.gov.ptt.gr1kisiteluyg.util.JSFUtil;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class GirisBean {

     private Giris giris;
     @EJB
     private GirisService girisService;
    
    public GirisBean() {
        giris = new Giris();
    }
    

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    
    public String girisKontrol()
    {
        boolean sonuc = girisService.girisKontrol(giris);
        if(sonuc)
        {
            JSFUtil.mesajEkle("Giriş Başarılı..");
            return "menu.xhtml?faces-redirect=true";
        }
        else
        {
            JSFUtil.hataEkle("Kullanıcı Ad veye Şifre Hatalı!");
            return "giris.xhtml?faces-redirect=true";
        }
    }
    
}
