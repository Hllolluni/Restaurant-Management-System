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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Tavolina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tavolina.findAll", query = "SELECT t FROM Tavolina t"),
    @NamedQuery(name = "Tavolina.findById", query = "SELECT t FROM Tavolina t WHERE t.id = :id"),
    @NamedQuery(name = "Tavolina.findByNrPersonave", query = "SELECT t FROM Tavolina t WHERE t.nrPersonave = :nrPersonave")})
public class Tavolina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @Column(name = "Nr_Personave")
    private Integer nrPersonave;
    @OneToMany(mappedBy = "tavolinaID")
    private Collection<Porosia> porosiaCollection;
    @JoinColumn(name = "OrariID", referencedColumnName = "ID")
    @ManyToOne
    private Orari orariID;
    @JoinColumn(name = "VendiID", referencedColumnName = "ID")
    @ManyToOne
    private Vendi vendiID;

    public Tavolina() {
    }

    public Tavolina(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNrPersonave() {
        return nrPersonave;
    }

    public void setNrPersonave(Integer nrPersonave) {
        this.nrPersonave = nrPersonave;
    }

    @XmlTransient
    public Collection<Porosia> getPorosiaCollection() {
        return porosiaCollection;
    }

    public void setPorosiaCollection(Collection<Porosia> porosiaCollection) {
        this.porosiaCollection = porosiaCollection;
    }

    public Orari getOrariID() {
        return orariID;
    }

    public void setOrariID(Orari orariID) {
        this.orariID = orariID;
    }

    public Vendi getVendiID() {
        return vendiID;
    }

    public void setVendiID(Vendi vendiID) {
        this.vendiID = vendiID;
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
        if (!(object instanceof Tavolina)) {
            return false;
        }
        Tavolina other = (Tavolina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tavolina: " + id +" per "+nrPersonave+ " persona";
    }
    
}
