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
@Table(name = "Ushqimi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ushqimi.findAll", query = "SELECT u FROM Ushqimi u"),
    @NamedQuery(name = "Ushqimi.findById", query = "SELECT u FROM Ushqimi u WHERE u.id = :id"),
    @NamedQuery(name = "Ushqimi.findByEmertimi", query = "SELECT u FROM Ushqimi u WHERE u.emertimi = :emertimi"),
    @NamedQuery(name = "Ushqimi.findByCmimiper1", query = "SELECT u FROM Ushqimi u WHERE u.cmimiper1 = :cmimiper1"),
    @NamedQuery(name = "Ushqimi.findBySasia", query = "SELECT u FROM Ushqimi u WHERE u.sasia = :sasia")})
public class Ushqimi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Emertimi")
    private String emertimi;
    @Basic(optional = false)
    @Column(name = "Cmimiper1")
    private Double cmimiper1;
    @Basic(optional = false)
    @Column(name = "Sasia")
    private Integer sasia;
    @OneToMany(mappedBy = "ushqimiID")
    private Collection<Porosia> porosiaCollection;

    public Ushqimi() {
    }

    public Ushqimi(Integer id) {
        this.id = id;
    }

    public Ushqimi(Integer id, String emertimi, Double cmimiper1, Integer sasia) {
        this.id = id;
        this.emertimi = emertimi;
        this.cmimiper1 = cmimiper1;
        this.sasia = sasia;
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

    public Double getCmimiper1() {
        return cmimiper1;
    }

    public void setCmimiper1(Double cmimiper1) {
        this.cmimiper1 = cmimiper1;
    }

    public Integer getSasia() {
        return sasia;
    }

    public void setSasia(Integer sasia) {
        this.sasia = sasia;
    }

    @XmlTransient
    public Collection<Porosia> getPorosiaCollection() {
        return porosiaCollection;
    }

    public void setPorosiaCollection(Collection<Porosia> porosiaCollection) {
        this.porosiaCollection = porosiaCollection;
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
        if (!(object instanceof Ushqimi)) {
            return false;
        }
        Ushqimi other = (Ushqimi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + ":"+ emertimi;
    }
}
