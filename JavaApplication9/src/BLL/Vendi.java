/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Vendi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendi.findAll", query = "SELECT v FROM Vendi v"),
    @NamedQuery(name = "Vendi.findById", query = "SELECT v FROM Vendi v WHERE v.id = :id"),
    @NamedQuery(name = "Vendi.findByEmertimi", query = "SELECT v FROM Vendi v WHERE v.emertimi = :emertimi")})
public class Vendi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;    
    @Column(name = "Emertimi")
    private String emertimi;
    @OneToMany(mappedBy = "vendiID")
    private Collection<Tavolina> tavolinaCollection;

    public Vendi() {
    }

    public Vendi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmertimi() {
        return emertimi;
    }

    public void setEmertimi(String emertimi) {
        this.emertimi = emertimi;
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
        if (!(object instanceof Vendi)) {
            return false;
        }
        Vendi other = (Vendi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Vendi[ id=" + id + " ]";
    }   
}