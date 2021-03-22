/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Orari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orari.findAll", query = "SELECT o FROM Orari o"),
    @NamedQuery(name = "Orari.findById", query = "SELECT o FROM Orari o WHERE o.id = :id"),
    @NamedQuery(name = "Orari.findByFillimi", query = "SELECT o FROM Orari o WHERE o.fillimi = :fillimi"),
    @NamedQuery(name = "Orari.findByMbarimi", query = "SELECT o FROM Orari o WHERE o.mbarimi = :mbarimi")})
public class Orari implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @Column(name = "Fillimi")
    @Temporal(TemporalType.TIME)
    private Date fillimi;
    @Column(name = "Mbarimi")
    @Temporal(TemporalType.TIME)
    private Date mbarimi;
    @OneToMany(mappedBy = "orariID")
    private Collection<Tavolina> tavolinaCollection;

    public Orari() {
    }

    public Orari(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFillimi() {
        return fillimi;
    }

    public void setFillimi(Date fillimi) {
        this.fillimi = fillimi;
    }

    public Date getMbarimi() {
        return mbarimi;
    }

    public void setMbarimi(Date mbarimi) {
        this.mbarimi = mbarimi;
    }

    @XmlTransient
    public Collection<Tavolina> getTavolinaCollection() {
        return tavolinaCollection;
    }

    public void setTavolinaCollection(Collection<Tavolina> tavolinaCollection) {
        this.tavolinaCollection = tavolinaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orari)) {
            return false;
        }
        Orari other = (Orari) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Orari[ id=" + id + " ]";
    }
    
}
