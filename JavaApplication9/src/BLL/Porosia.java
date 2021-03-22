/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Porosia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Porosia.findAll", query = "SELECT p FROM Porosia p"),
    @NamedQuery(name = "Porosia.findById", query = "SELECT p FROM Porosia p WHERE p.id = :id"),
    @NamedQuery(name = "Porosia.findBySasia", query = "SELECT p FROM Porosia p WHERE p.sasia = :sasia"),
    @NamedQuery(name = "Porosia.findByCmimi", query = "SELECT p FROM Porosia p WHERE p.cmimi = :cmimi")})
public class Porosia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Sasia")
    private int sasia;
    @Basic(optional = false)
    @Column(name = "Cmimi")
    private double cmimi;
    @JoinColumn(name = "TavolinaID", referencedColumnName = "ID")
    @ManyToOne
    private Tavolina tavolinaID;
    @JoinColumn(name = "UshqimiID", referencedColumnName = "ID")
    @ManyToOne
    private Ushqimi ushqimiID;

    public Porosia() {
    }

    public Porosia(Integer id) {
        this.id = id;
    }

    public Porosia(Integer id, int sasia, long cmimi) {
        this.id = id;
        this.sasia = sasia;
        this.cmimi = sasia*ushqimiID.getCmimiper1();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSasia() {
        return sasia;
    }

    public void setSasia(int sasia) {
        this.sasia = sasia;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(double cmimi) {
        this.cmimi = cmimi;
    }

    public Tavolina getTavolinaID() {
        return tavolinaID;
    }

    public void setTavolinaID(Tavolina tavolinaID) {
        this.tavolinaID = tavolinaID;
    }

    public Ushqimi getUshqimiID() {
        return ushqimiID;
    }

    public void setUshqimiID(Ushqimi ushqimiID) {
        this.ushqimiID = ushqimiID;
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
        if (!(object instanceof Porosia)) {
            return false;
        }
        Porosia other = (Porosia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Porosia[ id=" + id + " ]";
    }
    
}
