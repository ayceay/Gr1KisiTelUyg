/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "GIRIS")
@NamedQueries({
    @NamedQuery(name = "Giris.findAll", query = "SELECT g FROM Giris g"),
    @NamedQuery(name = "Giris.findByAd", query = "SELECT g FROM Giris g WHERE g.ad = :ad"),
    @NamedQuery(name = "Giris.findByAdandSifre", query = "SELECT g FROM Giris g WHERE g.ad = :ad and g.sifre = :sifre"),
    @NamedQuery(name = "Giris.findBySifre", query = "SELECT g FROM Giris g WHERE g.sifre = :sifre")})
public class Giris implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "AD")
    private String ad;
    @Size(max = 20)
    @Column(name = "SIFRE")
    private String sifre;

    public Giris() {
    }

    public Giris(String ad) {
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ad != null ? ad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giris)) {
            return false;
        }
        Giris other = (Giris) object;
        if ((this.ad == null && other.ad != null) || (this.ad != null && !this.ad.equals(other.ad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.gr1kisiteluyg.Giris[ ad=" + ad + " ]";
    }
    
}
