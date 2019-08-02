/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HARRY-PC
 */
@Entity
@Table(name = "CUSTOMERMEETING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customermeeting.findAll", query = "SELECT c FROM Customermeeting c")
    , @NamedQuery(name = "Customermeeting.findById", query = "SELECT c FROM Customermeeting c WHERE c.id = :id")})
public class Customermeeting implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BI_CUSTOMERMEETING")
    @SequenceGenerator(name = "BI_CUSTOMERMEETING", sequenceName = "ROLE_CUSTOMERMEETING", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "CUSTOMER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @JoinColumn(name = "MEETING", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Meeting meeting;

    public Customermeeting() {
    }

    public Customermeeting(BigDecimal id) {
        this.id = id;
    }

    public Customermeeting(BigDecimal id, Customer customer, Meeting meeting) {
        this.id = id;
        this.customer = customer;
        this.meeting = meeting;
    }

    public Customermeeting(Customer customer, Meeting meeting) {
        this.customer = customer;
        this.meeting = meeting;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
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
        if (!(object instanceof Customermeeting)) {
            return false;
        }
        Customermeeting other = (Customermeeting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Customermeeting[ id=" + id + " ]";
    }
    
}
