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
@Table(name = "EMPLOYEEMEETING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeemeeting.findAll", query = "SELECT e FROM Employeemeeting e")
    , @NamedQuery(name = "Employeemeeting.findById", query = "SELECT e FROM Employeemeeting e WHERE e.id = :id")})
public class Employeemeeting implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BI_EMPLOYEEMEETING")
    @SequenceGenerator(name = "BI_EMPLOYEEMEETING", sequenceName = "EMPLOYEEMEETING_SEQUENCE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "MEETING", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Meeting meeting;

    public Employeemeeting() {
    }

    public Employeemeeting(BigDecimal id) {
        this.id = id;
    }

    public Employeemeeting(BigDecimal id, Employee employee, Meeting meeting) {
        this.id = id;
        this.employee = employee;
        this.meeting = meeting;
    }

    public Employeemeeting(Employee employee, Meeting meeting) {
        this.employee = employee;
        this.meeting = meeting;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Employeemeeting)) {
            return false;
        }
        Employeemeeting other = (Employeemeeting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Employeemeeting[ id=" + id + " ]";
    }
    
}
