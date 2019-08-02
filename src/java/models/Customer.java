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
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id")
    , @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name")
    , @NamedQuery(name = "Customer.findByPic", query = "SELECT c FROM Customer c WHERE c.pic = :pic")
    , @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BI_CUSTOMER")
    @SequenceGenerator(name = "BI_CUSTOMER", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PIC")
    private String pic;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Meeting> meetingList;
    @JoinColumn(name = "DISTRICT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private District district;
    @JoinColumn(name = "PROVINCE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;
    @JoinColumn(name = "SUBDISTRICT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subdistrict subdistrict;
    @JoinColumn(name = "URBANVILLAGE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Urbanvillage urbanvillage;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Customermeeting> customermeetingList;

    public Customer() {
    }

    public Customer(BigDecimal id) {
        this.id = id;
    }

    public Customer(BigDecimal id, String name, String pic, String address, String phone, String email, District district, Province province, Subdistrict subdistrict, Urbanvillage urbanvillage) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.district = district;
        this.province = province;
        this.subdistrict = subdistrict;
        this.urbanvillage = urbanvillage;
    }

    public Customer(String name, String pic, String address, String phone, String email, District district, Province province, Subdistrict subdistrict, Urbanvillage urbanvillage) {
        this.name = name;
        this.pic = pic;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.district = district;
        this.province = province;
        this.subdistrict = subdistrict;
        this.urbanvillage = urbanvillage;
    }

    public Customer(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Subdistrict getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(Subdistrict subdistrict) {
        this.subdistrict = subdistrict;
    }

    public Urbanvillage getUrbanvillage() {
        return urbanvillage;
    }

    public void setUrbanvillage(Urbanvillage urbanvillage) {
        this.urbanvillage = urbanvillage;
    }

    @XmlTransient
    public List<Customermeeting> getCustomermeetingList() {
        return customermeetingList;
    }

    public void setCustomermeetingList(List<Customermeeting> customermeetingList) {
        this.customermeetingList = customermeetingList;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Customer[ id=" + id + " ]";
    }
    
}
