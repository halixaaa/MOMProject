/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HARRY-PC
 */
@Entity
@Table(name = "URBANVILLAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Urbanvillage.findAll", query = "SELECT u FROM Urbanvillage u")
    , @NamedQuery(name = "Urbanvillage.findById", query = "SELECT u FROM Urbanvillage u WHERE u.id = :id")
    , @NamedQuery(name = "Urbanvillage.findByName", query = "SELECT u FROM Urbanvillage u WHERE u.name = :name")})
public class Urbanvillage implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "urbanvillage", fetch = FetchType.LAZY)
    private List<Customer> customerList;
    @JoinColumn(name = "SUBDISTRICT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subdistrict subdistrict;

    public Urbanvillage() {
    }

    public Urbanvillage(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Subdistrict getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(Subdistrict subdistrict) {
        this.subdistrict = subdistrict;
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
        if (!(object instanceof Urbanvillage)) {
            return false;
        }
        Urbanvillage other = (Urbanvillage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Urbanvillage[ id=" + id + " ]";
    }
    
}
