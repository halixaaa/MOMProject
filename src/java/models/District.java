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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author HARRY-PC
 */
@Entity
@Table(name = "DISTRICT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d")
    , @NamedQuery(name = "District.findById", query = "SELECT d FROM District d WHERE d.id = :id")
    , @NamedQuery(name = "District.findByName", query = "SELECT d FROM District d WHERE d.name = :name")})
public class District implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BI_DISTRICT")
    @SequenceGenerator(name = "BI_DISTRICT", sequenceName = "DISTRICT_SEQUENCE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private List<Subdistrict> subdistrictList;
    @JoinColumn(name = "PROVINCE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;
    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private List<Customer> customerList;

    public District() {
    }

    public District(BigDecimal id) {
        this.id = id;
    }

    public District(BigDecimal id, String name, Province province) {
        this.id = id;
        this.name = name;
        this.province = province;
    }

    public District(String name, Province province) {
        this.name = name;
        this.province = province;
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
    public List<Subdistrict> getSubdistrictList() {
        return subdistrictList;
    }

    public void setSubdistrictList(List<Subdistrict> subdistrictList) {
        this.subdistrictList = subdistrictList;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.District[ id=" + id + " ]";
    }
    
}
