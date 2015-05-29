/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.gr1kisiteluyg.entity.Kisi;
import tr.gov.ptt.gr1kisiteluyg.entity.Telefon;
import tr.gov.ptt.gr1kisiteluyg.service.KisiService;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class KisiBean {
    
    private Kisi kisi;
    private Telefon evTel;
    private Telefon cepTel;
    private List<Kisi> kisiList;
    @EJB
    private KisiService kisiService; 

    public KisiBean() {
        kisiList = new ArrayList<Kisi>();
        kisi = new Kisi();
        evTel = new Telefon();
        cepTel = new Telefon();
    }

    public Telefon getEvTel() {
        return evTel;
    }

    public void setEvTel(Telefon evTel) {
        this.evTel = evTel;
    }

    public Telefon getCepTel() {
        return cepTel;
    }

    public void setCepTel(Telefon cepTel) {
        this.cepTel = cepTel;
    }

    public Kisi getKisi() {
        return kisi;
    }

    public List<Kisi> getKisiList() {
        this.kisiList = kisiListeleSirali();
        return kisiList;
    }

    public void setKisiList(List<Kisi> kisiList) {
        this.kisiList = kisiList;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
    
    public String kisiEkle()
    {
        List<Telefon> telefonListesi = new ArrayList<Telefon>();
        telefonListesi.add(this.evTel);
        telefonListesi.add(this.cepTel);
        
        this.kisi.setTelefonList(telefonListesi);
        this.cepTel.setKisi(this.kisi);
        this.evTel.setKisi(this.kisi);
        
        kisiService.kisiEkle(this.kisi);
        
        return "kisiListele.xhtml?faces-redirect=true";
    }
    
    public List<Kisi> kisiListele()
    {
        this.kisiList = kisiService.kisiListele();
        return this.kisiList;
    }
    
    public List<Kisi> kisiListeleSirali()
    {
        this.kisiList = kisiService.kisiListeleSirali();
        return this.kisiList;
    }
    
}
